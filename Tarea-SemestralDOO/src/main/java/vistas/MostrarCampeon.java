package vistas;

import modelos.Participante;

import javax.swing.*;
import java.awt.*;

public class MostrarCampeon extends JDialog {
    private JPanel panel;
    private JLabel label;

    public MostrarCampeon(JFrame ventana, Participante campeon) {
        super(ventana, "Campeón", true);

        setSize(500, 400);
        setLocationRelativeTo(ventana);

        panel = new JPanel(new BorderLayout());
        label = new JLabel("<html><div style='text-align: center;'>¡El campeón es " + campeon.getNombre() + "!</div></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(getFont().deriveFont(36f));

        JPanel botones = new JPanel();
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        botones.add(cerrar);

        JButton nuevo = new JButton("Crear Nuevo Torneo");
        nuevo.addActionListener(e -> {
            Ventana.reiniciarTorneo();
            dispose();
        });
        botones.add(nuevo);

        panel.add(label, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}