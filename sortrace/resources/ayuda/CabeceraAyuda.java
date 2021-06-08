package main.resources.ayuda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JComponent;

public class CabeceraAyuda extends JComponent {
    public CabeceraAyuda() {
        this.setMinimumSize(new Dimension(500, 60));
        this.setPreferredSize(new Dimension(500, 60));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2D.setRenderingHints(rh);
        GradientPaint color = new GradientPaint(0.0F, 0.0F, Color.DARK_GRAY, 500.0F, 0.0F, Color.GRAY);
        g2D.setPaint(color);
        g2D.fill(new Double(0.0D, 0.0D, (double)this.getWidth(), (double)this.getHeight()));
        g2D.setColor(Color.YELLOW);
        g2D.setFont(new Font("verdana", 0, 24));
        g2D.drawString("Ayuda de Sortrace", 20, 40);
    }
}
