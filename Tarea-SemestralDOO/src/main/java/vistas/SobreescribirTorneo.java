package vistas;

import javax.swing.*;

/**
 * JDialog que advierte sobre la existencia de un torneo y la posibilidad de sobreescribirlo
 */
public class SobreescribirTorneo extends JDialog {
    public int mostrarDialogo() {
        return JOptionPane.showConfirmDialog(
                this,
                "Ya hay un torneo creado ¿Deseas sobreescribirlo?",
                "Precaución",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
    }
}
