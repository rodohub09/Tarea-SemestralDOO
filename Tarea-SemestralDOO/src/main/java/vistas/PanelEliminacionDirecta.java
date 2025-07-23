package vistas;

import modelos.Enfrentamiento;

import javax.swing.*;
import java.util.ArrayList;

public class PanelEliminacionDirecta extends JPanel implements PanelTorneo {
    public PanelEliminacionDirecta(){
        super();
        setOpaque(false);
        setLayout(null);
    }
    @Override
    public JPanel devolverPanel() {
        return this;
    }

    @Override
    public void actualizar() {
        int participantes = PanelPrincipal.torneo.getCantidadParticipantes().getNumParticipantes();
        int ronda = PanelPrincipal.torneo.getNumJornada();

        int escalaY = (int)(Math.log(32) / Math.log(2)) - (int)(Math.log(participantes) / Math.log(2)) + 1;
        int escalaX = (int)(6 - Math.log(participantes) / Math.log(2));

        ArrayList<Enfrentamiento> enfrentamientos = PanelPrincipal.torneo.getCalendario().getJornada(ronda).getEnfrentamientos();
        int mitad = enfrentamientos.size() / 2;

        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);
            PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());

            if (i < mitad) {
                panel.setBounds(
                        50 + ronda * escalaX * 85,
                        ronda * (mitad * (65 + 20) + 50) + i * (65 + 20),
                        85, 65);
            } else {
                panel.setBounds(
                        865 - ronda * 100,
                        ronda * (mitad * (65 + 20) + 50) + (i - mitad) * (65 + 20),
                        85, 65);
            }

            add(panel);
        }

    }


}
