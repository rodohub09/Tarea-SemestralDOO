package vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que almacena un {@link ButtonGroup} para ingresar los resultados de cada {@link modelos.Enfrentamiento}
 */
public class BotonResultado extends JPanel {
    private JToggleButton local;
    private JToggleButton visita;
    private JToggleButton empate;

    public BotonResultado(){
        local = new JToggleButton("Local");
        visita = new JToggleButton("Visita");
        empate = new JToggleButton("Empate");
        setLayout(new FlowLayout());

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(local);
        grupo.add(visita);
        grupo.add(empate);

        add(local);
        add(visita);
        add(empate);
    }

    /**
     * @return Devuelve una variable tipo int asociada acada seleccion posible
     */
    public int resultado(){
        if(local.isSelected())
            return 1;
        else if(visita.isSelected())
            return 2;
        else if(empate.isSelected())
            return 3;
        return 0;
    }
}
