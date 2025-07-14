package vistas;

import modelos.Participante;

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
        int escalaY = (int)(Math.log(32) / Math.log(2)) - (int)(Math.log(PanelPrincipal.torneo.getCantidadParticipantes().getNumParticipantes()) / Math.log(2)) + 1;
        int escalaX = (int)(6 - Math.log(PanelPrincipal.torneo.getCantidadParticipantes().getNumParticipantes()) / Math.log(2));

        PanelPrincipal.torneo.getParticipantes().agrupar();
        ArrayList<Participante> p = PanelPrincipal.torneo.getParticipantes().devolverAgrupacion();

        for(int i = 0;i < p.size()/2;i++) {
            JLabel label1 = new JLabel(p.get(i).getNombre());
            label1.setFont(super.getFont().deriveFont(20f));
            label1.setBounds(14 + (70 + 14 * escalaX)*PanelPrincipal.torneo.getNumJornada(),
                    13 + (25+13*escalaY)*i +(25+13*escalaY)*PanelPrincipal.torneo.getNumJornada(),
                    70,
                    25);
            JLabel label2 = new JLabel(p.get(PanelPrincipal.torneo.getParticipantes().devolverAgrupacion().size()-i-1).getNombre());
            label2.setFont(super.getFont().deriveFont(20f));
            label2.setBounds(930-(14 + (70 + 14 * escalaX)*PanelPrincipal.torneo.getNumJornada()),
                    13 + (25+13*escalaY)*i +(25+13*escalaY)*PanelPrincipal.torneo.getNumJornada(),
                    70,
                    25);
            add(label1);
            add(label2);

        }

    }
}
