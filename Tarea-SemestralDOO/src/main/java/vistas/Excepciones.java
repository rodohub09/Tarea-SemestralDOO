package vistas;

import javax.swing.*;

/**
 * Clase que se extiende de {@link JDialog}, mostrando una ventana para indicar algunas excepciones.
 * */
public class Excepciones extends JDialog {
    public Excepciones(String string){
        super();
        JOptionPane.showMessageDialog(null,string,"Error",JOptionPane.INFORMATION_MESSAGE);
    }
}