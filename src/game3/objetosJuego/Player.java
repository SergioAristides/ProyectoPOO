/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.objetosJuego;
import Frames.WindowGame3;
import game3.estados.EstadoJuego;
import game3.estados.Teclado3;
import game3.utilidades.Assets;
import game3.utilidades.Constante;
import game3.utilidades.Cronometro;
import game3.utilidades.Sonido;
import game3.utilidades.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 *
 * @author sergi
 */
public class Player extends MovedObject{
    private Vector2D heading;
   //vector aceleracion ya que la velocidad no sera constante 
    //cambio en la velocidad con respecto al tiempo
    private Vector2D aceleracion;
    private boolean isAcelerando;
    private Cronometro cronometro;
    private Sonido sonido;
    
  
    private boolean aparece,visible;
    
    private Cronometro tiempoDReaparecer,parpadeo;


    public Player(Vector2D posicion, Vector2D velocidad, double maxVel,BufferedImage textura,EstadoJuego estadoJuego) {
        super(posicion, velocidad, maxVel,textura,estadoJuego);  
        heading= new Vector2D(0,1);
        aceleracion= new Vector2D();
        cronometro= new Cronometro();
        tiempoDReaparecer=new Cronometro();
        parpadeo=new Cronometro();
        sonido= new Sonido(Assets.disparo);
       
        
                
    }

   
    /*
    actualiza el movimiento del jugador y de la balas
    */
    @Override
    public void update() {
        //si el cronometro no esta corriendo
        if(!tiempoDReaparecer.isRunning()){
            
            aparece=false;
            visible=true;
        }
        //pero si esta corriendo
        if(aparece){
            //si no esta parpadeando
            if(!parpadeo.isRunning()){
                parpadeo.run(Constante.TIEMPO_PARPADEO);
                //efecto de parpadeo
                visible=!visible;
            }
        }
        if(Teclado3.disparar && !cronometro.isRunning() && !aparece){
            estadoJuego.getListObjetosMovibles().add(0,new Bala(
                    getCenter().add(heading.scale(width)),heading,Constante.LASER_VEL,angulo,Assets.bala1,
        estadoJuego));
          cronometro.run(Constante.VELOCIDAD_DISPARO);
          sonido.play();
        }
        
        
	 if(Teclado3.derecha)
            //Math.PI/30
            angulo+=Constante.ROTATIONANGLE;
        //Math.PI/30
        if(Teclado3.izquierda)
            angulo-=Constante.ROTATIONANGLE;
        if(Teclado3.arriba){
            //da recoorrido segun la constante aceleracion ya
            //que se multiplica al vector un escalar por cada componente
            aceleracion= heading.scale(Constante.ACC);
            isAcelerando=true;
        }else{
            isAcelerando=false;
            //si la aceleracion y la velocidad tiene el mismo signo en el mismo eje cordenado estamos
            //acelerando si son diferentes estamos frenando osea que no se presiono tecla arriba
            //debemos asegurarnos que la nave se quede quieta cuando no se presiona que el vector aceleracion baje
            if(velocidad.MagnitudVector()!=0){
                aceleracion=(velocidad.scale(-1).vector_unitario()).scale(Constante.ACC /2);
                
            }
        }	
      
        //como la aceleracion representa el cambio en la velocidad con resp
        //ecto al tiempo a ese vector velocidad debemos sumarle el vector aceleracion
        velocidad =velocidad.add(aceleracion);
        //limitamos la velocidad 
        velocidad=velocidad.limit(maxVel);
        //hace referencia a actualizar las posiciones en x y en y cuando la nave esta rotando
        heading=heading.setDirection(angulo - Math.PI/2);
        //la velocidad es el cambio de posicion con respecto
        //al tiempo por lo tanto cada photograma le sumariamos el vector velocidad
        //al vector posicion
        posicion=posicion.add(velocidad);
        
        if(posicion.getX()>WindowGame3.WIDTH)
            posicion.setX(0);
        if(posicion.getY()>WindowGame3.HEIGHT)
            posicion.setY(0);
        if(posicion.getX()<0)
            posicion.setX(WindowGame3.WIDTH);
        if(posicion.getY()<0)
            posicion.setY(WindowGame3.HEIGHT);
        
        cronometro.update();
        conColicion();
        tiempoDReaparecer.update();
        parpadeo.update();
        } 
    
    
    
   private void restaurarValores(){
       angulo=0;
       velocidad= new Vector2D();
       posicion= new Vector2D(Constante.WIDTH/2,Constante.HEIGHT/2);
       
       
   }
 
    @Override
    public void destruir(){
        //si est destruido aparece sera true
        aparece=true;
        tiempoDReaparecer.run(Constante.TIEMPO_R_APARECER);
        restaurarValores();
        estadoJuego.quitarVida();
                
    }

    public boolean isAparece() {
        return aparece;
    }
    
    
    
    
      /*
    dibuja el jugador y el propulsor y ademas intanceamos el tranform que nos ayuda a rotar la nave
    */
    @Override
    public void draw(Graphics g) {
        
        if(!visible)
            return;
        Graphics2D g2= (Graphics2D)g;
        AffineTransform at1=AffineTransform.getTranslateInstance(posicion.getX(),posicion.getY());
        at1.rotate(angulo,width/2,height/2);
        if(isAcelerando){
        g2.drawImage(Assets.efecto, at1,null);
        }
        at=AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        //punto de rotacion ancho y la altura de la imagen
        at.rotate(angulo,width/2,height/2);
        g2.drawImage(Assets.player, at, null);
        
    }
    

   
    
}

