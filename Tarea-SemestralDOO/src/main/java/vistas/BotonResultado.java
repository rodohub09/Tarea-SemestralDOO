package vistas;

import modelos.Formato;
import modelos.TipoTorneo;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que almacena un {@link ButtonGroup} para ingresar los resultados de cada {@link modelos.Enfrentamiento}
 */
public class BotonResultado extends JPanel {
    private JToggleButton local;
    private JToggleButton visita;
    private JToggleButton empate;
    private boolean esElimSoloIda;

    public BotonResultado() {
        Formato formato = PanelPrincipal.torneo.getFormato();
        TipoTorneo tipoTorneo = PanelPrincipal.torneo.getTipoTorneo();

        local = new JToggleButton("Local");
        visita = new JToggleButton("Visita");

        setLayout(new FlowLayout());
        ButtonGroup grupo = new ButtonGroup();

        grupo.add(local);
        grupo.add(visita);

        add(local);
        add(visita);

        esElimSoloIda = (tipoTorneo == TipoTorneo.Eliminacion_Directa || tipoTorneo == TipoTorneo.Doble_Eliminacion) && formato == Formato.Solo_Ida;

        if (!esElimSoloIda) {
            empate = new JToggleButton("Empate");
            grupo.add(empate);
            add(empate);
        }
    }

    /**
     * @return Devuelve una variable tipo int asociada acada seleccion posible
     */
    public int resultado(){
        if(local.isSelected())
            return 1;
        else if(visita.isSelected())
            return 2;
        else if(!esElimSoloIda && empate.isSelected())
            return 3;
        return 0;
    }
}
