package main;

import java.awt.Rectangle;

/*##############Purpose############
 * used for positioning of all objects
 * #############Description##########
 * this is useful so that there doesn't need to be
 * a new x and y value declared for each game object
 * all game objects (player,enemy,bullet,barrier)
 * just uses this for convenience
 */
public class Position {
	
	public double x;
	public double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//forms detection outline
	public Rectangle getOutline(int width,int height){
		return new Rectangle ((int)x, (int)y,width,height);
	}
}
