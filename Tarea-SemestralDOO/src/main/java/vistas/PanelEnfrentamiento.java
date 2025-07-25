package vistas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelEnfrentamiento extends JPanel {
    private JLabel labelLocal;
    private JLabel labelVisita;
    private JLabel labelvs;
    public PanelEnfrentamiento(String local, String visita){
        super();
        setSize(80,60);
        setLayout(null);
        setBorder(new LineBorder(Color.BLACK,1));
        this.labelLocal = new JLabel(local);
        this.labelVisita = new JLabel(visita);
        this.labelvs = new JLabel("vs.");

        labelLocal.setBounds(2,1,80,20);
        labelLocal.setFont(super.getFont().deriveFont(16f));

        labelvs.setBounds(32,20,40,20);
        labelvs.setFont(super.getFont().deriveFont(16f));

        labelVisita.setBounds(2,40,80,20);
        labelVisita.setFont(super.getFont().deriveFont(16f));

        add(labelLocal);
        add(labelvs);
        add(labelVisita);
    }
}
