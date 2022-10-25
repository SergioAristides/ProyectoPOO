/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

/**
 *
 * @author sergi
 */

/*
Clae que resive las url imagenes  y las asigna a un BufferedImage
*/
public class Assets {
    //nave
    public static BufferedImage player;
    //prepulsor nave
    public static BufferedImage efecto;
    //tipos de balas
    public static BufferedImage bala1;
    public static BufferedImage bala2;
    public static BufferedImage bala3;
    
    //arreglo de meteoros 
    public static BufferedImage[]meteoros= new BufferedImage[6];
    //arreglo de explociones
    public static BufferedImage[]explociones= new BufferedImage[9];
    //arreglo de numeros
    public static BufferedImage[]numeros= new BufferedImage[11];
    //imagen vida
    public static BufferedImage vida;
    
    public static Clip musicaFondo,explosion,disparo;
            
    public static void init(){
        player=Cargar.cargarImagen("/naves/player_nave_f.png");
        efecto=Cargar.cargarImagen("/naves/propulsoraf.png");
        bala1=Cargar.cargarImagen("/naves/balaP1.png");
        bala2=Cargar.cargarImagen("/naves/balaP2.png");
        bala3=Cargar.cargarImagen("/naves/laserBlue01.png");
        vida=Cargar.cargarImagen("/numeros/vida.png");
        
        
        for (int i = 0; i < meteoros.length; i++) {
            meteoros[i]=Cargar.cargarImagen("/naves/asteroide"+(i+1)+".png");
        }
        
        
         for (int i = 0; i < explociones.length; i++) {
            explociones[i]=Cargar.cargarImagen("/explociones/explosion"+i+".png");
        }
         for (int i = 0; i < numeros.length; i++) {
            numeros[i]=Cargar.cargarImagen("/numeros/"+i+".png");
        }
         
        musicaFondo= Cargar.CargarAudio("/sonidos/sonido3.wav");
        explosion = Cargar.CargarAudio("/sonidos/sonidoEx2.wav");
        disparo= Cargar.CargarAudio("/sonidos/disparof1.wav");
       
        
    }
    
}
