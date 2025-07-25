package vistas;

import modelos.Enfrentamiento;
import modelos.Jornada;
import modelos.ResultadosSinIngresarException;

import javax.swing.*;
import java.util.ArrayList;

/**
 * JDialog que se despliega desde {@link MenuVerTorneo} y permite determinar los resultados de {@link Enfrentamiento}
 */
public class IngresarResultados extends JDialog {
    private PanelCalendario panelCalendario;
    private JScrollPane scrollPane;
    private JPanel panel;
    private ArrayList<BotonResultado> botonEnfrentamientos;

    public IngresarResultados(JFrame ventana){
        super(ventana,"Ingresar Resultados");
        setSize(900,800);
        setLocationRelativeTo(ventana);
        panelCalendario = new PanelCalendario();
        panelCalendario.setBounds(25, 25, 450, 600);
        panelCalendario.actualizarCalendario();
        add(panelCalendario);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(475,25,420,600);
        botonEnfrentamientos = new ArrayList<>();

        JButton guardar = new JButton("Guardar Resultados");
        guardar.setBounds(250, 650,300,100);
        guardar.setFont(super.getFont().deriveFont(20f));
        guardar.addActionListener(e -> {
                try{
                    guardar();
                    MenuVerTorneo.setAddResultados();
                    Ventana.actualizar(Menu.VerTorneo);
                    dispose();
                }
                catch (ResultadosSinIngresarException resultadosSinIngresarException){
                    new Excepciones("Ingrese todos los resultados de la jornada");
                }
        });

        add(guardar);
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);
        ingresarResultados();
        add(panel);
    }

    /**
     * Metodo que crea un panel que contiene instancias de {@link BotonResultado}, este panel luego es ingresado en el Scrollpane de la clase
     */
    public void ingresarResultados(){
        if(PanelPrincipal.torneo.getCalendario() != null) {
            Jornada jornada = PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada());
            JPanel panel = new JPanel();
            panel.setLayout(null);
            JLabel titulo = new JLabel("Seleccionar Resultados");
            titulo.setBounds(20,0,420,40);
            panel.add(titulo);
            titulo.setFont(super.getFont().deriveFont(36f));
            panel.add(titulo);
            for (Enfrentamiento e : jornada.getEnfrentamientos()) {
                BotonResultado botonResultado = getBotonResultado();
                botonResultado.setBounds(70,40+jornada.getEnfrentamientos().indexOf(e)*30,300,30);
                panel.add(botonResultado);
                botonEnfrentamientos.add(botonResultado);
            }
            scrollPane.setViewportView(panel);
        }
    }

    /**
     * @return Instancia requerida de {@link BotonResultado}
     */
    private BotonResultado getBotonResultado() {
        BotonResultado botonResultado = new BotonResultado();
        botonResultado.setFont(super.getFont().deriveFont(20f));
        return botonResultado;
    }

    /**
     * Guarda los resultados mediante el setGanador de los {@link Enfrentamiento} de la {@link Jornada}
     */
    private void guardar() {
        Jornada jornada = PanelPrincipal.torneo.getCalendario().getJornada(PanelPrincipal.torneo.getNumJornada());
        for (Enfrentamiento e : jornada.getEnfrentamientos()) {
            if (botonEnfrentamientos.get(jornada.getEnfrentamientos().indexOf(e)).resultado() == 0)
                throw new ResultadosSinIngresarException();
            else if(botonEnfrentamientos.get(jornada.getEnfrentamientos().indexOf(e)).resultado() == 1){
                e.setGanador(e.local);
            }
            else if(botonEnfrentamientos.get(jornada.getEnfrentamientos().indexOf(e)).resultado() == 2)
                e.setGanador(e.visita);
            else
                e.setEmpate();
        }
    }
}
