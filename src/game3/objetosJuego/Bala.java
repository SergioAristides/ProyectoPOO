/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.objetosJuego;

import game3.estados.EstadoJuego;
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
public class Bala extends MovedObject {
    public Bala(Vector2D posicion, Vector2D velocidad, double maxVel, double angulo,BufferedImage textura,EstadoJuego estadoJuego) {
        super(posicion, velocidad, maxVel, textura,estadoJuego);
        this.angulo=angulo;
        this.velocidad=velocidad.scale(maxVel);
    }
    
    
    
    //
     @Override
    public void update() {
        posicion=posicion.add(velocidad);
        if(posicion.getX()<0 || posicion.getX()>Constante.WIDTH||posicion.getY()<0||posicion.getY()>Constante.HEIGHT){
            destruir();
        }
        conColicion();
    }

    @Override
    public void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
		
		at = AffineTransform.getTranslateInstance(posicion.getX() - width/2, posicion.getY());
		
		at.rotate(angulo, width/2, 0);
		
		g2d.drawImage(textura, at, null);
        
    }
    
    @Override
     public Vector2D getCenter(){
       // return new Vector2D(posicion.getX(),posicion.getY()); 
        return new Vector2D(posicion.getX()+width/2,posicion.getY()+width/2); 
        
    }
    
    
}
