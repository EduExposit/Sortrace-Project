package util.ayuda;

import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;

public class PanelHTML extends JEditorPane implements HyperlinkListener {
    public PanelHTML() {
        this.setEditable(false);
        this.setMinimumSize(new Dimension(500, 450));
        this.setPreferredSize(new Dimension(500, 450));
        this.addHyperlinkListener(this);
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        try {
            if (e.getEventType() == EventType.ACTIVATED) {
                this.setPage(e.getURL());
            }
        } catch (IOException var3) {
            Logger.getLogger(PanelHTML.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }
}