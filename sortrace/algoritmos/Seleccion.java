package sortrace.algoritmos;

import sortrace.Algoritmo;
import sortrace.Sortrace;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Seleccion implements Algoritmo {
    int[]v;
    int pos,asignaciones=0,comparaciones=0,fijados=0;
    int posMaxima;
    int posFinal=-1;
    int sigIt;
    int jAct;
    boolean continuo=false;
    Semaphore semAvance;
    Semaphore semContinuo;
    ArrayList<Integer> posIt;
    ArrayList<ConfigPos>configPos;
    Thread th2;
    Thread th1;

    public Seleccion(int[]v){
        this.v=v;
        pos = 0;
        posMaxima = 0;
        sigIt = 0;
        jAct = 0;
        semAvance=new Semaphore(0);
        semContinuo=new Semaphore(1);
        posIt=new ArrayList<>();
        configPos=new ArrayList<>();
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
        return continuo;
    }


    public ArrayList<ConfigPos> getConfigPos() {
        return configPos;
    }

    public void setConfigPos(ArrayList<ConfigPos> configPos) {
        this.configPos = configPos;
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

    @Override
    public void ejecutar() {
        th1 =new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {//funciona pero falta sincronizar la posicion del thread con la que realmente estoy
                int[]w=new int[v.length];
                for (int x=0; x<w.length;x++) {
                    w[x]=v[x];
                }
                //posiciones.add(w.clone());

                ConfigPos c=new ConfigPos();
                c.setVector(w.clone());
                c.setAsignaciones(0);
                c.setColumnas(0);
                c.setComparaciones(0);
                configPos.add(c);

                int markIt=0;
                posIt.add(markIt);
                int min;
                for (int i=0; i<v.length-1; i++) {
                    sigIt++;
                    min = i;
                    for (int j=i+1; j<v.length; j++){
                        ConfigPos c1=new ConfigPos();
                        try {
                            if(continuo==true){
                                Sortrace.getPantalla().mostrarPanelVisualizacion();
                                sleep(1000);
                            }
                            semAvance.acquire();
                            //comparados.clear();
                            //comparados.add(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        jAct++;
                        markIt++;
                        pos++;
                        posMaxima++;
                        //comparados.add(j);
                        //comparados.add(min);
                        //aqui cambiaria el axuliar que cuenta los pasos hasta la anterior iteracion
                        comparaciones++;
                        if (v[j]<v[min])
                            min = j;

                        //posiciones.add(v.clone());

                        c1.setVector(v.clone());
                        c1.getComparado().add(i);
                        c1.getComparado().add(j);
                        c1.getComparado().add(min);
                        c1.setAsignaciones(asignaciones);
                        c1.setColumnas(fijados);
                        c1.setComparaciones(comparaciones);
                        c1.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                        configPos.add(c1);
                        //System.out.println("["+w[0]+","+w[1]+","+w[2]+","+w[3]+","+w[4]+","+w[5]+","+w[6]+","+w[7]+"]");
                    }

                    try {
                        if(continuo==true){
                            Sortrace.getPantalla().mostrarPanelVisualizacion();
                            sleep(1000);
                        }
                        semAvance.acquire();//+1
                        //comparados.clear();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pos++;
                    markIt++;
                    posMaxima++;
                    ConfigPos c2= new ConfigPos();
                    c2.getIntercambios().add(min);
                    c2.getIntercambios().add(i);
                    c2.setVector(v.clone());
                    c2.setAsignaciones(asignaciones);
                    c2.setColumnas(fijados);
                    c2.setComparaciones(comparaciones);
                    c2.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                    configPos.add(c2);

                    //intercambio.add(min);
                    //intercambio.add(i);
                    try {
                        if(continuo==true){
                            Sortrace.getPantalla().mostrarPanelVisualizacion();
                            sleep(1000);
                        }
                        semAvance.acquire();//+1
                        //intercambio.clear();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    asignaciones+=3;
                    int aux = v[i];
                    v[i]   = v[min];
                    v[min] = aux;
                    pos++;
                    markIt++;
                    posMaxima++;
                    ConfigPos c3= new ConfigPos();
                    for(int x=0;x<=i;x++) {
                        c3.getFijado().add(x);
                    }
                    fijados++;
                    c3.setVector(v.clone());
                    c3.setAsignaciones(asignaciones);
                    c3.setColumnas(fijados);
                    c3.setComparaciones(comparaciones);
                    configPos.add(c3);
                    //fijados.add(i);

                    //posiciones.add(v.clone());
                    jAct=0;
                    posIt.add(markIt);
                    //System.out.println("["+w[0]+","+w[1]+","+w[2]+","+w[3]+","+w[4]+","+w[5]+","+w[6]+","+w[7]+"]");

                }
                try {
                    if(continuo==true){
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        sleep(1000);
                    }
                    semAvance.acquire();//+1
                    //comparados.clear();
                    pos++;
                    posMaxima++;
                    markIt++;
                    ConfigPos c4= new ConfigPos();
                    for(int x=0;x<v.length;x++) {
                        c4.getFijado().add(x);
                    }
                    c4.setVector(v.clone());
                    c4.setAsignaciones(asignaciones);
                    c4.setColumnas(fijados);
                    c4.setComparaciones(comparaciones);
                    configPos.add(c4);
                    if(continuo==true) {
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                    }
                    posIt.add(markIt);
                    //fijados.add(v.length-1);
                } catch (InterruptedException e) {
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
                //v[i] = posiciones.get(pos)[i];
                v[i] = configPos.get(pos).getVector()[i];
            }
            //System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
        }
    }

    @Override
    public void avanzarIteracion() {
        if(pos==posMaxima) {//el vector esta sincronizado con el programa (ejecucion normal)
            semAvance.release(v.length - sigIt-jAct+2);
        }else {//el programa no esta sincronizado por p que avanzamos en el registro de pos guardado
            if (posIt.size() == 1) {//solo esta guardad la iteracion 0
                while (pos < posMaxima) {
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    //System.out.println("[" + v[0] + "," + v[1] + "," + v[2] + "," + v[3] + "," + v[4] + "," + v[5] + "," + v[6] + "," + v[7] + "]");
                }
                semAvance.release(v.length - sigIt - jAct+2);
            } else if (pos >= posIt.get(posIt.size() - 1)) {//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
                while (pos < posMaxima) {
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    //System.out.println("[" + v[0] + "," + v[1] + "," + v[2] + "," + v[3] + "," + v[4] + "," + v[5] + "," + v[6] + "," + v[7] + "]");
                }
                semAvance.release(v.length - sigIt - jAct+2);
            } else {//la siguiente iteracion esta guardada por lo que buscamos cual es la siguiente it y nos posicionamos alli
                int aux = posIt.size() - 1;
                while ((pos < posIt.get(aux)) && (pos < posIt.get(aux - 1))) {
                    aux--;
                }
                while (pos < posIt.get(aux)) {
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    //System.out.println("[" + v[0] + "," + v[1] + "," + v[2] + "," + v[3] + "," + v[4] + "," + v[5] + "," + v[6] + "," + v[7] + "]");
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
                //v[i] = posiciones.get(pos)[i];
                v[i] = configPos.get(pos).getVector()[i];
            }
        }
        for (int i = 0; i < v.length; i++) {
            iteraciones = iteraciones + v.length - i+2;
        }
        semAvance.release(iteraciones+1);//liberamos hasta que termine
    }

    @Override
    public void retrocederPaso() {
        if(pos!=0) {//Retrocedemos un paso buscando en el registro y anotamos la posicion
            for (int i = 0; i < v.length; i++) {
                //v[i] = posiciones.get(pos - 1)[i];
                v[i] = configPos.get(pos-1).getVector()[i];
            }
            pos--;
        }
        //System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
    }

    @Override
    public void retrocederIteracion() {
        boolean encontrado=false;
        int x=1;
        if(pos!=0) {
            while(!encontrado){//buscamos que iteracion nos corresponde en funcion de la posicion en la que estamos
                if(pos>posIt.get(posIt.size()-x)){//la encontramos
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(posIt.get(posIt.size()-x))[i];
                        v[i] = configPos.get(posIt.get(posIt.size()-x)).getVector()[i];
                    }
                    pos=posIt.get(posIt.size()-x);
                    encontrado=true;
                }else if(pos==posIt.get(posIt.size()-x)){//la encontramos
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(posIt.get(posIt.size()-x-1))[i];
                        v[i] = configPos.get(posIt.get(posIt.size()-x-1)).getVector()[i];
                    }
                    pos=posIt.get(posIt.size()-x-1);
                    encontrado=true;
                }else{//seguimos buscando
                    x++;
                }
            }
        }
        //System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");

    }

    @Override
    public void retrocederComienzo() {
        for (int i = 0; i < v.length; i++) {
            //v[i] = posiciones.get(0)[i];
            v[i] = configPos.get(0).getVector()[i];

        }
        pos=0;
        //System.out.println("["+v[0]+","+v[1]+","+v[2]+","+v[3]+","+v[4]+","+v[5]+","+v[6]+","+v[7]+"]");
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
    public void retrocederContinuo() throws InterruptedException {
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
        jAct = 0;
        semAvance=new Semaphore(0);
        semContinuo=new Semaphore(1);
        posIt=new ArrayList<>();
        configPos=new ArrayList<>();
    }
}
