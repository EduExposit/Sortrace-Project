package main.vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D.Double;
import javax.swing.*;

import main.Algoritmo;
import main.Sortrace;
import main.algoritmos.*;
import java.util.ArrayList;


import static java.lang.Thread.sleep;


public class VistaVector extends JPanel {
    private Algoritmo algoritmo = null;
    private Color colorAsignacion = null;
    private Color colorComparacion = null;
    private Color colorFijado = null;
    private static final Stroke pincelElementoIntercambiado = new BasicStroke(2.0F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0F);
    private static final Stroke pincelElementoFijado = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0F);
    private static final Stroke pincelFlecha1 = new BasicStroke(1.5F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0F);

    private boolean compare;
    private boolean asing;
    private boolean set;
	private boolean flechaDibujada=false;


    public void dibujarFlecha(int posx, int posy, String contador, Graphics2D g2D) {
        if(this.algoritmo instanceof Seleccion){
        	Stroke pincelNormal = g2D.getStroke();
        	Color colorDefecto = g2D.getColor();
        	g2D.setColor(colorDefecto);
        	g2D.setStroke(pincelElementoFijado);
        	if((contador.equals("j;min"))||(contador.equals("min"))||(contador.equals("i;min"))) {
        		g2D.drawString(contador, posx + 18, posy - 10);
        	}else {
        		g2D.drawString(contador, posx + 25, posy - 10);
        	}
        	g2D.setStroke(pincelFlecha1);
        	g2D.drawLine(posx+10, posy - 5, posx + 40, posy - 5);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy - 10);
        	g2D.setStroke(pincelNormal);
        }else if(this.algoritmo instanceof Insercion){
        	Stroke pincelNormal = g2D.getStroke();
        	Color colorDefecto = g2D.getColor();
        	g2D.setColor(colorDefecto);
        	if(contador.equals("i ; j")) {
        		g2D.setStroke(pincelElementoFijado);
        		g2D.drawString(contador, posx + 20, posy - 10);
        		g2D.setStroke(pincelFlecha1);
        		g2D.drawLine(posx+10, posy - 5, posx + 40, posy - 5);
        		g2D.drawLine(posx+10, posy - 5, posx + 15, posy);
        		g2D.drawLine(posx+10, posy - 5, posx + 15, posy - 10);
        		g2D.setStroke(pincelNormal);
        	}else {
        		g2D.setStroke(pincelElementoFijado);
        		g2D.drawString(contador, posx + 25, posy - 10);
        		g2D.setStroke(pincelFlecha1);
        		g2D.drawLine(posx+10, posy - 5, posx + 40, posy - 5);
        		g2D.drawLine(posx+10, posy - 5, posx + 15, posy);
        		g2D.drawLine(posx+10, posy - 5, posx + 15, posy - 10);
        		g2D.setStroke(pincelNormal);
        	}
        }else if((this.algoritmo instanceof BurbujaBasica)||(this.algoritmo instanceof BurbujaAvanzada)) {
        	Stroke pincelNormal = g2D.getStroke();
        	Color colorDefecto = g2D.getColor();
        	g2D.setColor(colorDefecto);
        	g2D.setStroke(pincelElementoFijado);
        	g2D.drawString(contador, posx + 25, posy - 10);
        	g2D.setStroke(pincelFlecha1);
        	g2D.drawLine(posx+10, posy - 5, posx + 40, posy - 5);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy - 10);
        	g2D.setStroke(pincelNormal);
        }else if(this.algoritmo instanceof Shell) {
        	Stroke pincelNormal = g2D.getStroke();
        	Color colorDefecto = g2D.getColor();
        	g2D.setColor(colorDefecto);
        	g2D.setStroke(pincelElementoFijado);
        	if(contador.equals("i ; j")) {
        		g2D.drawString(contador, posx + 18, posy - 10);
        	}else {
        		g2D.drawString(contador, posx + 25, posy - 10);
        	}
        	g2D.setStroke(pincelFlecha1);
        	g2D.drawLine(posx+10, posy - 5, posx + 40, posy - 5);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy);
        	g2D.drawLine(posx+10, posy - 5, posx + 15, posy - 10);
        	g2D.setStroke(pincelNormal);
        }
    }

    public void pintarDetalle(Graphics2D g2D) {
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
        if(this.algoritmo instanceof Seleccion){
        	for(int i=0;i<=algoritmo.getPos();i++) {
        		if(algoritmo.getPosFinal()!=i) {
        			if(algoritmo.getItActualAlg()==algoritmo.getItPos(i)){
	        			pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}else {
						pintarLineaHorizontalBurbujaAvanzada(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}
        		}else {
    				pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-2,g2D);
        		}
        		for(int j = 0; j < algoritmo.getVector().length; j++) {
        			if(algoritmo.esComparadoEnPos(i,j)) {
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);

        			}else if(algoritmo.esIntercambiadoEnPos(i,j)){
        				pintarLineaGruesa(algoritmo.getItPos(i),j,g2D);
        			}else if(!algoritmo.esFijadoEnPos(i,j)){
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);
        			}
        		}
        	}
        }else if(this.algoritmo instanceof BurbujaBasica){
        	for(int i=0;i<=algoritmo.getPos();i++) {
        		if(algoritmo.getPosFinal()!=i) {
        			if(algoritmo.getItActualAlg()==algoritmo.getItPos(i)){
        				pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}else {
						pintarLineaHorizontalBurbujaAvanzada(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}
        		}else {
    				pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-2,g2D);
        		}
        		for(int j = 0; j < algoritmo.getVector().length; j++) {
        			if(algoritmo.esComparadoEnPos(i,j)) {
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);

        			}else if(algoritmo.esIntercambiadoEnPos(i,j)){
        				pintarLineaGruesa(algoritmo.getItPos(i),j,g2D);
        			}else if(!algoritmo.esFijadoEnPos(i,j)){
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);
        			}
        		}
        	}
        }else if(this.algoritmo instanceof BurbujaAvanzada){
        	boolean fijado=false;
        	for(int i=0;i<=algoritmo.getPos();i++) {
        		if(algoritmo.getPosFinal()!=i) {
        			if(algoritmo.getItActualAlg()==algoritmo.getItPos(i)){
        				pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}else {
						pintarLineaHorizontalBurbujaAvanzada(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
					}
        		}else {
    				pintarLineaHorizontal(algoritmo.getItPos(i),algoritmo.getItPos(i)-2,g2D);
        		}
        		for(int j = 0; j < algoritmo.getVector().length; j++) {
        			if(algoritmo.esComparadoEnPos(i,j)) {
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);

        			}else if(algoritmo.esIntercambiadoEnPos(i,j)){
        				pintarLineaGruesa(algoritmo.getItPos(i),j,g2D);
        			}else if(!algoritmo.esFijadoEnPos(i,j)){
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);

        			}
        		}
        		fijado=false;
        	}
        }else if((this.algoritmo instanceof Insercion)){
        	boolean fijado=false;
        	for(int i=0;i<=algoritmo.getPos();i++) {
        		if(algoritmo.getPosFinal()!=i){
        			if(algoritmo.getItActualAlg()==algoritmo.getItPos(i)){
        				pintarLineaHorizontalInsercion2(algoritmo.getItPos(i),algoritmo.getItPos(i),g2D);
					}else {
						pintarLineaHorizontalInsercion(algoritmo.getItPos(i),algoritmo.getItPos(i),g2D);
					}
        		}else {
    				pintarLineaHorizontalInsercion2(algoritmo.getItPos(i),algoritmo.getItPos(i)-1,g2D);
        		}
        		for(int j = 0; j < algoritmo.getVector().length; j++) {
        			if(algoritmo.esComparadoEnPos(i,j)) {
        				pintarLineaFina(algoritmo.getItPos(i),j,g2D);

        			}else if(algoritmo.esIntercambiadoEnPos(i,j)){
        				pintarLineaGruesa(algoritmo.getItPos(i),j,g2D);
        			}//else if(algoritmo.esFijadoEnPos(i,j)){
        				/*if(j!=0) {
        					if(j<algoritmo.getVector().length-1) {
        						if(!algoritmo.esFijadoEnPos(i,j+1)){
        							pintarLineaHorizontalInsercion(algoritmo.getItPos(i),j,g2D);
        							fijado=true;
        						}
        					}else {
    							pintarLineaHorizontalInsercion2(algoritmo.getItPos(i),j,g2D);
        					}
        				}*/
        			/*}*/else {
        				if(algoritmo.getItPos(i)>=j) {
        					if(algoritmo.getPosFinal()!=i){
        						pintarLineaFina(algoritmo.getItPos(i),j,g2D);
        					}
        				}
        			}
        		}
        		fijado=false;
        	}
        }else if(this.algoritmo instanceof Shell){
        	int iReal=0;
        	//posicion 8 lo cuenta como siguiente iteracion
        	Shell alg=(Shell)algoritmo;
        	for(int i=0;i<=algoritmo.getPos();i++) {
        		if(i>1) {
        			if(alg.getIncrementosPos(i)!=alg.getIncrementosPos(i-1)) {
        				iReal++;
        			}
        		}
        		for(int j = 0; j < algoritmo.getVector().length; j++) {
        			if(algoritmo.esComparadoEnPos(i,j)) {
        				pintarLineaFina(algoritmo.getItPos(i)+iReal,j,g2D);

        			}else if(algoritmo.esIntercambiadoEnPos(i,j)){
        				pintarLineaGruesa(algoritmo.getItPos(i)+iReal,j,g2D);
        			}else {
        				pintarLineaFina(algoritmo.getItPos(i)+iReal,j,g2D);
        			}
        		}
        	}
        }
    }
    
    public void pintarLineaHorizontal(int columna, int fila, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelNormal);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+15,  (fila+1)*18+18, 300, (fila+1)*18+18);
    	g2D.setStroke(pincelNormal);
    }
    
    public void pintarLineaHorizontalInsercion(int columna, int fila, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelNormal);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+15,  (fila+1)*18+18+19, columna*5+25, (fila+1)*18+18+19);
    	g2D.setStroke(pincelNormal);
    }
    
    public void pintarLineaHorizontalInsercion2(int columna, int fila, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelNormal);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+15,  (fila+1)*18+18+19, 300, (fila+1)*18+18+19);
    	g2D.setStroke(pincelNormal);
    }
    
    public void pintarLineaHorizontalBurbujaAvanzada(int columna, int fila, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelNormal);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+15,  (fila+1)*18+18, columna*5+25, (fila+1)*18+18);
    	g2D.setStroke(pincelNormal);
    }
    
    public void pintarLineaGruesa(int columna, int fila, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelElementoFijado);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+20,  (fila+1)*18+20, columna*5+20, (fila+1)*18+15+20);
    	g2D.setStroke(pincelNormal);
    }
    
    public void pintarLineaFina(int columna, int fila, Graphics2D g2D) {
    	Stroke pincelNormal = g2D.getStroke();
    	g2D.setStroke(pincelNormal);
    	if(Sortrace.getConfig().getModo().equals("no")) {
    		g2D.setColor(Color.BLACK);
    	}else {
    		g2D.setColor(Color.WHITE);
    	}
    	g2D.drawLine(columna*5+20,  (fila+1)*18+20, columna*5+20, (fila+1)*18+15+20);
    }
    
    public VistaVector() {
    	//super();
        compare=false;
        asing=false;
        set=false;
        new ArrayList<>();
    }

    public void actualizarVector() {
        this.algoritmo = Sortrace.getAlgoritmo();
        this.colorAsignacion = Sortrace.getConfig().getColorAsignacion();
        this.colorComparacion = Sortrace.getConfig().getColorComparacion();
        this.colorFijado= Sortrace.getConfig().getColorFijado();
        this.repaint();
        try {
            sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Sortrace.getAlgoritmo()!=null) {
        	if(Sortrace.getAlgoritmo().IsContinuo()) {
        		if(compare) {
        			Sortrace.getPantalla().subrayarComparacionCodigo();
        		}else if(asing){
        			Sortrace.getPantalla().subrayarAsignacionCodigo();
        		}else{
        			Sortrace.getPantalla().actualizarPanelCodigo();
        		}
        	}
        }

    }
    public boolean isCompare(){
        return compare;
    }
    public boolean isAsing(){
        return asing;
    }
    public boolean isSet(){
        return set;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //if (this.algoritmo != null) {

            Graphics2D g2D = (Graphics2D) g;
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2D.setRenderingHints(rh);

            Graphics2D g2DStadistics = (Graphics2D) g;
            RenderingHints rhStadistics = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2DStadistics.setRenderingHints(rhStadistics);

            this.pintarAlgoritmo(this.algoritmo, g2D, g2DStadistics);



            /*if (traza instanceof TrazaInsercion) {
                this.pintarInsercion((TrazaInsercion)traza, g2D);
            }

            if (traza instanceof TrazaBurbujaBasico) {
                this.pintarBurbuja((TrazaBurbujaBasico)traza, g2D);
            }

            if (traza instanceof TrazaBurbujaOptimizado) {
                this.pintarBurbuja((TrazaBurbujaOptimizado)traza, g2D);
            }

            if (traza instanceof TrazaIncrementos) {
                this.pintarIncrementos((TrazaIncrementos)traza, g2D);
            }*/

        //}
    }

    private int obtenerPosicionNumero(int numero) {
        int digitos = 0;
        if (numero <= 0) {
            ++digitos;
        }

        while (numero != 0) {
            numero /= 10;
            ++digitos;
        }

        return (digitos - 2) * 6 + 10;
    }

    
    private void pintarAlgoritmo(Algoritmo algoritmo, Graphics2D g2D, Graphics g2DStadistics) {
    	flechaDibujada=false;
        Color colorDefecto;
        compare=false;
        asing=false;
        set=false;
        int anchoPanel = this.getWidth();
        int anchoRect = anchoPanel / 5;
        int posYElemento = 18;
        Stroke pincelNormal = g2D.getStroke();
        if(Sortrace.getConfig().getModo().equals("si")) {
            colorDefecto = Sortrace.getConfig().getTextoModoOscuro();
            g2D.setColor(colorDefecto);
        }else{
            colorDefecto = g2D.getColor();
        }
        if(this.algoritmo!=null){
            if(algoritmo.getVector()!=null){
                for (int i = 0; i < algoritmo.getVector().length; ++i) {
                    if (algoritmo.esPosicionIntercambiada(i)) {
                        asing=true;
                        g2D.setStroke(pincelElementoIntercambiado);
                        g2D.setColor(this.colorAsignacion);
                        g2D.fillRect(350, posYElemento + 20, anchoRect, 13);
                        g2D.setStroke(pincelNormal);
                        g2D.setColor(colorDefecto);
                    }else if (algoritmo.esPosicionElementoComparado(i)) {
                        if (algoritmo.noIntercambio()) {
                            compare=true;
                            g2D.setColor(this.colorComparacion);
                            g2D.fillRect(350, posYElemento + 20, anchoRect, 13);
                            g2D.setStroke(pincelNormal);
                            g2D.setColor(colorDefecto);
                        }else {
                            //compare=true;
                        	g2D.setColor(this.colorFijado);
                            g2D.draw(new Double(350.0D, posYElemento + 20, anchoRect, 13.0D, 0.0D, 0.0D));
                            g2D.setColor(colorDefecto);
                        }
                    }else if (algoritmo.esPosicionElementoFijado(i)) {
                        set=true;
                        g2D.setStroke(pincelElementoFijado);
                        g2D.setColor(this.colorFijado);
                        g2D.draw(new Double(350.0D, posYElemento + 20, anchoRect, 13.0D, 0.0D, 0.0D));
                        g2D.setStroke(pincelNormal);
                        g2D.setColor(colorDefecto);
                    }else {
                        g2D.setColor(this.colorFijado);
                        g2D.draw(new Double(350.0D, posYElemento + 20, anchoRect, 13.0D, 0.0D, 0.0D));
                        g2D.setColor(colorDefecto);
                    }
                    if(this.algoritmo instanceof Seleccion){
                    	
                        Seleccion alg = (Seleccion) algoritmo;
                        if (algoritmo.esPosicionElementoComparado(i)) {
                        	if (alg.esMin(i)) {
                                if((alg.getMinAct() == alg.getjAct())&&(alg.getMinAct() == alg.getiAct())) {
                                	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+1+30, "i;j;min", g2D);
                                }else if (alg.getMinAct() == alg.getjAct() ) {
                                	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+1+30, "j;min", g2D);

                                }else if(alg.getMinAct() == alg.getiAct()){
                                	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+1+30, "i;min", g2D);
                                }else {
                                	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+1+30, "min", g2D);

                                }
                            }else if (alg.esI(i)) {
                            	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+1+30, "i", g2D);
                            }else if (alg.esJ(i)) {
                                    if (alg.getMinAct() != alg.getjAct()) {
                                	this.dibujarFlecha(370 + anchoRect - 5, posYElemento+30, "j", g2D);
                                	}
                            }
                            
                        }
                    }else if(this.algoritmo instanceof Insercion){
                            Insercion alg = (Insercion) algoritmo;
                            if(!algoritmo.esPosicionElementoFijado(i)) {
                            if (alg.esI(i)) {
                                if(alg.getiAct() == alg.getjAct()) {
                                	this.dibujarFlecha(370 + anchoRect - 10, posYElemento+1+30, "i ; j", g2D);
                                }else {
                                	this.dibujarFlecha(370 + anchoRect - 10, posYElemento+1+30, "i", g2D);
                                }
                            }else if(alg.esJ(i)) {
                            	this.dibujarFlecha(370 + anchoRect - 10, posYElemento+1+30, "j", g2D);

                            }
                            }
                    }else if(this.algoritmo instanceof BurbujaBasica) {
                    	BurbujaBasica alg = (BurbujaBasica) algoritmo;
                        if ((algoritmo.esPosicionElementoComparado(i))||(algoritmo.esPosicionIntercambiada(i))) {
                        	if(!flechaDibujada) {
                        		this.dibujarFlecha(370 + anchoRect - 5, posYElemento+19+30, "j", g2D);
                        		this.dibujarFlecha(370 + anchoRect - 5, (18*alg.getiAct())+2+30, "i", g2D);
                        		flechaDibujada=true;
                        	}
                        }

                    }else if(this.algoritmo instanceof BurbujaAvanzada) {
                    	BurbujaAvanzada alg = (BurbujaAvanzada) algoritmo;
                        if ((algoritmo.esPosicionElementoComparado(i))||(algoritmo.esPosicionIntercambiada(i))) {
                        	if(!flechaDibujada) {
                        		this.dibujarFlecha(370 + anchoRect - 5, posYElemento+19+30, "j", g2D);
                        		this.dibujarFlecha(370 + anchoRect - 5, (18*alg.getiAct())+2+30, "i", g2D);
                        		flechaDibujada=true;
                        	}
                        }

                    }else if(this.algoritmo instanceof Shell) {
                    	Shell alg = (Shell) algoritmo;
                        if(i==0) {
                        	if(alg.getIncAct()!=0) {
                        		if(alg.getiAct()==alg.getjAct()){
                        			this.dibujarFlecha(370 + anchoRect - 5, (18*alg.getjAct())+23+30, "i ; j", g2D);
                        		}else {
                        			this.dibujarFlecha(370 + anchoRect - 5, (18*alg.getjAct())+23+30, "j", g2D);
                        			this.dibujarFlecha(370 + anchoRect - 5, (18*alg.getiAct())+23+30, "i", g2D);
                        		}
                        	}
                        }
                    }

                    g2D.drawString(Integer.toString(algoritmo.getVector()[i]), 355 + anchoRect / 2 - this.obtenerPosicionNumero(algoritmo.getVector()[i]), posYElemento + 1+30);
                    g2D.drawString(Integer.toString(i), 370 + anchoRect - 15, posYElemento + 1+30);


                    posYElemento += 18;
                }
                if(this.algoritmo instanceof Insercion) {
                	Insercion alg = (Insercion) algoritmo;
                    g2D.drawString("pivote = "+alg.pivoteActual(), 360 + anchoRect +15, posYElemento + 1+35);
                }else if(this.algoritmo instanceof Shell) {
                	Shell alg = (Shell) algoritmo;
                    g2D.drawString("inc = "+alg.getIncrementos(), 370 + anchoRect +15, posYElemento + 1+35);
                }

                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionRendimiento"), 390 + anchoRect+50, 50);
                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionColumnas") + " = " + algoritmo.Columnas(), 400 + anchoRect+60, 70);
                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionComparaciones") + " = " + algoritmo.Comparaciones(), 400 + anchoRect+60, 90);
                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionAsignaciones") + " = " + algoritmo.Asignaciones(), 400 + anchoRect+60, 110);

                if(this.algoritmo instanceof Shell){
                    Shell alg = (Shell) algoritmo;
                    //g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionIncrementos") + " = " + alg.getIncrementos(), 400 + anchoRect+60, 150);
                    g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionIteracion") + " = " + alg.getItActual()+"/"+alg.getItTotales(), 400 + anchoRect+60, 150);
                }
                if(!Sortrace.getAlgoritmo().IsContinuo()) {
                    if (compare) {
                        Sortrace.getPantalla().subrayarComparacionCodigo();
                    }else if (asing) {
                        Sortrace.getPantalla().subrayarAsignacionCodigo();
                    } else {
                        Sortrace.getPantalla().actualizarPanelCodigo();
                    }
                }
            }else {
            	if(!Sortrace.getAlgoritmo().IsContinuo()) {
                    if (compare) {
                        Sortrace.getPantalla().subrayarComparacionCodigo();
                    }else if (asing) {
                        Sortrace.getPantalla().subrayarAsignacionCodigo();
                    } else {
                        Sortrace.getPantalla().actualizarPanelCodigo();
                    }
                }
            }
            if(Sortrace.getVector().getVector()!=null){
            	g2D.drawString(Sortrace.getIdioma().getProperty("visualizacionComparacion"), 400 + anchoRect+80, 230);
            	g2D.drawString(Sortrace.getIdioma().getProperty("visualizacionAsignacion"), 400 + anchoRect+80, 250);
            	g2D.drawString(Sortrace.getIdioma().getProperty("visualizacionFijados"), 400 + anchoRect+80, 270);
            	g2D.drawString(Sortrace.getIdioma().getProperty("visualizacionNoFijados"), 400 + anchoRect+80, 290);

            	g2D.setStroke(this.pincelElementoIntercambiado);
            	g2D.setColor(this.colorComparacion);
            	g2D.fillRect(400 + anchoRect+60, 220, 10, 10);
            	g2D.setColor(this.colorAsignacion);
            	g2D.fillRect(400 + anchoRect+60, 240, 10, 10);
            	g2D.setColor(this.colorFijado);
            	g2D.draw(new Double(400 + anchoRect+60, 260.0D, 10.0D, 10.0D,0.0D,0.0D));
            	g2D.setStroke(pincelNormal);
            	g2D.draw(new Double(400 + anchoRect+60, 280.0D, 10.0D, 10.0D,0.0D,0.0D));
                pintarDetalle(g2D);

            }
        }else{
            if(Sortrace.getVector().getVector()!=null){
                for (int i = 0; i < Sortrace.getVector().getVector().length; ++i) {
                    g2D.setColor(Sortrace.getConfig().getColorFijado());
                    g2D.draw(new Double(350.0D, posYElemento + 20, anchoRect, 13.0D, 0.0D, 0.0D));
                    g2D.setColor(colorDefecto);
                    g2D.drawString(Integer.toString(Sortrace.getVector().getVector()[i]), 355 + anchoRect / 2 - this.obtenerPosicionNumero(Sortrace.getVector().getVector()[i]), posYElemento + 1+30);
                    g2D.drawString(Integer.toString(i), 370 + anchoRect - 15, posYElemento +30+1);
                    posYElemento += 18;
                }
            }
        }
        //pintar leyenda colores


    }
}
