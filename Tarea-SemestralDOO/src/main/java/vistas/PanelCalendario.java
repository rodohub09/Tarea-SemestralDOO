package vistas;

import modelos.Enfrentamiento;
import modelos.Jornada;

import javax.swing.*;
import java.awt.*;

public class PanelCalendario extends JPanel {
    private JScrollPane scrollPane;

    public PanelCalendario() {
        super();
        setOpaque(false);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setLayout(new BoxLayout(scrollPane,BoxLayout.Y_AXIS));
        add(scrollPane);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarCalendario();
    }

    public void actualizarCalendario(){
        Jornada jornada = PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada());
            for(Enfrentamiento e : jornada.getEnfrentamientos()){
                LabelEnfrentamiento label;
                if(e.getLocal() != null && e.getVisita() != null) {
                    if (e.getFecha() != null)
                        label = new LabelEnfrentamiento(e.getLocal(), e.getVisita(), e.getFecha());
                    else
                        label = new LabelEnfrentamiento(e.getLocal(), e.getVisita(), "--/--");
                }
                else
                    label = new LabelEnfrentamiento("TBD", "TBD", "--/--");
                scrollPane.add(label);
            }
    }

}
