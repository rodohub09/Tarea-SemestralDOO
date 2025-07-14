package vistas;

import modelos.TipoTorneo;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que contiene la vista principal de un {@link modelos.Torneo} ya creado
 * Permite actualizar los resultados del torneo y avanzar las jornadas mediante {@link JButton}
 */
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
                                                    PanelPrincipal.torneo.getCalendario().actualizarCalendario();
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

    /**
     * Setter del {@link PanelTorneo} a implementar
     * @param tipoTorneo Determina el strategy a utilizar
     */
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

    /**
     * Metodo que verifica la existencia de un torneo valido para mostrarlo en pantalla llamando al metodo del strategy asociado
     */
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

    /**
     * Cambia el valor booleano de addResultados para verificar que se actualizaron los resultados antes de avanzar de jornada
     */
    public static void setAddResultados(){
        addResultados = !addResultados;
    }
}
