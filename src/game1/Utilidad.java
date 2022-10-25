/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game1;

/**
 *
 * @author sergi
 */
public class Utilidad {
    
    private boolean pierdeVida;
    private int vidas;
    private int puntos;
    private int nivel;

    public Utilidad(boolean pierdeVida, int vidas, int puntos, int nivel) {
        this.pierdeVida = pierdeVida;
        this.vidas = vidas;
        this.puntos = puntos;
        this.nivel = nivel;
    }

    public boolean isPierdeVida() {
        return pierdeVida;
    }

    public void setPierdeVida(boolean pierdeVida) {
        this.pierdeVida = pierdeVida;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
