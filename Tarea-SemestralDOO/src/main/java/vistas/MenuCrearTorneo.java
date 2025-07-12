package vistas;

import javax.swing.*;
import java.awt.*;

public class MenuCrearTorneo extends JPanel {
    private DefinirCaracteristicasTorneo definirCaracteristicasTorneo;
    private AgregarParticipante agregarParticipante;
    private PanelInscritos panelInscritos;

    public MenuCrearTorneo() {
        setOpaque(false);
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        definirCaracteristicasTorneo = new DefinirCaracteristicasTorneo();
        agregarParticipante = new AgregarParticipante();
        panelInscritos = new PanelInscritos();
        definirCaracteristicasTorneo.setBounds(400,400,800,800);
        add(definirCaracteristicasTorneo);
        agregarParticipante.setBounds(200,200,500,500);
        add(agregarParticipante);
        panelInscritos.setBounds(700,100,300,500);
        add(panelInscritos);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizar(){
        panelInscritos.actualizarInscritos();
    }
}
