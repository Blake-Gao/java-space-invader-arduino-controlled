package entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface EntityP {
	public void update();
	public void draw(Graphics2D g2d);
	public Rectangle getOutline();
	
	public double getx();
	public double gety();
	
}
