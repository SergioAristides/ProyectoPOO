/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import game3.utilidades.Vector2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author sergi
 */
public class Boton {
    
    private BufferedImage mouseNotCLICKED;//mouse outin
	private BufferedImage mouseClicked;//mouse inimg
	private boolean mouseDentro;//mouse in
	private Rectangle cajaBoton;
	private Action action;
	private String texto;
        private Font fuente;

    public Boton(BufferedImage mouseNotCLICKED,
            BufferedImage mouseClicked, 
            int x,
            int y,
           String texto,Action action) {
        this.mouseNotCLICKED = mouseNotCLICKED;
        this.mouseClicked = mouseClicked;
        this.texto = texto;
        cajaBoton= new Rectangle(x,y,mouseClicked.getWidth(),mouseClicked.getHeight());
        this.action=action;
        fuente= new Font("Bauhaus 93",Font.PLAIN,40) ;
        
    }
	
        
        
	
	public void update() {
		
		if(cajaBoton.contains(Mouse.X, Mouse.Y)) {
			mouseDentro = true;
		}else {
			mouseDentro = false;
		}
		
		if(mouseDentro && Mouse.presionado) {
			action.doAction();
		}
	}
	
	public void draw(Graphics g) {
            //g.setFont(fuente);
		if(mouseDentro) {
			g.drawImage(mouseClicked, cajaBoton.x,cajaBoton.y, null);
		}else {
			g.drawImage(mouseNotCLICKED, cajaBoton.x, cajaBoton.y, null);
		}
		
                
		texto.drawText(
				g,
				texto,
				new Vector2D(
					cajaBoton.getX() + cajaBoton.getWidth() / 2,
						cajaBoton.getY() + cajaBoton.getHeight()),
				true,
				Color.BLACK,
				);
		
		
	}
    
}
