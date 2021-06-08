package main.algoritmos;

import java.util.ArrayList;

import main.Sortrace;

public class ConfigPos  {
    int[]vector;
    int jAct,iAct,minAct,inc; //variables para seleccion
    int incrementos, itAct, itTotal; //variables para shell
    int asignaciones=0,comparaciones=0,columnas=0,pivote;
    ArrayList<Integer> comparados;
    ArrayList<Integer>fijados;
    ArrayList<Integer>intercambio;
    public ConfigPos(int[] vector, ArrayList<Integer> comparados, ArrayList<Integer> fijados, ArrayList<Integer> intercambio) {
        this.vector = vector;
        this.comparados = comparados;
        this.fijados = fijados;
        this.intercambio = intercambio;
    }

    public ConfigPos() {
    	if(Sortrace.getVector().getVector()!=null) {
    		this.vector=new int[Sortrace.getVector().getVector().length];
    	}
        fijados=new ArrayList<>();
        intercambio=new ArrayList<>();
        comparados=new ArrayList<>();
    }

    public int getjAct() {
        return jAct;
    }

    public void setjAct(int jAct) {
        this.jAct = jAct;
    }

    public int getiAct() {
        return iAct;
    }

    public void setiAct(int iAct) {
        this.iAct = iAct;
    }

    public int getMinAct() {
        return minAct;
    }

    public void setMinAct(int minAct) {
        this.minAct = minAct;
    }

    public int getIncrementos() {
        return incrementos;
    }

    public void setIncrementos(int incrementos) {
        this.incrementos = incrementos;
    }

    public int getItAct() {
        return itAct;
    }

    public void setItAct(int itAct) {
        this.itAct = itAct;
    }

    public int getItTotal() {
        return itTotal;
    }

    public void setItTotal(int itTotal) {
        this.itTotal = itTotal;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public ArrayList<Integer> getComparado() {
        return comparados;
    }

    public void setComparado(ArrayList<Integer> comparados) {
        this.comparados = comparados;
    }

    public ArrayList<Integer> getFijado() {
        return fijados;
    }

    public void setFijado(ArrayList<Integer> fijados) {
        this.fijados = fijados;
    }

    public ArrayList<Integer> getIntercambios() {
        return intercambio;
    }

    public void setIntercambios(ArrayList<Integer> intercambio) {
        this.intercambio = intercambio;
    }

    public int getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(int asignaciones) {
        this.asignaciones = asignaciones;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }

    public int getPivote() {
        return pivote;
    }

    public void setPivote(int pivote) {
        this.pivote = pivote;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

	public int getInc() {
		return inc;
	}

	public void setInc(int inc) {
		this.inc = inc;
	}
    
    
}
