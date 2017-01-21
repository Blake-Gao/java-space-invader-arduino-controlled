package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import entities.EntityE;
import entities.EntityP;
import main.ControlClass;
import main.Game;
import main.Mechanics;
import main.Position;


public class Barrier extends Position implements EntityE{
	/*##############Purpose############
	 * draw and update the barriers
	 * #############Description##########
	 * uses an imported image of a barrier
	 * part of enemy class
	 * if collision occurs with player class
	 * changes the image of the barrier until it is removed
	 */
	private String barrierimage = "/images/barrier1.png";
	
	private int barrierdamage = 1;
	double spacing = 11;
	double blockwidth = 10;
	ControlClass cc;
	Game game;
	
	//using image icon to import the image of the barriers
	public Image getEnemiesImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(barrierimage));
		return i.getImage();
	}
	///#############################
	
	public Barrier(double x, double y,ControlClass cc,Game game){
		//uses the position class,control class, and game
		super (x ,y);
		this.game = game;
		this.cc = cc;
	}

	//################################################
	public void update() {
		for(int i =0;i<game.ep.size();i++){
			EntityP entityB = game.ep.get(i);  // temporary bullet entity
			if (Mechanics.Collision(this, entityB)){
				barrierdamage += 1;
				if (barrierdamage <= 4){
					cc.removeE(entityB); //remove bullet when it hits barrier
					//changes barrier image after it's hit
					barrierimage = "/images/barrier"+ (barrierdamage) + ".png";
					}
				}
				else if (barrierdamage >= 5) {
					//if the damage is maxed out, remove the bullet and barrier entity
					cc.removeE(this);
					cc.removeE(entityB);
				}
		}
	}
	//#############################################
	public void draw(Graphics2D g2d) {
		//draws the image of barrier
		g2d.drawImage(getEnemiesImage(), (int) x, (int) y, null);
	}

	//###################################
	//outline to check detection
	public Rectangle getOutline() {
		return new Rectangle ((int)x, (int)y, 170, 85);
	}
	public double getx() {
		return x;
	}
	public double gety() {
		return y;
	}
}
