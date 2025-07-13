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

        Row fila1 = hoja.createRow(1);
        fila1.createCell(1).setCellValue("Nombre");
        fila1.createCell(2).setCellValue("Contacto");
        fila1.createCell(3).setCellValue("PJ");
        fila1.createCell(4).setCellValue("PG");
        fila1.createCell(5).setCellValue("PE");
        fila1.createCell(6).setCellValue("PP");

        ArrayList<Participante> lista = torneo.getParticipantes().getArrayParticipante();

        int filaActual = 1;
        for (Participante participante : lista) {
            Row fila = hoja.createRow(filaActual++);
            fila.createCell(1).setCellValue(participante.getNombre());
            fila.createCell(2).setCellValue(participante.getContacto());
            fila.createCell(3).setCellValue(participante.getPartidosJugados());
            fila.createCell(4).setCellValue(participante.getWins());
            fila.createCell(5).setCellValue(participante.getDraws());
            fila.createCell(6).setCellValue(participante.getLosses());
        }

        int columnaJornadas = 8;
        int cantJornadas = torneo.getCalendario().getCantJornadas();
        for (int i = 0; i < cantJornadas; i++) {
            Jornada jornada = torneo.getCalendario().getJornada(i);
            ArrayList<Enfrentamiento> enfrentamientos = jornada.getEnfrentamientos();

            hoja.createRow(1).createCell(columnaJornadas).setCellValue("J" + (i + 1));

            for (Enfrentamiento enfrentamiento : enfrentamientos) {
                Row fila = hoja.getRow(i + 2);
                if (fila == null)
                    hoja.createRow(i + 2);
                String texto = enfrentamiento.getSringLocal() + " vs " + enfrentamiento.getStringVisita();
                if (enfrentamiento.getGanador() != null)
                    texto += " (Ganador: " + enfrentamiento.getGanador().getNombre() + ")";
                fila.createCell(columnaJornadas).setCellValue(texto);
            }
            columnaJornadas++;
        }

        try (FileOutputStream archivo = new FileOutputStream("Torneo.xlsx")) {
            libro.write(archivo);
            libro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}