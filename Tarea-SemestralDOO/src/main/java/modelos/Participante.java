package modelos;

public class Participante implements Observer {
    private String nombre;
    private String contacto;
    private int partidosJugados;
    private int wins;
    private int losses;
    private int draws;
    private int puntos;

    public Participante(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.partidosJugados = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.puntos = 0;
    }

    @Override
    public void registrarResultado(Resultados resultado) {
        partidosJugados++;
        switch (resultado) {
            case Victoria -> {
                wins++;
                puntos += 3;
            }
            case Derrota -> losses++;
            case Empate -> {
                draws++;
                puntos += 1;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getPuntos() {
        return puntos;
    }
}