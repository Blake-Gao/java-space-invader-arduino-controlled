package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
/*#############Purpose############
 * Screen for when the game is over
 * #############Description############
 * creates graphical buttons
 * uses basic draw string to output information
 */
public class GameOver {
	Game game;
	StartMenu start;
	private String gameoverBG = "/images/";
	
	public GameOver(Game game){
		this.game = game;
	}
	//####################################
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(gameoverBG));
		return i.getImage();
	}
	//######################################
	//creates graphical buttons
	public Rectangle quit = new Rectangle(280, 250, 200,50);
	public Rectangle Back = new Rectangle(200, 400, 350,50);
	
	//########################################
	public void draw(Graphics g){
		//uses basic draw string to output information
		Graphics2D g2d = (Graphics2D) g;
		Font f0 = new Font("helvetica neue",Font.PLAIN, 15);
		Font f1 = new Font("helvetica neue",Font.PLAIN, 30);
		g.setColor (Color.white);
		// g2d.drawImage(getBackgroundImage(), 0, 0, this);
		g.setFont(start.getFont("kenvector_future_thin.ttf"));
		g.drawString("GAME OVER", 300, 200);
		
		g.drawString("Quit Game", 310, 280);
		g2d.draw(quit);
		g.drawString("Back To Main Menu", 230, 430);
		g2d.draw(Back);
		
	}
}
