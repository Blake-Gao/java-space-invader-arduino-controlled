package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import entities.EntityP;

public class Bullets extends Position implements EntityP{

	private String bulletimage = "/images/bullet.png";
	private Game game;
	private ControlClass cc;
	
	public Bullets(double x, double y, Game game) {
		super (x,y);
		this.game = game;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getBulletImage(), (int) x,(int)y,null);
	}
	
	public Image getBulletImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(bulletimage));
		return i.getImage();
	}

	public void update() {
		y -= 5;
		//checks if this player entity, the bullets collides
		/*if (Mechanics.Collision(this, game.ee)){
			cc.removeEP (this);
			
		}
		*/
	}
	
	public double gety(){
		return y;
	}

	public double getx() {
		return x;
	}

	

	public Rectangle getOutline() {
		return new Rectangle ((int)x, (int)y,9,54);
	}

}
