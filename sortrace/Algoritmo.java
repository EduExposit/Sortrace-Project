package sortrace;

public interface Algoritmo {
    int[] getVector();

    void setVector(int[]vector);

    boolean getContinuo();

    void terminar();

    int getAsignaciones();

    int getComparaciones();

    int getFijados();

    void ejecutar();

    void avanzarPaso();

    void avanzarIteracion();

    void avanzarFinal();

    void retrocederPaso();

    void retrocederIteracion();

    void retrocederComienzo();

    void avanzarContinuo() throws InterruptedException;

    void retrocederContinuo() throws InterruptedException;

    void pause() throws InterruptedException;

    boolean esPosicionElementoComparado(int i);

    boolean esPosicionIntercambiada(int i);

    boolean noIntercambio();

    boolean esPosicionElementoFijado(int i);

    int Comparaciones();

    int Asignaciones();

    int Columnas();

    boolean IsComienzo();

    boolean IsFinal();

    boolean IsContinuo();
}
