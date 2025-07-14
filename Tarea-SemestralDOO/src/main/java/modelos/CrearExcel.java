package modelos;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de exportar los datos del torneo a un archivo Excel.
 * Los datos varían según el tipo de torneo: Liga, Eliminación Directa o Doble Eliminación.
 */
public class CrearExcel {

    /**
     * Exporta la información del torneo a un archivo Excel llamado "Torneo.xlsx".
     *
     * @param torneo El torneo del cual se exportarán los datos.
     */
    public static void exportar(Torneo torneo) {
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet();

        // Datos generales
        Row fila0 = hoja.createRow(0);
        fila0.createCell(0).setCellValue("Nombre del torneo:");
        fila0.createCell(1).setCellValue(torneo.getNombre());
        fila0.createCell(3).setCellValue("Tipo de torneo:");
        fila0.createCell(4).setCellValue(torneo.getTipoTorneo().toString());
        fila0.createCell(6).setCellValue("Formato:");
        fila0.createCell(7).setCellValue(torneo.getFormato().toString());

        // Encabezado de participantes
        Row fila1 = hoja.createRow(1);
        fila1.createCell(1).setCellValue("Nombre");
        fila1.createCell(2).setCellValue("Contacto");
        fila1.createCell(3).setCellValue("PTS");
        fila1.createCell(4).setCellValue("PJ");
        fila1.createCell(5).setCellValue("PG");
        fila1.createCell(6).setCellValue("PE");
        fila1.createCell(7).setCellValue("PP");

        // Participantes
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

        // Jornadas
        int columnaJornadas = 9;
        int cantJornadas = torneo.getCalendario().getCantJornadas();
        for (int i = 0; i < cantJornadas; i++) {
            Jornada jornada = torneo.getCalendario().getJornada(i);
            ArrayList<Enfrentamiento> enfrentamientos = jornada.getEnfrentamientos();

            Row encabezado = hoja.getRow(1);
            if (encabezado == null) encabezado = hoja.createRow(1);
            encabezado.createCell(columnaJornadas).setCellValue("J" + (i + 1));

            int filaJornada = 2;
            for (Enfrentamiento enf : enfrentamientos) {
                Row fila = hoja.getRow(filaJornada);
                if (fila == null) fila = hoja.createRow(filaJornada);
                String texto = enf.getStringLocal() + " vs " + enf.getStringVisita();
                if (enf.getGanador() != null) texto += " (Ganador: " + enf.getGanador().getNombre() + ")";
                fila.createCell(columnaJornadas).setCellValue(texto);
                filaJornada++;
            }
            columnaJornadas++;
        }

        int filaBracket = filaActual + 2;
        switch (torneo.getTipoTorneo()) {
            case Liga -> {
                hoja.createRow(filaBracket++).createCell(1).setCellValue("Clasificación final:");
                ArrayList<Participante> clasificados = torneo.getAgrupacionParticipantes().devolverAgrupacion();
                for (Participante p : clasificados) {
                    hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                }
            }

            case Eliminacion_Directa -> {
                if (torneo.getAgrupacionParticipantes() instanceof AgrupacionElimDirecta agrupacion) {
                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Bracket:");
                    for (Participante p : agrupacion.devolverAgrupacion()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }
                }
            }

            case Doble_Eliminacion -> {
                if (torneo.getAgrupacionParticipantes() instanceof AgrupacionElimDoble agrupacion) {
                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Upper Bracket:");
                    for (Participante p : agrupacion.getGanadores()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }

                    filaBracket++;
                    hoja.createRow(filaBracket++).createCell(1).setCellValue("Lower Bracket:");
                    for (Participante p : agrupacion.getPerdedores()) {
                        hoja.createRow(filaBracket++).createCell(1).setCellValue(p.getNombre());
                    }
                }
            }
        }

        try (FileOutputStream archivo = new FileOutputStream("Torneo.xlsx")) {
            libro.write(archivo);
            libro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}