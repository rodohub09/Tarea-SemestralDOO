package modelos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vistas.PanelPrincipal;
import vistas.PanelTorneo;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalendarioElimDirectaTest {

    private static CalendarioElimDirecta calendario;
    private static Participantes participantes;
    private static ArrayList<Jornada> jornadas;

    @BeforeEach
    void setUp(){
        participantes = new Participantes();
        participantes.addParticipante(new Participante("equipo 1", "equipo1@proton.me"));
        participantes.addParticipante(new Participante("equipo 2", "equipo2@proton.me"));
        participantes.addParticipante(new Participante("equipo 3", "equipo3@proton.me"));
        participantes.addParticipante(new Participante("equipo 4", "equipo4@proton.me"));

        jornadas = new ArrayList<>();
        calendario = new CalendarioElimDirecta();
    }

    @Test
    @DisplayName("4 Participantes y 1 enfrentamiento")
    void creacionCalendario4() {
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Cuatro,participantes);

        assertEquals("[Partido: equipo 1 vs equipo 4\n" +
                "Partido: equipo 2 vs equipo 3\n" +
                "]",jornadas.toString());
    }

    @Test
    @DisplayName("8 Participantes")
    void creacionCalendario8() {
        participantes.addParticipante(new Participante("equipo 5", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 6", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 7", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 8", "equipo8@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Ocho,participantes);
        assertEquals("[Partido: equipo 1 vs equipo 8\n" +
                "Partido: equipo 2 vs equipo 7\n" +
                "Partido: equipo 3 vs equipo 6\n" +
                "Partido: equipo 4 vs equipo 5\n" +
                "]",jornadas.toString());
    }

    @Test
    @DisplayName("16 Participantes")
    void creacionCalendario16() {
        participantes.addParticipante(new Participante("equipo 5", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 6", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 7", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 8", "equipo8@proton.me"));
        participantes.addParticipante(new Participante("equipo 9", "equipo9@proton.me"));
        participantes.addParticipante(new Participante("equipo 10", "equipo10@proton.me"));
        participantes.addParticipante(new Participante("equipo 11", "equipo11@proton.me"));
        participantes.addParticipante(new Participante("equipo 12", "equipo12@proton.me"));
        participantes.addParticipante(new Participante("equipo 13", "equipo13@proton.me"));
        participantes.addParticipante(new Participante("equipo 14", "equipo14@proton.me"));
        participantes.addParticipante(new Participante("equipo 15", "equipo15@proton.me"));
        participantes.addParticipante(new Participante("equipo 16", "equipo16@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Dieciseis,participantes);
        assertEquals("[Partido: equipo 1 vs equipo 16\n" +
                "Partido: equipo 2 vs equipo 15\n" +
                "Partido: equipo 3 vs equipo 14\n" +
                "Partido: equipo 4 vs equipo 13\n" +
                "Partido: equipo 5 vs equipo 12\n" +
                "Partido: equipo 6 vs equipo 11\n" +
                "Partido: equipo 7 vs equipo 10\n" +
                "Partido: equipo 8 vs equipo 9\n" +
                "]",jornadas.toString());
    }

    @Test
    @DisplayName("32 Participantes")
    void creacionCalendario32() {
        participantes.addParticipante(new Participante("equipo 5", "equipo5@proton.me"));
        participantes.addParticipante(new Participante("equipo 6", "equipo6@proton.me"));
        participantes.addParticipante(new Participante("equipo 7", "equipo7@proton.me"));
        participantes.addParticipante(new Participante("equipo 8", "equipo8@proton.me"));
        participantes.addParticipante(new Participante("equipo 9", "equipo9@proton.me"));
        participantes.addParticipante(new Participante("equipo 10", "equipo10@proton.me"));
        participantes.addParticipante(new Participante("equipo 11", "equipo11@proton.me"));
        participantes.addParticipante(new Participante("equipo 12", "equipo12@proton.me"));
        participantes.addParticipante(new Participante("equipo 13", "equipo13@proton.me"));
        participantes.addParticipante(new Participante("equipo 14", "equipo14@proton.me"));
        participantes.addParticipante(new Participante("equipo 15", "equipo15@proton.me"));
        participantes.addParticipante(new Participante("equipo 16", "equipo16@proton.me"));
        participantes.addParticipante(new Participante("equipo 17", "equipo17@proton.me"));
        participantes.addParticipante(new Participante("equipo 18", "equipo18@proton.me"));
        participantes.addParticipante(new Participante("equipo 19", "equipo19@proton.me"));
        participantes.addParticipante(new Participante("equipo 20", "equipo20@proton.me"));
        participantes.addParticipante(new Participante("equipo 21", "equipo21@proton.me"));
        participantes.addParticipante(new Participante("equipo 22", "equipo22@proton.me"));
        participantes.addParticipante(new Participante("equipo 23", "equipo23@proton.me"));
        participantes.addParticipante(new Participante("equipo 24", "equipo24@proton.me"));
        participantes.addParticipante(new Participante("equipo 25", "equipo25@proton.me"));
        participantes.addParticipante(new Participante("equipo 26", "equipo26@proton.me"));
        participantes.addParticipante(new Participante("equipo 27", "equipo27@proton.me"));
        participantes.addParticipante(new Participante("equipo 28", "equipo28@proton.me"));
        participantes.addParticipante(new Participante("equipo 29", "equipo29@proton.me"));
        participantes.addParticipante(new Participante("equipo 30", "equipo30@proton.me"));
        participantes.addParticipante(new Participante("equipo 31", "equipo31@proton.me"));
        participantes.addParticipante(new Participante("equipo 32", "equipo32@proton.me"));
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.TreintayDos,participantes);
        assertEquals("[Partido: equipo 1 vs equipo 32\n" +
                "Partido: equipo 2 vs equipo 31\n" +
                "Partido: equipo 3 vs equipo 30\n" +
                "Partido: equipo 4 vs equipo 29\n" +
                "Partido: equipo 5 vs equipo 28\n" +
                "Partido: equipo 6 vs equipo 27\n" +
                "Partido: equipo 7 vs equipo 26\n" +
                "Partido: equipo 8 vs equipo 25\n" +
                "Partido: equipo 9 vs equipo 24\n" +
                "Partido: equipo 10 vs equipo 23\n" +
                "Partido: equipo 11 vs equipo 22\n" +
                "Partido: equipo 12 vs equipo 21\n" +
                "Partido: equipo 13 vs equipo 20\n" +
                "Partido: equipo 14 vs equipo 19\n" +
                "Partido: equipo 15 vs equipo 18\n" +
                "Partido: equipo 16 vs equipo 17\n" +
                "]",jornadas.toString());
    }

    @Test
    @DisplayName("0 Participantes")
    void creacionCalendario0() {
        Participantes participantes0 = new Participantes();
        participantes0.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Cuatro,participantes0);

        assertEquals("[]",jornadas.toString());
    }

    @Test
    @DisplayName("1 Participantes")
    void creacionCalendario1() {
        Participantes participantes1 = new Participantes();
        participantes1.addParticipante(new Participante("equipo 1", "equipo1@proton.me"));
        participantes1.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Cuatro,participantes1);

        assertEquals("[]",jornadas.toString());
    }

    @Test
    void actualizarCalendario() {
        Torneo t = new Torneo("asdsa",TipoTorneo.Eliminacion_Directa);
        PanelPrincipal.torneo = t;
        ArrayList<Participante> activos = new ArrayList<>();
        participantes.setAgrupacionParticipantes(TipoTorneo.Eliminacion_Directa);
        calendario.creacionCalendario(jornadas,1,CantidadParticipantes.Cuatro,participantes);
        jornadas.get(0).enfrentamientos.get(0).setGanador(jornadas.get(0).enfrentamientos.get(0).getLocal());
        jornadas.get(0).enfrentamientos.get(1).setGanador(jornadas.get(0).enfrentamientos.get(1).getVisita());
        activos.add(jornadas.get(0).enfrentamientos.get(0).getLocal());
        activos.add(jornadas.get(0).enfrentamientos.get(1).getVisita());
        calendario.actualizarCalendario(jornadas,activos);
        assertEquals("[Partido: equipo 1 vs equipo 4\n" +
                "Partido: equipo 2 vs equipo 3\n" +
                ", Partido: equipo 1 vs equipo 3\n" +
                "]",jornadas.toString());
    }
}