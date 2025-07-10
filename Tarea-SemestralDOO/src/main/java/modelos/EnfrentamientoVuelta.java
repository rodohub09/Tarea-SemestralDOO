package modelos;

import java.util.Date;

public class EnfrentamientoVuelta extends Enfrentamiento{
    private Enfrentamiento enfrentamientoIda;
    private Participante ganadorGlobal = null;
    private Participante ganadorDeEstePartido = null;

    public EnfrentamientoVuelta(Participante local, Participante visita, Date fecha, Enfrentamiento enfrentamiento){
        super(local, visita, fecha);
        this.enfrentamientoIda = enfrentamiento;
    }

    public void setGanador(Participante ganadorGlobal) {
        this.ganadorGlobal = ganadorGlobal;
    }

    public Participante getGanador() {
        return ganadorGlobal;
    }

    public Participante getGanadorDeEstePartido() {
        return ganadorDeEstePartido;
    }

    public void setGanadorDeEstePartido(Participante ganadorDeEstePartido) {
        this.ganadorDeEstePartido = ganadorDeEstePartido;
    }
}
