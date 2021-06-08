package main.resources.ayuda;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class PanelAyuda extends JPanel {
    public static final String PAGINA_PRINCIPAL = "AyudaSortrace.html";
    private final CabeceraAyuda cabeceraAyuda = new CabeceraAyuda();
    private final PanelExplorador panelExplorador = new PanelExplorador(this);
    private final PanelHTML panelHTML = new PanelHTML();

    public PanelAyuda() {
        super(new GridBagLayout());
        JSplitPane paneles = new JSplitPane(1, this.panelExplorador, new JScrollPane(this.panelHTML));
        paneles.setContinuousLayout(true);
        paneles.setDividerSize(5);
        paneles.setDividerLocation(200);
        paneles.setEnabled(false);
        GridBagConstraints posCabecera = new GridBagConstraints();
        posCabecera.weightx = 1.0D;
        posCabecera.weighty = 0.0D;
        posCabecera.gridx = 0;
        posCabecera.gridy = 0;
        posCabecera.fill = 1;
        GridBagConstraints posPaneles = new GridBagConstraints();
        posPaneles.weightx = 1.0D;
        posPaneles.weighty = 1.0D;
        posPaneles.gridx = 0;
        posPaneles.gridy = 1;
        posPaneles.fill = 1;
        this.add(this.cabeceraAyuda, posCabecera);
        this.add(paneles, posPaneles);
        this.mostrarPagina(this.getClass().getResource("/main/resources/ayuda/pagina/AyudaSortrace.html"));
    }

    public void mostrarPagina(URL url) {
        try {
            if (url != null) {
                this.panelHTML.setPage(url);
            }
        } catch (IOException var3) {
            Logger.getLogger(PanelAyuda.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }
}
