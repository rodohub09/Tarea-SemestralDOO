package modelos;

public enum CantidadParticipantes {
    Cuatro(4,2,2),
    Ocho(8,4,3),
    Dieciseis(16,8,4),
    TreintayDos(32,16,5);

    private final int numParticipantes;
    private final int enfrentamientosXJornadaLiga;
    private final int enfrentamientosXJornadaElimDirecta;

    CantidadParticipantes (int numParticipantes, int enfrentamientosXJornada, int enfrentamientosXJornadaElimDirecta) {
        this.numParticipantes = numParticipantes;
        this.enfrentamientosXJornadaLiga = enfrentamientosXJornada;
        this.enfrentamientosXJornadaElimDirecta = enfrentamientosXJornadaElimDirecta;
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
}
