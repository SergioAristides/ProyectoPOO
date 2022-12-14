/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import game1.Constante;
import game1.Dino;
import game1.Fondo;
import game1.Obstaculo;
import game1.Teclado;
import game1.Utilidad;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author sergi
 */
public class Game1 extends javax.swing.JFrame implements KeyListener, ActionListener,Runnable {

    URL urlSonidoChoque, urlSonidoSalto;
    AudioClip sonidoChoque, sonidoSalto;
    //Object de la clase Dino
    Dino dino;
    Fondo fondo;
    Obstaculo obstaculo;
    Utilidad utilidad;
    static boolean juegoFinalizado = false;
    static Thread thread;
    Graphics2D g2;
    private Timer timer;
    int cont = 0;
    Applet applet;
    

    /**
     * Creates new form Game1
     */
    public Game1() {
        initComponents();
        utilidad = new Utilidad(false, 3, 0, 1);
        dino = new Dino();
        fondo = new Fondo();
        obstaculo = new Obstaculo();
        obstaculo.setUtilidad(utilidad);
        dino.setObstaculo(obstaculo);
        dino.setGame(this);
        fondo.setGame(this);
        obstaculo.setGame(this);
        this.addKeyListener(this);
        urlSonidoChoque = getClass().getResource("/game1/music/choque.wav");
        sonidoChoque = applet.newAudioClip(urlSonidoChoque);
        urlSonidoSalto = getClass().getResource("/game1/music/salto.wav");
        sonidoSalto = applet.newAudioClip(urlSonidoSalto);
        this.setSize(1280, 400);
        this.setLocationRelativeTo(null);
        setFocusable(true);
        timer = new Timer(50, this);//--->maneja la velocidad del moved de la nave
        timer.start();
        thread = new Thread(this);
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Game1().setVisible(true);
       
            }
        });
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.dino.setSaltar(true);
            System.out.println("holaaaaa");
            sonidoSalto.play();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public  void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }

    public void dibujar(Graphics2D g2) {

        fondo.paint(g2);
        dino.paint(g2);
        obstaculo.paint(g2);
        mover();
      
   
    }

    public void dibujarPuntaje(Graphics2D g) {
//        Graphics2D g1,g2;
//        g1=g;
//        g2=g;
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g.setColor(Color.BLUE);
        g1.drawString("Puntaje: " + utilidad.getPuntos(), Constante.COORDENADA_X_PUNTAJE, Constante.COORDENADA_Y_PUNTAJE);
        g1.drawString("Vidas: " + utilidad.getVidas(), Constante.COORDENADA_X_VIDA, Constante.COORDENADA_Y_VIDA);
        g1.drawString("Nivel: " + utilidad.getNivel(), Constante.COORDENADA_X_NIVEL, Constante.COORDENADA_Y_NIVEL);

        if (juegoFinalizado) {
            g2.setColor(Color.red);
            g2.drawString("??????HAZ PERDIDO!!!: ", ((float) getBounds().getCenterX() / 2) + 170, 70);
        }

    }

    public void finJuego() {

    }

    public void pierdeVida() {
        //sonidoChoque.play();
        utilidad.setPierdeVida(true);

    }

    public  void mover() {
        obstaculo.mover();
        dino.Movimiento();
    }
//    @Override
//    public void run(){
//         
//        while(true){
//            this.repaint();
//            try { 
//                Thread.sleep(1000000);
//                
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
       

    }
    @Override
    public void run(){
                   while(true){
             this.repaint();
            try {
                
                
                thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
