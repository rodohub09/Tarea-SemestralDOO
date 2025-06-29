import java.util.Date;

public class Enfrentamiento {
    private Equipo local;
    private Equipo visita;
    private Equipo ganador = null;
    private Date fecha;

    //Quizás se puede añadir el equipo perdedor también para los torneos de doble eliminación y las ligas
    public Enfrentamiento(Equipo local, Equipo visita){
        this.local = local;
        this.visita = visita;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public Equipo getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        return "Partido: " + local.getNombre() + " vs " + visita.getNombre();
    }
}
