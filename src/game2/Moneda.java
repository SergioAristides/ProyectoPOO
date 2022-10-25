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
public class Moneda extends Component2 {

    public Moneda(int posx,int posy) {
        super.posx=posx;
        super.posy=posy;
    }

    public Moneda() {
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
    
    
    
    
   
    @Override
    public void paintElements(Graphics g) {
        g.setColor(Color.YELLOW);g.fillOval(this.posx, this.posy, 12, 12);
        g.setColor(Color.YELLOW);
        g.setColor(Color.ORANGE);
        g.fillOval(posx+3, posy+3, 6, 6);
    }
    
}
