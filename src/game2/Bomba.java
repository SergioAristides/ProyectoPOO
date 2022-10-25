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
public class Bomba extends Component2
{
    public Bomba(int posx,int posy)
    {
        super.posx = posx;
        super.posy = posy;
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
    public void paintElements(Graphics g)
    {
        
//      Un circulo negro
        g.setColor(Color.BLACK);
        g.fillOval(posx, posy, 12, 12); 
    }
    
}