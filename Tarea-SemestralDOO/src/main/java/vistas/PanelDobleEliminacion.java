package vistas;

import modelos.Enfrentamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class PanelDobleEliminacion extends JPanel implements PanelTorneo {
    private JScrollPane upperScroll;
    private JPanel upperView;;
    private JScrollPane lowerScroll;
    private JPanel lowerView;
    private JLabel noHayEnfrentamiento;
    private JButton upperButton;
    private JButton lowerButton;

    public PanelDobleEliminacion(){
        super();
        setOpaque(false);
        setLayout(null);
        upperScroll = new JScrollPane();
        upperScroll.setBounds(0,0,1000,600);
        upperScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        upperScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        upperScroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!e.getValueIsAdjusting()) { // Solo cuando el ajuste ha finalizado
                    revalidate();
                    repaint();
                }
            }
        });
        upperScroll.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!e.getValueIsAdjusting()) {
                    revalidate();
                    repaint();
                }
            }
        });

        add(upperScroll);

        lowerScroll = new JScrollPane();
        lowerScroll.setBounds(0,0,1000,600);
        lowerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        lowerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        lowerScroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!e.getValueIsAdjusting()) { // Solo cuando el ajuste ha finalizado
                    revalidate();
                    repaint();
                }
            }
        });
        lowerScroll.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!e.getValueIsAdjusting()) {
                    revalidate();
                    repaint();
                }
            }
        });

        add(lowerScroll);

        upperButton = new JButton("Upper");
        upperButton.setBounds(780,520,200,60);
        upperButton.setFont(super.getFont().deriveFont(18f));
        upperButton.addActionListener(e -> switchPanel(0));
        upperButton.setVisible(false);
        add(upperButton);

        lowerButton = new JButton("Lower");
        lowerButton.setBounds(780,520,200,60);
        lowerButton.setFont(super.getFont().deriveFont(18f));
        lowerButton.addActionListener(e -> switchPanel(1));
        lowerButton.setVisible(true);
        add(lowerButton);

        setComponentZOrder(lowerButton,0);
        setComponentZOrder(upperButton,1);

        upperView = new JPanel();
        upperView.setLayout(null);
        upperView.setPreferredSize(new Dimension(1000,1200));
        lowerView = new JPanel();
        lowerView.setLayout(null);
        lowerView.setPreferredSize(new Dimension(1000,1200));

        noHayEnfrentamiento = new JLabel("No hay enfrentamientos del bracket esta jornada");
        noHayEnfrentamiento.setBounds(400,20,400,50);
        noHayEnfrentamiento.setFont(super.getFont().deriveFont(20f));
        noHayEnfrentamiento.setVisible(false);
        upperView.add(noHayEnfrentamiento);

        actualizar();

    }

    @Override
    public JPanel devolverPanel() {
        return this;
    }

    @Override
    public void actualizar() {
        int ronda = PanelPrincipal.torneo.getNumJornada();
        System.out.println(ronda);

        if (PanelPrincipal.torneo.torneoFinalizado()){
            JLabel campeon = new JLabel(PanelPrincipal.torneo.getCampeon().getNombre());
            campeon.setFont(super.getFont().deriveFont(20f));
            campeon.setBounds(490,220,80,40);
            add(campeon);
        }

        else{
            ArrayList<Enfrentamiento> enfrentamientos = PanelPrincipal.torneo.getCalendario().getJornada(ronda).getEnfrentamientos();
            int mitad = enfrentamientos.size() / 2;

            if(enfrentamientos.size() == 1){
                Enfrentamiento e = enfrentamientos.getFirst();
                PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                panel.setBounds(460,270,80,60);
                upperView.add(panel);

            }

            else {
                if (ronda == 0){
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        panel.setBounds(
                                50,
                                10 + i * 70 * (int) Math.pow(2, ronda),
                                80, 60);
                        upperView.add(panel);

                    }

                }
                else if(ronda%2 == 0) {
                    noHayEnfrentamiento.setVisible(true);
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        panel.setBounds(
                                50 + ronda * 100,
                                10 + (i - mitad) * 70 * (int) Math.pow(2, ronda-1),
                                80, 60);
                        lowerView.add(panel);

                    }
                }
                else{
                    noHayEnfrentamiento.setVisible(false);
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        if (i < mitad) {
                            panel.setBounds(
                                    50 + ronda * 100,
                                    10 + i * 70 * (int) Math.pow(2, ronda),
                                    80, 60);
                            upperView.add(panel);
                        } else {
                            panel.setBounds(
                                    50 + ronda * 100,
                                    10 + (i - mitad) * 70 * (int) Math.pow(2, ronda-1),
                                    80, 60);
                            lowerView.add(panel);
                        }
                    }

                }
            }
        }
        upperScroll.setViewportView(upperView);
        lowerScroll.setViewportView(lowerView);
    }

    protected void switchPanel(int panel) {
        switch (panel){
            case 0 -> {upperButton.setVisible(false);
                        upperScroll.setVisible(true);
                        lowerButton.setVisible(true);
                        lowerScroll.setVisible(false);
                        revalidate();
                        repaint();}
            case 1 -> {upperButton.setVisible(true);
                        upperScroll.setVisible(false);
                        lowerButton.setVisible(false);
                        lowerScroll.setVisible(true);
                        revalidate();
                        repaint();}
        }
    }
}
