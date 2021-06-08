/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources.filtros;
import java.io.File;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author usuario
 */
public class FiltroTxt extends FileFilter{
    public static final String EXTENSION = ".txt";
    public static final String FORMATO = "TXT";

    public FiltroTxt() {
    }

    public boolean accept(File fileName) {
        String nombreFichero = fileName.getName().toLowerCase();
        return fileName.isDirectory() || nombreFichero.endsWith(".txt");
    }

    public String getDescription() {
        return ".txt";
    }
}
