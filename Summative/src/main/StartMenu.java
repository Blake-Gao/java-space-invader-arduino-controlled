package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.InputStream;

public class StartMenu {
	Game game;
	public StartMenu(Game game){
		this.game = game;
	}
	/*##############Purpose############
	 * output the initial starting screen
	 * #############Description##########
	 * creates graphical buttons for user to choose which screen to go to 
	 * uses basic draw string to putput information
	 */
	public Rectangle play = new Rectangle(330, 150, 150,50);
	public Rectangle quit = new Rectangle(330, 250, 150,50);
	public Rectangle about = new Rectangle(330, 350, 150,50);
	//##########################################
	public static Font getFont(String name) {
		//get custom font
	    Font font = null;
	    String fName = "/Fonts/" + name;
	    try {
	      InputStream is = InGameHUD.class.getResourceAsStream(fName);
	      font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN,30);
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    return font;
	  }
	//###########################################
	public void draw(Graphics g){
		//draws words and graphical buttons
		Graphics2D g2d = (Graphics2D) g;
		Font f0 = new Font("helvetica neue",Font.PLAIN, 30);
		Font f1 = new Font("comic sans ms",Font.PLAIN, 30);
		g.setFont(f1);
		g.setColor (Color.white);
		g.setFont(getFont("kenvector_future_thin.ttf"));
		g.drawString("Space Invaders Redux", 240, 90);	
		g.drawString("alpha2.5", 335, 130);
		g.drawString("PLAY", 370, 180);
		g.drawString("QUIT", 370, 280);
		g.drawString("ABOUT", 350, 380);
		g2d.draw(play);
		g2d.draw(quit);
		g2d.draw(about);
	}
	
	
}
