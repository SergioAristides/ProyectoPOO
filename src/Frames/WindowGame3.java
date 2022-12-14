/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;


import game3.estados.Teclado3;
import game3.estados.EstadoJuego;
import game3.utilidades.Assets;
import game3.utilidades.Constante;
import game3.utilidades.Sonido;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author sergi
 */

public class WindowGame3 extends JFrame implements Runnable{
    
        //dimenciones de la ventana
        public static final int WIDTH = 1000, HEIGHT = 600;
        //canvas tiene menos funcionalidades que un JPanel lo cual representa una 
        //menor carga para el programa
	private Canvas canvas;
        //atributo thread
	private Thread thread;
	private boolean isRunning = true;
	
        //objetos para dibujar
	private BufferStrategy bs;
	private Graphics g;
	
	private final int FPS = 60;
        //tiempo requerido para aumentar un fotogrma para ser mas precisos se divide en 1 nanosegundo
        //que equivale a un segundo
	private double TARGETTIME = 1000000000/FPS;
        //cambio con respecto al tiempo
	private double delta = 0;
        //fotgramas por segundo promedio saber a cuanto FPS esta corriendo el juego
	private int AVERAGEFPS = FPS;
        
       // EstadoJuego estadoJuego;
        EstadoJuego estadoJuego;
        Teclado3 teclado;
        
        
       
        
        
        private boolean bandera=true;
        
        //inicializadr del frame
	public WindowGame3()
	{
		setTitle("Space Ship Game");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		canvas = new Canvas();
		teclado= new Teclado3();
                System.out.println(Constante.WIDTH);
		canvas.setPreferredSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		canvas.setMaximumSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		canvas.setMinimumSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		canvas.setFocusable(true);
		
                //agregar el canvas al Jframe para trabajar sobre el
		add(canvas);
                canvas.addKeyListener(teclado);
                setVisible(true);
		
	}
	
        
        
  
       
       public void pausar(){
          
       if(Teclado3.pausar){    
           while(bandera){
               
               if(Teclado3.seguir){
                   
                bandera=false;
               }
               
           }
       }
          
       }
       
//       public void pausar(){
//           if(Teclado3.pausar){
//               stop();
//           } else if(Teclado3.seguir){
//                       start();
//                       }   
//               
//           }
       
           
       
       public  void reiniciar(){
           stop();
           
       }
	
        //ejecutable de la ventana
	public static void main(String[] args) {
		new WindowGame3().start();
	}
	
	
        //actualiza el juego
	private void update(){
            teclado.update();
            
            //Estado.getEstado().update();
            estadoJuego.update();
	}
        
        //dibuja los primeros componenentes del juego
	private void draw(){
		bs = canvas.getBufferStrategy();
		
		if(bs == null)
		{  
                        //3= numero de bufer que utiliza un canvas
			canvas.createBufferStrategy(3);
			return;
		}
                // Obtenga un nuevo contexto de gr??ficos cada vez que pase por el ciclo
              // para asegurarse de que la estrategia est?? validada
		g = bs.getDrawGraphics();
                g.setColor(new Color(9,2,60));
                g.fillRect(0, 0, WIDTH, HEIGHT);
                g.setColor(Color.red);
                estadoJuego.draw(g);
                //DIBUJA LOS FPS
                g.drawString(""+AVERAGEFPS, 10,10);
		//---------------------
		//g.dispose();
                //// Muestra el buffer
		bs.show();
	}
	
	//Maneja la ejecucion de el hilo
	@Override
	public void run() {
            
            long now=0;
            //restringir el ciclo y que corra a 60
            //registro del tiempo pasado nos da la hora actual del sistema en 
            //nanosegundos
            long lasTime=System.nanoTime();
            int frames=0;
            long time=0;
            init();
		while(isRunning){
                    pausar();
                    now=System.nanoTime();
                    //tiempo que ha pasado
                    delta+=(now-lasTime)/TARGETTIME;
                    time+=(now-lasTime);
                    lasTime=now;
                    
                    //due por que aumentamos un fotograma
                    if(delta>=1){
                    update();
                    draw();
                    delta--;
                    frames++;
                    //System.out.println(frames);
                    }
                    if(time>=1000000000){
                        AVERAGEFPS=frames;
                        frames=0;
                        time=0;
                    }
                   
                }
                stop();
	}
	
        //inicaliza algunas que no estan en el thread
        public void init(){
            Assets.init();
           // Estado.setEstado(new EstadoJuego());
           estadoJuego= new EstadoJuego();
        }
	private void start(){
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		
		
	}
        //detiene el hilo
	private void stop(){
		try {
			thread.join();
			isRunning = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
