package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import entities.EntityE;
import main.Bullets;
import main.ControlClass;
import main.Game;
import main.Mechanics;
import main.Position;

public class Enemies extends Position implements EntityE{

	private String enemyimage = "/images/enemy.png";
	private ControlClass cc;
	private Game game;


	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(enemyimage));
		return i.getImage();
	}

	public Enemies(double x, double y, ControlClass cc,Game game) {
		super(x,y);
		this.game=game;
		this.cc = cc;
	}
	int vel = 3;

	public void update() {
		if (x > 535)
			vel = -3;
		if (x < 0)
			vel = 3;
		/*
			if (x > 535) {
				y+=75;
				vel = -3;
			}
			else if (x < 0) {
				y += 75;
				vel = 3;
			}
			if (y+75>480){
				x=1;
				y=0;
			}
			*/
		x += vel;
		if (Mechanics.Collision(this, game.ep)){
			cc.removeEE (this);
			
			game.setEnemykills(game.getEnemykills() + 1);
			System.out.println(game.getEnemykills());
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), (int) x, (int) y, null);
	}
	
	public double getx() {
		return x;
	}
	public double gety() {
		return y;
	}
	
	public Rectangle getOutline() {
		return new Rectangle ((int)x, (int)y,104,84);
	}

}
