package main;

import entities.EntityE;
import entities.EntityP;

/*##############Purpose############
 * detects collision between entities 
 * #############Description##########
 * uses the outlines that each type of entity created
 * to see if there is intersection between those outlines
 * This class is used and called in each of the game objects(bullet,enemy,barrier)
 */
public class Mechanics {
	// checks if player entities collides with enemy entities
	// by checking the outlines of the rectangle around entities
	public static boolean Collision(EntityP ep, EntityE ee) {
		if (ep.getOutline().intersects(ee.getOutline()))
			return true;
		return false;
	}
	//checks if enemy entity collides with player entity
	public static boolean Collision(EntityE ee, EntityP ep) {
		if (ee.getOutline().intersects(ep.getOutline()))
			return true;
		return false;
	}

}
