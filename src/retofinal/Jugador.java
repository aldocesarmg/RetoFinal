
package retofinal;

public class Jugador {
    int vida;

    public Jugador() {
        vida = 100;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void construirCasa(){
        System.out.println("¡La casa se ha construido con éxtio!");
    }
    
}
