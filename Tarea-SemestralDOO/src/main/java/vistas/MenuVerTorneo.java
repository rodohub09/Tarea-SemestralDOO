package vistas;

import modelos.Participante;
import modelos.Participantes;
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
        ingresar.setBounds(400,700,300,60);
        ingresar.setFont(super.getFont().deriveFont(22f));
        ingresar.addActionListener(e -> {if (PanelPrincipal.torneo.torneoFinalizado())
                                                        new Excepciones("Este torneo ya ha finalizado");
                                                    else
                                                        new IngresarResultados(Ventana.getInstance()).setVisible(true);});

        JButton avanzar = new JButton("Siguiente Jornada");
        avanzar.setBounds(850,700,300,60);
        avanzar.setFont(super.getFont().deriveFont(22f));
        avanzar.addActionListener(e -> {
            if(addResultados) {
                PanelPrincipal.torneo.incJornada();
                if (PanelPrincipal.torneo.torneoFinalizado()) {
                    Participante campeon = PanelPrincipal.torneo.getCampeon();
                    Ventana.actualizar(Menu.VerTorneo);
                    new MostrarCampeon(Ventana.getInstance(), campeon).setVisible(true);
                    return;
                }
                PanelPrincipal.torneo.getCalendario().actualizarCalendario(PanelPrincipal.torneo.getParticipantes().devolverAgrupacion());
                setAddResultados();
                Ventana.actualizar(Menu.VerTorneo);
            } else {
                new Excepciones("Ingresa los resultados de la jornada");
        }
        });

        menuInicial = new JButton("<<<");
        menuInicial.setFont(super.getFont().deriveFont(20f));
        menuInicial.addActionListener(e -> Ventana.actualizar(Menu.Inicial));
        menuInicial.setBounds(20,20,70,40);
        add(menuInicial);

        panelCalendario = new PanelCalendario();
        panelCalendario.setBounds(1050,75,450,800);
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
        JLabel nombreTorneo = new JLabel(PanelPrincipal.torneo.getNombre() + " - " + PanelPrincipal.torneo.getDisciplina());
        nombreTorneo.setFont(super.getFont().deriveFont(26f));
        nombreTorneo.setBounds(450,10,500,60);
        add(nombreTorneo);

        switch (tipoTorneo){
            case Liga -> {
                panelTorneo = new PanelLiga();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(25,75,1000,600);
                add(panel);
            }
            case Eliminacion_Directa ->  {
                panelTorneo = new PanelEliminacionDirecta();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(25,75,1000,600);
                add(panel);
            }
            case Doble_Eliminacion -> {
                panelTorneo = new PanelDobleEliminacion();
                JPanel panel = panelTorneo.devolverPanel();
                panel.setBounds(25,75,1000,600);
                add(panel);
            }
        }
    }

    /**
     * Metodo que verifica la existencia de un torneo valido para mostrarlo en pantalla llamando al metodo del strategy asociado
     */
    public void actualizar(){
        actualizarActivos();
        panelCalendario.actualizarCalendario();
        if(crearpanel && PanelPrincipal.creado) {
            setPanelTorneo(PanelPrincipal.torneo.getTipoTorneo());
            crearpanel = false;
            panelTorneo.actualizar();
        }
        else if(panelTorneo != null)
            panelTorneo.actualizar();
    }

    /**
     * Cambia el valor booleano de addResultados para verificar que se actualizaron los resultados antes de avanzar de jornada
     */
    public static void setAddResultados(){
        addResultados = !addResultados;
    }

    public static void actualizarActivos(){
        int total = PanelPrincipal.torneo.getCalendario().getCantJornadas();
        int num = PanelPrincipal.torneo.getNumJornada();

        if (num < total)
            PanelPrincipal.torneo.getParticipantes().getAgrupacionParticipantes().actualizarParticipantes(PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada()).getEnfrentamientos());
    }
}
