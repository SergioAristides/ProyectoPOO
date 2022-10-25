/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author sergi
 */
public class Sonido {
    
    
    private Clip clip;
	private FloatControl volume;
	
	public Sonido(Clip clip) {
		this.clip = clip;
                //maneja el columen
		volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	
        //INICA EL SONIDO
	public void play() {
                //ME aseguro que siempre inicie desde el comienzo(audio)
		clip.setFramePosition(0);
		clip.start();
	}
	
        //musica de fono
	public void FondoMusica () {
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void detener() {
		clip.stop();
	}
	
	//
	public void manejaVolumen(float value) {
		volume.setValue(value);
	}
}
