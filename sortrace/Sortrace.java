package sortrace;

import sortrace.auxiliar.Vector;
import util.Configuracion.Configuracion;
import util.Configuracion.properties.Language;

public class Sortrace {
    private static Vector vector;
    private  static Pantalla pantalla;
    private static Algoritmo algoritmo;
    private static Configuracion config;
    private static Language idioma;

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

    public static Configuracion getConfig() {
        return config;
    }

    public static void setConfig(Configuracion config) {
        Sortrace.config = config;
    }

    public static Language getIdioma() {
        return idioma;
    }

    public static void actualizarIdioma() {
        idioma= new Language(config.getIdioma());
    }

    public static void main(String args[]) {
        config=new Configuracion();
        config.cargarConfiguracionXML();
        idioma= new Language(config.getIdioma());
        Sortrace.pantalla=new Pantalla();
        vector=new Vector();
    }
}
