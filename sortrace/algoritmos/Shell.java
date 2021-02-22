package sortrace.algoritmos;

import sortrace.Algoritmo;
import sortrace.Sortrace;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Shell implements Algoritmo {
    int[]v; //vector
    int pos,asignaciones=0,comparaciones=0,fijados=0; //variable para contar: la posicion, el numero de asinaciones, el numero de comparaiones y el numero de elementos fijados
    int posMaxima; //numero de posiciones que hay guardadas en el array
    int posFinal=-1;
    int incrementos; //numero de incrementos del algoritmo de shell
    int sigIt;  //posicion de la siguiente iteracion
    int itActual; //iteracion actual
    Semaphore semAvance; //semaforo para controlar la ejecucion del algoritmo
    Semaphore semContinuo; //semaforo para controlar el avance o retroceso continuo
    boolean continuo=false,avanzaIt=false; //variables booleanas para controlar el avance y retroceso continuo y el avance de iteracion
    ArrayList<Integer> posIt; //arraylist para donde se guardan las posiciones en las que se encuentran el final de las iteraciones en configpos
    ArrayList<ConfigPos>configPos; //arraylist donnde se guarda cada paso para poder mostrar cualquier paso en cualquier momento
    Thread th2;
    Thread th1;

    public Shell(int[]v){
        this.v=v;
        pos = 0;
        posMaxima = 0;
        sigIt = 0;
        semAvance=new Semaphore(0);
        semContinuo=new Semaphore(1);
        posIt=new ArrayList<>();
        configPos=new ArrayList<>();
        incrementos=1;
        itActual=1;
    }
    @Override
    public int[] getVector() {
        return v;
    }

    @Override
    public void setVector(int[] vector) {
        this.v=vector;
    }

    @Override
    public boolean getContinuo() {
        return false;
    }

    @Override
    public int getAsignaciones() {
        return asignaciones;
    }

    @Override
    public int getComparaciones() {
        return comparaciones;
    }

    @Override
    public int getFijados() {
        return fijados;
    }

    public int getIncrementos() {
        return incrementos;
    }

    public int getItActual() {
        return itActual;
    }

    @Override
    public void ejecutar() {
        Thread th1 =new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {//funciona pero falta sincronizar la posicion del thread con la que realmente estoy
                //Creamos la primera posicion del vector con la configuracion inicial y la guardamos
                ConfigPos c=new ConfigPos();
                c.setVector(v.clone());
                c.setAsignaciones(0);
                c.setColumnas(0);
                c.setComparaciones(0);
                configPos.add(c);
                try {
                    if(continuo==true){
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        sleep(1000);
                    }
                    if(!avanzaIt) {
                        semAvance.acquire();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int markIt = 0;
                posIt.add(markIt);//guardamos en que posicion esta la primera iteracion
                for (incrementos = v.length / 2; incrementos > 0; incrementos /= 2) {
                    for (int i=1; i<v.length/incrementos; i++) {
                        sigIt++;
                        itActual=i;
                        for (int j=v.length-1; j>=incrementos*i; j--){
                            ConfigPos c1=new ConfigPos();

                            /*nueva posicion*/
                            comparaciones++;
                            markIt++;
                            pos++;
                            posMaxima++;
                            c1.setVector(v.clone());
                            c1.getComparado().add(j-incrementos);
                            c1.getComparado().add(j);
                            c1.setAsignaciones(asignaciones);
                            c1.setColumnas(fijados);
                            c1.setComparaciones(comparaciones);
                            c1.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                            configPos.add(c1);
                            /*nueva posicion*/

                            //aqui cambiaria el axuliar que cuenta los pasos hasta la anterior iteracion
                            if (v[j-incrementos]>v[j]) {
                                try {
                                    if(continuo==true){
                                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                                        sleep(1000);
                                    }
                                    if(!avanzaIt) {
                                        semAvance.acquire();
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                /*nueva posicion*/
                                pos++;
                                markIt++;
                                posMaxima++;
                                asignaciones+=3;
                                ConfigPos c2= new ConfigPos();
                                c2.getIntercambios().add(j-incrementos);
                                c2.getIntercambios().add(j);
                                c2.setVector(v.clone());
                                c2.setAsignaciones(asignaciones);
                                c2.setColumnas(fijados);
                                c2.setComparaciones(comparaciones);
                                c2.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                                configPos.add(c2);
                                /*nueva posicion*/

                                try {
                                    if(continuo==true){
                                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                                        sleep(1000);
                                    }
                                    if(!avanzaIt) {
                                        semAvance.acquire();
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                int aux = v[j];
                                v[j] = v[j-incrementos];
                                v[j-incrementos] = aux;

                                /*nueva posicion*/
                                pos++;
                                markIt++;
                                posMaxima++;
                                ConfigPos c3= new ConfigPos();
                                c3.setVector(v.clone());
                                c3.setAsignaciones(asignaciones);
                                c3.setColumnas(fijados);
                                c3.setComparaciones(comparaciones);
                                c3.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                                configPos.add(c3);
                                /*nueva posicion*/

                            }
                            try {
                                if(continuo==true){
                                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                                    sleep(1000);
                                }
                                if(!avanzaIt) {
                                    semAvance.acquire();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        avanzaIt=false;
                        fijados++;
                        posIt.add(markIt);
                    }
                }
                if(incrementos==0){
                    incrementos=1;
                }

                /*nueva posicion*/
                pos++;
                markIt++;
                posMaxima++;
                ConfigPos c4= new ConfigPos();
                c4.setVector(v.clone());
                c4.setAsignaciones(asignaciones);
                c4.setColumnas(fijados);
                c4.setComparaciones(comparaciones);
                for(int x=0;x<v.length;x++){
                    c4.getFijado().add(x);
                }
                configPos.add(c4);
                /*nueva posicion*/

                try {
                    if (continuo == true) {
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        sleep(1000);
                    }
                    semAvance.acquire();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                posFinal=posMaxima;
            }
        });
        th1.start();
    }

    @Override
    public void avanzarPaso() {
        if(pos==posMaxima) {//el vector esta sincronizado con el programa (ejecucion normal)
            semAvance.release();
        }else{//el vector no esta sincronizado por lo queavanzamos una pos en el registro guardado
            pos++;
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos).getVector()[i];
            }
            System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
        }
    }

    @Override
    public void avanzarIteracion() {
        if(pos==posMaxima) {//el vector esta sincronizado con el programa (ejecucion normal)
            avanzaIt=true;
            semAvance.release(1);
        }else{//el programa no esta sincronizado por p que avanzamos en el registro de pos guardado
            if(posIt.size()==1){
                while(pos<posMaxima){
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
                }
                avanzaIt=true;
                semAvance.release(1);
            }else if(pos>=posIt.get(posIt.size()-1)){//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
                while(pos<posMaxima){
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
                }
                avanzaIt=true;
                semAvance.release(1);
            }else{//la siguiente iteracion esta guardada por lo que buscamos cual es la siguiente it y nos posicionamos alli
                int aux=posIt.size()-1;
                while((pos<posIt.get(aux)) && (pos<posIt.get(aux-1))){
                    aux--;
                }
                while(pos<posIt.get(aux)) {
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    System.out.println("[" + v[0] + "," + v[1] + "," + v[2] + "," + v[3] + "," + v[4] + "," + v[5] + "," + v[6] + "," + v[7] + "]");
                }
            }
        }
    }

    @Override
    public void avanzarFinal() {
        int iteraciones = 0;
        while(pos<posMaxima) {//avanzamos hasta sincronizar con el programa
            pos++;
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos).getVector()[i];
            }
        }
        for (int i = 0; i < v.length; i++) {
            iteraciones = iteraciones + v.length - i;
        }
        semAvance.release(iteraciones);//liberamos hasta que termine
    }

    @Override
    public void retrocederPaso() {
        if(pos!=0) {//Retrocedemos un paso buscando en el registro y anotamos la posicion
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos-1).getVector()[i];
            }
            pos--;
        }
        System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
    }

    @Override
    public void retrocederIteracion() {
        boolean encontrado=false;
        int x=1;
        if(pos!=0) {
            while(!encontrado){//buscamos que iteracion nos corresponde en funcion de la posicion en la que estamos
                if(pos>posIt.get(posIt.size()-x)){//la encontramos
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(posIt.get(posIt.size()-x)).getVector()[i];
                    }
                    pos=posIt.get(posIt.size()-x);
                    encontrado=true;
                }else if(pos==posIt.get(posIt.size()-x)){//la encontramos
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(posIt.get(posIt.size()-x-1)).getVector()[i];
                    }
                    pos=posIt.get(posIt.size()-x-1);
                    encontrado=true;
                }else{//seguimos buscando
                    x++;
                }
            }
        }
        System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
    }

    @Override
    public void retrocederComienzo() {
        for (int i = 0; i < v.length; i++) {
            v[i] = configPos.get(0).getVector()[i];
        }
        pos=0;
        System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
    }

    @Override
    public void avanzarContinuo() throws InterruptedException {
        th2=new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {
                int iteraciones = 0;
                continuo=true;
                while(pos<posMaxima) {//avanzamos hasta sincronizar con el programa
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        semContinuo.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    pos++;
                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    semContinuo.release();
                }
                for (int i = 0; i < v.length; i++) {
                    iteraciones = iteraciones + v.length - i+2;
                }
                semAvance.release(iteraciones+1);//liberamos hasta que termine
            }
        });
        th2.start();
    }

    @Override
    public void retrocederContinuo() {
        continuo=true;
        th2=new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {
                while(pos>0){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        semContinuo.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    pos--;
                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    semContinuo.release();
                }
            }
        });
        th2.start();
    }

    @Override
    public void pause() throws InterruptedException {
        try {
            semContinuo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th2.stop();
        semAvance.acquire(semAvance.availablePermits());
        continuo=false;
        semContinuo.release();
    }
    @Override
    public boolean esPosicionElementoComparado(int i){
        if(configPos.get(pos).getComparado().contains(i)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean esPosicionIntercambiada(int i){
        if(configPos.get(pos).getIntercambios().contains(i)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean noIntercambio(){
        if(configPos.get(pos).getIntercambios().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean esPosicionElementoFijado(int i){
        if(configPos.get(pos).getFijado().contains(i)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public int Comparaciones(){
        return configPos.get(pos).getComparaciones();
    }
    @Override
    public int Asignaciones(){
        return configPos.get(pos).getAsignaciones();
    }
    @Override
    public int Columnas(){
        return configPos.get(pos).getColumnas();
    }

    @Override
    public boolean IsComienzo() {
        return pos==0;
    }

    @Override
    public boolean IsFinal() {
        if(posFinal==-1) {
            return false;
        }
        return pos == posFinal;
    }

    @Override
    public void terminar() {
        th1.stop();
        v=null;
        pos = 0;
        posMaxima = 0;
        sigIt = 0;
        semAvance=new Semaphore(0);
        semContinuo=new Semaphore(1);
        posIt=new ArrayList<>();
        configPos=new ArrayList<>();
    }

    public int getItTotales() {
        if(incrementos!=0) {
            return v.length / incrementos;
        }
        else{
            return 1;
        }
    }
}
