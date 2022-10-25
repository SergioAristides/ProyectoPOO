 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.objetosJuego;

import game3.estados.EstadoJuego;
import game3.utilidades.Assets;
import game3.utilidades.Sonido;
import game3.utilidades.Vector2D;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */

//clase que representa a todos los objetos moviles del juego
public abstract class MovedObject extends ObjetoJuego{
    protected Vector2D velocidad;
    protected double maxVel ;
    //componente que ayuda a rotar la nave o cualquier objeto movible
    protected AffineTransform at;
    protected double angulo;
    protected int width;
    protected int height;
    protected EstadoJuego estadoJuego;
    private Sonido sonido;
   
    public MovedObject(Vector2D posicion,Vector2D velocidad ,double maxVel,BufferedImage textura,EstadoJuego estadoJuego) {
        super(posicion, textura);
        this.estadoJuego=estadoJuego;
        this.velocidad= velocidad;
        this.maxVel=maxVel;
        width= textura.getWidth();
        height= textura.getHeight();
        angulo=0;
        sonido= new Sonido(Assets.explosion);
    }
    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
    }
    
    
    /*
tenemos un objeto: calcular la distancia desde los centros de los objetos y comprobaremos si esa 
distancia es menor que la suma de ambos radios
if(distancia<radio+radio){
colisión();
}   para hallar la distancia simplemente restamos los vectores
    */
    //se llama en el update del jugador al final
    protected void conColicion(){
        ArrayList<MovedObject> objetosMovibles=estadoJuego.getListObjetosMovibles();
        for (int i = 0; i < objetosMovibles.size(); i++) {
            MovedObject m=objetosMovibles.get(i);
            if(m.equals(this)){
                continue;
            }
            double distancia=m.getCenter().restar(getCenter()).MagnitudVector();
            if(distancia<m.width/2 && objetosMovibles.contains(this)){
                colisionObjeto(m,this);
            }
        }
        
    }
     protected   Vector2D getCenter(){
       // return new Vector2D(posicion.getX(),posicion.getY()); 
        return new Vector2D(posicion.getX()+width/2,posicion.getY()+height/2); 
        
    }
     //maneja que deberia hacer en caso de que el objeto colisione
    private void colisionObjeto(MovedObject a,MovedObject b){
        if(!(a instanceof Meteoro && b instanceof Meteoro)){
//            if(a instanceof Player || b instanceof Player){
//                estadoJuego.quitarVida(1);
//            }
              if(a instanceof Player && ((Player)a).isAparece()){
                return;
            }
              if(b instanceof Player && ((Player)b).isAparece()){
                return;
            }
            estadoJuego.empezarExplosion(getCenter());
            a.destruir();
            b.destruir();
        }
        
        
    }
     //elimiba el objeto del arreglo al ver que la distancia es menor a la magnitud de la resta de los vectores
     protected void destruir(){
         
         estadoJuego.getListObjetosMovibles().remove(this);
         if(!(this instanceof Bala)){
             sonido.play();
         }
     }
    
}
