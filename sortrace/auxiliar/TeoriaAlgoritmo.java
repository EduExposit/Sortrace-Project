package sortrace.auxiliar;

import sortrace.Sortrace;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeoriaAlgoritmo {
    private String[] texto;
    private String[] textoCodigo;
    private ImageIcon[] icons;
    public TeoriaAlgoritmo(String nombreAlg) {
        if(nombreAlg.equals("seleccion")){
            texto=new String[7];
            icons=new ImageIcon[5];
            textoCodigo=new String[12];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaSeleccion1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaSeleccion2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaSeleccion3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaSeleccion4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaSeleccion5");
            texto[5]= Sortrace.getIdioma().getProperty("teoriaSeleccion6");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Selección 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Selección 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Selección 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Selección 5.png"));

            textoCodigo[0]="public static void ordenarPorSelec (int[] v) {\n";
            textoCodigo[1]="    int min;\n";
            textoCodigo[2]="    for (int i=0; i<v.length-1; i++) {\n";
            textoCodigo[3]="        min = i;\n";
            textoCodigo[4]="        for (int j=i+1; j<v.length; j++)\n";
            textoCodigo[5]="            if (v[j]<v[min])\n";
            textoCodigo[6]="                min = j;\n";
            textoCodigo[7]="        {int aux = v[i];\n";
            textoCodigo[8]="         v[i]   = v[min];\n";
            textoCodigo[9]="         v[min] = aux; }\n";
            textoCodigo[10]="   }\n";
            textoCodigo[11]="}\n";


        }else if(nombreAlg.equals("burbujabasica")){
            texto=new String[5];
            icons=new ImageIcon[5];
            textoCodigo=new String[9];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaBurbujaBasica5");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Burbuja 5.png"));

            textoCodigo[0]="public static void burbuja (int[] v) {\n";
            textoCodigo[1]="    for (int i=0; i<v.length-1; i++)\n";
            textoCodigo[2]="        for (int j=v.length-1; j>i; j--)\n";
            textoCodigo[3]="            if (v[j-1]>v[j]) {\n";
            textoCodigo[4]="                int aux = v[j-1];\n";
            textoCodigo[5]="                v[j-1] = v[j];\n";
            textoCodigo[6]="                v[j] = aux;\n";
            textoCodigo[7]="            }\n";
            textoCodigo[8]="}\n";
        }else if(nombreAlg.equals("burbujaavanzada")){
            texto=new String[1];
            icons=new ImageIcon[1];
            textoCodigo=new String[14];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaBurbujaAvanzada1");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/BurbujaAvanzada 1.png"));

            textoCodigo[0]="public static void bubbleSort1Optimized (int[] v) {\n";
            textoCodigo[1]="    boolean intercambio = true;\n";
            textoCodigo[2]="    for (int i=0; i<v.length-1 && intercambio; i++) {\n";
            textoCodigo[3]="        intercambio = false;\n";
            textoCodigo[4]="        for (int j=v.length-1; j>i; j--)\n";
            textoCodigo[5]="            if (v[j-1]>v[j]) {\n";
            textoCodigo[6]="                int aux = v[j-1];\n";
            textoCodigo[7]="                v[j-1] = v[j];\n";
            textoCodigo[8]="                v[j] = aux;\n";
            textoCodigo[9]="                intercambio = true;\n";
            textoCodigo[10]="           }\n";
            textoCodigo[11]="       }\n";
            textoCodigo[12]="   }\n";
            textoCodigo[13]="}\n";
        }else if(nombreAlg.equals("insercion")){
            texto=new String[7];
            icons=new ImageIcon[6];
            textoCodigo=new String[10];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaInsercion1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaInsercion2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaInsercion3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaInsercion4");
            texto[4]= Sortrace.getIdioma().getProperty("teoriaInsercion5");
            texto[5]= Sortrace.getIdioma().getProperty("teoriaInsercion6");
            texto[6]= Sortrace.getIdioma().getProperty("teoriaInsercion7");



            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 4.png"));
            icons[4]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 5.png"));
            icons[5]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Inserción 6.png"));

            textoCodigo[0]="public static void insertSort (int[] v) {\n";
            textoCodigo[1]="    for (int i=1; i<v.length; i++) {\n";
            textoCodigo[2]="        int pivote = v[i];\n";
            textoCodigo[3]="        int j;\n";
            textoCodigo[4]="        for (j=i-1; j>=0 && v[j]>pivote; j--){\n";
            textoCodigo[5]="            v[j+1] = v[j];\n";
            textoCodigo[6]="            }\n";
            textoCodigo[7]="        v[j+1] = pivote;\n";
            textoCodigo[8]="    }\n";
            textoCodigo[9]="}\n";


        }else if(nombreAlg.equals("shell")){
            texto=new String[4];
            icons=new ImageIcon[4];
            textoCodigo=new String[10];

            texto[0]= Sortrace.getIdioma().getProperty("teoriaShell1");
            texto[1]= Sortrace.getIdioma().getProperty("teoriaShell2");
            texto[2]= Sortrace.getIdioma().getProperty("teoriaShell3");
            texto[3]= Sortrace.getIdioma().getProperty("teoriaShell4");

            icons[0]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Shell 1.png"));
            icons[1]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Shell 2.png"));
            icons[2]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Shell 3.png"));
            icons[3]=new javax.swing.ImageIcon(getClass().getResource("/util/iconsAlgoritmos/Shell 4.png"));

            textoCodigo[0]="public static void ShellSort (int[] v) {\n";
            textoCodigo[1]="    for (int inc=v.length/2; inc>0; inc/=2)\n";
            textoCodigo[2]="        for (int i=1; i<v.length/inc; i++)\n";
            textoCodigo[3]="            for (int j=v.length-1; j>=inc*i; j--)\n";
            textoCodigo[4]="                if (v[j-inc]>v[j]) {\n";
            textoCodigo[5]="                    int aux = v[j];\n";
            textoCodigo[6]="                    v[j] = v[j-inc];\n";
            textoCodigo[7]="                    v[j-inc] = aux;\n";
            textoCodigo[8]="                }\n";
            textoCodigo[9]="}\n";

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

    public String[] getTextoCodigo() {
        return textoCodigo;
    }

    public void setTextoCodigo(String[] textoCodigo) {
        this.textoCodigo = textoCodigo;
    }
}
