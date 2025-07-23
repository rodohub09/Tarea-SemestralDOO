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
        label = new JLabel("¡El campeón es " + campeon.getNombre() + "!");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());

        panel.add(label, BorderLayout.CENTER);
        panel.add(cerrar, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}