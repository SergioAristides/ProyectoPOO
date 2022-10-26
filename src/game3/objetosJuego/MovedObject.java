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
        MovedObject m;
        //Referecia al arreglo de objetos movibles de estadoJuego
        ArrayList<MovedObject> objetosMovibles=estadoJuego.getListObjetosMovibles();
        for (int i = 0; i < objetosMovibles.size(); i++) {
                 m=objetosMovibles.get(i);
            //asegurar de no comprobar colicion con migo mismo
            if(m.equals(this)){
                continue;
            }
            
            //el restar.getcenter()--> vendria siendo el de el objeto que esta intentando colisionar
            double distancia=m.getCenter().restar(getCenter()).MagnitudVector();
            // verifico si la distancia es menor al radio del el objeto en el arreglo con el radio de el objeto
            //movible donde se este llamando
            //contains hace referencia a que ese objeto este en arreglo ya pudo haber sido eliminado
            if(distancia<m.width/2 +width/2 && objetosMovibles.contains(this)){
                colisionObjeto(m,this);
            }
        }
        
    }
     protected   Vector2D getCenter(){
       // return new Vector2D(posicion.getX(),posicion.getY()); 
       //retorna por decirlo asi las dimenciones en completo  de la imagen por que
       //posicion seria una posicion en x normal pero mas el radio nos dario todo su tamaño
        return new Vector2D(posicion.getX()+width/2,posicion.getY()+height/2); 
        
    }
     /*
     1-->verificamos que tanto a y b no sean meteoros ya que pueden colisionar entre ellos
     2-->si no es por que alguno de los dos no son meteoros por ende debe haber una colicion
     tanto bala meteoro o nave meteoro
     */
    private void colisionObjeto(MovedObject a,MovedObject b){
        if(!(a instanceof Meteoro && b instanceof Meteoro)){
//            if(a instanceof Player || b instanceof Player){
//                estadoJuego.quitarVida(1);
//            }

            estadoJuego.empezarExplosion(getCenter());
            a.destruir();
            b.destruir();
        }
        
        
    }
     //1--->elimiba el objeto movible que coliciono
    //2---->pero verifica que el objeto se diferente a un jugador
    //---> y si no es una instancia de bala es por que es un meteoro y debe hacer sonido
     protected void destruir(){
         if(!(this instanceof Player)){
         estadoJuego.getListObjetosMovibles().remove(this);
         if(!(this instanceof Bala)){
             sonido.play();
         }
     }
     }
}
