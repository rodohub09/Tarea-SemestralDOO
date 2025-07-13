package modelos;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CrearExcel {
    public static void exportar(Torneo torneo) {
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet();

        Row fila0 = hoja.createRow(0);
        fila0.createCell(0).setCellValue("Nombre del torneo:");
        fila0.createCell(1).setCellValue(torneo.getNombre());
        fila0.createCell(3).setCellValue("Tipo de torneo:");
        fila0.createCell(4).setCellValue(torneo.getTipoTorneo().toString());
        fila0.createCell(6).setCellValue("Formato:");
        fila0.createCell(7).setCellValue(torneo.getFormato().toString());

        Row fila1 = hoja.createRow(1);
        fila1.createCell(1).setCellValue("Nombre");
        fila1.createCell(2).setCellValue("Contacto");
        fila1.createCell(3).setCellValue("PTS");
        fila1.createCell(4).setCellValue("PJ");
        fila1.createCell(5).setCellValue("PG");
        fila1.createCell(6).setCellValue("PE");
        fila1.createCell(7).setCellValue("PP");

        ArrayList<Participante> lista = torneo.getParticipantes().getArrayParticipante();
        int filaActual = 2;
        for (Participante p : lista) {
            Row fila = hoja.createRow(filaActual++);
            fila.createCell(1).setCellValue(p.getNombre());
            fila.createCell(2).setCellValue(p.getContacto());
            fila.createCell(3).setCellValue(p.getPuntos());
            fila.createCell(4).setCellValue(p.getPartidosJugados());
            fila.createCell(5).setCellValue(p.getWins());
            fila.createCell(6).setCellValue(p.getDraws());
            fila.createCell(7).setCellValue(p.getLosses());
        }

        int columnaJornadas = 9;
        int cantJornadas = torneo.getCalendario().getCantJornadas();
        for (int i = 0; i < cantJornadas; i++) {
            Jornada jornada = torneo.getCalendario().getJornada(i);
            ArrayList<Enfrentamiento> enfrentamientos = jornada.getEnfrentamientos();

            Row encabezadoJornada = hoja.getRow(1);
            if (encabezadoJornada == null) encabezadoJornada = hoja.createRow(1);
            encabezadoJornada.createCell(columnaJornadas).setCellValue("J" + (i + 1));

            int filaJornada = 2;
            for (Enfrentamiento enf : enfrentamientos) {
                Row fila = hoja.getRow(filaJornada);
                if (fila == null) fila = hoja.createRow(filaJornada);
                String texto = enf.getSringLocal() + " vs " + enf.getStringVisita();
                if (enf.getGanador() != null) texto += " (Ganador: " + enf.getGanador().getNombre() + ")";
                fila.createCell(columnaJornadas).setCellValue(texto);
                filaJornada++;
            }
            columnaJornadas++;
        }

        switch (torneo.getTipoTorneo()) {
            case Liga:
                break;

            case Eliminacion_Directa:
                if (torneo.getAgrupacionParticipantes() instanceof AgrupacionElimDirecta agrupacionParticipantes) {
                    int filaBracket = filaActual + 2;

                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Bracket:");
                    for (Participante p : agrupacionParticipantes.devolverAgrupacion()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }
                }
                break;

            case Doble_Eliminacion:
                if (torneo.getAgrupacionParticipantes() instanceof AgrupacionElimDoble agrupacionParticipantes) {
                    int filaBracket = filaActual + 2;

                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Bracket de Ganadores:");
                    for (Participante p : agrupacionParticipantes.getGanadores()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }

                    filaBracket++;
                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Bracket de Perdedores:");
                    for (Participante p : agrupacionParticipantes.getPerdedores()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }
                }
                break;
        }

        try (FileOutputStream archivo = new FileOutputStream("Torneo.xlsx")) {
            libro.write(archivo);
            libro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}