/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

/**
 *
 * @author sergi
 */
public class Cronometro {
    private long delta,lasTime;
    private long time;
    private boolean isRunning;

    public Cronometro() {
        delta=0;
        lasTime=0;
        isRunning=false;
                
    }
    //Inicializa el cronometro ySE LE ENVIE EL TIME= como el tiempo de disparo
    public void run(long time){
        isRunning=true;
        this.time=time;
                
        
    }
    //
    public void update(){
        if(isRunning)
            delta+=System.currentTimeMillis()-lasTime;
        if(delta >=time){
            isRunning=false;
            delta=0;
        }
        //TIEMPO QUE VA PASANDO
        lasTime=System.currentTimeMillis();
    }
    
    public boolean isRunning(){
        return isRunning;
    }
   
    
    
}
