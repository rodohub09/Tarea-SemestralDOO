public enum CantidadParticipantes {
    Cuatro(4,2),
    Ocho(8,4),
    Dieciseis(16,8),
    TreintayDos(32,16);

    private final int numParticipantes;
    private final int enfrentamientosXJornada;

    CantidadParticipantes (int numParticipantes, int enfrentamientosXJornada) {
        this.numParticipantes = numParticipantes;
        this.enfrentamientosXJornada = enfrentamientosXJornada;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public int getEnfrentamientosXJornada() {
        return enfrentamientosXJornada;
    }
}
