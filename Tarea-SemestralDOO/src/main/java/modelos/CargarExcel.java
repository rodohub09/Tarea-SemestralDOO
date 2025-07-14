/**
 * Clase que permite cargar un torneo desde un archivo Excel (.xlsx).
 * Extrae la información del nombre, tipo de torneo, formato, participantes, estadísticas y jornadas.
 */
package modelos;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class CargarExcel {

    /**
     * Carga un torneo desde un archivo Excel (.xlsx) dado su path.
     *
     * @param ruta Ruta del archivo Excel a leer.
     * @return Una instancia de {@link Torneo} con los datos leídos del archivo, o {@code null} si ocurre un error.
     */
    public static Torneo cargarTorneoDesdeExcel(String ruta) {
        try (FileInputStream fis = new FileInputStream(ruta);
             Workbook libro = new XSSFWorkbook(fis)) {

            Sheet hoja = libro.getSheetAt(0);

            // Carga los datos generales del torneo.
            Row fila0 = hoja.getRow(0);
            String nombreTorneo = fila0.getCell(1).getStringCellValue();
            String tipoTorneo = fila0.getCell(4).getStringCellValue();
            String formato = fila0.getCell(7).getStringCellValue();

            TipoTorneo tipoDetectado = TipoTorneo.valueOf(tipoTorneo);
            Formato formatoDetectado = Formato.valueOf(formato);

            Participantes participantes = new Participantes();
            participantes.setAgrupacionParticipantes(tipoDetectado);
            Map<String, Participante> mapa = new HashMap<>();

            int filaIdx = 2;
            // Lee las estadisticas de los participantes.
            while (true) {
                Row fila = hoja.getRow(filaIdx);
                if (fila == null || fila.getCell(1) == null) break;

                String nombre = fila.getCell(1).getStringCellValue();
                String contacto = fila.getCell(2).getStringCellValue();
                Participante p = new Participante(nombre, contacto);

                if (fila.getCell(3) != null) p.setPuntos((int) fila.getCell(3).getNumericCellValue());
                if (fila.getCell(4) != null) p.setPartidosJugados((int) fila.getCell(4).getNumericCellValue());
                if (fila.getCell(5) != null) p.setWins((int) fila.getCell(5).getNumericCellValue());
                if (fila.getCell(6) != null) p.setDraws((int) fila.getCell(6).getNumericCellValue());
                if (fila.getCell(7) != null) p.setLosses((int) fila.getCell(7).getNumericCellValue());

                participantes.addParticipante(p);
                mapa.put(nombre, p);
                filaIdx++;
            }

            int columnaJornadas = 9;
            Row encabezado = hoja.getRow(1);
            ArrayList<Jornada> jornadas = new ArrayList<>();

            // Lee los enfrentamientos de todas las jornadas.
            while (encabezado != null && encabezado.getCell(columnaJornadas) != null &&
                    encabezado.getCell(columnaJornadas).getStringCellValue().startsWith("J")) {

                Jornada jornada = new Jornada(participantes);
                int filaEnfrentamiento = 2;

                while (true) {
                    Row filaActual = hoja.getRow(filaEnfrentamiento++);
                    if (filaActual == null) break;

                    Cell celda = filaActual.getCell(columnaJornadas);
                    if (celda == null || celda.getCellType() != CellType.STRING) continue;

                    String texto = celda.getStringCellValue().trim();
                    if (texto.isEmpty()) continue;

                    String[] partes = texto.split(" vs ");
                    if (partes.length < 2) continue;

                    String local = partes[0].trim();
                    String[] derecho = partes[1].split("\\(Ganador:");
                    String visita = derecho[0].trim();
                    String ganador = (derecho.length > 1) ? derecho[1].replace(")", "").trim() : null;

                    Participante pLocal = mapa.get(local);
                    Participante pVisita = mapa.get(visita);
                    Participante pGanador = (ganador != null) ? mapa.get(ganador) : null;

                    if (pLocal != null && pVisita != null) {
                        Enfrentamiento e = new Enfrentamiento(pLocal, pVisita, null);
                        if (pGanador != null) e.setGanador(pGanador);
                        jornada.getEnfrentamientos().add(e);
                    }
                }
                jornadas.add(jornada);
                columnaJornadas++;
            }
            participantes.agrupar();

            // Crea el torneo con los datos leídos.
            Torneo torneo = new Torneo(nombreTorneo, tipoDetectado);
            torneo.setFormato(formatoDetectado);
            torneo.setAgrupacionParticipantes(participantes.getAgrupacionParticipantes());

            Calendario calendario = new Calendario();
            calendario.setJornadas(jornadas);
            torneo.setCalendario(calendario);

            return torneo;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}