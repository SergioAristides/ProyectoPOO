 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import java.awt.Graphics;

/**
 *
 * @author sergi
 */
public abstract class Estado {
    //CON ESTE NOS ASEGURAMOS NO PERTENECERA A LOS OBJETOS
   private static Estado estado = null;

    public static Estado getEstado() {
        return estado;
    }

    public static void setEstado(Estado estado) {
        Estado.estado = estado;
    }
	
	
	
	
	public abstract void update();
	public abstract void draw(Graphics g);
}
