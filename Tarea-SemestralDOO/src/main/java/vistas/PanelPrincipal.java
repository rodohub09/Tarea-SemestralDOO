package vistas;

import modelos.TipoTorneo;
import modelos.Torneo;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que contiene los menus principales del programa
 * */
public class PanelPrincipal extends JPanel {
    public static Torneo torneo;
    public static Boolean creado = false;
    private MenuInicial menuInicial;
    private MenuCrearTorneo crearTorneo;
    private MenuVerTorneo verTorneo;

    public PanelPrincipal() {
        super();
        torneo = new Torneo("Hola", TipoTorneo.ND);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setOpaque(false);
        setLayout(null);

        menuInicial = new MenuInicial();
        crearTorneo = new MenuCrearTorneo();
        verTorneo = new MenuVerTorneo();

        add(menuInicial);
        add(crearTorneo);
        add(verTorneo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Metodo que recibe un {@param menu} para cambiar el setVisible de cada Menu segun corresponda
     */
    public void actualizar(Menu menu){
        switch (menu) {
            case Inicial -> {
                menuInicial.setVisible(true);
                crearTorneo.setVisible(false);
                verTorneo.setVisible(false);
                menuInicial.actualizar();
            }
            case CrearTorneo -> {
                menuInicial.setVisible(false);
                crearTorneo.setVisible(true);
                verTorneo.setVisible(false);
                crearTorneo.actualizar();
            }
            case VerTorneo -> {
                menuInicial.setVisible(false);
                crearTorneo.setVisible(false);
                verTorneo.setVisible(true);
                verTorneo.actualizar();
            }
        }
    }
}
