package vistas;

import modelos.Participante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel que muestra una tabla con todos los nombres de los {@link Participante} inscritos
 */
public class PanelInscritos extends JPanel {
    JTable tablaInscritos;
    DefaultTableModel modelo;

    public PanelInscritos() {
        super();
        setOpaque(false);
        setLayout(null);
        String[] tabla = {"Inscritos",""};
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
        tablaInscritos.getColumnModel().getColumn(0).setPreferredWidth(300);
        tablaInscritos.getColumnModel().getColumn(1).setPreferredWidth(100);

        tablaInscritos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaInscritos.rowAtPoint(e.getPoint());
                int columna = tablaInscritos.columnAtPoint(e.getPoint());

                if (columna == 1) {
                    Participante p = PanelPrincipal.torneo.getParticipantes().getArrayParticipante().get(fila);
                    PanelPrincipal.torneo.getParticipantes().getArrayParticipante().remove(p);
                    Ventana.actualizar(Menu.CrearTorneo);
                }
            }
        });

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


    /**
     * Metodo que actualiza las filas de la tabla segun lo almacenado en {@link modelos.Participantes}
     */
    protected void actualizarInscritos(){
        modelo.setRowCount(0);

        for(Participante p : PanelPrincipal.torneo.getParticipantes().getArrayParticipante()){
            modelo.addRow(new Object[]{p.getNombre(),"Eliminar"});
        }
    }
}
