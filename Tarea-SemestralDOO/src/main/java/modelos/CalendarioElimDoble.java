package modelos;

import vistas.PanelPrincipal;

import java.util.ArrayList;

/**
 * Clase que representa el calendario para un torneo de eliminación doble.
 * Se encarga de crear y actualizar las jornadas del torneo utilizando los brackets
 * definidos por {@link AgrupacionElimDoble}.
 */
public class CalendarioElimDoble implements TipoDeCalendario {
    /**
     * Crea el calendario inicial con enfrentamientos entre los participantes del Upper Bracket.
     * @param alj Lista de jornadas del torneo.
     * @param cantEnfrentamientosJornada Cantidad de enfrentamientos por jornada.
     * @param p Configuración de cantidad de participantes.
     * @param participantes Lista de participantes agrupados según el tipo de torneo.
     */
    @Override
    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfrentamientosJornada, CantidadParticipantes p, Participantes participantes) {
        Jornada jornadaInicial = new Jornada();
        ArrayList<Participante> upperBracket = participantes.participantes;

        for (int i = 0; i < upperBracket.size() / 2; i++) {
            Enfrentamiento e = new Enfrentamiento(upperBracket.get(i), upperBracket.get(upperBracket.size() - i - 1), null);
            jornadaInicial.getEnfrentamientos().add(e);
        }
        alj.add(jornadaInicial);
    }

    /**
     * Actualiza las siguientes jornadas del torneo considerando los ganadores y perdedores de la jornada actual.
     * @param alj Lista de jornadas del torneo.
     */
    public void actualizarCalendario(ArrayList<Jornada> alj, ArrayList<Participante> activos) {
        Jornada jornada = new Jornada();
        Jornada anteriorJornada = alj.getLast();
        int mitad = anteriorJornada.enfrentamientos.size()/2;
        if(alj.size()%2 == 0){
            for(int i = 0; i < anteriorJornada.enfrentamientos.size();i++){
                if(i < mitad){
                    continue;
                }
                else{
                    Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i-mitad);
                    Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i);
                    Participante p1 = e1.getLocal() == e1.getGanador() ? e1.getVisita() : e1.getLocal();
                    Participante p2 = e2.getGanador();
                    jornada.enfrentamientos.add(new Enfrentamiento(p1,p2,null));
                }
            }
        }
        else if (alj.size()==1){
            for(int i = 0; i < anteriorJornada.enfrentamientos.size();i+=2){
                if(i < mitad){
                    Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i);
                    Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i+1);
                    Participante p1 = e1.getGanador();
                    Participante p2 = e2.getGanador();
                    jornada.enfrentamientos.add(new Enfrentamiento(p1,p2,null));
                }
                else{
                    Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i);
                    Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i+1);
                    Participante p1 = e1.getGanador();
                    Participante p2 = e2.getGanador();
                    jornada.enfrentamientos.add(new Enfrentamiento(p1,p2,null));
                }
            }
        }
        else {

        }
        alj.add(jornada);
    }
}