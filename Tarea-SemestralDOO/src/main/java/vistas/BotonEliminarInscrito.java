package vistas;

import modelos.Participante;

import javax.swing.*;

public class BotonEliminarInscrito extends JButton {
    public BotonEliminarInscrito(Participante participante) {
        super();
        setText("Eliminar");
        setFont(super.getFont().deriveFont(12f));
        addActionListener(e -> {PanelPrincipal.torneo.getParticipantes().participantes.remove(participante);
                                            Ventana.actualizar(Menu.CrearTorneo);
                                            });
    }
}
