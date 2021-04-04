
package util.Configuracion;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Configuracion  {
    private static final String FICHERO_CONFIGURACION = "configuracion.xml";
    private static Document doc;
    //private AjustesAnimacion ajustesAnimacion;
    //private AjustesVisualizacion ajustesVisualizacion;
    private Color colorAsignacion;
    private Color colorComparacion;
    private Color colorFijado;
    private Color fondoModoOscuro;
    private Color panelModoOscuro;
    private Color textoModoOscuro;
    private Color botonModoOscuro;
    private String idioma;
    private String modo;
    private String directorioVectores;
    private String directorioImagenes;
    private int velocidadAnimacion;
    //private ConfiguracionLineaResaltada configuracionLineaResaltada;

    public Configuracion() {
    }

    public String getDirectorioVectores() {
        return this.directorioVectores;
    }

    public void setDirectorioVectores(String directorioVectores) {
        this.directorioVectores = directorioVectores;
        //this.modificarDirectorioVectores(directorioVectores);
    }

    public String getDirectorioImagenes() {
        return this.directorioImagenes;
    }

    public void setDirectorioImagenes(String directorioImagenes) {
        this.directorioImagenes = directorioImagenes;
        //this.modificarDirectorioImagenes(directorioImagenes);
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Color getFondoModoOscuro() {
        return fondoModoOscuro;
    }

    public void setFondoModoOscuro(Color fondoModoOscuro) {
        this.fondoModoOscuro = fondoModoOscuro;
    }

    public Color getPanelModoOscuro() {
        return panelModoOscuro;
    }

    public void setPanelModoOscuro(Color panelModoOscuro) {
        this.panelModoOscuro = panelModoOscuro;
    }

    public Color getTextoModoOscuro() {
        return textoModoOscuro;
    }

    public void setTextoModoOscuro(Color textoModoOscuro) {
        this.textoModoOscuro = textoModoOscuro;
    }

    public Color getBotonModoOscuro() {
        return botonModoOscuro;
    }

    public void setBotonModoOscuro(Color botonModoOscuro) {
        this.botonModoOscuro = botonModoOscuro;
    }

    public int getVelocidadAnimacion() {
        return velocidadAnimacion;
    }

    public void setVelocidadAnimacion(int velocidadAnimacion) {
        this.velocidadAnimacion = velocidadAnimacion;
    }

    /*public AjustesAnimacion getAnimacion() {
        return this.ajustesAnimacion;
    }

    private void setAnimacion(AjustesAnimacion animacion) {
        this.ajustesAnimacion = animacion;
    }
*/

    public Color getColorAsignacion() {
        return colorAsignacion;
    }

    public void setColorAsignacion(Color colorAsignacion) {
        this.colorAsignacion = colorAsignacion;
    }

    public Color getColorComparacion() {
        return colorComparacion;
    }

    public void setColorComparacion(Color colorComparacion) {
        this.colorComparacion = colorComparacion;
    }

    public Color getColorFijado() {
        return colorFijado;
    }

    public void setColorFijado(Color colorFijado) {
        this.colorFijado = colorFijado;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
        this.modificarAjustesIdioma();
    }

    /*public ConfiguracionLineaResaltada getLineaResaltada() {
        return this.configuracionLineaResaltada;
    }

    public void setLineaResaltada(ConfiguracionLineaResaltada linea) {
        this.configuracionLineaResaltada = linea;
        this.modificarLineaResaltada();
    }*/

    public void cargarConfiguracionXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File("src/ConfiguracionAplicacion.xml"));
            doc.getDocumentElement().normalize();
            String color1 = doc.getElementsByTagName("colorAsignacion").item(0).getTextContent();
            String color2 = doc.getElementsByTagName("colorComparcion").item(0).getTextContent();
            String color3 = doc.getElementsByTagName("colorFijado").item(0).getTextContent();
            String color4 = doc.getElementsByTagName("fondoModoOscuro").item(0).getTextContent();
            String color5 = doc.getElementsByTagName("panelModoOscuro").item(0).getTextContent();
            String color6 = doc.getElementsByTagName("textoModoOscuro").item(0).getTextContent();
            String color7 = doc.getElementsByTagName("botonModoOscuro").item(0).getTextContent();
            String modo = doc.getElementsByTagName("modoOscuro").item(0).getTextContent();
            String nodoIdioma = doc.getElementsByTagName("idioma").item(0).getTextContent();
            String nodoVelocidad = doc.getElementsByTagName("velocidad").item(0).getTextContent();
            String nodoParpadeo = doc.getElementsByTagName("parpadeo").item(0).getTextContent();
            String nodoDirVectores = doc.getElementsByTagName("directorioVectores").item(0).getTextContent();
            String nodoDirImagenes = doc.getElementsByTagName("directorioImagenes").item(0).getTextContent();
            String nodoLineaResaltada = doc.getElementsByTagName("lineaResaltada").item(0).getTextContent();
            String nodoNumLineasResaltadas = doc.getElementsByTagName("numLineasResaltadas").item(0).getTextContent();
            String nodoVarResaltada1 = doc.getElementsByTagName("varResaltada1").item(0).getTextContent();
            String nodoVarResaltada2 = doc.getElementsByTagName("varResaltada2").item(0).getTextContent();

            Scanner sc = new Scanner(color1);
            sc.useDelimiter("\\D+");
            colorAsignacion = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color2);
            sc.useDelimiter("\\D+");
            colorComparacion = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color3);
            sc.useDelimiter("\\D+");
            colorFijado = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color4);
            sc.useDelimiter("\\D+");
            fondoModoOscuro = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color5);
            sc.useDelimiter("\\D+");
            panelModoOscuro = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color6);
            sc.useDelimiter("\\D+");
            textoModoOscuro = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc = new Scanner(color7);
            sc.useDelimiter("\\D+");
            botonModoOscuro = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            this.setModo(modo);

            String idioma = nodoIdioma.trim();
            if (idioma.equals("es")) {
                this.setIdioma("ESPAÑOL");
            } else {
                this.setIdioma("INGLES");
            }

            int linea = Integer.parseInt(nodoLineaResaltada.trim());
            int numLineas = Integer.parseInt(nodoNumLineasResaltadas.trim());
            int varResaltada1 = Integer.parseInt(nodoVarResaltada1.trim());
            int varResaltada2 = Integer.parseInt(nodoVarResaltada2.trim());
            //this.setLineaResaltada(new ConfiguracionLineaResaltada(linea, numLineas, varResaltada1, varResaltada2));
            velocidadAnimacion = Integer.parseInt(nodoVelocidad.trim());
            boolean parpadeoActivado = Boolean.parseBoolean(nodoParpadeo.trim());
            //this.setAnimacion(new AjustesAnimacion(velocidad, parpadeoActivado));
            //this.ajustesAnimacion.addObserver(this);
            //this.ajustesVisualizacion.addObserver(this);
            //this.configuracionLineaResaltada.addObserver(this);
            this.setDirectorioImagenes(nodoDirImagenes);
            this.setDirectorioVectores(nodoDirVectores);
        } catch (SAXException | IOException | ParserConfigurationException var28) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, (String)null, var28);
        }

    }

    public void modificarAjustesVisualizacion() {
        doc.getElementsByTagName("colorAsignacion").item(0).setTextContent(this.colorAsignacion.toString());
        doc.getElementsByTagName("colorComparcion").item(0).setTextContent(this.colorComparacion.toString());
        doc.getElementsByTagName("colorFijado").item(0).setTextContent(this.colorFijado.toString());
        doc.getElementsByTagName("modoOscuro").item(0).setTextContent(this.modo);
        guardarConfiguracion();
    }

    public void modificarAnimacion() {
        doc.getElementsByTagName("velocidad").item(0).setTextContent(""+this.velocidadAnimacion);
        guardarConfiguracion();
    }

    private void modificarAjustesIdioma() {
        if (!this.idioma.equals("ESPAÑOL") && !this.idioma.equals("SPANISH")) {
            doc.getElementsByTagName("idioma").item(0).setTextContent("en");
        } else {
            doc.getElementsByTagName("idioma").item(0).setTextContent("es");
        }
        guardarConfiguracion();
    }

    /*private void modificarLineaResaltada() {
        doc.getElementsByTagName("lineaResaltada").item(0).setTextContent(Integer.toString(this.configuracionLineaResaltada.getLineaResaltada()));
        doc.getElementsByTagName("numLineasResaltadas").item(0).setTextContent(Integer.toString(this.configuracionLineaResaltada.getNumLineasResaltadas()));
    }

    private void modificarVariablesResaltadas() {
        doc.getElementsByTagName("varResaltada1").item(0).setTextContent(Integer.toString(this.configuracionLineaResaltada.getVariableResaltada1()));
        doc.getElementsByTagName("varResaltada2").item(0).setTextContent(Integer.toString(this.configuracionLineaResaltada.getVariableResaltada2()));
    }

    private void modificarAjustesAnimacion() {
        doc.getElementsByTagName("parpadeo").item(0).setTextContent(Boolean.toString(this.ajustesAnimacion.estaParpadeoActivado()));
        doc.getElementsByTagName("velocidad").item(0).setTextContent(Integer.toString(this.ajustesAnimacion.getVelocidad()));
    }*/

    public void modificarDirectorioVectores(String dir) {
        this.setDirectorioVectores(dir);
        doc.getElementsByTagName("directorioVectores").item(0).setTextContent(this.directorioVectores);
        guardarConfiguracion();
    }

    public void modificarDirectorioImagenes(String dir) {
        this.setDirectorioImagenes(dir);
        doc.getElementsByTagName("directorioImagenes").item(0).setTextContent(this.directorioImagenes);
        guardarConfiguracion();
    }

    public void guardarConfiguracion() {
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();
            transFact.setAttribute("indent-number", new Integer(3));
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty("indent", "yes");
            trans.setOutputProperty("omit-xml-declaration", "no");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource domSource = new DOMSource(doc);
            trans.transform(domSource, sr);
            PrintWriter pw = new PrintWriter(new FileWriter("src/ConfiguracionAplicacion.xml"));
            pw.println(sw.toString());
            pw.close();
        } catch (TransformerConfigurationException var7) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (IOException | TransformerException var8) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

    }

    /*public void update(Observable o, Object arg) {
        if (arg instanceof AjustesAnimacion) {
            this.modificarAjustesAnimacion();
        } else if (arg instanceof AjustesVisualizacion) {
            this.modificarAjustesVisualizacion();
        } else {
            this.modificarLineaResaltada();
            this.modificarVariablesResaltadas();
        }

    }*/
}
