/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author sergi
 */

/*
clase que captura los eventos del teclado
*/
public class Teclado3 extends  KeyAdapter{
    private boolean[] teclas= new boolean[256];
    public static boolean arriba,izquierda,derecha,disparar,pausar,seguir;
    
    public Teclado3(){
        arriba=false;
        izquierda=false;
        derecha=false;
        disparar=false;
        pausar=false;
        seguir=false;
        
    }
    
    /*
    verifica que las teclas si se esten precionadas ya que si en la posicion 
    que retorna el codigo del keyPressed referente a la tecla oprimida es true
    */
    public void update(){
        arriba=teclas[KeyEvent.VK_UP];
        izquierda=teclas[KeyEvent.VK_LEFT];
        derecha=teclas[KeyEvent.VK_RIGHT];
        disparar=teclas[KeyEvent.VK_SPACE];
        pausar=teclas[KeyEvent.VK_P];
        seguir=teclas[KeyEvent.VK_F];
    }
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]=true;
        System.out.println(e.getKeyCode());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }
   
    
}
