package vistas;

import modelos.TipoTorneo;
import modelos.Torneo;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public static Torneo torneo;
    private MenuInicial menuInicial;
    private MenuCrearTorneo crearTorneo;
    private MenuVerTorneo verTorneo;

    public PanelPrincipal() {
        super();
        torneo = new Torneo("Hola", TipoTorneo.EliminacionDirecta);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setOpaque(false);
        setLayout(null);
        setBackground(Color.BLACK);

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

    public void actualizar(){
        menuInicial.actualizar();
        crearTorneo.actualizar();
        verTorneo.actualizar();
    }
}
