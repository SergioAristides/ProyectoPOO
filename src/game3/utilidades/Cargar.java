 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author sergi
 */
/*
carga todas las imagenes
*/
public class Cargar {
    public static BufferedImage cargarImagen(String ruta){
        try {
            return ImageIO.read(Cargar.class.getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
   public static Clip CargarAudio(String ruta) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Cargar.class.getResource(ruta)));
			return clip;
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    
}
