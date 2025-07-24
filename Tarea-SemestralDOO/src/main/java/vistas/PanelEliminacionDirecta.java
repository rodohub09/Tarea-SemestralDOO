package vistas;

import modelos.Enfrentamiento;

import javax.swing.*;
import java.util.ArrayList;

public class PanelEliminacionDirecta extends JPanel implements PanelTorneo {
    private int[][] posX;
    private int[] posY;

    public PanelEliminacionDirecta(){
        super();
        setOpaque(false);
        setLayout(null);
        posX = new int[][]{{350, 570},
                            {250,670},
                            {150, 770},
                            {50,870}};
        posY = new int[]{295,155,85,50};
    }
    @Override
    public JPanel devolverPanel() {
        return this;
    }

    @Override
    public void actualizar() {
        int participantes = PanelPrincipal.torneo.getCantidadParticipantes().getNumParticipantes();
        int ronda = PanelPrincipal.torneo.getNumJornada();
        int escala = (int)(Math.log(participantes) / Math.log(2));

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
            add(panel);

            }

            else {
                int[] boundX = posX[escala - 2];
                int boundY = posY[escala - 2 - ronda];

                for (int i = 0; i < enfrentamientos.size(); i++) {
                    Enfrentamiento e = enfrentamientos.get(i);
                    PanelEnfrentamiento panel = new PanelEnfrentamiento(e.getStringLocal(), e.getStringVisita());

                    if (i < mitad) {
                        panel.setBounds(
                                boundX[0] + ronda * 100,
                                boundY + i * 70 * (int) Math.pow(2, ronda),
                                80, 60);
                    } else {
                        panel.setBounds(
                                boundX[1] - ronda * 100,
                                boundY + (i - mitad) * 70 * (int) Math.pow(2, ronda),
                                80, 60);
                    }

                    add(panel);
                }
            }
        }

    }


}
