package modelos;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Enfrentamiento {
    public Participante local;
    public Participante visita;
    private Participante ganador = null;
    private boolean esEmpate = false;
    private Date fecha;

    //Quizás se puede añadir el equipo perdedor también para los torneos de doble eliminación y las ligas
    public Enfrentamiento(Participante local, Participante visita, Date fecha) {
        this.local = local;
        this.visita = visita;
        this.fecha = fecha;
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

    public String getFecha() {
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM");
        return simple.format(fecha);
    }


    public String getLocal() {
        return local.getNombre();
    }

    public String getVisita() {
        return visita.getNombre();
    }

    @Override
    public String toString() {
        return "Partido: " + local.getNombre() + " vs " + visita.getNombre();
    }
}