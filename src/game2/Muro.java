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
public class Muro extends Component2{

    public Muro(int posx,int posy) {
        super.posx=posx;
        super.posy=posy;
    }

    
    
    @Override
    public void paintElements(Graphics g) {
        g.setColor(new Color(185,122,87));
        g.fillRoundRect(posx, posy,25, 25,6,6);
        g.setColor(Color.BLACK);
        g.drawRoundRect(posx, posy,25, 25,6,6);
        
    }
    
}
