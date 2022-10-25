/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.estados;

import java.awt.Button;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Menu extends Estado{
    
    private ArrayList<Boton> buttons;
	
	public Menu() {
		buttons = new ArrayList<Button>();
		
		buttons.add(new Boton(
				Assets .greyBtn,
				Assets.blueBtn,
				Constants.WIDTH / 2 - Assets.greyBtn.getWidth()/2,
				Constants.HEIGHT / 2 - Assets.greyBtn.getHeight(),
				Constants.PLAY,
				new Action() {
					@Override
					public void doAction() {
						State.changeState(new GameState());
					}
				}
				));
		
		buttons.add(new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				Constants.WIDTH / 2 - Assets.greyBtn.getWidth()/2,
				Constants.HEIGHT / 2 + Assets.greyBtn.getHeight()/2 ,
				Constants.EXIT,
				new Action() {
					@Override
					public void doAction() {
						System.exit(0);
					}
				}
				));
		
	}
	
	
	@Override
	public void update() {
		for(Button b: buttons) {
			b.update();
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Button b: buttons) {
			b.draw(g);
		}
	}
    
}
