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
        scrollPane.setBounds(0,0,600,600);
        add(scrollPane);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarCalendario();
    }

    public void actualizarCalendario(){
        if(PanelPrincipal.torneo.getCalendario() != null) {
            Jornada jornada = PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada());
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JLabel titulo = new JLabel("  Jornada "+ (PanelPrincipal.torneo.getNumJornada()+1));
            titulo.setFont(super.getFont().deriveFont(36f));
            panel.add(titulo);
            for (Enfrentamiento e : jornada.getEnfrentamientos()) {
                LabelEnfrentamiento label = getLabelEnfrentamiento(e);
                panel.add(label);
            }
            scrollPane.setViewportView(panel);
        }
    }

    private LabelEnfrentamiento getLabelEnfrentamiento(Enfrentamiento e) {
        LabelEnfrentamiento label;
        if (e.getSringLocal() != null && e.getStringVisita() != null) {
            if (e.getFecha() != null)
                label = new LabelEnfrentamiento(e.getSringLocal(), e.getStringVisita(), e.getFecha());
            else
                label = new LabelEnfrentamiento(e.getSringLocal(), e.getStringVisita(), "--/--");
        } else
            label = new LabelEnfrentamiento("TBD", "TBD", "--/--");
        label.setFont(super.getFont().deriveFont(20f));
        return label;
    }

}
