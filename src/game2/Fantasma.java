/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sergi
 */
public class Fantasma extends Component2 implements InterfaceGame2{

    
    private Color color;
    private int direccion;
    public Fantasma(int posx,int posy,Color cFondo) {
        super.posx=posx;
        super.posy=posy;
        this.color=cFondo;
    }

    public Fantasma() {
    }
    
  

    @Override
    public void moverElemento(int estado) {
         switch(estado){
            case DOWN:
                this.posy+=25;
                break;
            case UP:
                this.posy-=25;
                break;
            case LEFT: 
                this.posx-=25;
                break;
            case RIGHT:
                this.posx+=25;
                break;
        }
    }
    
    
   
    @Override
    public void paintElements(Graphics g) {
        g.setColor(this.color);
        g.fillArc(this.posx, this.posy, 20, 20, 0, 180);
        g.fillRect(this.posx+1, this.posy+10,19,10);
        g.setColor(Color.WHITE);
        g.fillOval(posx+2, posy+4,7,7);
        g.fillOval(posx+10, posy+4, 7, 7);
        
        g.setColor(Color.BLACK);
        g.fillOval(posx+4, posy+8,3,3);
        g.fillOval(posx+12, posy+8, 3, 3);
        g.drawArc(posx+7, posx+15,5,5,0,180);
       
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    
     public int getPosx() {
        return (posx/25);
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return (posy/25);
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    
}
