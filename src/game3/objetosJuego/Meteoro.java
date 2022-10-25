/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.objetosJuego;

import Frames.WindowGame3;
import game3.estados.EstadoJuego;
import game3.utilidades.Assets;
import game3.utilidades.Constante;
import game3.utilidades.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author sergi
 */
public class Meteoro extends MovedObject{
   // private Size size;
    
    public Meteoro(Vector2D posicion, Vector2D velocidad, double maxVel, BufferedImage textura, EstadoJuego estadoJuego) {
        super(posicion, velocidad, maxVel, textura, estadoJuego);
      
        this.velocidad=velocidad.scale(maxVel);
    }
    
       @Override
    public void update() {
        //cada iteracion se le suma el vector velocidad al vextor posicion
        posicion=posicion.add(velocidad);
        //si se sale de la dimension de la pantalla aparece en su direccion inversa
        if(posicion.getX()>WindowGame3.WIDTH)
            posicion.setX(-width);
        if(posicion.getY()>WindowGame3.HEIGHT)
            posicion.setY(-height);
        if(posicion.getX()<-width)
            posicion.setX(WindowGame3.WIDTH);
        if(posicion.getY()<-height)
            posicion.setY(WindowGame3.HEIGHT);
        
        angulo+=Constante.ROTATIONANGLE/2;
    }
    

    @Override
    public void draw(Graphics g) {
        Graphics2D g2= (Graphics2D)g;
        at=AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        //punto de rotacion ancho y la altura de la imagen
        at.rotate(angulo,width/2,height/2);
        g2.drawImage(textura, at, null);
    }
    @Override
    public void destruir(){
        estadoJuego.setCantidadMeteorosOleada(estadoJuego.getCantidadMeteorosOleada()+1);
        super.destruir();
        estadoJuego.agregarPuntaje(Constante.PUNTAJE_DESTRUIR_M);
    }
    

  
      
    
    
}
