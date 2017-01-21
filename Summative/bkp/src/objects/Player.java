package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import main.Position;
import entities.EntityP;

public class Player extends Position implements EntityP{


	
	private String playerimage = "/images/player.png";
	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	
	
	private double xvel = 0;
	private double yvel = 0;
	
	public Player(double x, double y) {
		
		super (x,y);
		
	}

	public void update() {
		x+=xvel;
		y+=yvel;	
		//border collision checking
		if (x < 0)
			x = 1;
		if (y < 0)
			y = 1;
		if (x > 535)
			x = 535;
		if (y > 375)
			y = 375;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), (int)x, (int)y, null);
	}
	
	public double getx(){
		return x;
	}
	public double gety() {
		return y;
	}
	
	public void setx(double x){
		this.x = x;
	}
	public void sety(double y){
		this.y = y;
	}
	
	public void setxvel(double xvel){
		this.xvel = xvel;
	}
	public void setyvel(double yvel){
		this.yvel = yvel;
	}

	@Override
	public Rectangle getOutline() {
		return new Rectangle ((int)x, (int)y,99,75);
	}

}
