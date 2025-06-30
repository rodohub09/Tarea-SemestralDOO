import java.util.ArrayList;
import java.util.Random;

public class JornadaaXPuntos implements TipoDeCalendario{
    public JornadaaXPuntos(){

    }

    public void crearCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes) {
        int[][] matrizEnfrentamientos = new int[p.getNumParticipantes()][p.getNumParticipantes()];
        for(int i=0;i< (p.getNumParticipantes()-1)*cantEnfretamientosIgual;i++){
            alj.add(new Jornada());
        }
        for(int i=0;i<p.getNumParticipantes();i++){
            for(int j=0;j<p.getNumParticipantes();j++){
                if(i==j || (matrizEnfrentamientos[j][i]!=0 && cantEnfretamientosIgual==1)){
                    continue;
                } else if(matrizEnfrentamientos[j][i]==0){
                    matrizEnfrentamientos[i][j] = new Random().nextInt((((p.getNumParticipantes()-1)*cantEnfretamientosIgual)-1)+1)+1;
                    while (!noSeRepite(matrizEnfrentamientos[i][j],matrizEnfrentamientos,p,i)){
                        matrizEnfrentamientos[i][j] = new Random().nextInt((((p.getNumParticipantes()-1)*cantEnfretamientosIgual)-1)+1)+1;
                    }
                    alj.get(matrizEnfrentamientos[i][j]-1).partidos.add(new Enfrentamiento(participantes.getParticipante(i),participantes.getParticipante(j)));
                } else if(matrizEnfrentamientos[j][i]<=p.getNumParticipantes()-1){
                    matrizEnfrentamientos[i][j] = new Random().nextInt((((p.getNumParticipantes()-1)*cantEnfretamientosIgual)-p.getNumParticipantes())+1) + p.getNumParticipantes();
                    alj.get(matrizEnfrentamientos[i][j]-1).partidos.add(new Enfrentamiento(participantes.getParticipante(i),participantes.getParticipante(j)));
                } else if(matrizEnfrentamientos[j][i]>p.getNumParticipantes()-1){
                    matrizEnfrentamientos[i][j] = new Random().nextInt((((p.getNumParticipantes()-1)-0)+1)) + 1;
                    alj.get(matrizEnfrentamientos[i][j]-1).partidos.add(new Enfrentamiento(participantes.getParticipante(i),participantes.getParticipante(j)));
                }
            }
        }
        for(int i=0;i<p.getNumParticipantes();i++){
            for(int j=0;j<p.getNumParticipantes();j++){
                System.out.println(matrizEnfrentamientos[i][j]+", ");
            }
            System.out.println("\n");
        }
    }

    private boolean noSeRepite(int q, int[][] t, CantidadParticipantes p,int j){
        int aux = 0;
        for(int i=0;i<p.getNumParticipantes()-1;i++) {
            if (t[j][i] != q && t[i][j] != q) {
                aux++;
            } else {
                System.out.println();
                continue;
            }
        }
        if(aux == p.getNumParticipantes()-1){
            return true;
        }else{
            return false;
        }
    }
}
