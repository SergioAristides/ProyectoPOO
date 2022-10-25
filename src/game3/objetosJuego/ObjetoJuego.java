/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.objetosJuego;

import game3.utilidades.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author sergi
 */

//representa a todos los objetos en el juego
public abstract class ObjetoJuego {
    protected BufferedImage textura;
    protected Vector2D posicion;

    public ObjetoJuego( Vector2D posicion,BufferedImage textura) {
        this.posicion = posicion;
        this.textura = textura;
    }
    public abstract void update();
    public abstract void draw(Graphics g);

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }
    
    
    
}
