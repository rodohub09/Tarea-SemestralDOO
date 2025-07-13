package vistas;

import modelos.Participante;

import javax.swing.*;
import java.awt.*;

public class AgregarParticipante extends JPanel {
    JTextField nombre;
    JTextField correo;
    JButton agregar;

    public AgregarParticipante(){
        super();
        setOpaque(false);
        setLayout(null);
        setBackground(Color.BLACK);
        nombre = new JTextField(20);
        nombre.setFont(super.getFont().deriveFont(20f));
        correo = new JTextField(20);
        correo.setFont(super.getFont().deriveFont(20f));
        JLabel etiqueta1 = new JLabel("Nombre:");
        etiqueta1.setFont(super.getFont().deriveFont(20f));
        JLabel etiqueta2 = new JLabel("Contacto:");
        etiqueta2.setFont(super.getFont().deriveFont(20f));
        agregar = new JButton("Agregar");
        agregar.setFont(super.getFont().deriveFont(20f));
        agregar.addActionListener(e -> {
            String[] campos = getCampos();
            if (!campos[0].isBlank() && !campos[1].isBlank()) {
                PanelPrincipal.torneo.getParticipantes().addParticipante(new Participante(campos[0], campos[1]));
                nombre.setText("");
                correo.setText("");
                Ventana.actualizar(Menu.CrearTorneo);
            }
            });
        nombre.setBounds(100,0,100,30);
        add(nombre);
        correo.setBounds(100,40,100,30);
        add(correo);
        etiqueta1.setBounds(0,0,100,30);
        add(etiqueta1);
        etiqueta2.setBounds(0,40,100,30);
        add(etiqueta2);
        agregar.setBounds(32,80,200,30);
        add(agregar);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public String[] getCampos(){
        if(!nombre.getText().isBlank() && !correo.getText().isBlank())
            return new String[]{nombre.getText(),correo.getText()};
        return new String[]{"",""};
    }
}
