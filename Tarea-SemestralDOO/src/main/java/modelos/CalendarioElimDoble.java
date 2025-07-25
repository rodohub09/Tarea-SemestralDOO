package modelos;

import java.util.ArrayList;

/**
 * Clase que representa el calendario para un torneo de eliminación doble.
 * Se encarga de crear y actualizar las jornadas del torneo utilizando los brackets
 * definidos por {@link AgrupacionElimDoble}.
 */
public class CalendarioElimDoble implements TipoDeCalendario {

    private int jornadas;

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
        jornadas = (int)(Math.log(upperBracket.size())/Math.log(2))*2;

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
        int ronda = alj.size();

        if (ronda == jornadas - 1){
            Jornada previo = alj.get(ronda-2);
            Enfrentamiento e1 = previo.enfrentamientos.getFirst();
            Enfrentamiento e2 = anteriorJornada.enfrentamientos.getFirst();
            Participante p1 = e1.getGanador();
            Participante p2 = e2.getGanador();
            jornada.enfrentamientos.add(new Enfrentamiento(p1,p2,null));

        }
        else if(ronda%2 == 0){
            for(int i = 0; i < anteriorJornada.enfrentamientos.size();i++){
                if(i < mitad){
                    continue;
                }
                else{
                    Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i-mitad);
                    Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i);
                    Participante p1 = e1.getPerdedor();
                    Participante p2 = e2.getGanador();
                    jornada.enfrentamientos.add(new Enfrentamiento(p1,p2,null));
                }
            }
        }
        else if (ronda == 1){
            ArrayList<Enfrentamiento> upper = new ArrayList<>();
            ArrayList<Enfrentamiento> lower = new ArrayList<>();
            for(int i = 0; i < anteriorJornada.enfrentamientos.size();i+=2){
                Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i);
                Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i+1);
                Participante p1 = e1.getGanador();
                Participante p2 = e2.getGanador();
                upper.add(new Enfrentamiento(p1,p2,null));

                p1 = e1.getPerdedor();
                p2 = e2.getPerdedor();
                lower.add(new Enfrentamiento(p1,p2,null));
            }
            jornada.enfrentamientos.addAll(upper);
            jornada.enfrentamientos.addAll(lower);
        }
        else {
            Jornada previo = alj.get(ronda - 2);
            for (int i = 0; i < previo.enfrentamientos.size()/2; i += 2) {
                Enfrentamiento e1 = previo.enfrentamientos.get(i);
                Enfrentamiento e2 = previo.enfrentamientos.get(i + 1);
                Participante p1 = e1.getGanador();
                Participante p2 = e2.getGanador();
                jornada.enfrentamientos.add(new Enfrentamiento(p1, p2, null));
            }
            for (int i = 0; i < anteriorJornada.enfrentamientos.size();i+=2) {
                Enfrentamiento e1 = anteriorJornada.enfrentamientos.get(i);
                Enfrentamiento e2 = anteriorJornada.enfrentamientos.get(i+1);
                Participante p1 = e1.getGanador();
                Participante p2 = e2.getGanador();
                jornada.enfrentamientos.add(new Enfrentamiento(p1, p2, null));
            }

        }

        alj.add(jornada);
    }
}