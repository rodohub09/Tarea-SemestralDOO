package vistas;

import javax.swing.*;

/**
 * Interfaz strategy que permite cambiar la forma en la que se muestran los {@link modelos.Participante}
 */
public interface PanelTorneo {
    JPanel devolverPanel();
    void actualizar();
}
