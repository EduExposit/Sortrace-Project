package sortrace.auxiliar;

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

            texto[0]="El algoritmo de selección directa realiza una secuencia de iteraciones, de forma que, en cada iteración, se selecciona el elemento más pequeño de la parte del vector aún desordenada y se coloca a continuación de la parte ordenada.\n"
            +"Por concretar, podemos imaginar que el vector está partido en dos partes, una parte ya ordenada situada a la izquierda y otra aún desordenada situada a la derecha. Inicialmente la parte izquierda ordenada está vacía. En las figuras, separamos ambas partes mediante una barra gruesa vertical. Por ejemplo, sea el siguiente vector:\n";
            texto[1]="\nLa primera iteración va a seleccionar el elemento más pequeño de la parte desordenada (el 1) e intercambiarlo con la celda que está a la derecha de la parte ordenada (el 8). Dado que el algoritmo debe conseguirlo para un vector con un contenido cualquiera, se determina cuál es el elemento menor mediante la comparación de todas las celdas de la parte desordenada, desde su extremo derecho hasta su extremo izquierdo. Tras esta iteración, la parte ordenada ya tiene un elemento y la parte desordenada, el resto.\n";
            texto[2]="\nEn la siguiente iteración, se vuelve a determinar el siguiente elemento menor (el 2) comparando las celdas desde el extremo derecho del vector hasta la separación con la parte ordenada. Una vez determinado, se intercambiará con el elemento situado a la derecha de la parte ordenada (el 8). Tras esta iteración, la parte ordenada ya tiene dos elementos.\n";
            texto[3]="\nEl proceso descrito se repetirá hasta que en la parte desordenada quede un solo elemento (el 8), que será mayor que todos los demás y por tanto no hará falta realizar una última iteración porque ya estará ordenado el vector completo.\n";
            texto[4]="\nEl algoritmo de selección directa tiene una complejidad cuadrática. Su análisis es prácticamente igual que el de la burbuja ya que los bucles están controlados por índices de forma muy parecida, variando solamente en otras operaciones, que son de coste constante. Sea n la longitud del vector. La función de tiempo del algoritmo es igual a:\n";
            texto[5]="\nObsérvese que el bucle interior contiene una instrucción condicional. Siendo estrictos, deberíamos realizar un análisis del algoritmo distinguiendo entre caso mejor, peor y medio, ya que el cuerpo de la instrucción condicional se ejecutará o no según el caso. Sin embargo, el número de iteraciones no varía, por lo que la función de tiempo para dichos casos varía en factores constantes, pero no varía su orden de complejidad cuadrático.";

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

            texto[0]="El algoritmo de la burbuja se denomina así porque realiza una secuencia de iteraciones, de forma que, en cada una, el elemento más pequeño de una parte del vector se desplaza hacia la otra parte, como una “burbuja” que flota sobre los elementos aún desordenados, más grandes. El desplazamiento se consigue comparando cada par de elementos contiguos desde un extremo hasta el otro.\n"
                    +"Por concretar, supongamos que la burbuja se desplaza hacia la izquierda. Podemos imaginar que el vector está partido en dos partes, una parte ya ordenada y situada a la izquierda y otra aún desordenada situada a la derecha. Inicialmente la parte izquierda ordenada está vacía. Por ejemplo, sea el siguiente vector:\n";
            texto[1]="\nLa primera iteración va “hacer flotar la burbuja” (el elemento más pequeño, el 1) hasta la celda de la izquierda. Dado que el algoritmo debe conseguirlo para un vector con un contenido cualquiera, se compararán sucesivamente dos celdas contiguas desde el extremo derecho hasta la parte izquierda del vector. Como resultado, algunas celdas se han desplazado a la izquierda de su posición original y el elemento menor de todos, hasta el extremo izquierdo. Tras esta iteración, la parte ordenada ya tiene un elemento y la parte desordenada, el resto.\n";
            texto[2]="\nEn la siguiente iteración, puede hacerse el mismo proceso de comparaciones entre celdas contiguas desde el extremo derecho hasta la parte ordenada. Como resultado, algunas celdas se han desplazado a la izquierda de su posición original y el siguiente elemento menor de todos, hasta la derecha del vector ordenado. Tras esta iteración, la mitad ordenada ya tiene dos elementos.\n";
            texto[3]="\nEl proceso descrito se repetirá hasta que en la parte desordenada quede un solo elemento, que será mayor que todos los demás y por tanto ya estará ordenado.\n";
            texto[4]="\nEl algoritmo de la burbuja tiene una complejidad cuadrática. Dado que todas las operaciones que realiza son elementales, basta con fijarnos en los valores distintos que toman los índices de los dos bucles anidados. Sea n la longitud del vector. La función de tiempo del algoritmo es igual a:\n";

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

            texto[0]="El algoritmo de la burbuja optimizada es igual al algoritmo de la burbuja excepto en que, en cada iteración, detecta si se ha producido algún intercambio entre celdas contiguas. Si no se ha producido ningún intercambio, las celdas del vector ya están ordenadas y, por tanto, el algoritmo termina.\n"
                    +"La complejidad del algoritmo de la burbuja optimizada es igual al algoritmo de la burbuja en los casos peor y medio. Sin embargo, en el caso mejor tiene una complejidad lineal. En efecto, en este caso el bucle interno realizará una iteración sin realizar ningún intercambio entre celdas contiguas, tras lo cual el algoritmo terminará su ejecución. Por tanto, el bucle externo termina.\n";

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

            texto[0]="El algoritmo de inserción directa es, en cierto modo, el inverso del algoritmo de selección directa. Realiza una secuencia de iteraciones, de forma que, en cada una, toma el elemento que está situado justo a continuación de la parte ordenada del vector y lo inserta en el lugar adecuado de la parte ya ordenada.\n"
                    +"Por concretar, podemos imaginar que el vector está partido en dos partes, una parte ya ordenada situada a la izquierda y otra aún desordenada situada a la derecha. En lugar de partir de una parte izquierda ordenada vacía, podemos partir de una parte izquierda con un elemento, ya que así también está ordenada. Por ejemplo, sea el siguiente vector:\n";
            texto[1]="\nLa primera iteración toma el elemento situado a la derecha de la parte ordenada (el 1), que podemos llamar elemento pivote. Entonces, se recorre la parte izquierda del vector de derecha a izquierda, y va desplazando una posición a la derecha cada elemento que encuentre mayor que el pivote (en este caso, sólo el 8). Esta iteración termina al encontrar un elemento de la parte izquierda menor que el pivote o cuando no queden más elementos por comparar. A continuación, se inserta el elemento pivote en la posición que ocupaba el último elemento desplazado a su derecha.\n";
            texto[2]="\nEn la siguiente iteración, tomamos como pivote el elemento situado a la derecha de la parte ordenada (el 7). De nuevo, se recorre la parte izquierda del vector de derecha a izquierda, desplazando una posición a la derecha cada elemento que encuentre mayor que el pivote (en este caso, el 8 de nuevo). Esta iteración termina al encontrar un elemento de la parte izquierda menor que el pivote (el 1) e inserta el elemento pivote en la posición que ocupaba el último elemento desplazado a su derecha (el 8). Tras esta iteración, la parte ordenada ya tiene dos elementos.\n";
            texto[3]="\nEl proceso descrito se repetirá hasta que la parte desordenada quede vacía y por tanto ya estará ordenado el vector completo.\n";
            texto[4]="\nEl análisis de complejidad del algoritmo de inserción directa es algo más complejo que el de otros algoritmos. El bucle interno tiene una condición compuesta que hace que el número de repeticiones no sólo dependa del tamaño del vector sino también de su contenido. Por tanto, hay que distinguir entre los casos mejor, peor y medio.\n"
                    +"En el caso mejor, el bucle interno nunca se ejecuta. Dado que esto no puede suceder por los valores de los índices, sucede porque no se cumple la segunda parte de la condición del bucle, es decir, cuando v[i-1]\uF0A3v[i], para 1\uF0A3i\uF0A3n-1. Esta situación se da cuando el vector está ordenado inicialmente. En este caso, la función de tiempo del algoritmo es igual a:\n";
            texto[5]="\nEn el caso peor, el bucle interno itera el máximo número de veces permitido por los índices, lo cual exige que la segunda parte de la condición del bucle siempre se cumpla, es decir, que v[i-1]>v[i], para 1\uF0A3i\uF0A3n-1. Esta situación se da cuando el vector está inicialmente ordenado en orden inverso. En este caso, la función de tiempo del algoritmo es igual a:\n";
            texto[6]="\nEn el caso medio, el bucle interno itera la mitad del máximo número de veces permitido por los índices. El análisis resultante es parecido al del caso peor, obteniéndose que T(n) = \uF071(n2).\n";

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

            texto[0]="El algoritmo de Shell se denomina así en honor a que lo inventó Donald Shell en 1959. También se conoce como algoritmo de ordenación por incrementos decrecientes. Se basa en la observación de que algunos algoritmos de ordenación directa, como el de la burbuja o el de inserción, desplazan elementos pequeños a la izquierda a costa de muchos intercambios debido a que sólo comparan celdas adyacentes. Si se compararan celdas situadas a mayor distancia, podría acelerarse la ordenación.\n"
                    +"La versión que presentamos se basa en el algoritmo de la burbuja y utiliza incrementos que son potencias de dos, con una complejidad T(n) = \uF071(n2). Pueden obtenerse versiones más eficientes a partir del algoritmo de inserción directa y utilizando otros valores para los incrementos.\n"
                    +"Por ejemplo, sea el siguiente vector, de longitud 8:\n";
            texto[1]="\nComenzamos utilizando un incremento igual a la mitad de la longitud del vector. Por tanto, aplicamos el algoritmo de la burbuja a celdas cuya distancia es 4. Solamente se realiza una iteración.\n";
            texto[2]="\nA continuación, se vuelve a aplicar el algoritmo de la burbuja con un incremento de tamaño la mitad del anterior, es decir 2. Esta vez se necesitan tres iteraciones, aunque para este vector concreto basta con una para que quede ordenado con incrementos 2.\n";
            texto[3]="\nObsérvese que el vector está ordenado si comparamos las celdas con incrementos 2 y 4, pero aún falta que lo esté con incremento 1.\n"
                    +"Por último, realizamos el mismo proceso con incremento igual a la unidad. Aunque harían falta siete iteraciones en el caso peor, el vector ya está “bastante ordenado”, por lo que, para este ejemplo, sólo se necesitan tres iteraciones.\n";

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
