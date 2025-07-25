package vistas;

import modelos.Torneo;

import javax.swing.*;
import java.awt.*;

/**
 * Menu que muestra los {@link JButton} para avanzar en la creacion del torneo
 */
public class MenuInicial extends JPanel {
    private JButton crearTorneo;
    private JButton verTorneo;

    public MenuInicial(){
        super();
        setOpaque(false);
        setVisible(true);
        setLayout(null);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        crearTorneo = new JButton("Crear Torneo");
        crearTorneo.setFont(super.getFont().deriveFont(22f));
        crearTorneo.addActionListener(e -> {if(!PanelPrincipal.creado)
                                                            Ventana.actualizar(Menu.CrearTorneo);
                                                        else
                                                        {int opcion = new SobreescribirTorneo().mostrarDialogo();
                                                         if(opcion == JOptionPane.YES_OPTION){
                                                             PanelPrincipal.creado = !PanelPrincipal.creado;
                                                             Ventana.reiniciarTorneo();
                                                             Ventana.actualizar(Menu.CrearTorneo);
                                                            }
                                                           }
                                                        });

        verTorneo = new JButton("Ver Torneo");
        verTorneo.setFont(super.getFont().deriveFont(22f));
        verTorneo.addActionListener(e -> {if(PanelPrincipal.creado)
                                                        Ventana.actualizar(Menu.VerTorneo);
                                                     else
                                                         new Excepciones("No hay un torneo creado actualmente");});

        crearTorneo.setBounds(300,200,400,400);
        verTorneo.setBounds(900,200,400,400);

        add(crearTorneo);
        add(verTorneo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizar(){
    }
}
