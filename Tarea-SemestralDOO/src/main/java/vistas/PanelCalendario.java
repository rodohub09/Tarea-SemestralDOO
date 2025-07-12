package vistas;

import modelos.Calendario;
import modelos.Enfrentamiento;
import modelos.Jornada;

import javax.swing.*;
import java.awt.*;

public class PanelCalendario extends JScrollPane {

    public PanelCalendario() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarCalendario();
    }

    protected void actualizarCalendario(){
        Jornada jornada = PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada());
            for(Enfrentamiento e : jornada.getEnfrentamientos()){
                if(e.getLocal() != null && e.getVisita() != null) {
                    if (e.getFecha() != null)
                        add(new LabelEnfrentamiento(e.getLocal(), e.getVisita(), e.getFecha()));
                    add(new LabelEnfrentamiento(e.getLocal(), e.getVisita(), "--"));
                }
                add(new LabelEnfrentamiento("TBD","TBD","--"));
            }
    }

}
