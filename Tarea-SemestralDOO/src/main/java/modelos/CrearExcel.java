package modelos;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        for (int i = 0; i < lista.size(); i++) {
            Participante participante = lista.get(i);
            Row fila = hoja.createRow(i + 2);
            fila.createCell(1).setCellValue(participante.getNombre());
            fila.createCell(2).setCellValue(participante.getContacto());
            fila.createCell(3).setCellValue(participante.getPartidosJugados());
            fila.createCell(4).setCellValue(participante.getWins());
            fila.createCell(5).setCellValue(participante.getDraws());
            fila.createCell(6).setCellValue(participante.getLosses());
        }
    }
}