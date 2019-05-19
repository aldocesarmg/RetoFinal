
package retofinal;

import java.util.Scanner;

public class RetoFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aleat, casasC = 0, hadasCapt = 0;
        String ent;
        Jugador JugadorP = new Jugador();
        Mago MagoN = new Mago();
        Ogro OgroP = new Ogro();
        
        System.out.println(" ------------------------- | BIENVENIDO AL JUEGO | ------------------------- ");
        System.out.println(" - El objetivo principal del juego es que construyas casas, así de simple. - ");
        
        do {
            System.out.println(" ------------------ Pulsa la tecla C para construir una casa --------------- ");
            System.out.println(" -------------------- Pulsa la tecla Q para salir del juego ---------------- ");
            ent = sc.next();
            if(ent.equalsIgnoreCase("C")){
                JugadorP.construirCasa();
                casasC++;
                
                if(casasC == 10){
                    MagoN.setPoder(MagoN.getPoder()-1);
                    if ((JugadorP.getVida()+5)>100){
                        JugadorP.setVida(100);
                    }else{
                        JugadorP.setVida(JugadorP.getVida()+5);
                    }
                    casasC = 0;
                    System.out.println(" #### ¡FELICIDADES! ¡HAS LOGRADO DISMINUIR EL PODER DEL MAGO! +5 DE VIDA ####");
                }
            
                aleat = (int) (Math.random() * 10) + 1;
                if (aleat>5) {
                    JugadorP.setVida(JugadorP.getVida() - OgroP.getDaño());
                    System.out.println("¡Oh no! El ogro ha defendido al mago y ha capturado un hada");
                    hadasCapt++;
                    if (hadasCapt == 10) {
                        MagoN.setPoder(MagoN.getPoder()+1);
                        hadasCapt = 0;
                    }
                }else{
                    System.out.println(" Por fortuna, el ogro no ha defendido al mago, tu vida sigue intacta. ");
                }
                System.out.println("Tu vida es de "+JugadorP.getVida()+" y el poder del mago es de "+MagoN.getPoder());
            }else if(ent.equalsIgnoreCase("Q")){
                System.exit(1);
            }else{
                System.out.println("Presiona una letra válida.");
            }
        } while(JugadorP.getVida()>0 && MagoN.getPoder()>0);
        
        if(JugadorP.getVida()==0){
            System.out.println("¡Felicidades! ¡Has logrado salvar a las hadas y ganar el juego!");
        }else if(MagoN.getPoder()==0){
            System.out.println("Todas las hadas han sido capturadas, lo sentimos.");
        }
    }
    
}
