package vistas;

import modelos.Enfrentamiento;
import modelos.Jornada;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que recopila todos los {@link Enfrentamiento} de una {@link Jornada} contenida en el calendario del torneo
 */
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

    /**
     * Metodo que crea el {@link JPanel} que se agrega {@link JScrollPane} que contiene la clase
     */
    public void actualizarCalendario(){
        if(PanelPrincipal.torneo.getCalendario() != null && PanelPrincipal.torneo.getNumJornada() < PanelPrincipal.torneo.getCalendario().getCantJornadas()) {
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


    /**
     * @param e Enfretamiento del cual utilizara sus variables de {@link modelos.Participante} para crear un label adecuado
     * @return Label creado utilizando los valores válidos retornados
     */
    private LabelEnfrentamiento getLabelEnfrentamiento(Enfrentamiento e) {
        LabelEnfrentamiento label;
        if (e.getStringLocal() != null && e.getStringVisita() != null) {
            if (e.getFecha() != null)
                label = new LabelEnfrentamiento(e.getStringLocal(), e.getStringVisita(), e.getFecha());
            else
                label = new LabelEnfrentamiento(e.getStringLocal(), e.getStringVisita(), "--/--");
        } else
            label = new LabelEnfrentamiento("TBD", "TBD", "--/--");
        label.setFont(super.getFont().deriveFont(21f));
        return label;
    }

}
