package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import java.util.Random;

import javax.swing.ImageIcon;

import entities.EntityE;
import entities.EntityP;
import main.ControlClass;
import main.Game;
import main.Mechanics;
import main.Position;

public class Enemies extends Position implements EntityE {
	/*##############Purpose############
	 * sets the initial settings for enemy(aliens)
	 * #############Description##########
	 * imports image of enemy in
	 * sets which direction it moves in
	 * detecting collision with bullet
	 */
	private String enemyimage = "/images/enemy2.gif";
	private ControlClass cc;
	private Game game;

	Random r = new Random();

	//using image icon to import the image of the aliens
	public Image getEnemiesImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(enemyimage));
		return i.getImage();
	}
	//##############################################
	public Enemies(double x, double y, ControlClass cc, Game game) {
		//uses the position class,control class, and game
		super(x, y);
		this.game = game;
		this.cc = cc;
	}
	//##################################################
	int vel = (r.nextInt(2)+1);		//random velocity 
	public void update() {
		//lives mechanic, where if enemy hit the bottom life removed
		//it will respawn that up at the top
		//below checks if that occurs
		System.out.println(game.getLives());
		y += vel;
		if (y > 557){
			game.setLives(game.getLives() -1);
			x = r.nextInt(794);
			y=-10;
			vel = (r.nextInt(2)+1);	
		}
		//checks if collision with bullet
		for (int i = 0; i < game.ep.size(); i++) {
			EntityP entityB = game.ep.get(i); // temporary bullet entity
			if (Mechanics.Collision(this, entityB)) {
					cc.removeE(entityB);	//remove bullet
					cc.removeE(this);	//remove the alien
					//changes the kill and points 
					game.setEnemykills(game.getEnemykills()+ 1);
					game.setPoints(game.getPoints() + 1);
			}
		}
	}
	//###########################################
	public void draw(Graphics2D g2d) {
		//draw the enemy
		g2d.drawImage(getEnemiesImage(), (int) x, (int) y, null);
		
	}

	//###########################################
	public double getx() {
		return x;
	}
	public double gety() {
		return y;
	}
	public Rectangle getOutline() {
		//outline of each enemy
		return new Rectangle((int) x, (int) y, 56, 43);
	}
}
