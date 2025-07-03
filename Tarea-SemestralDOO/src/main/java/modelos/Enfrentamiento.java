package modelos;
import java.util.Date;

public class Enfrentamiento {
    private Participante local;
    private Participante visita;
    private Participante ganador = null;
    private boolean esEmpate = false;
    private Date fecha;

    //Quizás se puede añadir el equipo perdedor también para los torneos de doble eliminación y las ligas
    public Enfrentamiento(Participante local, Participante visita) {
        this.local = local;
        this.visita = visita;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
        this.esEmpate = false;

        local.registrarResultado((local == ganador) ? Resultados.Victoria : Resultados.Derrota);
        visita.registrarResultado((visita == ganador) ? Resultados.Victoria : Resultados.Derrota);
    }

    public void setEmpate() {
        this.ganador = null;
        this.esEmpate = true;

        local.registrarResultado(Resultados.Empate);
        visita.registrarResultado(Resultados.Empate);
    }

    public boolean isEmpate() {
        return esEmpate;
    }

    public Participante getGanador() {
        return ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Partido: " + local.getNombre() + " vs " + visita.getNombre();
    }
}