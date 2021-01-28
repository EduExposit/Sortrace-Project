/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortrace;

import sortrace.auxiliar.Vector;
import sortrace.vistas.VistaVector;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class GenerarDatosAleatorios_IU extends javax.swing.JFrame {
    /**
     * Creates new form GenerarDatosAleatorios_IU
     */
    public GenerarDatosAleatorios_IU() {
        initComponents();
        this.buttonGroup1.add(jRadioButton1);
        this.buttonGroup1.add(jRadioButton2);
        this.buttonGroup1.add(jRadioButton3);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Dimension dim=new Dimension(40,25);
        jTextField1.setPreferredSize(dim);
        jTextField2.setPreferredSize(dim);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", Font.BOLD, 14)); // NOI18N
        jLabel1.setText("Tamaño del vector");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Intervalo*");


        jLabel3.setText("...");


        jLabel4.setFont(new java.awt.Font("DejaVu Sans", Font.ITALIC, 12)); // NOI18N
        jLabel4.setText("Los elementos del vector deben estar entre [-999 ... 999]");

        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", Font.BOLD, 14)); // NOI18N
        jLabel5.setText("Orden");

        jRadioButton1.setFont(new java.awt.Font("DejaVu Sans", Font.PLAIN, 12)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Aleatorio");

        jRadioButton2.setFont(new java.awt.Font("DejaVu Sans", Font.PLAIN, 12)); // NOI18N
        jRadioButton2.setText("Orden Creciente");

        jRadioButton3.setFont(new java.awt.Font("DejaVu Sans", Font.PLAIN, 12)); // NOI18N
        jRadioButton3.setText("Orden Decreciente");

        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        JLabel l4=new JLabel();

        l1.setPreferredSize(dim);
        l2.setPreferredSize(dim);
        l3.setPreferredSize(dim);
        l4.setPreferredSize(dim);

        l1.setText("");
        l2.setText("");
        l3.setText("");
        l4.setText("");

        /*this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 3;
        c.gridheight=1;
        c.weighty = 1;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(l4,c);
        c.gridx = 0;
        c.gridy = 1;
        this.add(jLabel1,c);
        c.gridx = 0;
        c.gridy = 2;
        this.add(jComboBox1,c);
        c.gridx = 0;
        c.gridy = 3;
        this.add(l1,c);
        c.gridx = 0;
        c.gridy = 4;
        this.add(jLabel2,c);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        this.add(jTextField1,c);
        c.gridx = 2;
        c.gridy = 5;
        this.add(jTextField2,c);
        c.gridx = 1;
        c.gridy = 5;
        this.add(jLabel3,c);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        this.add(jLabel4,c);
        c.gridx = 0;
        c.gridy = 7;
        this.add(l2,c);
        c.gridx = 0;
        c.gridy = 8;
        this.add(jLabel5,c);
        c.gridx = 0;
        c.gridy = 9;
        this.add(jRadioButton1,c);
        c.gridx =0;
        c.gridy = 10;
        this.add(jRadioButton2,c);
        c.gridx =0;
        c.gridy = 11;
        this.add(jRadioButton3,c);
        c.gridx = 0;
        c.gridy = 12;
        this.add(l3,c);
        c.gridx =0;
        c.gridy = 13;
        c.gridwidth = 1;
        this.add(jButton1,c);
        c.gridx =2;
        c.gridy = 13;
        this.add(jButton2,c);*/


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton1)
                        .addGap(49, 49, 49)
                        .addComponent(jButton2)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        //this.setBounds(0,0,600,800);
        //Dimension d=new Dimension(500,500);
        //this.setPreferredSize(d);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAceptarMouseClicked
        this.longitud=Integer.parseInt((String)this.jComboBox1.getSelectedItem());
        Vector vector = Sortrace.getVector();
        if(this.jRadioButton1.isSelected()){
            vector.setVector(generarNumAleatorios(longitud));
            vector.setSize(longitud);
        }else if(this.jRadioButton2.isSelected()){
            vector.setVector(generarNumCreciente(longitud));
            vector.setSize(longitud);
        }else{
            vector.setVector(generarNumDecreciente(longitud));
            vector.setSize(longitud);
        }
        if(Sortrace.getAlgoritmo()!=null){
            Sortrace.getAlgoritmo().terminar();
            Sortrace.getAlgoritmo().setVector(Sortrace.getVector().getVector());
            Sortrace.getAlgoritmo().ejecutar();
            Sortrace.getPantalla().mostrarPanelVisualizacion();
        }
        Sortrace.getPantalla().actualizarBotonesArchivo();
        this.dispose();
    }
    private int[] generarNumAleatorios(int longitud) {
        Random random = new Random(System.currentTimeMillis());
        int[] vectorAux = new int[longitud];
        int limSup,limInf;
        limInf=Integer.parseInt(this.jTextField1.getText());
        limSup=Integer.parseInt(this.jTextField2.getText());
        for(int i=0;i<longitud;i++){
            vectorAux[i] = random.nextInt(limSup - limInf + 1) + limInf;
        }
        return  vectorAux;
    }
    private int[] generarNumCreciente(int longitud) {
        int[] aux = generarNumAleatorios(longitud);
        Arrays.sort(aux);
        return aux;
    }
    private int[] generarNumDecreciente(int longitud) {
        int[] aux = generarNumCreciente(longitud);
        int[] auxDecreciente = new int[aux.length];

        for(int i = 0; i < aux.length; ++i) {
            auxDecreciente[i] = aux[aux.length - 1 - i];
        }
        return auxDecreciente;
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAceptarMouseClicked
       this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerarDatosAleatorios_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarDatosAleatorios_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarDatosAleatorios_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarDatosAleatorios_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GenerarDatosAleatorios_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private int longitud;
    // End of variables declaration//GEN-END:variables
}
