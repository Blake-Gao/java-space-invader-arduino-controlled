package main;

import java.awt.Rectangle;

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
