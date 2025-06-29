import java.util.ArrayList;

public class Copa extends Torneo {
    private int cantEquipos;
    private String nombre;
    private ArrayList<Equipo> equipos;
    private TipoTorneo tipoTorneo;

    public Copa(String nombre, TiposDisciplina disciplina) {
        super(nombre, disciplina);
    }
}