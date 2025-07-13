package modelos;

public enum Formato {
    Ida_y_Vuelta(2),
    Solo_Ida(1);

    private final int numEnfrentamientos;

    Formato(int numEnfrentamientos){
        this.numEnfrentamientos = numEnfrentamientos;
    }

    public int getNumEnfrentamientos() {
        return numEnfrentamientos;
    }
}
