package main.algoritmos;

import main.Algoritmo;
import main.Sortrace;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Shell implements Algoritmo {
    int[]v; //vector
    int pos,asignaciones=0,comparaciones=0,fijados=0; //variable para contar: la posicion, el numero de asinaciones, el numero de comparaiones y el numero de elementos fijados
    int posMaxima; //numero de posiciones que hay guardadas en el array
    int posFinal=-1;
    int itTotales;
    int incrementos; //numero de incrementos del algoritmo de shell
    int sigIt;  //posicion de la siguiente iteracion
    int itActual; //iteracion actual
    Semaphore semAvance; //semaforo para controlar la ejecucion del algoritmo
    Semaphore semContinuo; //semaforo para controlar el avance o retroceso continuo
    boolean continuo=false,avanzaIt=false,avanzaFin=false,blanco=true; //variables booleanas para controlar el avance y retroceso continuo y el avance de iteracion
    ArrayList<Integer> posIt; //arraylist para donde se guardan las posiciones en las que se encuentran el final de las iteraciones en configpos
    ArrayList<Integer> posAux; //arraylist para donde se guardan las posiciones en las que se encuentran el final de las iteraciones en configpos
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
        posAux=new ArrayList<>();
        configPos=new ArrayList<>();
        incrementos=1;
        itActual=1;
    } 
    @Override
	public int getPos() {
		// TODO Auto-generated method stub
		return pos;
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
        return configPos.get(pos).getIncrementos();
    }
    public int getIncrementosPos(int i) {
        return configPos.get(i).getIncrementos();
    }
    public int getItActual() {
        return configPos.get(pos).getItAct();
    }

    @Override
    public void ejecutar() {
        //thread para realizar el algoritmo
        th1 =new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {            //Creamos la primera posicion del vector con la configuracion inicial y la guardamos
                ConfigPos c = new ConfigPos();
                c.setVector(v.clone());
                c.setAsignaciones(0);
                c.setColumnas(0);
                c.setComparaciones(0);
                c.setIncrementos(0);
                c.setItAct(0);
                c.setItTotal(0);
                configPos.add(c);

                int markIt = 0;
                posIt.add(markIt);//guardamos en que posicion esta la primera iteracion
                posAux.add(markIt);//guardamos en que posicion esta la primera iteracion
                for (incrementos = v.length / 2; incrementos > 0; incrementos /= 2) {
                    for (int i = 1; i < v.length / incrementos; i++) {
                        itTotales = (v.length / incrementos) - 1;
                        sigIt++;
                        itActual = i;
                        for (int j = v.length - 1; j >= incrementos * i; j--) {
                            try {
                                if (continuo) {
                                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                                    Sortrace.getPantalla().añadirFotoSecuencia();
                                    sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
                                } else {
                                    if ((!avanzaIt) && (!avanzaFin)) {
                                    	if(blanco) {
                                    		Sortrace.getPantalla().mostrarPanelVisualizacion();
                                            Sortrace.getPantalla().añadirFotoSecuencia();
                                    		semAvance.acquire();
                                    	}else {
                                    		Sortrace.getPantalla().mostrarPanelVisualizacion();
                                            Sortrace.getPantalla().añadirFotoSecuencia();
                                    	}
                                    }
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            blanco=false;
                            ConfigPos c1 = new ConfigPos();

                            /*nueva posicion*/
                            comparaciones++;
                            markIt++;
                            pos++;
                            posMaxima++;
                            c1.setVector(v.clone());
                            c1.getComparado().add(j - incrementos);
                            c1.getComparado().add(j);
                            c1.setAsignaciones(asignaciones);
                            c1.setColumnas(fijados);
                            c1.setComparaciones(comparaciones);
                            c1.setiAct(i);
                            c1.setjAct(j);
                            c1.setInc(incrementos);
                            c1.setFijado((ArrayList<Integer>) configPos.get(configPos.size() - 1).getFijado().clone());
                            c1.setIncrementos(incrementos);
                            c1.setItAct(itActual);
                            c1.setItTotal(itTotales);
                            configPos.add(c1);
                            /*nueva posicion*/
                            try {
                                if (continuo) {
                                    Sortrace.getPantalla().mostrarPanelVisualizacion();
                                    Sortrace.getPantalla().añadirFotoSecuencia();
                                    sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
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
                            //aqui cambiaria el axuliar que cuenta los pasos hasta la anterior iteracion
                            if (v[j - incrementos] > v[j]) {


                                /*nueva posicion*/
                                pos++;
                                markIt++;
                                posMaxima++;
                                asignaciones += 3;
                                ConfigPos c2 = new ConfigPos();
                                c2.getIntercambios().add(j - incrementos);
                                c2.getIntercambios().add(j);
                                c2.setVector(v.clone());
                                c2.setAsignaciones(asignaciones);
                                c2.setColumnas(fijados);
                                c2.setComparaciones(comparaciones);
                                c2.setiAct(i);
                                c2.setjAct(j);
                                c2.setInc(incrementos);
                                c2.setFijado((ArrayList<Integer>) configPos.get(configPos.size() - 1).getFijado().clone());
                                c2.setIncrementos(incrementos);
                                c2.setItAct(itActual);
                                c2.setItTotal(itTotales);
                                configPos.add(c2);
                                /*nueva posicion*/

                                try {
                                    if (continuo) {
                                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                                        Sortrace.getPantalla().añadirFotoSecuencia();
                                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
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

                                int aux = v[j];
                                v[j] = v[j - incrementos];
                                v[j - incrementos] = aux;

                                /*nueva posicion*/
                                pos++;
                                markIt++;
                                posMaxima++;
                                ConfigPos c3 = new ConfigPos();
                                c3.setVector(v.clone());
                                c3.setAsignaciones(asignaciones);
                                c3.setColumnas(fijados);
                                c3.setComparaciones(comparaciones);
                                c3.setiAct(i);
                                c3.setjAct(j);
                                c3.setInc(incrementos);
                                c3.setFijado((ArrayList<Integer>) configPos.get(configPos.size() - 1).getFijado().clone());
                                c3.setIncrementos(incrementos);
                                c3.setItAct(itActual);
                                c3.setItTotal(itTotales);
                                configPos.add(c3);
                                blanco=true;

                                /*nueva posicion*/

                            }else {
                                if(j==incrementos * i) {
                                    pos++;
                                    markIt++;
                                    posMaxima++;
                                    ConfigPos c3 = new ConfigPos();
                                    c3.setVector(v.clone());
                                    c3.setAsignaciones(asignaciones);
                                    c3.setColumnas(fijados);
                                    c3.setComparaciones(comparaciones);
                                    c3.setiAct(i);
                                    c3.setjAct(j);
                                    c3.setInc(incrementos);
                                    c3.setFijado((ArrayList<Integer>) configPos.get(configPos.size() - 1).getFijado().clone());
                                    c3.setIncrementos(incrementos);
                                    c3.setItAct(itActual);
                                    c3.setItTotal(itTotales);
                                    configPos.add(c3);
                                    blanco=true;
                                }
                            }
                        }

                        /*avanzaIt = false;
                        fijados++;
                        posIt.add(markIt);*/
                        fijados++;
                        posAux.add(markIt);
                        
                        
                    }
                    avanzaIt = false;
                    fijados++;
                    posIt.add(markIt);
                }
                if (incrementos == 0) {
                    incrementos = 1;
                }

                /*nueva posicion*/
                pos++;
                posMaxima++;
                markIt++;
                posIt.remove(posIt.size()-1);
                posIt.add(markIt);
                ConfigPos c4 = new ConfigPos();
                c4.setVector(v.clone());
                c4.setAsignaciones(asignaciones);
                c4.setColumnas(fijados);
                c4.setComparaciones(comparaciones);
                c4.setIncrementos(incrementos);
                c4.setItAct(itActual);
                c4.setItTotal(itTotales);
                for (int x = 0; x < v.length; x++) {
                    c4.getFijado().add(x);
                }
                configPos.add(c4);
                /*nueva posicion*/

                try {
                    if ((continuo)||(avanzaFin)) {
                        Sortrace.getPantalla().mostrarPanelVisualizacion();
                        Sortrace.getPantalla().añadirFotoSecuencia();
                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
                    } else {
                        if (!avanzaFin) {
                        	Sortrace.getPantalla().mostrarPanelVisualizacion();
                            Sortrace.getPantalla().añadirFotoSecuencia();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                posFinal = posMaxima;
                Sortrace.getPantalla().actualizarBotonesEjecucion();
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
    public void avanzarContinuo() {
        //thread para realizar el algoritmo
        th2 =new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {
                continuo = true;
                while (pos < posMaxima) {//avanzamos hasta sincronizar con el programa
                    try {
                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
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
                if (pos == posFinal) {
                    Sortrace.getPantalla().actualizarBotonesEjecucion();
                }
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
        //continuo=true;
        //thread para realizar el algoritmo
        th2 =new Thread(new Runnable() {//thread para realizar el algoritmo
            @Override
            public void run() {
                while (pos > 0) {
                    try {
                        sleep(Math.abs(Sortrace.getConfig().getVelocidadAnimacion() - 10) * 200L+100);
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
        while(this.semAvance.availablePermits()!=0);
        //semAvance.acquire(semAvance.availablePermits());
        Sortrace.getPantalla().mostrarPanelVisualizacion();
        Sortrace.getPantalla().actualizarBotonesEjecucion();
        semContinuo.release();
    }
    @Override
    public boolean esPosicionElementoComparado(int i){
        return configPos.get(pos).getComparado().contains(i);
    }
    @Override
    public boolean esPosicionIntercambiada(int i){
        return configPos.get(pos).getIntercambios().contains(i);
    }
    @Override
    public boolean noIntercambio(){
        return configPos.get(pos).getIntercambios().isEmpty();
    }
    @Override
    public boolean esPosicionElementoFijado(int i){
        return configPos.get(pos).getFijado().contains(i);
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
        posFinal=-1;
        asignaciones=0;
        comparaciones=0;
        fijados=0;
        avanzaIt=false;
        continuo=false;
        avanzaFin=false;
        blanco=true;
        semAvance=new Semaphore(0);
        posIt=new ArrayList<>();
        posAux=new ArrayList<>();
        configPos=new ArrayList<>();
        this.ejecutar();
        semContinuo.release();
    }

    public int getItTotales() {
        return configPos.get(pos).itTotal;
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
    
    public boolean esInc(int x) {
        return this.configPos.get(pos).getInc()==x;
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
    
    public int getIncAct() {
        return this.configPos.get(pos).getInc();
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
			if(posAux.size()>1) {
				if(pos==posAux.get(posAux.size()-1)) {
					return this.posAux.size()-1;
				}else {
					return this.posAux.size();
				}
			}else {
				return this.posAux.size();
				
			}
		}else if (pos >= posAux.get(posAux.size() - 1)) {//la siguiente iteracion no esta guardada por lo que no ponemos en la posicion maxima de nuestra ejecucion y continuamos la ejecuci
			if(posAux.size()>1) {
				if(pos==posAux.get(posAux.size()-1)) {
					return this.posAux.size()-1;
				}else {
					return this.posAux.size();
				}
			}else {
				return this.posAux.size();
				
			}
        }else {//la siguiente iteracion esta guardada por lo que buscamos cual es la siguiente it y nos posicionamos alli
                int aux = posAux.size() -1;
    			if(posAux.size()>1) {
                while ((pos < posAux.get(aux)) && (pos < posAux.get(aux - 1))) {
                    aux--;
                }
               
                if(aux==0) {
                	return 1;
                }else {
                	if(pos<=posAux.get(aux)) {
                    	if(pos>=posAux.get(aux-1)) {
                    		aux--;
                    		 if(posAux.size()>1) {
                             	if((pos==posAux.get(aux+1))||(pos==posAux.get(aux))) {
                             		aux--;
                             		
                             	}
                             }
                    	}
                    }else {
                    	 return aux+1;
                    }
                }
                if(aux<=0) {
         			return 1;
         		}
                return aux+1;
    			}else {return 1;}
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
