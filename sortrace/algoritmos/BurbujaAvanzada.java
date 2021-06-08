package main.algoritmos;

import main.Algoritmo;
import main.Sortrace;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class BurbujaAvanzada implements Algoritmo {
    int[]v;
    int pos,asignaciones=0,comparaciones=0,fijados=0;
    int posMaxima;
    int posFinal=-1;
    int sigIt;
    int jAct;
    boolean avanzaIt=false,continuo=false,avanzaFin=false;
    Semaphore semAvance;
    Semaphore semContinuo;
    ArrayList<Integer> posIt;
    //ArrayList<int[]>posiciones;
    ArrayList<ConfigPos>configPos;
    boolean intercambio = true;
    Thread th2;
    Thread th1;

    public BurbujaAvanzada(int[]v){
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
   	public int getPos() {
   		// TODO Auto-generated method stub
   		return pos;
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

                ConfigPos c=new ConfigPos();
                c.setVector(w.clone());
                c.setAsignaciones(0);
                c.setColumnas(0);
                c.setComparaciones(0);
                configPos.add(c);

                int markIt=0;
                posIt.add(markIt);
                for (int i=1; i<v.length && intercambio;i++) {
                    sigIt++;
                    intercambio = false;
                    for (int j=v.length-1; j>=i; j--) {
                        ConfigPos c1=new ConfigPos();
                        try {
                            if(continuo){
                                Sortrace.getPantalla().mostrarPanelVisualizacion();
                                Sortrace.getPantalla().añadirFotoSecuencia();
                                sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion()-10)* 200L+100);
                            } else {
                                if ((!avanzaIt) && (!avanzaFin)) {
                                	Sortrace.getPantalla().mostrarPanelVisualizacion();
                                    Sortrace.getPantalla().añadirFotoSecuencia();
                                    semAvance.acquire();
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        jAct++;
                        markIt++;
                        pos++;
                        posMaxima++;
                        comparaciones++;

                        c1.setVector(v.clone());
                        c1.setAsignaciones(asignaciones);
                        c1.setColumnas(fijados);
                        c1.setComparaciones(comparaciones);
                        c1.setiAct(i);
                        c1.setjAct(j);
                        c1.getComparado().add(j-1);
                        c1.getComparado().add(j);
                        c1.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                        configPos.add(c1);
                        //aqui cambiaria el axuliar que cuenta los pasos hasta la anterior iteracion
                        if (v[j-1]>v[j]) {
                            ConfigPos c2=new ConfigPos();
                                try {
                                    if(continuo){
                                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                                        Sortrace.getPantalla().añadirFotoSecuencia();
                                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion()-10)* 200L+100);
                                    }else {
                                        if ((!avanzaIt) && (!avanzaFin)) {
                                        	Sortrace.getPantalla().mostrarPanelVisualizacion();
                                            Sortrace.getPantalla().añadirFotoSecuencia();
                                            semAvance.acquire();
                                        }
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            int aux = v[j-1];
                            v[j-1] = v[j];
                            v[j] = aux;
                            intercambio = true;

                            posMaxima++;
                            pos++;
                            markIt++;
                            asignaciones+=3;

                            c2.setVector(v.clone());
                            c2.setAsignaciones(asignaciones);
                            c2.setColumnas(fijados);
                            c2.setComparaciones(comparaciones);
                            c2.setiAct(i);
                            c2.setjAct(j);
                            c2.setFijado((ArrayList<Integer>)configPos.get(configPos.size()-1).getFijado().clone());
                            c2.getIntercambios().add(j-1);
                            c2.getIntercambios().add(j);
                            configPos.add(c2);
                        }
                    }
                    /*if(avanzaIt){
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        Sortrace.getPantalla().añadirFotoSecuencia();
                    }*/
                    try {
                        if(continuo){
                            Sortrace.getPantalla().mostrarPanelVisualizacion();
                            Sortrace.getPantalla().añadirFotoSecuencia();
                            sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion()-10)* 200L+100);
                        }else {
                            if ((!avanzaIt) && (!avanzaFin)) {
                            	Sortrace.getPantalla().mostrarPanelVisualizacion();
                                Sortrace.getPantalla().añadirFotoSecuencia();
                                semAvance.acquire();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pos++;
                    posMaxima++;
                    markIt++;
                    fijados++;
                    ConfigPos c3= new ConfigPos();
                    if(intercambio) {
                        for (int x = 0; x <= i; x++) {
                            c3.getFijado().add(x - 1);
                        }
                        if (i == w.length - 1) {
                            c3.getFijado().add(i);
                        }
                        fijados++;
                        c3.setVector(v.clone());
                        c3.setAsignaciones(asignaciones);
                        c3.setColumnas(fijados);
                        c3.setComparaciones(comparaciones);
                        c3.setiAct(i);
                        c3.setjAct(0);
                        configPos.add(c3);
                    }else{
                        for(int x=0;x<v.length;x++){
                            c3.getFijado().add(x);
                        }
                        fijados=v.length-1;
                        c3.setVector(v.clone());
                        c3.setAsignaciones(asignaciones);
                        c3.setColumnas(fijados);
                        c3.setComparaciones(comparaciones);
                        configPos.add(c3);
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        Sortrace.getPantalla().añadirFotoSecuencia();
                    }
                    jAct=0;
                    posIt.add(markIt);
                    avanzaIt=false;

                }
                posFinal=posMaxima;
                Sortrace.getPantalla().actualizarBotonesEjecucion();
                avanzaFin=false;
            }
        });
        th1.start();
    }

    @Override
    public void avanzarPaso() {
        if(pos==posMaxima) {//el vector esta sincronizado con el programa (ejecucion normal)
            semAvance.release();
        }else{//el vector no esta sincronizado por lo que avanzamos una pos en el registro guardado
            pos++;
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos).getVector()[i];
            }
            Sortrace.getPantalla().mostrarPanelVisualizacion();
        	Sortrace.getPantalla().añadirFotoSecuencia();
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
                }
                avanzaIt=true;
                semAvance.release(1);
            }else if(pos>=posIt.get(posIt.size()-1)){//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
                while(pos<posMaxima){
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        v[i] = configPos.get(pos).getVector()[i];
                    }
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
                }
                Sortrace.getPantalla().mostrarPanelVisualizacion();
            	Sortrace.getPantalla().añadirFotoSecuencia();
            }
        }
    }

    @Override
    public void avanzarFinal() {
        while(pos<posMaxima) {//avanzamos hasta sincronizar con el programa
            pos++;
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos).getVector()[i];
            }
        }
        if(pos==posFinal) {
        	Sortrace.getPantalla().mostrarPanelVisualizacion();
        	Sortrace.getPantalla().añadirFotoSecuencia();
        }
        avanzaFin=true;
        semAvance.release(1);//liberamos hasta que termine
    }

    @Override
    public void retrocederPaso() {
        if(pos!=0) {//Retrocedemos un paso buscando en el registro y anotamos la posicion
            for (int i = 0; i < v.length; i++) {
                v[i] = configPos.get(pos-1).getVector()[i];
            }
            pos--;
        }
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
    }

    @Override
    public void retrocederComienzo() {
        for (int i = 0; i < v.length; i++) {
            v[i] = configPos.get(0).getVector()[i];
        }
        pos=0;
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
                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion()-10)* 200L+1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        semContinuo.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pos++;
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }
                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                    Sortrace.getPantalla().añadirFotoSecuencia();
                    semContinuo.release();
                }
                if(pos==posFinal){
                    Sortrace.getPantalla().actualizarBotonesEjecucion();
                }
                Sortrace.getPantalla().mostrarPanelVisualizacion();
                Sortrace.getPantalla().añadirFotoSecuencia();
                try {
					sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                semAvance.release(1);//liberamos hasta que termine
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
                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion()-10)* 200L+100);
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
                    Sortrace.getPantalla().añadirFotoSecuencia();
                    for (int i = 0; i < v.length; i++) {
                        //v[i] = posiciones.get(pos)[i];
                        v[i] = configPos.get(pos).getVector()[i];
                    }

                    semContinuo.release();
                }
                Sortrace.getPantalla().actualizarBotonesEjecucion();
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
        continuo=false;
        th2.stop();
        //semAvance.acquire(semAvance.availablePermits());
        while(this.semAvance.availablePermits()!=0);
        Sortrace.getPantalla().mostrarPanelVisualizacion();
        Sortrace.getPantalla().actualizarBotonesEjecucion();
        semContinuo.release();

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
    	try {
			this.semContinuo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(th1!=null) {
        	th1.stop();
        }
        if(th2!=null) {
        	th2.stop();
        }
        if(Sortrace.getConfig().getVector()!=null) {
        	Sortrace.getVector().setSize(Sortrace.getConfig().getVector().length);
        }
    	v=Sortrace.getConfig().getVector();
    	Sortrace.getVector().setVector(Sortrace.getConfig().getVector());
        pos = 0;
        posMaxima = 0;
        sigIt = 0;
        jAct = 0;
        posFinal=-1;
        asignaciones=0;
        comparaciones=0;
        fijados=0;
        avanzaIt=false;
        continuo=false;
        avanzaFin=false;
        intercambio = true;
        semAvance=new Semaphore(0);
        semContinuo=new Semaphore(1);
        posIt=new ArrayList<>();
        configPos=new ArrayList<>();
        this.ejecutar();
        semContinuo.release();
    }
    @Override
    public boolean IsContinuo() {
        return continuo;
    }
    public boolean esI(int x) {
        return this.configPos.get(pos).getiAct()==x;
    }
    public boolean esJ(int x) {
        return this.configPos.get(pos).getjAct()==x;
    }
    public boolean esMin(int x) {
        return this.configPos.get(pos).getMinAct()==x;
    }

    public int getjAct() {
        return this.configPos.get(pos).getjAct();
    }

    public int getiAct() {
        return this.configPos.get(pos).getiAct();
    }

    public int getMinAct() {
        return this.configPos.get(pos).getMinAct();
    }
    
    @Override
	public int getItActualAlg() {
		if(pos==posMaxima) {
			return this.posIt.size();
		}else if (pos >= posIt.get(posIt.size() - 1)) {//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
			return this.posIt.size();
        }else {//la siguiente iteracion esta guardada por lo que buscamos cual es la siguiente it y nos posicionamos alli
                int aux = posIt.size() - 1;
                while ((pos < posIt.get(aux)) && (pos < posIt.get(aux - 1))) {
                    aux--;
                }
                return aux;
        }
	}
    @Override
	public int getItPos(int pos) {
		if(pos==posMaxima) {
			return this.posIt.size();
		}else if (pos >= posIt.get(posIt.size() - 1)) {//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
			return this.posIt.size();
        }else {//la siguiente iteracion esta guardada por lo que buscamos cual es la siguiente it y nos posicionamos alli
                int aux = posIt.size() - 1;
                while ((pos < posIt.get(aux)) && (pos < posIt.get(aux - 1))) {
                    aux--;
                }
                return aux;
        }
	}
    @Override
    public boolean esIntercambiadoEnPos(int pos, int i){
        return configPos.get(pos).getIntercambios().contains(i);
    }
	@Override
    public boolean esComparadoEnPos(int pos, int i){
        return configPos.get(pos).getComparado().contains(i);
    }
	@Override
    public boolean esFijadoEnPos(int pos, int i){
        return configPos.get(pos).getFijado().contains(i);
    }
	@Override
	public int getPosFinal() {
		return posFinal;
	}
}
