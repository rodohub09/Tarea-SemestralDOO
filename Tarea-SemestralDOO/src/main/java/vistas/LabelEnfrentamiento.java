package vistas;

import javax.swing.*;

/**
 * JLabel que recibe strings asociadas a {@link modelos.Enfrentamiento} para crear texto
 */
public class LabelEnfrentamiento extends JLabel {
    public LabelEnfrentamiento(String local, String visita, String fecha){
        super();
        setText(local + " vs. " + visita + "  " + fecha);
    }
}
