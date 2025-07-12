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
        nombre = new JTextField(20);
        correo = new JTextField(20);
        JLabel etiqueta1 = new JLabel("Nombre:");
        JLabel etiqueta2 = new JLabel("Contacto:");
        agregar = new JButton("Agregar");
        agregar.addActionListener(e -> {
            String[] campos = getCampos();
            if (!campos[0].isBlank() && !campos[1].isBlank()) {
                PanelPrincipal.torneo.getParticipantes().addParticipante(new Participante(campos[0], campos[1]));
                nombre.setText("");
                correo.setText("");
                Ventana.actualizar();
            }
            });
        nombre.setBounds(60,0,100,20);
        add(nombre);
        correo.setBounds(60,20,100,20);
        add(correo);
        etiqueta1.setBounds(0,0,100,20);
        add(etiqueta1);
        etiqueta2.setBounds(0,20,100,20);
        add(etiqueta2);
        agregar.setBounds(32,70,100,20);
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
