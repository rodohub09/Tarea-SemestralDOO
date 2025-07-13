package vistas;

import modelos.Participante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelInscritos extends JPanel {
    JTable tablaInscritos;
    DefaultTableModel modelo;

    public PanelInscritos() {
        super();
        setOpaque(false);
        setLayout(null);
        String[] tabla = {"Inscritos"};
        modelo = new DefaultTableModel(tabla,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaInscritos = new JTable(modelo);
        tablaInscritos.getTableHeader().setReorderingAllowed(false);
        tablaInscritos.setFont(super.getFont().deriveFont(20f));
        tablaInscritos.setRowHeight(30);
        tablaInscritos.getTableHeader().setFont(super.getFont().deriveFont(20f));
        JScrollPane scrollPane = new JScrollPane(tablaInscritos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBounds(0,0,400,600);
        add(scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarInscritos();
    }

    protected void actualizarInscritos(){
        modelo.setRowCount(0);

        for(Participante p : PanelPrincipal.torneo.getParticipantes().getArrayParticipante()){
            modelo.addRow(new Object[]{p.getNombre()});
        }
    }
}
