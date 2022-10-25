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
public class Cpacman extends Component2 implements InterfaceGame2{
    private int direction;
    private boolean isOpen=true;

    public Cpacman(int posx,int posy,int direction) {
        super.posx=posx;
        super.posy=posy;
        this.direction = direction;
    }

    public Cpacman() {
        super.posx=0;
        super.posy=0;
    }
    
    @Override
    public void paintElements(Graphics g) {
        switch(this.direction){
            case RIGHT:
                    if(isOpen){
                        g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 45,275);
                        isOpen=false;
                    }else{
                         g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 0,360);
                         this.isOpen=true;
                    }
                    g.setColor(Color.BLACK);g.fillOval(this.posx+8,this.posy+4, WIDTHOJO, HEIGHTOJO);
                
                break;
            case LEFT:
                if(isOpen){
                        g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 225,275);
                        isOpen=false;
                    }else{
                         g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 0,360);
                         this.isOpen=true;
                    }
                    g.setColor(Color.BLACK);g.fillOval(this.posx+8,this.posy+4 , WIDTHOJO, HEIGHTOJO);
                
                
                break;
            
            
            case UP:
                if(isOpen){
                        g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 135,270);
                        isOpen=false;
                    }else{
                         g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 0,360);
                         this.isOpen=true;
                    }
                    g.setColor(Color.BLACK);g.fillOval(this.posx+4,this.posy+8, WIDTHOJO, HEIGHTOJO);
                
                break;
            case DOWN :
                  if(isOpen){
                        g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 315,270);
                        isOpen=false;
                    }else{
                         g.setColor(Color.ORANGE);g.fillArc(this.posx, this.posy,WIDTH, HEIGHT, 0,360);
                         this.isOpen=true;
                    }
                    g.setColor(Color.BLACK);g.fillOval(this.posx+4,this.posy+8, WIDTHOJO, HEIGHTOJO);
                
                break;
            
        }
        
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
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
