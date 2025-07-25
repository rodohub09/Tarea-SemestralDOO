package vistas;

import modelos.Enfrentamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

/**
 * Panel que muestra el estado del bracket de doble eliminacion
 */
public class PanelDobleEliminacion extends JPanel implements PanelTorneo {
    private JScrollPane upperScroll;
    private JPanel upperView;;
    private JScrollPane lowerScroll;
    private JPanel lowerView;
    private JLabel noHayEnfrentamiento;
    private JButton upperButton;
    private JButton lowerButton;
    private int rondaUpper;
    private int rondaLower;

    public PanelDobleEliminacion(){
        super();
        setOpaque(false);
        setLayout(null);
        rondaUpper = 0;
        rondaLower = 0;
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
                if (!e.getValueIsAdjusting()) {
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
        noHayEnfrentamiento.setBounds(300,10,500,50);
        noHayEnfrentamiento.setFont(super.getFont().deriveFont(20f));
        noHayEnfrentamiento.setVisible(false);
        upperView.add(noHayEnfrentamiento);

    }

    @Override
    public JPanel devolverPanel() {
        return this;
    }

    /**
     * Metodo que determina el panel correspondiente a cada enfrentamiento, para organizarlos en forma de bracket
     */
    @Override
    public void actualizar() {
        int ronda = PanelPrincipal.torneo.getNumJornada();

        if (PanelPrincipal.torneo.torneoFinalizado()){
            JLabel campeon = new JLabel(PanelPrincipal.torneo.getCampeon().getNombre());
            System.out.println(PanelPrincipal.torneo.getCampeon().getNombre());
            campeon.setFont(super.getFont().deriveFont(20f));
            campeon.setBounds(
                    150 + rondaUpper * 100,
                    40 + (35+10*rondaUpper-1)*(rondaUpper-1),
                    80, 60);
            upperView.add(campeon);
        }

        else{
            ArrayList<Enfrentamiento> enfrentamientos = PanelPrincipal.torneo.getCalendario().getJornada(ronda).getEnfrentamientos();
            int mitad = enfrentamientos.size() / 2;

            if(enfrentamientos.size() == 1 && ronda == PanelPrincipal.torneo.getCantidadParticipantes().getJornadasElimDirecta()*2 - 1){
                noHayEnfrentamiento.setVisible(false);
                Enfrentamiento e = enfrentamientos.getFirst();
                PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                panel.setBounds(
                        50 + rondaUpper * 100,
                        40 + (35+10*rondaUpper-1)*(rondaUpper-1),
                        80, 60);
                upperView.add(panel);

            }

            else {
                if (ronda == 0){
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        panel.setBounds(
                                50,
                                40 + i * 70 * (int) Math.pow(2, rondaUpper),
                                80, 60);
                        upperView.add(panel);

                    }
                    rondaUpper++;

                }
                else if(ronda%2 == 0) {
                    noHayEnfrentamiento.setVisible(true);
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        panel.setBounds(
                                50 + rondaLower * 100,
                                40 + (35+10*rondaLower)*(rondaLower) + i * 70,
                                80, 60);
                        lowerView.add(panel);
                    }
                    rondaLower++;
                }
                else{
                    noHayEnfrentamiento.setVisible(false);
                    for (int i = 0; i < enfrentamientos.size(); i++) {
                        Enfrentamiento e = enfrentamientos.get(i);
                        PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());
                        if (i < mitad) {
                            panel.setBounds(
                                    50 + rondaUpper * 100,
                                    40 + (35+10*rondaUpper)*(rondaUpper) + i * 70 * (int) Math.pow(2, rondaUpper),
                                    80, 60);
                            upperView.add(panel);
                        } else {
                            if (rondaLower == 0){
                                panel.setBounds(
                                        50,
                                        40 + (i-mitad) * 70,
                                        80, 60);
                                lowerView.add(panel);
                            }
                            else{
                                panel.setBounds(
                                        50 + rondaLower*100,
                                        40 + (i - mitad) * 70 + (35+8*rondaLower)*(rondaLower),
                                        80, 60);
                                lowerView.add(panel);
                            }
                        }
                    }
                    rondaLower++;
                    rondaUpper++;

                }
            }
        }
        upperScroll.setViewportView(upperView);
        lowerScroll.setViewportView(lowerView);
    }

    /**
     * Metodo que intercambia el panel visto dependiendo del int que se le ingresa
     * @param panel int asociado a cada panel
     */
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
