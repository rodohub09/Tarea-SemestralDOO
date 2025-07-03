import java.util.ArrayList;
import java.util.Random;

public class CalendarioXPuntos implements TipoDeCalendario{
    public CalendarioXPuntos() {

    }

    public void creacionCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes){
        int cal = crearCalendario(alj,  cantEnfretamientosIgual,  p,  participantes);
        while(cal == 0){
            alj = new ArrayList<>();
            cal = crearCalendario(alj,  cantEnfretamientosIgual,  p,  participantes);
        }
    }

    public int crearCalendario(ArrayList<Jornada> alj, int cantEnfretamientosIgual, CantidadParticipantes p, Participantes participantes) {
        int[][] matrizEnfrentamientos = new int[p.getNumParticipantes()][p.getNumParticipantes()];
        for(int i=0;i< (p.getNumParticipantes()-1)*cantEnfretamientosIgual;i++){
            alj.add(new Jornada(participantes,TipoTorneo.Liga));
        }
        int intentos = 0;
        for(int i=0;i<p.getNumParticipantes();i++){
            for(int j=0;j<p.getNumParticipantes();j++){
                if(i==j || (matrizEnfrentamientos[j][i]!=0 && cantEnfretamientosIgual==1)){
                    continue;
                } else if(matrizEnfrentamientos[j][i]==0){
                    if( (cantEnfretamientosIgual == 1) && j==new Random().nextInt(p.getNumParticipantes()-1)+1){
                        continue;
                    }else{
                        matrizEnfrentamientos[i][j] = new Random().nextInt((p.getNumParticipantes()-1)*cantEnfretamientosIgual)+1;
                        while (seRepite(matrizEnfrentamientos, i, j, p,matrizEnfrentamientos[i][j])){
                            matrizEnfrentamientos[i][j] = new Random().nextInt((p.getNumParticipantes()-1)*cantEnfretamientosIgual)+1;
                            intentos++;
                            if(intentos == 20){
                                return 0;
                            }
                        }
                        alj.get(matrizEnfrentamientos[i][j]-1).partidos.add(new Enfrentamiento(participantes.getParticipante(i),participantes.getParticipante(j)));
                    }
                } else if( (matrizEnfrentamientos[j][i]<=p.getNumParticipantes()-1) && (cantEnfretamientosIgual == 2) ){
                    matrizEnfrentamientos[i][j] = new Random().nextInt(p.getNumParticipantes()-1)+(p.getNumParticipantes());
                    while (seRepite(matrizEnfrentamientos, i, j, p,matrizEnfrentamientos[i][j])){
                        matrizEnfrentamientos[i][j] = new Random().nextInt(p.getNumParticipantes()-1)+(p.getNumParticipantes());
                        intentos++;
                        if(intentos == 20){
                            return 0;
                        }
                    }
                    alj.get(matrizEnfrentamientos[i][j]-1).partidos.add(new Enfrentamiento(participantes.getParticipante(i),participantes.getParticipante(j)));
                } else{
                    matrizEnfrentamientos[i][j] = new Random().nextInt(p.getNumParticipantes()-1) + 1;
                    while (seRepite(matrizEnfrentamientos, i, j, p,matrizEnfrentamientos[i][j])){
                        matrizEnfrentamientos[i][j] = new Random().nextInt(p.getNumParticipantes()-1) + 1;
                        intentos++;
                        if(intentos == 20){
                            return 0;
                        }
                    }
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
        return 1;
    }

    private boolean seRepite(int [][] matriz, int i, int j, CantidadParticipantes p, int jornada){
        for(int k=0;k<p.getNumParticipantes();k++){
            if( ( (k==i) && (i==j) ) || ( (k==j) ) || (k==i) || ( (j==i) && (k==j) ) )
                continue;
            else if( (matriz[k][i] != jornada) && (matriz[i][k] != jornada) && (matriz[k][j] != jornada) && (matriz[j][k] != jornada) )
                continue;
            else
                System.out.println(i + "-" + j + "-" + k);
                System.out.println(matriz[i][j] + " " + jornada + " " + matriz[j][i]);
                for(int w=0;w<p.getNumParticipantes();w++){
                    for(int z=0;z<p.getNumParticipantes();z++){
                        System.out.println(matriz[w][z]+", ");
                    }
                    System.out.println("\n");
                }
                return true;
        }
        System.out.println("aaa");
        return false;
    }
}
