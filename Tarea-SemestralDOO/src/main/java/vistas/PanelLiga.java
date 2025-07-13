package vistas;

import modelos.Participante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelLiga extends JPanel implements PanelTorneo {
    private DefaultTableModel modelo;
    private JTable clasificacion;

    public PanelLiga(){
        super();
        setOpaque(false);
        setLayout(null);
        String[] tabla = {"POS","Participante","PTS","PJ","PG","PE","PP"};
        modelo = new DefaultTableModel(tabla,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        clasificacion= new JTable(modelo);
        clasificacion.getTableHeader().setReorderingAllowed(false);
        clasificacion.setFont(super.getFont().deriveFont(20f));
        clasificacion.setRowHeight(30);
        clasificacion.getTableHeader().setFont(super.getFont().deriveFont(20f));
        clasificacion.getTableHeader().setReorderingAllowed(false);
        clasificacion.getTableHeader().setResizingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(clasificacion);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBounds(0,0,1000,600);
        add(scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actualizar(){
        modelo.setRowCount(0);
        PanelPrincipal.torneo.getParticipantes().agrupar();
        for(Participante p : PanelPrincipal.torneo.getParticipantes().devolverAgrupacion()){
            modelo.addRow(new Object[]{
                PanelPrincipal.torneo.getParticipantes().devolverAgrupacion().indexOf(p) + 1,
                p.getNombre(),
                p.getPuntos(),
                p.getPartidosJugados(),
                p.getWins(),
                p.getDraws(),
                p.getLosses()
            });
        }
    }

    public JPanel devolverPanel(){
        return this;
    }
}
