package vistas;

import javax.swing.*;

public class PanelEnfrentamiento extends JPanel {
    private JLabel labelLocal;
    private JLabel labelVisita;
    private JLabel labelvs;
    public PanelEnfrentamiento(String local, String visita){
        super();
        setSize(85,65);
        setLayout(null);
        this.labelLocal = new JLabel(local);
        this.labelVisita = new JLabel(visita);
        this.labelvs = new JLabel("vs.");

        labelLocal.setBounds(0,0,85,20);
        labelLocal.setFont(super.getFont().deriveFont(16f));

        labelvs.setBounds(32,23,40,20);
        labelvs.setFont(super.getFont().deriveFont(16f));

        labelVisita.setBounds(0,45,85,20);
        labelVisita.setFont(super.getFont().deriveFont(16f));

        add(labelLocal);
        add(labelvs);
        add(labelVisita);
    }
}
