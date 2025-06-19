public class Torneo {
    protected String nombre;
    protected String disciplina;

    public Torneo(String nombre, TiposDisciplina disciplina) {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}