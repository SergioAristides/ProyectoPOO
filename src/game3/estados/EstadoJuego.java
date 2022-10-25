/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import game3.objetosJuego.Meteoro;
import game3.objetosJuego.MovedObject;
import game3.objetosJuego.Player;
import game3.utilidades.Animacion;
import game3.utilidades.Assets;
import game3.utilidades.Constante;
import game3.utilidades.Sonido;
import game3.utilidades.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */

/*
dibuja y actualiza el estado del juego
*/
public class EstadoJuego extends Estado{
    Player player;
    private ArrayList<MovedObject>listObjetosMovibles= new ArrayList<>();
    private ArrayList<Animacion>listExplociones= new ArrayList<>();
    private int cantidadMeteorosOleada;
    private int score=0;
    private int vidas=3;
    
    Sonido sonido;
    
    public EstadoJuego() {
        //valores inicales del jugador
        player= new Player(new Vector2D(100,500),new Vector2D(),Constante.PLAYER_MAX_VEL, Assets.player,this );
        listObjetosMovibles.add(player);
        cantidadMeteorosOleada=2;
        sonido= new Sonido(Assets.musicaFondo);
        sonido.FondoMusica();
        sonido.manejaVolumen(-30f);
    }
     
    
    //se llama en moved object
    //se llama en el destruir player
    public void quitarVida(){
        vidas--;
    }
//    public void quitarVida(int value){
//        if(vidas!=0){
//        vidas+=-value;
//    }else{
//            JOptionPane.showMessageDialog(null,"has perdido");
//        }
//    }
//    
    //dibuja las vidas en una posicion especifica y valida que no restemos a la vida del jugador mas de lo deseado
    //se llama en el draw del estado del juego
    private void drawlive(Graphics g){
		
		Vector2D posicionVida = new Vector2D(25, 25);
		
		g.drawImage(Assets.vida, (int)posicionVida.getX(), (int)posicionVida.getY(), null);
		
		g.drawImage(Assets.numeros[10], (int)posicionVida.getX() + 40,
				(int)posicionVida.getY() + 5, null);
		
		String livesToString = Integer.toString(vidas);
		
		Vector2D pos = new Vector2D(posicionVida.getX(), posicionVida.getY());
		
		for(int i = 0; i < livesToString.length(); i ++)
		{
			int number = Integer.parseInt(livesToString.substring(i, i+1));
			
                        
                        //verificamos que el numero de vidas sea mayor a 0 para poder restarle
			if(number <= 0)
				break;
			g.drawImage(Assets.numeros[number],
					(int)pos.getX() + 60, (int)pos.getY() + 5, null);
			pos.setX(pos.getX() + 20);
		}
		
	}
    
    
    //dibuja el puntaje se llama en el draw del estado del juego
    private void drawScore(Graphics g){
        Vector2D posicion= new Vector2D(850,25);
        String scoreToString=Integer.toString(score);
        
        for (int i = 0; i<scoreToString.length() ; i++) {
            /*
            Devuelve una nueva cadena que es una subcadena de esta cadena. La subcadena comienza en el especificado 
            beginIndexy se extiende hasta el carácter en el índice endIndex - 1. Por lo tanto, la longitud de la subcadena 
            es endIndex-beginIndex.
            Ejemplos:
            "hamburguesa".substring(4, 8) devuelve "urgencia"
            "sonrisas".substring(1, 5) devuelve "milla"
            */
            g.drawImage(
                    Assets.numeros[Integer.parseInt(scoreToString.substring(i,i+1))],
                    (int)posicion.getX(), 
                    (int)posicion.getY(), 
                    null);
        posicion.setX(posicion.getX()+20);
        }
       
    }
    
    
    
    //se le agrega a el puntaje 
    //se llama en el metodo destruir meteoros
    public void agregarPuntaje(int value){
        score+=value;
    }
    private void startMetoros(){
        double x,y;
        for (int i = 0; i < cantidadMeteorosOleada; i++) {
            System.out.println("----------------------------------------");
            System.out.println(i);
            System.out.println("----------------------------------------");
            
            //math.random devuelve= un nuero mayor a 0.0 y menor a 1.0
            //SI i es par  x sera igual a un numero aleaotorio entre sero y el ancho de la ventana si no cero
            x=i%2==0?Math.random()*Constante.WIDTH:0;
            y=i%2!=0?0:Math.random()*Constante.HEIGHT;
            
            BufferedImage textura =Assets.meteoros[(int)(Math.random()*Assets.meteoros.length)];
            listObjetosMovibles.add(new Meteoro(
                    new Vector2D(x,y),
                    new Vector2D(0,1).setDirection(Math.random()*Math.PI*2), 
                    Constante.METEOR_VEL*Math.random()+1,
                    textura,
                    this
            
            ));
            
            
        }
        
        cantidadMeteorosOleada++;
        
    }
    
    public void empezarExplosion(Vector2D posicion){
        listExplociones.add(
                new Animacion(Assets.explociones,
                50,
                posicion.restar(new Vector2D(Assets.explociones[0].getWidth()/2,
                Assets.explociones[0] .getHeight()/2))
                
                ));
        
        
        
    }
  
    //actualiza todos los objetos del juego 
    public void update(){
        for(int i=0;i<listObjetosMovibles.size();i++){
            listObjetosMovibles.get(i).update();
        }
        for(int i=0;i<listExplociones.size();i++){
            Animacion animacion= listExplociones.get(i);
            animacion.update();
            if(!animacion.isIsRunning()){
                listExplociones.remove(i);
            }
        }
        for(int i=0;i<listObjetosMovibles.size();i++)
            if(listObjetosMovibles.get(i)instanceof Meteoro)
                return;
        
        startMetoros();
                
            
        
        
        
        
    }

    public int getCantidadMeteorosOleada() {
        return cantidadMeteorosOleada;
    }

    public void setCantidadMeteorosOleada(int cantidadMeteorosOleada) {
        this.cantidadMeteorosOleada = cantidadMeteorosOleada;
    }
    //dibuja todos los objetos movibles
    public void draw(Graphics g){
         Graphics2D g2= (Graphics2D)g;
         g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         for(int i=0;i<listObjetosMovibles.size();i++){
            listObjetosMovibles.get(i).draw(g);
        }
         
           
         
         //dibuja las animaciones
         for(int i=0;i<listExplociones.size();i++){
            Animacion animacion= listExplociones.get(i);
            g2.drawImage(animacion.getCFrames(),
            (int) animacion.getPosicion().getX(),
            (int) animacion.getPosicion().getY(),
            null);
         }
        drawScore(g);
        drawlive(g);
    }

    public ArrayList<MovedObject> getListObjetosMovibles() {
        return listObjetosMovibles;
    }

    public void setListObjetosMovibles(ArrayList<MovedObject> listObjetosMovibles) {
        this.listObjetosMovibles = listObjetosMovibles;
    }

    
    
     
    
}
