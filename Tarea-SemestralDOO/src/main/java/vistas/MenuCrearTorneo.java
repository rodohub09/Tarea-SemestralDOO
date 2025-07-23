package vistas;

import modelos.CamposObligatoriosException;
import modelos.CantidadInscritosInvalidaException;

import javax.swing.*;
import java.awt.*;

/**
 * Menu que contiene todas las caracteristicas requeridas para crear correctamente un torneo
 * Primero
 */
public class MenuCrearTorneo extends JPanel {
    private DefinirCaracteristicasTorneo definirCaracteristicasTorneo;
    private AgregarParticipante agregarParticipante;
    private PanelInscritos panelInscritos;
    private JButton crearTorneo;
    private JButton menuInicial;

    public MenuCrearTorneo() {
        super();
        setOpaque(false);
        setLayout(null);
        setVisible(false);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        definirCaracteristicasTorneo = new DefinirCaracteristicasTorneo();
        agregarParticipante = new AgregarParticipante();
        panelInscritos = new PanelInscritos();
        crearTorneo = new JButton("Crear Torneo");
        crearTorneo.setFont(super.getFont().deriveFont(20f));
        crearTorneo.addActionListener(e -> {
                try {
                    crearTorneo();
                    Ventana.actualizar(Menu.VerTorneo);
                }
                catch (CantidadInscritosInvalidaException cantidadInscritosInvalidaException){
                    new Excepciones("La cantidad de inscritos es distinta de la seleccionada");
                }
                catch (CamposObligatoriosException camposObligatoriosException){
                    new Excepciones("Debes rellenar los campos Nombre del Torneo y Disciplina");
                }

        });
        menuInicial = new JButton("<<<");
        menuInicial.setFont(super.getFont().deriveFont(20f));
        menuInicial.addActionListener(e -> Ventana.actualizar(Menu.Inicial));

        JLabel etiqueta1 = new JLabel("Crea un Torneo");
        etiqueta1.setFont(super.getFont().deriveFont(36f));
        etiqueta1.setBounds(680,20,400,40);
        add(etiqueta1);

        JLabel etiqueta2 = new JLabel("Agregar Participante");
        etiqueta2.setFont(super.getFont().deriveFont(36f));
        etiqueta2.setBounds(240,520,400,42);
        add(etiqueta2);

        menuInicial.setBounds(20,20,70,40);

        add(menuInicial);

        definirCaracteristicasTorneo.setBounds(180,100,800,800);
        add(definirCaracteristicasTorneo);
        agregarParticipante.setBounds(280,600,500,500);
        add(agregarParticipante);
        panelInscritos.setBounds(1000,100,500,700);
        add(panelInscritos);
        crearTorneo.setBounds(1100,720,200,50);
        add(crearTorneo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizar(){
        panelInscritos.actualizarInscritos();
    }

    /**
     * Metodo que settea las caracteristicas del {@link modelos.Torneo} de las selecciones de los paneles asociados
     * @throws CantidadInscritosInvalidaException Verifica que la cantidad de {@link modelos.Participante} inscritos coincida
     * con la {@link modelos.CantidadParticipantes} asociada al torneo
     * @throws CamposObligatoriosException Verifica que se hayan rellenado completamente los campos obligatorios del torneo
     */
    private void crearTorneo() throws CantidadInscritosInvalidaException, CamposObligatoriosException{
        try {
            definirCaracteristicasTorneo.actualizarTorneo();
        }
        catch (CamposObligatoriosException camposObligatoriosException){
            throw camposObligatoriosException;
        }
        if(PanelPrincipal.torneo.getParticipantes().getArrayParticipante().size() != PanelPrincipal.torneo.getCantidadParticipantes().getNumParticipantes())
            throw new CantidadInscritosInvalidaException();
        else {
            PanelPrincipal.torneo.getParticipantes().setAgrupacionParticipantes(PanelPrincipal.torneo.getTipoTorneo());
            PanelPrincipal.torneo.getCalendario().setTipoDeCalendario(PanelPrincipal.torneo.getTipoTorneo(),
                    PanelPrincipal.torneo.getFormato().getNumEnfrentamientos(),
                    PanelPrincipal.torneo.getCantidadParticipantes(),
                    PanelPrincipal.torneo.getParticipantes());
            PanelPrincipal.torneo.getParticipantes().agrupar();
            PanelPrincipal.creado = true;
        }
    }
}
