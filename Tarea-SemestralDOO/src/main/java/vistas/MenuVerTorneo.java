package vistas;

import modelos.TipoTorneo;

import javax.swing.*;
import java.awt.*;

public class MenuVerTorneo extends JPanel {
    private PanelTorneo panelTorneo;
    private PanelCalendario panelCalendario;
    private JButton menuInicial;
    private Boolean crearpanel = true;
    private static Boolean addResultados = false;

    public MenuVerTorneo(){
        super();
        setOpaque(false);
        setVisible(false);
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        JButton ingresar = new JButton("Actualizar Resultados");
        ingresar.setBounds(600,700,300,40);
        ingresar.setFont(super.getFont().deriveFont(20f));
        ingresar.addActionListener(e -> new IngresarResultados(Ventana.getInstance()).setVisible(true));

        JButton avanzar = new JButton("Siguiente Jornada");
        avanzar.setBounds(1000,700,300,40);
        avanzar.setFont(super.getFont().deriveFont(20f));
        avanzar.addActionListener(e -> {if(addResultados) {PanelPrincipal.torneo.incJornada();
                                                    setAddResultados();
                                                    Ventana.actualizar(Menu.VerTorneo);
                                                  }else {
                                                    new Excepciones("Ingresa los resultados de la jornada");
        }
        });

        panelCalendario = new PanelCalendario();
        panelCalendario.setBounds(950,50,600,800);
        panelCalendario.setFont(super.getFont().deriveFont(20f));
        add(panelCalendario);
        add(ingresar);
        add(avanzar);

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

        panelCalendario.actualizarCalendario();
    }

    public static void setAddResultados(){
        addResultados = !addResultados;
    }
}
