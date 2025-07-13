package vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase de la ventana que contiene todos los paneles.
 * */
public class Ventana extends JFrame {
    private static Ventana instancia;
    private static PanelPrincipal panelPrincipal;

    private Ventana() {
        super();
        setTitle("Torneo");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panelPrincipal= new PanelPrincipal();
        add(panelPrincipal);
        setVisible(true);
    }

    /**
     * Al ser un singleton, este metodo se encarga de crear solo una instancia de ventana.
     * @return Instancia unica de ventana.
     * */
    public static Ventana getInstance() {
        if (instancia == null){
            instancia = new Ventana();
        }
        return instancia;
    }

    /**
     * Metodo encargado de realizar un repaint, o repintar la ventana y sus paneles.
     * */
    public static void actualizar(Menu menu) {
        instancia.repaint();
        panelPrincipal.actualizar(menu);
    }
}