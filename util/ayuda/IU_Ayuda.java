package util.ayuda;

import java.awt.Component;
import javax.swing.JFrame;

public class IU_Ayuda extends JFrame {
    private PanelAyuda panel;

    public IU_Ayuda() {
        this.setTitle("Ayuda de Sortrace");
        this.setSize(700, 450);
        this.setResizable(true);
        this.setDefaultCloseOperation(2);
        this.panel = new PanelAyuda();
        this.setContentPane(this.panel);
        this.setLocationRelativeTo((Component)null);
        this.pack();
        this.setVisible(true);
    }
}