/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import static Frames.WindowGame3.HEIGHT;
import static Frames.WindowGame3.WIDTH;
import game1.Fondo;
import game3.estados.Teclado3;
import game3.utilidades.Cargar;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author sergi
 */
public class WindowGame1 extends JFrame implements Runnable{

    private Canvas canvas;
    private BufferedImage image;
    private BufferStrategy bs;
    private Graphics g;
    private boolean isRunning = false;
    public static final int WIDTH = 1280, HEIGHT = 400;
    private Fondo fondo;
    Thread thread;
     
    public WindowGame1(){
        setTitle("Saltando");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
	setLocationRelativeTo(null);
	setVisible(true);
        canvas = new Canvas();
        
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	canvas.setFocusable(true);
        add(canvas);
    }
    
    public static void main(String[] args) {
        new WindowGame1().start();
    }

    @Override
    public void run() {
        while(isRunning){
        draw();
        }
    }
    public void start(){
        thread = new Thread(this);
        thread.start();
        isRunning = true;
        
    }
    public void stop(){
        
    }
    public void init(){
        
    }
    public void update(){
        
    }
    public void draw(){
        bs= canvas.getBufferStrategy();
        if(bs==null){
            canvas.createBufferStrategy(3);
            return;
            
        }
        g= bs.getDrawGraphics();
        //pintar Fondo
         Graphics2D g2 = (Graphics2D) g;
         fondo.paint(g2);
       
        
    }
    
}
