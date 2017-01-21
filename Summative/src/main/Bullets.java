package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import entities.EntityP;

public class Bullets extends Position implements EntityP{

	/*#####################Purpose#################
	 * The purpose of this is to create the bullet and initialize its properties
	 * ###################Description##############
	 * The bullet class uses the position class and is a part of the player entities
	 * The design of the bullet being shot is just a square
	 * has getters and setters for the x and y positions
	 * it moves in the negative y direction
	 * gets the outline for detection use
	 */
	Game game;
	
	public Bullets(double x, double y, Game game) {
		super (x,y);		//uses position class
		this.game = game;	//use for calling it in game class 
	}

	public void draw(Graphics2D g2d) {
		//draws the bullet
		g2d.setColor(Color.WHITE);				
		g2d.fillRoundRect((int)x ,(int)y , 10, 14, 5, 8);
	}
	

	public void update() {
		// make the bullet constantly go in the negative y direction
		y -= 4;
		
	}
	
	//getters and setters for the bullet which is required as part of player entity
	public double gety(){
		return y;
	}

	public double getx() {
		return x;
	}

	//gets the outline of the bullet for the detection when it collides with aliens
	public Rectangle getOutline() {
		return new Rectangle ((int)x, (int)y,9,54);
	}

}
