package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Game;
import main.ControlClass;
import objects.Player;

public class KeyInput extends KeyAdapter{

	Player p;
	Game game;
	
	public KeyInput(Game game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
		
	}
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}
	
}
