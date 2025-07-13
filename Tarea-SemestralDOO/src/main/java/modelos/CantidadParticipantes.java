package modelos;

public enum CantidadParticipantes {
    Cuatro(4,2,2,3),
    Ocho(8,4,3,7),
    Dieciseis(16,8,4,15),
    TreintayDos(32,16,5,31);

    private final int numParticipantes;
    private final int enfrentamientosXJornadaLiga;
    private final int enfrentamientosXJornadaElimDirecta;
    private final int jornadasLiga;

    CantidadParticipantes (int numParticipantes, int enfrentamientosXJornada, int enfrentamientosXJornadaElimDirecta,int jornadasLiga) {
        this.numParticipantes = numParticipantes;
        this.enfrentamientosXJornadaLiga = enfrentamientosXJornada;
        this.enfrentamientosXJornadaElimDirecta = enfrentamientosXJornadaElimDirecta;
        this.jornadasLiga = jornadasLiga;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public int getEnfrentamientosXJornadaLiga() {
        return enfrentamientosXJornadaLiga;
    }

    public int getEnfrentamientosXJornadaElimDirecta() {
        return enfrentamientosXJornadaElimDirecta;
    }

    public int getJornadasLiga() {
        return jornadasLiga;
    }

    @Override
    public String toString() {
        return String.valueOf(numParticipantes);
    }
}
