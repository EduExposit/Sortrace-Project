package main.auxiliar;

import main.Sortrace;

import java.awt.Color;

import javax.swing.*;

public class TeoriaAlgoritmo {
    private String[] texto;
    private String codigoHTML;
    private String codigoComparacionHTML;
    private String codigoAsignacionHTML;
    private ImageIcon[] icons;
    public TeoriaAlgoritmo(String nombreAlg) {
        if(nombreAlg.equals("seleccion")){
            texto=new String[7];
            icons=new ImageIcon[5];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaSeleccion1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaSeleccion2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaSeleccion3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaSeleccion4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaSeleccion5");
            texto[5]= Sortrace.getIdioma().getProperty("teoriaSeleccion6");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Selección 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Selección 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Selección 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Selección 5.png"));
            
            Color colorComparacion = Sortrace.getConfig().getColorAsignacion();
            String hexComparacion = "#"+Integer.toHexString(colorComparacion.getRGB()).substring(2);
            Color colorAsignacion = Sortrace.getConfig().getColorAsignacion();
            String hexAsignacion = "#"+Integer.toHexString(colorAsignacion.getRGB()).substring(2);
           
            codigoHTML="<html>"
            		+ "<head>"
            		+ "<meta charset=\"utf-8\"/>"
            		+ "</head>"
            		+ "<body>"
            		+ "<h1>"+Sortrace.getIdioma().getProperty("algortimosToolSeleccion")+"</h1><br>"
            		+ "<span class=\"first\">public static void</span> <span class=\"second\" >ordenarPorSelec</span><span class=\"second\" > (</span><span class=\"first\" >int</span><span class=\"second\" >[] </span><span class=\"seventh\" >v</span><span class=\"second\">) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"first\">int</span> <span class=\"seventh\">min;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"first\">for</span> <span class=\"second\" >(</span><span class=\"first\" >int</span> <span class=\"seventh\">i</span><span class=\"second\">=0; </span><span class=\"seventh\">i</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1; </span><span class=\"seventh\">i</span><span class=\"second\">++) {<br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class=\"seventh\">min</span><span class=\"second\"> = </span><span class=\"seventh\">i</span><span class=\"second\">;</span><br>"
            		+ "</span>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span> <span class=\"second\" >(</span><span class=\"first\" >int</span> <span class=\"seventh\">j</span><span class=\"second\">=</span><span class=\"seventh\">i</span><span class=\"second\">+1; </span><span class=\"seventh\">j</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span>; </span><span class=\"seventh\">j</span><span class=\"second\">++&#41;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"third\">if</span><span class=\"fourth\" >(</span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">]&#60;</span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">min</span><span class=\"fourth\">]&#41;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"seventh\">min</span><span class=\"second\"> = </span><span class=\"seventh\">j</span><span class=\"second\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"second\" >{</span><span class=\"fifth\" >int</span><span class=\"nineth\"> aux</span><span class=\"sixth\" > = </span><span class=\"nineth\" >v</span><span class=\"sixth\">[</span><span class=\"nineth\">i</span><span class=\"sixth\" >];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\" >v</span><span class=\"sixth\" >[</span><span class=\"nineth\">i</span><span class=\"sixth\">]   = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">min</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\" >min</span><span class=\"sixth\">] = </span><span class=\"nineth\" >aux</span><span class=\"sixth\" >;</span><span class=\"second\" >}<br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br>"
            		+ "}</span>"
            		+ "</body>"
            		+ "</html>";


        }else if(nombreAlg.equals("burbujabasica")){
            texto=new String[5];
            icons=new ImageIcon[5];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica5");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Burbuja 5.png"));
            
            codigoHTML="<html>"
            		+ "<head>"
            		+ "<meta charset=\"utf-8\"/>"
            		+ "</head>"
            		+ "<body>"
            		+ "<h1>"+Sortrace.getIdioma().getProperty("algortimosToolBurbujaBasica")+"</h1><br>"
            		+"<span class=\"first\">public static void</span> <span class=\"second\">burbuja (</span><span class=\"first\">int</span><span class=\"second\">[] </span><span class=\"seventh\">v</span><span class=\"second\">) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span> <span class=\"seventh\">i</span><span class=\"second\">=0; </span><span class=\"seventh\">i</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1; </span><span class=\"seventh\">i</span><span class=\"second\">++)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"first\">for</span> <span class=\"second\">(</span><span class=\"first\">int</span> <span class=\"seventh\">j</span><span class=\"second\">=</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1; </span><span class=\"seventh\">j</span><span class=\"second\">></span><span class=\"seventh\">i</span><span class=\"second\">; </span><span class=\"seventh\">j</span><span class=\"second\">--)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"third\">if </span><span class=\"fourth\">(</span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">-1]></span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">]) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"fifth\">int </span><span class=\"nineth\">aux</span><span class=\"sixth\"> = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j<span class=\"sixth\">-1];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">-1] = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">] = </span><span class=\"nineth\">aux</span><span class=\"sixth\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"second\">}<br>"
            		+ "}</span>"
            		+ "</body>"
            		+ "</html>";
            
        }else if(nombreAlg.equals("burbujaavanzada")){
            texto=new String[1];
            icons=new ImageIcon[1];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaBurbujaAvanzada1");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/BurbujaAvanzada 1.png"));

            
            codigoHTML="<html>"
            		+ "<head>"
            		+ "<meta charset=\"utf-8\"/>"
            		+ "</head>"
            		+ "<body>"
            		+ "<h1>"+Sortrace.getIdioma().getProperty("algortimosToolBurbujaAvanzada")+"</h1><br>"
            		+"<span class=\"first\">public static void</span> <span class=\"second\">bubbleSort1Optimized (</span><span class=\"first\">int</span><span class=\"second\">[] </span><span class=\"seventh\">v</span><span class=\"second\">) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">boolean</span><span class=\"seventh\"> intercambio</span><span class=\"second\"> = </span><span class=\"first\">true</span><span class=\"second\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> i</span><span class=\"second\">=0; </span><span class=\"seventh\">i</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1 && </span><span class=\"seventh\">intercambio</span><span class=\"second\">; </span><span class=\"seventh\">i</span><span class=\"second\">++) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"seventh\">intercambio</span><span class=\"second\"> = </span><span class=\"first\">false</span><span class=\"second\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> j</span><span class=\"second\">=</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1; </span><span class=\"seventh\">j</span><span class=\"second\">></span><span class=\"seventh\">i</span><span class=\"second\">; </span><span class=\"seventh\">j</span><span class=\"second\">--)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"third\">if</span><span class=\"fourth\"> (</span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">-1]></span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">]) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"fifth\">int</span><span class=\"nineth\"> aux</span><span class=\"sixth\"> = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">-1];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">-1] = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">] = </span><span class=\"nineth\">aux</span><span class=\"sixth\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"seventh\">intercambio</span><span class=\"second\"> = </span><span class=\"first\">true</span><span class=\"second\">;<br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br>"
            		+ "}</span>"
            		+ "</body>"
            		+ "</html>";
            
        }else if(nombreAlg.equals("insercion")){
            texto=new String[7];
            icons=new ImageIcon[6];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaInsercion1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaInsercion2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaInsercion3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaInsercion4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaInsercion5");
            texto[5]= Sortrace.getIdioma().getProperty("teoriaInsercion6");
            texto[6]= Sortrace.getIdioma().getProperty("teoriaInsercion7");



            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 5.png"));
            icons[5]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Inserción 6.png"));

            
            codigoHTML="<html>"
            		+ "<head>"
            		+ "<meta charset=\"utf-8\"/>"
            		+ "</head>"
            		+ "<body>"
            		+ "<h1>"+Sortrace.getIdioma().getProperty("algortimosToolInsercion")+"</h1><br>"
            		+ "<span class=\"first\">public static void</span><span class=\"second\"> insertSort (</span><span class=\"first\">int</span<span class=\"second\">[] </span><span class=\"seventh\">v</span><span class=\"second\">) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> i</span><span class=\"second\">=1; </span><span class=\"seventh\">i</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">; </span><span class=\"seventh\">i</span><span class=\"second\">++) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">int</span><span class=\"seventh\"> pivote</span><span class=\"second\"> = </span><span class=\"seventh\">v</span><span class=\"second\">[</span><span class=\"seventh\">i</span><span class=\"second\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">int</span><span class=\"seventh\"> j</span><span class=\"second\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"third\">for</span><span class=\"fourth\"> (</span><span class=\"eight\">j</span><span class=\"fourth\">=</span><span class=\"eight\">i</span><span class=\"fourth\">-1; </span><span class=\"eight\">j</span><span class=\"fourth\">>=0 && </span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">]></span><span class=\"eight\">pivote</span><span class=\"fourth\">; </span><span class=\"eight\">j</span><span class=\"fourth\">--){</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">+1] = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"second\">}</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">+1] = </span><span class=\"nineth\">pivote</span><span class=\"sixth\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"second\">}<br>"
            		+ "}</span>"
            		+ "</body>"
            		+ "</html>";

        }else if(nombreAlg.equals("shell")){
            texto=new String[4];
            icons=new ImageIcon[4];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaShell1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaShell2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaShell3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaShell4");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Shell 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Shell 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Shell 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/main/resources/iconsAlgoritmos/Shell 4.png"));

            
            codigoHTML="<html>"
            		+ "<head>"
            		+ "<meta charset=\"utf-8\"/>"  
            		+ "</head>"
            		+ "<body>"
            		+ "<h1>"+Sortrace.getIdioma().getProperty("algortimosToolShell")+"</h1><br>"
            		+ "<span class=\"first\">public static void</span><span class=\"second\"> ShellSort (</span><span class=\"first\">int</span><span class=\"second\">[] </span><span class=\"seventh\">v</span><span class=\"second\">) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> inc</span><span class=\"second\">=</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">/2; </span><span class=\"seventh\">inc</span><span class=\"second\">>0; </span><span class=\"seventh\">inc</span><span class=\"second\">/=2)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> i</span><span class=\"second\">=1; </span><span class=\"seventh\">i</span><span class=\"second\">&#60;</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">/</span><span class=\"seventh\">inc</span><span class=\"second\">; </span><span class=\"seventh\">i</span><span class=\"second\">++)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"first\">for</span><span class=\"second\"> (</span><span class=\"first\">int</span><span class=\"seventh\"> j</span><span class=\"second\">=</span><span class=\"seventh\">v</span><span class=\"second\">.</span><span class=\"ten\">length</span><span class=\"second\">-1; </span><span class=\"seventh\">j</span><span class=\"second\">>=</span><span class=\"seventh\">inc</span><span class=\"second\">*</span><span class=\"seventh\">i</span><span class=\"second\">; </span><span class=\"seventh\">j</span><span class=\"second\">--)</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"third\">if</span><span class=\"fourth\"> (</span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">-</span><span class=\"eight\">inc</span><span class=\"fourth\">]></span><span class=\"eight\">v</span><span class=\"fourth\">[</span><span class=\"eight\">j</span><span class=\"fourth\">]) {</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"fifth\">int</span><span class=\"nineth\"> aux</span><span class=\"sixth\"> = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">] = </span><span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">-</span><span class=\"nineth\">inc</span><span class=\"sixth\">];</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"nineth\">v</span><span class=\"sixth\">[</span><span class=\"nineth\">j</span><span class=\"sixth\">-</span><span class=\"nineth\">inc</span><span class=\"sixth\">] = </span><span class=\"nineth\">aux</span><span class=\"sixth\">;</span><br>"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"second\">}<br>"
            		+ "}</span>"
            		+ "</body>"
            		+ "</html>";
        }
    }

    public String[] getTexto() {
        return texto;
    }

    public void setTexto(String[] texto) {
        this.texto = texto;
    }

    public ImageIcon[] getIcons() {
        return icons;
    }

    public void setIcons(ImageIcon[] icons) {
        this.icons = icons;
    }

	public String getCodigoHTML() {
		return codigoHTML;
	}

	public void setCodigoHTML(String codigoHTML) {
		this.codigoHTML = codigoHTML;
	}

	public String getCodigoComparacionHTML() {
		return codigoComparacionHTML;
	}

	public void setCodigoComparacionHTML(String codigoComparacionHTML) {
		this.codigoComparacionHTML = codigoComparacionHTML;
	}

	public String getCodigoAsignacionHTML() {
		return codigoAsignacionHTML;
	}

	public void setCodigoAsignacionHTML(String codigoAsignacionHTML) {
		this.codigoAsignacionHTML = codigoAsignacionHTML;
	}
    
}
