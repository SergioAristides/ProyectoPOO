/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.awt.Image;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author sergi
 */
public class Principal extends javax.swing.JFrame {
    
     Clip clip;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        InsertImage();
        producirSonido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGame1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGame1.setText("Juego1");
        btnGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGame1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 120, 50));

        btn2.setText("juego2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 100, 40));
        getContentPane().add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 1190, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGame1ActionPerformed
        PanelGame1 p= new PanelGame1();
        this.add(p);
        p.setVisible(true);
        
    }//GEN-LAST:event_btnGame1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        Game2 game=new Game2();
        game.PintarElementos();
        game.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }
    
     public void InsertImage(){
        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
         ImageIcon icone =new ImageIcon(image.getImage().getScaledInstance(
                lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));
       lblImage.setIcon(icone);
        
        
    }
     
      public void producirSonido(){
        try {
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/musica/choque.wav")));
            clip.start();
            
        } catch (Exception e) {
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2;
    private javax.swing.JButton btnGame1;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
