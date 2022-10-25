/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game1;

import Frames.Game1;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sergi
 */
public class Dino {

    private Game1 game;

    private Obstaculo obstaculo;
    private boolean saltar;
    private boolean subir;
    private boolean bajar;
    private Area area;
    private int ancho;
    private int alto;
    private int xInicial;
    private int YInicial;
    //coordenadas para manipular el dino
    private int xAuxiliar = 0;
    private int yAuxiliar = 0;

    public Dino(){

        this.saltar = false;
        this.subir = false;
        this.bajar = false;
        this.ancho = 112;
        this.alto = 112;
        this.xInicial = 50;
        this.YInicial = 235;

    }

    public void Movimiento() {
        
        if(this.xInicial+this.xAuxiliar>0 && xInicial+xAuxiliar<game.getWidth()-ancho){
            xInicial+=xAuxiliar;
        }
        if(this.saltar){
            if(this.YInicial==235){//SI EL AUTO ESTA EN EL SUELO
                this.subir=true;
                this.yAuxiliar=-2;
                this.bajar=false;
            }
            if(YInicial==200){ //SI EL AUTO LLEGO AL LIMITE DEL SALTO
                this.bajar=true;
                this.yAuxiliar=2;
                this.subir=false;
            }
            
            if(this.subir){
                YInicial+=yAuxiliar;
                
            }
            if(this.bajar){
                YInicial+=yAuxiliar;
                if(YInicial==235){//SI EL AUTO LLEGO AL SUELO
                    this.saltar=false;
                    
                }
                
            }
        }
           
        
    }

    public void paint(Graphics2D g2) {
        ImageIcon dino = new ImageIcon(getClass().getResource("/imagenes/tirano_saurio-rex.png"));
        g2.drawImage(dino.getImage(), xInicial, YInicial, ancho, alto, null);

    }

    public Game1 getGame() {
        return game;
    }

    public void setGame(Game1 game) {
        this.game = game;
    }
    public boolean isSaltar() {
        return saltar;
    }

    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }

    public boolean isSubir() {
        return subir;
    }

    public void setSubir(boolean subir) {
        this.subir = subir;
    }

    public boolean isBajar() {
        return bajar;
    }

    public void setBajar(boolean bajar) {
        this.bajar = bajar;
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

    public int getYInicial() {
        return YInicial;
    }

    public void setYInicial(int YInicial) {
        this.YInicial = YInicial;
    }

    public int getxAuxiliar() {
        return xAuxiliar;
    }

    public void setxAuxiliar(int xAuxiliar) {
        this.xAuxiliar = xAuxiliar;
    }

    public int getyAuxiliar() {
        return yAuxiliar;
    }

    public void setyAuxiliar(int yAuxiliar) {
        this.yAuxiliar = yAuxiliar;
    }

    public Obstaculo getObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

}
