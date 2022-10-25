/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import game2.Bomba;
import game2.Fantasma;
import game2.InterfaceGame2;
import game2.Muro;
import game2.Tablero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sergi
 */
public class PanelGame1 extends JPanel implements Runnable,KeyListener,InterfaceGame2
{
    private Tablero  tablero = new Tablero();
    public boolean    isPause = false;
    private Thread    hilo;
    private int       iCont;
    
     public PanelGame1()
     {
    //    this.addKeyListener(this); //escuchador de las teclas
        hilo = new Thread(this);
        setFocusable(true);
     }
     
     
    public void iniciar() {
        iCont = 0; 
        hilo.start();
    }

    
     
     public void pausar()
     {
        hilo.suspend();
     }
    
     public void continuar()
     {
        hilo.resume();
     }
    
    public void detener()
    {
        hilo.stop();
    }
    
    @Override
    public void run() 
    {
      try
      {
          tablero.setRandomDirectionGhosts();
          
         while( !tablero.isPlaying() && !tablero.esGanador())
         {
          Thread.sleep(250);
          tablero.moverFantasmas(iCont);
          
          if(iCont == 10)
          {
            iCont = 0;
          }
          
           switch(tablero.pacman.getDirection())
           {
                 case LEFT: 
                        if((tablero.getObject( tablero.pacman.getPosy() , tablero.pacman.getPosx()-1))!= 1){
                           tablero.moverPacman();
                        }
                     break;   
                 case RIGHT:
                         if((tablero.getObject( tablero.pacman.getPosy() , tablero.pacman.getPosx()+1))!= 1){
                           tablero.moverPacman();
                         }
                     break;
                 case UP:
                         if((tablero.getObject( tablero.pacman.getPosy()-1,tablero.pacman.getPosx()))!= 1){
                           tablero.moverPacman();
                         }
                     break;
                 case DOWN: 
                         if((tablero.getObject( tablero.pacman.getPosy()+1, tablero.pacman.getPosx() ))!= 1){ 
                           tablero.moverPacman();
                         }
                     break;
             }
           
             repaint();
             iCont++;
         }
         
          if( tablero.esGanador() && !tablero.isPlaying())
          {
               JOptionPane.showMessageDialog(this, "! Felicidades ganaste !", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
          }
          else{
               JOptionPane.showMessageDialog(this, "! Perdiste !", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
          }
    
          
      }catch(InterruptedException | HeadlessException e)
      {
            JOptionPane.showMessageDialog(this,"Ha ocurrido un Error: "+e.getMessage(),"Advertencia",JOptionPane.ERROR_MESSAGE);
      }
      
    }
    
    @Override
     public void paintComponent(Graphics g)
     {
//         fondo blanco
         g.setColor(Color.white);
         g.fillRect(0, 0, getWidth(), getHeight());
         
//         Se pintan los elementos
        for(Fantasma fantasmita : tablero.fantasmitas) 
        {
            fantasmita.paintElements(g);
        }
         
        for (Muro cuadrito : tablero.cuadritos) 
        {
            cuadrito.paintElements(g);
        }
         
        for (int i=0; i < tablero.coins.size();i++) {
           tablero.coins.get(i).paintElements(g);
        }
         
        
        for(int s=0; s<tablero.bombas.size();s++)
        {
                
               tablero.bombas.get(s).paintElements(g);   
        }
           
           
        
         
          tablero.pacman.paintElements(g);
     }

    @Override
    public void keyTyped(KeyEvent arg0) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) 
    {
        int key = arg0.getKeyCode();
        
        switch(key)
        {
            case KeyEvent.VK_LEFT:  tablero.pacman.setDirection(LEFT); break;
            case KeyEvent.VK_RIGHT: tablero.pacman.setDirection(RIGHT); break;  
            case KeyEvent.VK_UP:    tablero.pacman.setDirection(UP);  break;
            case KeyEvent.VK_DOWN:  tablero.pacman.setDirection(DOWN);  break;
            case KeyEvent.VK_SPACE: 
                       
                     if(isPause == false)
                       { 
                           pausar(); 
                           isPause = true; 
                       }
                       else
                       { 
                           continuar(); 
                           isPause = false;
                       } 
                       break;
            case KeyEvent.VK_ESCAPE: 
                             detener(); 
                             System.exit(1); 
                             break;  
            case KeyEvent.VK_X: 
                // Aqui le cambie
           
                   if( tablero.bombas.size()<3)
                   {
                     
                           tablero.setObject(5, tablero.pacman.getPosy(), tablero.pacman.getPosx());
                           
                           tablero.bombas.add(new Bomba(tablero.pacman.getPosx()*25 , tablero.pacman.getPosy()*25));
                           
                          
                          
                   }
             
          
             break;    
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void moverElemento(int iEstado) {
    }

   
    
}
