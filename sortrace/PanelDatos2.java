package sortrace;

import sortrace.auxiliar.Vector;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author usuario
 */
public class PanelDatos2 extends javax.swing.JPanel {

    /** Creates new form NewJPanel */
    public PanelDatos2(int longitud) {
        this.longitud=longitud;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Dimension dim=new Dimension(40,25);
        elementos=new javax.swing.JTextField[longitud];
        posiciones=new javax.swing.JLabel[longitud];
        panel = new javax.swing.JPanel();
        panelF = new javax.swing.JPanel();

        for(int i=0;i<longitud;i++){
            posiciones[i]=new javax.swing.JLabel();
            posiciones[i].setText(""+(i+1));
            elementos[i]=new javax.swing.JTextField();
            elementos[i].setPreferredSize(dim);
        }
        jLabel2.setText(Sortrace.getIdioma().getProperty("introducirDatosPosicion"));
        jLabel3.setText(Sortrace.getIdioma().getProperty("introducirDatosElemento"));
        jLabel1.setText(Sortrace.getIdioma().getProperty("introducirDatosEtiquetaEntrada"));
        //this.setLayout(new GridLayout(2,17));
        /*this.setLayout(new GridBagLayout());
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setVerticalAlignment(JLabel.NORTH);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        jLabel3.setHorizontalAlignment(JLabel.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.0;
        c.gridwidth = longitud+1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
       this.add(jLabel1, c);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(jLabel2,c);
        for(int i=0;i<longitud;i++) {
            c.gridx = i+1;
            posiciones[i].setHorizontalAlignment(JLabel.CENTER);
            posiciones[i].setVerticalAlignment(JLabel.NORTH);
            this.add(posiciones[i],c);
        }
        c.gridx = 0;
        c.gridy = 2;
        this.add(jLabel3,c);
        for(int i=0;i<longitud;i++) {
            c.gridx = i+1;
            this.add(elementos[i],c);
        }*/

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        // Set for horizontal and vertical group
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup pGroup = layout
                .createParallelGroup(GroupLayout.Alignment.CENTER);
        pGroup.addComponent(jLabel2);
        pGroup.addComponent(jLabel3);
        hGroup.addGroup(pGroup);
        for (int i=0;i<longitud;i++) {
            GroupLayout.ParallelGroup p1Group = layout
                .createParallelGroup(GroupLayout.Alignment.CENTER);
            p1Group.addComponent(posiciones[i]);
            elementos[i].setMinimumSize(new Dimension(35,30));
            elementos[i].setMaximumSize(new Dimension(35,30));
            elementos[i].setPreferredSize(new Dimension(35,30));
            p1Group.addComponent(elementos[i]);
            hGroup.addGroup(p1Group);
        }

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup v1Group = layout
                .createParallelGroup(GroupLayout.Alignment.CENTER);
        vGroup.addGroup(v1Group);
        v1Group.addComponent(jLabel2);
        for (int i=0;i<longitud;i++) {
            v1Group.addComponent(posiciones[i]);
        }
        GroupLayout.ParallelGroup v2Group = layout
                .createParallelGroup(GroupLayout.Alignment.CENTER);
        vGroup.addGroup(v2Group);
        v2Group.addComponent(jLabel3);
        for (int i=0;i<longitud;i++) {
            v2Group.addComponent(elementos[i]);
        }
        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        panelF.setLayout(new FlowLayout());
        ImageIcon imagen=new ImageIcon(getClass().getResource("/util/icon/Boton_Introducir_Datos.png"));
        JLabel im = new JLabel();
        im.setIcon(imagen);

        panelF.add(im);
        panelF.add(jLabel1);

        this.setLayout(new BorderLayout(20,10));
        this.add(panelF, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        if(Sortrace.getConfig().getModo().equals("si")) {
            jLabel1.setForeground(Sortrace.getConfig().getTextoModoOscuro());
            jLabel2.setForeground(Sortrace.getConfig().getTextoModoOscuro());
            jLabel3.setForeground(Sortrace.getConfig().getTextoModoOscuro());
            for(int i=0;i<posiciones.length;i++) {
                posiciones[i].setForeground(Sortrace.getConfig().getTextoModoOscuro());
            }
            panel.setBackground(Sortrace.getConfig().getFondoModoOscuro());
            panelF.setBackground(Sortrace.getConfig().getFondoModoOscuro());
            this.setBackground(Sortrace.getConfig().getFondoModoOscuro());
        }else{
            jLabel1.setForeground(UIManager.getColor("JLabel.foreground"));
            jLabel2.setForeground(UIManager.getColor("JLabel.foreground"));
            jLabel3.setForeground(UIManager.getColor("JLabel.foreground"));
            for(int i=0;i<posiciones.length;i++) {
                posiciones[i].setForeground(UIManager.getColor("JLabel.foreground"));
            }
            panel.setBackground(UIManager.getColor("JPanel.background"));
            panelF.setBackground(UIManager.getColor("JPanel.background"));
            this.setBackground(UIManager.getColor("JPanel.background"));
        }

    }
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public JTextField[] getElementos() {
        return elementos;
    }
    public void mostrarNumeros(){
        Vector vector=Sortrace.getVector();
        for(int i=0;i<vector.getSize();i++){
            elementos[i].setText(Integer.toString(vector.getVector()[i]));
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField []elementos;
    private javax.swing.JLabel []posiciones;
    int longitud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelF;
    // End of variables declaration//GEN-END:variables
}
