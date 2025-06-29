import java.util.Date;

public class Enfrentamiento {
    private Participante local;
    private Participante visita;
    private Participante ganador = null;
    private Date fecha;

    //Quizás se puede añadir el equipo perdedor también para los torneos de doble eliminación y las ligas
    public Enfrentamiento(Participante local, Participante visita){
        this.local = local;
        this.visita = visita;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public Participante getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        return "Partido: " + local.getNombre() + " vs " + visita.getNombre();
    }
}