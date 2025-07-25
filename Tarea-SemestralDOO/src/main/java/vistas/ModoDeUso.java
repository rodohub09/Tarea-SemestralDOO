package vistas;

import javax.swing.*;

/**
 * Clase que muestra un JDialog con las instrucciones de uso del programa
 */
public class ModoDeUso extends JDialog {
    public ModoDeUso(){
        super();
        JOptionPane.showMessageDialog(null,
                "Instrucciones de uso:\nCrear Torneo:\nPermite crear un nuevo torneo, al cual se le debe asignar un nombre, tipo, cantidad de participantes, disciplina, formato y descripción, opcionalmente.\nAl añadir participantes se debe ingresar tanto nombre como contacto y al agregarlo este aparecerá en la tabla de inscritos.\n\nVer Torneo:\nPermite visualizar el estado de un torneo ya existente.\n\nEn el menú de visualización del torneo aparecerá el estado del torneo, ya sea la tabla o la disposición de los brackets, junto a los enfrentamientos de la jornada.\nPara seguir el curso del torneo, es necesario ingresar los resultados de la jornada actual dentro del menú desplegado con el botón Actualizar Resultados, solo así será posible avanzar de jornada mediante el botón Siguiente Jornada.",
                "Modo de uso",JOptionPane.INFORMATION_MESSAGE);
    }
}
