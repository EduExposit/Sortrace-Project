
package main.resources.Configuracion;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JRadioButton;
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
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import main.Sortrace;

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
    private int tamañoGenerarDatos;
    private String limiteInfGenerarDatos;
    private String limiteSupGenerarDatos;
    private int ordenGenerarDatos;
    private int[] vector;
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

    public int getTamañoGenerarDatos() {
		return tamañoGenerarDatos;
	}

	public void setTamañoGenerarDatos(int tamañoGenerarDatos) {
		this.tamañoGenerarDatos = tamañoGenerarDatos;
	}

	public String getLimiteInfGenerarDatos() {
		return limiteInfGenerarDatos;
	}

	public void setLimiteInfGenerarDatos(String limiteInfGenerarDatos) {
		this.limiteInfGenerarDatos = limiteInfGenerarDatos;
	}

	public String getLimiteSupGenerarDatos() {
		return limiteSupGenerarDatos;
	}

	public void setLimiteSupGenerarDatos(String limiteSupGenerarDatos) {
		this.limiteSupGenerarDatos = limiteSupGenerarDatos;
	}

	public int getOrdenGenerarDatos() {
		return ordenGenerarDatos;
	}

	public void setOrdenGenerarDatos(int ordenGenerarDatos) {
		this.ordenGenerarDatos = ordenGenerarDatos;
	}
	
	

	public int[] getVector() {
		cargarConfiguracionXML();
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public void cargarConfiguracionXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File xmlConfig = new File("ConfiguracionAplicacion.xml");
            if (xmlConfig.exists()) {
                doc = db.parse(new File("ConfiguracionAplicacion.xml"));
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
                String nodoTamañoGenerarDatos = doc.getElementsByTagName("tamano").item(0).getTextContent();
                String nodoLimInf = doc.getElementsByTagName("limInf").item(0).getTextContent();
                String nodoLimSup = doc.getElementsByTagName("limSup").item(0).getTextContent();
                String nodoOrden = doc.getElementsByTagName("orden").item(0).getTextContent();
                String nodoVector = doc.getElementsByTagName("vector").item(0).getTextContent();
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
                    this.setIdioma("Español");
                } else {
                    this.setIdioma("Inglés");
                }

                int linea = Integer.parseInt(nodoLineaResaltada.trim());
                int numLineas = Integer.parseInt(nodoNumLineasResaltadas.trim());
                int varResaltada1 = Integer.parseInt(nodoVarResaltada1.trim());
                int varResaltada2 = Integer.parseInt(nodoVarResaltada2.trim());
                //this.setLineaResaltada(new ConfiguracionLineaResaltada(linea, numLineas, varResaltada1, varResaltada2));
                this.velocidadAnimacion = Integer.parseInt(nodoVelocidad.trim());
                this.tamañoGenerarDatos = Integer.parseInt(nodoTamañoGenerarDatos.trim());
                this.limiteInfGenerarDatos = nodoLimInf.trim();
                this.limiteSupGenerarDatos = nodoLimSup.trim();
                this.ordenGenerarDatos = Integer.parseInt(nodoOrden.trim());
                boolean parpadeoActivado = Boolean.parseBoolean(nodoParpadeo.trim());
                //this.setAnimacion(new AjustesAnimacion(velocidad, parpadeoActivado));
                //this.ajustesAnimacion.addObserver(this);
                //this.ajustesVisualizacion.addObserver(this);
                //this.configuracionLineaResaltada.addObserver(this);
                this.setDirectorioImagenes(nodoDirImagenes);
                this.setDirectorioVectores(nodoDirVectores);
                
                String[] auxVector = nodoVector.split(" ");
                vector = new int[auxVector.length];
                if((auxVector.length>0)&&(auxVector[0]!="")) {
                	for(int i=0;i<auxVector.length;i++) {
                		vector[i]=Integer.parseInt(auxVector[i]);
                	}
                }else {
                	vector=null;
                }
            }else{
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                //Elemento raiz
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("configuracion");
                doc.appendChild(rootElement);
                //elementos
                Element elemento = doc.createElement("colorAsignacion");
                elemento.setTextContent("java.awt.Color[r=255,g=255,b=0]");
                rootElement.appendChild(elemento);
                Element elemento2 = doc.createElement("colorComparcion");
                elemento2.setTextContent("java.awt.Color[r=0,g=255,b=255]");
                rootElement.appendChild(elemento2);
                Element elemento3 = doc.createElement("colorFijado");
                elemento3.setTextContent("java.awt.Color[r=0,g=0,b=0]");
                rootElement.appendChild(elemento3);
                Element elemento4 = doc.createElement("modoOscuro");
                elemento4.setTextContent("no");
                rootElement.appendChild(elemento4);
                Element elemento5 = doc.createElement("fondoModoOscuro");
                elemento5.setTextContent("java.awt.Color[r=44,g=44,b=44]");
                rootElement.appendChild(elemento5);
                Element elemento6 = doc.createElement("panelModoOscuro");
                elemento6.setTextContent("java.awt.Color[r=64,g=64,b=64]");
                rootElement.appendChild(elemento6);
                Element elemento7 = doc.createElement("textoModoOscuro");
                elemento7.setTextContent("java.awt.Color[r=209,g=209,b=209]");
                rootElement.appendChild(elemento7);
                Element elemento8 = doc.createElement("botonModoOscuro");
                elemento8.setTextContent("java.awt.Color[r=100,g=100,b=100]");
                rootElement.appendChild(elemento8);
                Element elemento9 = doc.createElement("idioma");
                elemento9.setTextContent("es");
                rootElement.appendChild(elemento9);
                Element elemento10 = doc.createElement("velocidad");
                elemento10.setTextContent("5");
                rootElement.appendChild(elemento10);
                Element elemento11 = doc.createElement("parpadeo");
                elemento11.setTextContent("true");
                rootElement.appendChild(elemento11);
                Element elemento12 = doc.createElement("lineaResaltada");
                elemento12.setTextContent("0");
                rootElement.appendChild(elemento12);
                Element elemento13 = doc.createElement("numLineasResaltadas");
                elemento13.setTextContent("0");
                rootElement.appendChild(elemento13);
                Element elemento14 = doc.createElement("varResaltada1");
                elemento14.setTextContent("0");
                rootElement.appendChild(elemento14);
                Element elemento15 = doc.createElement("varResaltada2");
                elemento15.setTextContent("0");
                rootElement.appendChild(elemento15);
                Element elemento16 = doc.createElement("directorioVectores");
                elemento16.setTextContent("C:\\");
                rootElement.appendChild(elemento16);
                Element elemento17 = doc.createElement("directorioImagenes");
                elemento17.setTextContent("C:\\");
                rootElement.appendChild(elemento17);
                Element elemento18 = doc.createElement("tamano");
                elemento18.setTextContent("8");
                rootElement.appendChild(elemento18);
                Element elemento19 = doc.createElement("limInf");
                elemento19.setTextContent("0");
                rootElement.appendChild(elemento19);
                Element elemento20 = doc.createElement("limSup");
                elemento20.setTextContent("99");
                rootElement.appendChild(elemento20);
                Element elemento21 = doc.createElement("orden");
                elemento21.setTextContent("1");
                rootElement.appendChild(elemento21);
                Element elemento22 = doc.createElement("vector");
                elemento22.setTextContent("");
                rootElement.appendChild(elemento22);
                //Se escribe el contenido del XML en un archivo
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("ConfiguracionAplicacion.xml"));
                transformer.transform(source, result);
                this.cargarConfiguracionXML();
            }
            } catch(SAXException | IOException | ParserConfigurationException | TransformerConfigurationException var28){
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, (String) null, var28);
            } catch (TransformerException e) {
            e.printStackTrace();
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
        if (!this.idioma.equals("Español") && !this.idioma.equals("Spanish")) {
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
    
    public void guardarGenerarDatos(int tamaño, String limInf, String limSup, int orden) {
        this.tamañoGenerarDatos = tamaño;
        this.limiteInfGenerarDatos = limInf;
        this.limiteSupGenerarDatos = limSup;
        this.ordenGenerarDatos = orden;
        
        doc.getElementsByTagName("tamano").item(0).setTextContent(""+this.tamañoGenerarDatos);
        doc.getElementsByTagName("limInf").item(0).setTextContent(this.limiteInfGenerarDatos);
        doc.getElementsByTagName("limSup").item(0).setTextContent(this.limiteSupGenerarDatos);
        doc.getElementsByTagName("orden").item(0).setTextContent(""+this.ordenGenerarDatos);
        guardarConfiguracion();

    }

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

    public void guardarVector() {
    	String vect="";
        vector=Sortrace.getVector().getVector();
        for(int i=0;i<vector.length;i++) {
        	vect=vect+vector[i]+" ";
        }
        doc.getElementsByTagName("vector").item(0).setTextContent(vect);
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
            PrintWriter pw = new PrintWriter(new FileWriter("ConfiguracionAplicacion.xml"));
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
