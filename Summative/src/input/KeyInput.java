package input;
/*###################Purpose####################
 * This class is used to detect all the key input in the program
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Game;
import main.ControlClass;
import objects.Player;

public class KeyInput extends KeyAdapter{

	/*##################Description##############
	 * This class extends the keyAdapter class
	 * the program detects key inputs then calls the key listener in the 
	 * game class to execute what the key inputs do
	 */
	
	Game game; 	//This creates a game object that uses the methods from game 
	
	public KeyInput(Game game){	
		/*This is the constructor loaded with the game class
		 * This is created so that the it can be called from the game class
		 * using keylistener
		 */
		
		// this means that the game object in this class is same as the main game class
		this.game = game; 
	}
	
	public void keyPressed(KeyEvent e){
		//this method detects all the key presses
		game.keyPressed(e);
		
	}
	public void keyReleased(KeyEvent e){
		//this method detect when a key is released
		game.keyReleased(e);
	}
	
}
