package sortrace.vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D.Double;
import javax.swing.*;

import sortrace.Algoritmo;
import sortrace.Sortrace;
import sortrace.algoritmos.*;


public class VistaVector extends JPanel {
    private Algoritmo algoritmo = null;
    private Color colorAsignacion = null;
    private Color colorComparacion = null;
    private Color colorFijado = null;
    private static final Stroke pincelElementoIntercambiado = new BasicStroke(2.0F, 0, 1, 1.0F);
    private static final Stroke pincelElementoAColocar = new BasicStroke(1.0F, 1, 1, 1.0F, new float[]{5.0F, 5.0F, 5.0F, 5.0F}, 5.0F);
    private static final Stroke pincelElementoFijado = new BasicStroke(2.0F, 1, 0, 1.0F);
    private static final Stroke pincelFlecha1 = new BasicStroke(1.5F, 0, 1, 1.0F);
    private boolean compare;
    private boolean asing;
    private boolean set;


    public void dibujarFlecha(int posx, int posy, String contador, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
        Color colorDefecto = g2D.getColor();
        g2D.setColor(colorDefecto);
        g2D.setStroke(pincelElementoFijado);
        g2D.drawString(contador, posx + 12, posy - 6);
        g2D.setStroke(pincelFlecha1);
        g2D.drawLine(posx, posy - 5, posx + 20, posy - 5);
        g2D.drawLine(posx, posy - 5, posx + 5, posy);
        g2D.drawLine(posx, posy - 5, posx + 5, posy - 10);
        g2D.setStroke(pincelNormal);
    }

    public void dibujarFlechaExterna(int posx1, int posy1, int posx2, int posy2, Graphics2D g2D) {
        Stroke pincelNormal = g2D.getStroke();
        Color colorDefecto = g2D.getColor();
        g2D.setStroke(pincelFlecha1);
        g2D.setColor(Color.RED);
        g2D.drawLine(posx1, posy1 - 5, posx1 + 40, posy1 - 5);
        g2D.drawLine(posx1, posy1 - 5, posx1 + 5, posy1);
        g2D.drawLine(posx1, posy1 - 5, posx1 + 5, posy1 - 10);
        g2D.drawLine(posx2, posy2 - 5, posx2 + 40, posy2 - 5);
        g2D.drawLine(posx2, posy2 - 5, posx2 + 5, posy2);
        g2D.drawLine(posx2, posy2 - 5, posx2 + 5, posy2 - 10);
        g2D.drawLine(posx1 + 40, posy1 - 5, posx2 + 40, posy2 - 5);
        g2D.setStroke(pincelNormal);
        g2D.setColor(colorDefecto);
    }

    public VistaVector() {
        compare=false;
        asing=false;
        set=false;
        //this.setSize(this.getWidth()+200,this.getHeight());
    }

    public void actualizarVector() {
        this.algoritmo = Sortrace.getAlgoritmo();
        this.colorAsignacion = Sortrace.getConfig().getColorAsignacion();
        this.colorComparacion = Sortrace.getConfig().getColorComparacion();
        this.colorFijado= Sortrace.getConfig().getColorFijado();
        this.repaint();
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
        if (this.algoritmo != null) {
            System.out.println("****************** VECTOR ***********************");

            Graphics2D g2D = (Graphics2D) g;
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2D.setRenderingHints(rh);

            Graphics2D g2DStadistics = (Graphics2D) g;
            RenderingHints rhStadistics = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2DStadistics.setRenderingHints(rhStadistics);
            if(this.algoritmo instanceof Seleccion) {
                this.pintarSeleccion(this.algoritmo, g2D, g2DStadistics);
            }else if(this.algoritmo instanceof BurbujaBasica){
                this.pintarSeleccion(this.algoritmo, g2D, g2DStadistics);
            }else if(this.algoritmo instanceof BurbujaAvanzada){
                this.pintarSeleccion(this.algoritmo, g2D, g2DStadistics);
            }else if(this.algoritmo instanceof Insercion){
                this.pintarSeleccion(this.algoritmo, g2D, g2DStadistics);

            }else if(this.algoritmo instanceof Shell){
                this.pintarSeleccion(this.algoritmo, g2D, g2DStadistics);

            }


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

        }
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

    private void pintarSeleccion(Algoritmo algoritmo, Graphics2D g2D, Graphics g2DStadistics) {
        compare=false;
        asing=false;
        set=false;
        int anchoPanel = this.getWidth();
        int anchoRect = anchoPanel - 500;
        int posYElemento = 20;
        Stroke pincelNormal = g2D.getStroke();
        Color colorDefecto=g2D.getColor();
        if(Sortrace.getConfig().getModo().equals("si")) {
            colorDefecto = Sortrace.getConfig().getTextoModoOscuro();
            g2D.setColor(colorDefecto);
        }else{
            colorDefecto = g2D.getColor();
        }
        System.out.println("PINTAR SELECCION");
        if(algoritmo.getVector()==null){

        }else {
            for (int i = 0; i < algoritmo.getVector().length; ++i) {
                if (algoritmo.esPosicionIntercambiada(i)) {
                    asing=true;
                    g2D.setStroke(pincelElementoIntercambiado);
                    g2D.setColor(this.colorAsignacion);
                    g2D.fillRoundRect(50, posYElemento - 10, anchoRect, 13, 5, 5);
                    g2D.setStroke(pincelNormal);
                    g2D.setColor(colorDefecto);
                } else if (algoritmo.esPosicionElementoComparado(i)) {
                    if (algoritmo.noIntercambio()) {
                        compare=true;
                        g2D.setColor(this.colorComparacion);
                        g2D.fillRoundRect(50, posYElemento - 10, anchoRect, 13, 5, 5);
                        g2D.setStroke(pincelNormal);
                        g2D.setColor(colorDefecto);
                    } else {
                        compare=true;
                        g2D.draw(new Double(50.0D, (double) (posYElemento - 10), (double) anchoRect, 13.0D, 5.0D, 5.0D));
                    }
                } else if (algoritmo.esPosicionElementoFijado(i)) {
                    set=true;
                    g2D.setStroke(pincelElementoFijado);
                    g2D.setColor(this.colorFijado);
                    g2D.draw(new Double(50.0D, (double) (posYElemento - 10), (double) anchoRect, 13.0D, 5.0D, 5.0D));
                    g2D.setStroke(pincelNormal);
                    g2D.setColor(colorDefecto);
                } else {
                    g2D.draw(new Double(50.0D, (double) (posYElemento - 10), (double) anchoRect, 13.0D, 5.0D, 5.0D));
                }

                if(this.algoritmo instanceof Insercion){
                    if (algoritmo.esPosicionElementoComparado(i)) {
                        Insercion alg = (Insercion) algoritmo;
                        g2D.drawString("aux = " + Integer.toString(alg.pivoteActual()), 0, posYElemento + 1);
                    }
                }

                g2D.drawString(Integer.toString(algoritmo.getVector()[i]), 50 + anchoRect / 2 - this.obtenerPosicionNumero(algoritmo.getVector()[i]), posYElemento + 1);
                g2D.drawString(Integer.toString(i), 50 + anchoRect - 7, posYElemento + 2);


                posYElemento += 18;
            }
            Sortrace.getPantalla().actualizarPanelCodigo();
            if(compare) {
                Sortrace.getPantalla().subrayarComparacionCodigo();
            }else if(asing){
                Sortrace.getPantalla().subrayarAsignacionCodigo();
            }
            System.out.println("******************ESTADISTICAS***********************");
            g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionRendimiento"), 55 + anchoRect, 20);
            g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionColumnas") + " = " + algoritmo.Columnas(), 60 + anchoRect, 40);
            g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionComparaciones") + " = " + algoritmo.Comparaciones(), 60 + anchoRect, 60);
            g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionAsignaciones") + " = " + algoritmo.Asignaciones(), 60 + anchoRect, 80);

            if(this.algoritmo instanceof Shell){
                Shell alg = (Shell) algoritmo;
                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionIncrementos") + " = " + alg.getIncrementos(), 60 + anchoRect, 120);
                g2DStadistics.drawString(Sortrace.getIdioma().getProperty("visualizacionIteracion") + " = " + alg.getItActual()+"/"+alg.getItTotales(), 60 + anchoRect, 140);
            }
        }
    }
}
