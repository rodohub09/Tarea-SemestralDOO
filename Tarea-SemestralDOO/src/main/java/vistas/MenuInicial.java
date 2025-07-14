package vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Menu que muestra los {@link JButton} para avanzar en la creacion del torneo
 */
public class MenuInicial extends JPanel {
    private JButton crearTorneo;
    private JButton verTorneo;

    public MenuInicial(){
        super();
        setOpaque(false);
        setVisible(true);
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        crearTorneo = new JButton("Crear Torneo");
        crearTorneo.setFont(super.getFont().deriveFont(20f));
        crearTorneo.addActionListener(e -> Ventana.actualizar(Menu.CrearTorneo));

        verTorneo = new JButton("Cargar Torneo");
        verTorneo.setFont(super.getFont().deriveFont(20f));
        verTorneo.addActionListener(e -> Ventana.actualizar(Menu.VerTorneo));

        crearTorneo.setBounds(300,200,400,400);
        verTorneo.setBounds(900,200,400,400);

        add(crearTorneo);
        add(verTorneo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizar(){
    }
}
