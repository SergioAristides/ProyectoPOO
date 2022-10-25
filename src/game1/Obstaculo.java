/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game1;

import Frames.Game1;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 *
 * @author sergi
 */
public class Obstaculo {
    private Utilidad utilidad;
    private Game1 game;
    private Area area;
    private int ancho,alto;
    private int xInicial;
    private int yInicial;
    private static int xAux;
   
    
    

    public Obstaculo() {
        this.ancho=70;
        this.alto=70;
        this.xInicial=1280;
        this.yInicial=280;
        this.xAux=-4;
         
    }
    
    
    
    public void paint(Graphics2D g2){
        ImageIcon obstaculo=new ImageIcon(getClass().getResource("/imagenes/fuego.png"));
        g2.drawImage(obstaculo.getImage(),xInicial, yInicial,ancho,alto,null);
        
    }
    public void mover(){
        int a;
        if(this.xInicial<=-100){
            a=this.utilidad.getPuntos();
            System.out.println(a);
            a=a+1;
            this.utilidad.setPuntos(a);
            System.out.println(this.utilidad.getPuntos());
            System.out.println("-------------------------ENTROO-------------------------------------------");
            this.xInicial=1280;
            if(this.utilidad.getPuntos()==3|| this.utilidad.getPuntos()==6||
                    this.utilidad.getPuntos()==9||this.utilidad.getPuntos()==12){
                xAux+=-2;
                a=this.utilidad.getNivel();
                a=a+1;
                this.utilidad.setNivel(a);
            }
        }else{
            System.out.println("hollaaa");
            System.out.println("---------");
            System.out.println(this.xInicial);
            this.xInicial+=this.xAux;
        }
    }

    public Utilidad getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Utilidad utilidad) {
        this.utilidad = utilidad;
    }

    public Game1 getGame() {
        return game;
    }

    public void setGame(Game1 game) {
        this.game = game;
    }

  

    

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getxInicial() {
        return xInicial;
    }

    public void setxInicial(int xInicial) {
        this.xInicial = xInicial;
    }

    public int getyInicial() {
        return yInicial;
    }

    public void setyInicial(int yInicial) {
        this.yInicial = yInicial;
    }

    public static int getxAux() {
        return xAux;
    }

    public static void setxAux(int xAux) {
        Obstaculo.xAux = xAux;
    }

   

   
    
}


