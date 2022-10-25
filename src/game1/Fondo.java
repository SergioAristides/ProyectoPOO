/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game1;

import Frames.Game1;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author sergi
 */
public class Fondo {

    Game1 game;
    int anchoFondo;
    int altoFondo;
    //coordenadas iniciales para mover el fondo
    int x1;
    int y1;
    //coordenadas auxiliares que mueven otro fondo
    int x2;
    int y2;

    public Fondo() {
        this.anchoFondo = 1300;
        this.altoFondo = 400;
        this.x1 = 1300;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;

    }

    public void paint(Graphics2D g2) {
        ImageIcon imagenF = new ImageIcon(getClass().getResource("/imagenes/fondo1.jpg"));
        g2.drawImage(imagenF.getImage(), x1, y1, anchoFondo, altoFondo, null);
        g2.drawImage(imagenF.getImage(), x2, y2, anchoFondo, altoFondo, null);

    }

    public Game1 getGame() {
        return game;
    }

    public void setGame(Game1 game) {
        this.game = game;
    }

    
   

    public int getAnchoFondo() {
        return anchoFondo;
    }

    public void setAnchoFondo(int anchoFondo) {
        this.anchoFondo = anchoFondo;
    }

    public int getAltoFondo() {
        return altoFondo;
    }

    public void setAltoFondo(int altoFondo) {
        this.altoFondo = altoFondo;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

}



