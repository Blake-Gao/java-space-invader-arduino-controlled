package input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/*###################Purpose####################
 * This class is used to detect all the mouse input in the program
 */
import main.Game;
import main.Game.state;

public class MouseInput implements MouseListener {

	/*##################Purpose####################
	 * The purpose of this is to detect mouse clicking 
	 * from the user
	 * ##################Description############## 
	 * This class implements Mouselistener along comes with 
	 * Mouse event The methods below are required when
	 * implementing the mouse event
	 */
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
		//getting the coordinates of where the mouse clicked
		int clickX = e.getX();
		int clickY = e.getY();
		
		//checking which screen the clicking is currently happening
		//then check the coordinates to see if it clicked on the right place
		//it then switches to the screen requested
		if (Game.screen == state.START) {
			if (clickX >= 330 && clickX <= 430) {
				if (clickY >= 150 && clickY <= 300) {
					Game.screen = Game.screen.GAME;
				}
				if (clickY >= 250 && clickY <= 300) {
					System.exit(0);
				}
				if (clickY >= 350 && clickY <= 380) {
					Game.screen = Game.screen.ABOUT;
				}
			}
		}
		//##########################################
		if (Game.screen == state.ABOUT) {
			if (clickX >= 300 && clickX <= 650) {
				if (clickY >= 500 && clickY <= 550) {
					Game.screen = Game.screen.START;
				}
			}
		}
		//#########################################
		if (Game.screen == state.GAME) {
			if (clickX >= 700 && clickX <= 800) {
				if (clickY >= 0 && clickY <= 50) {
					Game.screen = Game.screen.GAMEOVER;
				}
			}
		}

		//#############################################
		if (Game.screen == state.GAMEOVER) {
			if (clickX >= 280 && clickX <= 480) {
				if (clickY >= 250 && clickY <= 300) {
					System.exit(0);
				}
			}
			if (clickX >= 200 && clickX <= 550) {
				if (clickY >= 400 && clickY <= 450) {
					Game.screen = Game.screen.START;
				}
			}
		}
		
	}

	public void mouseReleased(MouseEvent arg0) {
	}

}
