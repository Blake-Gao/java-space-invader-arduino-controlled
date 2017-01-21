package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import main.Position;
import entities.EntityP;

public class Player extends Position implements EntityP{
	/*##############Purpose############
	 * sets the initial settings for player
	 * #############Description##########
	 * imports image of player in
	 * checks border collision
	 */
	
	//using image icon to import the image of the player
	private String playerimage = "/images/player.png";
	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	//setting initial velocity to 0
	private double xvel = 0;
	private double yvel = 0;
	//##################################
	public Player(double x, double y) {
		super (x,y);
	}
	//##################################
	public void update() {
		//updates the x and y coordinate according to the key press
		//with the velocity
		x+=xvel;
		y+=yvel;

		//Collision checking with borders
		//so player dont go off the screen
		if (x < 0)
			x = 1;
		if (y < 0)
			y = 1;
		if (x > 770)
			x = 770;
		if (y > 530)
			y = 530;
	}
	//################################
	public void draw(Graphics2D g2d) {
		//draws the player
		g2d.drawImage(getPlayerImage(), (int)x, (int)y, null);
	}
	//#################################
	//getter and setter for x and y 
	public double getx(){
		return x;
	}
	public double gety() {
		return y;
	}
	
	public void setx(double x){
		this.x = x;
	}
	//used in game class to set velocity when corresponding key is pressed
	public void setxvel(double xvel){
		this.xvel = xvel;
	}
	public void setyvel(double yvel){
		this.yvel = yvel;
	}

	//#################################
	public Rectangle getOutline() {
		//outline of the player to detect collision
		return new Rectangle ((int)x, (int)y,78,47);
	}

}
