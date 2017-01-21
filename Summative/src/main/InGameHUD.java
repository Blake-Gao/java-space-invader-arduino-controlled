package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.InputStream;
import java.text.SimpleDateFormat;
/*##############Purpose############
 * outputs the in game heads up display
 * #############Description##########
 * outputs the amount of lives left, score, and timer
 */

public class InGameHUD {

	Game game;
	private int score = 0;

    private int seconds;
    private int milliseconds;
    private int minutes;
	
    public Rectangle end = new Rectangle(700, 0, 100,50);
	//###################################################
	public InGameHUD(Game game){
		this.game = game;
	}
	public static Font getFont(String name) {
		//to get custom font
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
		
	//##########################################
	public void draw(Graphics g){
		//draws the outputs live,time,score
		Graphics2D g2d = (Graphics2D) g;
		Font f0 = new Font("helvetica neue",Font.PLAIN, 30);
		g.setFont(getFont("kenvector_future_thin.ttf"));
		//g.setFont(f0);
		g.setColor (Color.white);
		g.drawString("Score:" + score,100,30);
		g.drawString("Live:" + game.getLives(),350,30);
		g.drawString((minutes + ":" + seconds + ":" + milliseconds),550,30);
		
		g.drawString("END", 720, 30);
		g2d.draw(end);
		}
	//##################################
	public void update(){
		//updates the lives,time score
		score = game.getPoints()* 10;
	    SimpleDateFormat date = new SimpleDateFormat("mm.ss");
        if (seconds == 65) {
            seconds = 00;
            minutes++;
        }
        seconds++;
	}
	//###############################
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public int getMilliseconds() {
		return milliseconds;
	}
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
}
