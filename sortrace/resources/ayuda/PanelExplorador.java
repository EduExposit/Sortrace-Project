package main.resources.ayuda;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class PanelExplorador extends JPanel implements TreeSelectionListener {
    private final PanelAyuda panelAyuda;
    private final JTree arbolExp;

    public PanelExplorador(PanelAyuda panelAyuda) {
        super(new GridLayout(1, 0));
        this.panelAyuda = panelAyuda;
        this.setPreferredSize(new Dimension(200, 450));
        this.setMinimumSize(new Dimension(200, 450));
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Ayuda de Sortrace", "AyudaSortrace.html"));
        this.crearNodos(top);
        this.arbolExp = new JTree(top);
        this.arbolExp.getSelectionModel().setSelectionMode(1);
        this.arbolExp.addTreeSelectionListener(this);
        JScrollPane scrollArbol = new JScrollPane(this.arbolExp);
        this.add(scrollArbol);
    }

    private void crearNodos(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode bloque = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Usar Sortrace", "UsarSortrace.html"));
        top.add(bloque);
        DefaultMutableTreeNode apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Seleccionar algoritmo", "SeleccionarAlgoritmo.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Cargar datos", "CargarDatos.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Modificar datos", "ModificarDatos.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Ejecutar algoritmo", "EjecutarAlgoritmo.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Atajos de teclado", "AtajosTeclado.html"));
        bloque.add(apartado);

        bloque = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Interfaz", "Interfaz.html"));
        top.add(bloque);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Barra de iconos", "BarraIconos.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Panel de teoría", "PanelTeoria.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Panel de visualización", "PanelVisualizacion.html"));
        bloque.add(apartado);

        bloque = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Opciones del menú", "OpcionesMenu.html"));
        top.add(bloque);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Archivo", "Archivo.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Ejecución", "Ejecucion.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Configuración", "Configuracion.html"));
        bloque.add(apartado);
        apartado = new DefaultMutableTreeNode(new PanelExplorador.NodoArbol("Ayuda", "Ayuda.html"));
        bloque.add(apartado);
    }

    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.arbolExp.getLastSelectedPathComponent();
        if (node != null) {
            Object nodeInfo = node.getUserObject();
            PanelExplorador.NodoArbol nodo = (PanelExplorador.NodoArbol)nodeInfo;
            this.panelAyuda.mostrarPagina(nodo.getUrl());

        }
    }

    private class NodoArbol {
        private final String nombre;
        private final URL url;

        public NodoArbol(String nombreNodo, String nombrePagina) {
            this.nombre = nombreNodo;
            this.url = this.getClass().getResource("/main/resources/ayuda/pagina/" + nombrePagina);
            if (this.url == null) {
                System.out.println("No se encuentra la pagina: " + nombrePagina);
            }

        }

        public String toString() {
            return this.nombre;
        }

        public URL getUrl() {
            return this.url;
        }
    }
}
