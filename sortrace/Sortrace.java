package sortrace;

import sortrace.auxiliar.Vector;

public class Sortrace {
    private static Vector vector;
    private  static Pantalla pantalla;
    private static Algoritmo algoritmo;

    public static Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public static Algoritmo getAlgoritmo() {
        return algoritmo;
    }

    public static void setAlgoritmo(Algoritmo alg) {
        algoritmo = alg;
    }

    public  static Pantalla getPantalla() {
        return pantalla;
    }

    public static void main(String args[]) {
            Sortrace.pantalla=new Pantalla();
            vector=new Vector();
    }
}
