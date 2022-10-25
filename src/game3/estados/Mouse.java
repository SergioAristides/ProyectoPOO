/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author sergi
 */
public class Mouse extends MouseAdapter {

    public static int X, Y;
	public static boolean presionado;
	
        
        
	@Override
	public void mousePressed(MouseEvent e) {
            //mouse izquierdo
		if(e.getButton() == MouseEvent.BUTTON1) {
			presionado= true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			presionado= false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}
    
}
