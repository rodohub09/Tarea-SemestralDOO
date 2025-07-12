package vistas;

import javax.swing.*;

public class LabelEnfrentamiento extends JLabel {
    public LabelEnfrentamiento(String local, String visita, String fecha){
        super();
        setText(local + " vs. " + visita + "  " + fecha);
    }
}
