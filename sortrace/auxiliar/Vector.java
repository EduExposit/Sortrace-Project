package sortrace.auxiliar;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

public class Vector implements Serializable {
        private int[] vector;
        private int size=0;

        public Vector(){
            size=0;
        }

    public int[] getVector() {
        return vector;
    }
    public boolean isEmpty() {
        return this.size==0;
    }
    public void setVector(int[] vector) {
            if (vector!=null) {
                this.vector = Arrays.copyOf(vector, vector.length);
                this.size = vector.length;
            }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void cargarDeFichero(String infoVector) throws NumberFormatException {
        String[] datosVector = infoVector.split(" ");
        this.size = Integer.parseInt(datosVector[0]);
        int[] v = new int[this.size];
        if (datosVector.length != v.length + 1) {
            throw new NumberFormatException();
        } else {
            for(int i = 0; i < v.length; ++i) {
                v[i] = Integer.parseInt(datosVector[i + 1]);
                if (v[i] < -999 || v[i] > 999) {
                    throw new NumberFormatException();
                }
            }

            this.setVector(v);
        }
    }
    public void escribirEnFichero(PrintWriter pw) {
        pw.print(this.size);

        for(int i = 0; i < this.size; ++i) {
            pw.print(" " + this.vector[i]);
        }

    }
}
