/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 *
 * @author sergi
 */
public class Animacion {
    private BufferedImage[] frames;
    private int velocidad;
    private int index;
    private boolean isRunning;
    private Vector2D posicion;
    private long time;

    public Animacion(BufferedImage[] frames,int velocidad,Vector2D posicion) {
        this.frames=frames;
        this.velocidad=velocidad;
        this.posicion=posicion;
        //posicion inicial
        this.index=0;
        isRunning=true;
        time=0;
        
               
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }
    
    //maneja el tiempo para que desaparezca la explocion
    public void update(){
        time++;
        if(time>5){
            isRunning=false;
            time=0;
        }
    }
    
    //obtiene el photograma actual en el arreglo de photogramas
  public BufferedImage getCFrames(){
      return frames[index];
      
  }
    
}
