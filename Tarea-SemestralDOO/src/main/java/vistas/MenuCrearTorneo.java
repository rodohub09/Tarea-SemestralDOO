package vistas;

import javax.swing.*;
import java.awt.*;

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
            if(definirCaracteristicasTorneo.camposObligatorios()) {
                crearTorneo();
                Ventana.actualizar(Menu.VerTorneo);
            }
        });
        menuInicial = new JButton("<<<");
        menuInicial.setFont(super.getFont().deriveFont(20f));
        menuInicial.addActionListener(e -> Ventana.actualizar(Menu.Inicial));

        menuInicial.setBounds(20,20,70,40);
        add(menuInicial);

        definirCaracteristicasTorneo.setBounds(100,200,800,800);
        add(definirCaracteristicasTorneo);
        agregarParticipante.setBounds(200,600,500,500);
        add(agregarParticipante);
        panelInscritos.setBounds(1000,100,400,700);
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

    private void crearTorneo(){
        definirCaracteristicasTorneo.actualizarTorneo();
        PanelPrincipal.torneo.getParticipantes().setAgrupacionParticipantes(PanelPrincipal.torneo.getTipoTorneo());
        PanelPrincipal.torneo.getCalendario().setTipoDeCalendario(PanelPrincipal.torneo.getTipoTorneo(),
                PanelPrincipal.torneo.getFormato().getNumEnfrentamientos(),
                PanelPrincipal.torneo.getCantidadParticipantes(),
                PanelPrincipal.torneo.getParticipantes());
        PanelPrincipal.creado = true;
    }
}
