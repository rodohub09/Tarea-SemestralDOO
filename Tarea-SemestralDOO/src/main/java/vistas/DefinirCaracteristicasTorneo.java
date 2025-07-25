package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que contiene {@link JComboBox} y {@link JTextField} para ingresar los campos requeridos para el torneo
 */
public class DefinirCaracteristicasTorneo extends JPanel {
    private JComboBox<TipoTorneo> tipoTorneo;
    private JComboBox<CantidadParticipantes> cantidadParticipantes;
    private JComboBox<Formato> formatoTorneo;
    private JTextField nombreTorneo;
    private JTextField disciplinaTorneo;
    private JTextArea descripcionTorneo;

    public DefinirCaracteristicasTorneo(){
        super();
        setOpaque(false);
        setLayout(null);

        tipoTorneo = new JComboBox<>(new TipoTorneo[]{TipoTorneo.Liga,TipoTorneo.Eliminacion_Directa,TipoTorneo.Doble_Eliminacion});
        tipoTorneo.setFont(super.getFont().deriveFont(20f));

        cantidadParticipantes = new JComboBox<>(CantidadParticipantes.values());
        cantidadParticipantes.setFont(super.getFont().deriveFont(20f));

        formatoTorneo = new JComboBox<>(Formato.values());
        formatoTorneo.setFont(super.getFont().deriveFont(20f));

        nombreTorneo = new JTextField(20);
        nombreTorneo.setFont(super.getFont().deriveFont(20f));

        disciplinaTorneo = new JTextField(20);
        disciplinaTorneo.setFont(super.getFont().deriveFont(20f));

        descripcionTorneo = new JTextArea(5,100);
        descripcionTorneo.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta1 = new JLabel("Nombre del Torneo:");
        etiqueta1.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta2 = new JLabel("Tipo de Torneo:");
        etiqueta2.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta3 = new JLabel("Cantidad de Participantes:");
        etiqueta3.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta4 = new JLabel("Disciplina:");
        etiqueta4.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta5 = new JLabel("Descripción:");
        etiqueta5.setFont(super.getFont().deriveFont(20f));

        JLabel etiqueta6 = new JLabel("Formato");
        etiqueta6.setFont(super.getFont().deriveFont(20f));

        nombreTorneo.setBounds(200,0,240,30);
        tipoTorneo.setBounds(150,40,240,30);
        cantidadParticipantes.setBounds(250,80,50,30);
        disciplinaTorneo.setBounds(200,120,240,30);
        formatoTorneo.setBounds(200,160,150,30);
        descripcionTorneo.setBounds(150,200,400,200);
        descripcionTorneo.setLineWrap(true);
        descripcionTorneo.setWrapStyleWord(true);
        etiqueta1.setBounds(0,0,200,30);
        etiqueta2.setBounds(0,40,250,30);
        etiqueta3.setBounds(0,80,250,30);
        etiqueta4.setBounds(0,120,250,30);
        etiqueta5.setBounds(0,200,250,30);
        etiqueta6.setBounds(0,160,250,30);

        add(nombreTorneo);
        add(tipoTorneo);
        add(cantidadParticipantes);
        add(disciplinaTorneo);
        add(descripcionTorneo);
        add(formatoTorneo);
        add(etiqueta1);
        add(etiqueta2);
        add(etiqueta3);
        add(etiqueta4);
        add(etiqueta5);
        add(etiqueta6);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * @throws CamposObligatoriosException Verifica que se hayan rellenado los campos obligatorios,
     * de ser asi actualiza los datos de la instancia static de {@link modelos.Torneo} en {@link PanelPrincipal}
     * */
    public void actualizarTorneo() throws CamposObligatoriosException, ModosIncompatiblesException {
        if(!camposObligatorios()){
            throw new CamposObligatoriosException();
        }
        else if (modosIncompatibles())
            throw new ModosIncompatiblesException();
        else {
            PanelPrincipal.torneo.setNombre(nombreTorneo.getText());
            PanelPrincipal.torneo.setTipoTorneo((TipoTorneo) tipoTorneo.getSelectedItem());
            PanelPrincipal.torneo.setDisciplina(disciplinaTorneo.getText());
            PanelPrincipal.torneo.setCantidadParticipantes((CantidadParticipantes) cantidadParticipantes.getSelectedItem());
            PanelPrincipal.torneo.setDescripcion(descripcionTorneo.getText());
            PanelPrincipal.torneo.setFormato((Formato) formatoTorneo.getSelectedItem());
            limpiarEntradas();
        }
    }


    /**
     * @return Valor booleano que verifica que los campos obligatorios esten llenos
     */
    public Boolean camposObligatorios() {
        return !nombreTorneo.getText().isBlank() && !disciplinaTorneo.getText().isBlank();
    }

    public Boolean modosIncompatibles() {
        return (tipoTorneo.getSelectedItem().equals(TipoTorneo.Doble_Eliminacion)||tipoTorneo.getSelectedItem().equals(TipoTorneo.Eliminacion_Directa)) && formatoTorneo.getSelectedItem().equals(Formato.Ida_y_Vuelta);
    }

    public void limpiarEntradas() {
        nombreTorneo.setText("");
        disciplinaTorneo.setText("");
        descripcionTorneo.setText("");
    }
}
