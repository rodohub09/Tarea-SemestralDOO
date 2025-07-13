package vistas;

import modelos.TipoTorneo;

import javax.swing.*;
import java.awt.*;

public class MenuVerTorneo extends JPanel {
    private PanelTorneo panelTorneo;
    private JButton menuInicial;
    private Boolean crearpanel = true;

    public MenuVerTorneo(){
        super();
        setOpaque(false);
        setVisible(false);
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

    }

    public void setPanelTorneo(TipoTorneo tipoTorneo){
        switch (tipoTorneo){
            case Liga -> {
                panelTorneo = new PanelLiga();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(50,50,1000,600);
                add(panel);
            }
            case Eliminacion_Directa ->  {
                panelTorneo = new PanelEliminacionDirecta();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(50,50,1000,600);
                add(panel);
            }
            case Doble_Eliminacion -> {
                panelTorneo = new PanelDobleEliminacion();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(50,50,1000,600);
                add(panel);
            }
        }
    }

    public void actualizar(){
        if(crearpanel && PanelPrincipal.creado) {
            setPanelTorneo(PanelPrincipal.torneo.getTipoTorneo());
            crearpanel = false;
            panelTorneo.actualizar();
        }
        else if(panelTorneo != null)
            panelTorneo.actualizar();
    }
}
