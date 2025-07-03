package modelos;

public class Torneo {
    protected String nombre;
    protected TipoTorneo tipoTorneo;

    public Torneo(String nombre, TipoTorneo tipoTorneo) {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}