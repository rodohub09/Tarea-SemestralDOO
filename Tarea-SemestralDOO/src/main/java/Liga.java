import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Liga extends Torneo {
    private int cantEquipos;
    private ArrayList<Equipo> equipos;
    private ArrayList<Integer> posiciones;

    public Liga(String nombre, TiposDisciplina disciplina) {
        super(nombre, disciplina);
        setPosiciones();
    }

    public void setCantEquipos(int cantEquipos) {
        this.cantEquipos = cantEquipos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setPosiciones() {
        Scanner scanner = new Scanner(System.in);
        int cantidad = scanner.nextInt();
        this.setCantEquipos(cantidad);
        this.posiciones = new ArrayList<>(cantEquipos);
        Random random = new Random();

        while (posiciones.size() < cantEquipos) {
            int pos = random.nextInt(cantEquipos) + 1;
            if (!posiciones.contains(pos)) {
                posiciones.add(pos);
            }
        }

        for (int i = 0; i < cantEquipos; i++) {
            if (equipos != null) {
                Equipo equipo = equipos.get(i);
                int posicion = posiciones.get(i);
                equipo.setPosicion(posicion);
            }
        }
    }
}