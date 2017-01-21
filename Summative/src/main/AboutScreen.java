package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/* ####################Purpose###################
 * The purpose of this is to out put the about screen when requested by user
 * ##################Description#################
 * This contains basic information and documentation about the game
 */

public class AboutScreen {
	Game game;
	StartMenu start;
	public AboutScreen(Game game){	//class constructor
		this.game = game;		//use for calling it in game class
	}
	//creating a button for user to click on,this is coordinates checked in mouseinput
	public Rectangle Back = new Rectangle(300, 500, 350,50);
	
	public void draw(Graphics g){
		//below uses basic draw string to out put the text on to the screen
		Graphics2D g2d = (Graphics2D) g;
		Font f0 = new Font("helvetica neue",Font.PLAIN, 15);
		Font f1 = new Font("helvetica neue",Font.PLAIN, 30);
		g.setColor (Color.white);
		g.setFont(start.getFont("kenvector_future_thin.ttf"));
		g.drawString("Space Invaders Redux    alpha2.5", 100, 70);
		g.drawString("By: Blake Gao, Johnny Hu", 100, 110);
		g.setFont(f0);
		//#############################################
		g.drawString("This is an attemp to re-create the original Space Invaders game.", 100, 140);
		g.drawString("The design is pretty similar with slight differences.", 100, 155);
		g.drawString("The gameplay is quite different from the original however", 100, 170);
		g.drawString("Instructions", 100, 200);
		g.drawString("D-Move Right    A-Move Left    SPACEBAR- Shoot", 100, 215);
		//#############################################
		g.drawString("Objective/Goal", 100, 250);
		g.drawString("Your objective as the player is to shoot down as much aliens as you can", 100, 275);
		g.drawString("You have a limited amount of lives, If an alien touches the bottom border, you lose a life", 100, 290);
		g.drawString("The aliens will spawn in waves, a new wave starts after you kill every alien in the current wave", 100, 305);
		g.drawString("With every new wave more aliens spawn", 100, 320);
		g.drawString("There is no real win condition to the game,your goal is to last as long as you can", 100, 335);
		g.drawString("There's a timer on the top to check your time", 100, 350);
		g.drawString("Compete with yourself or friends to see who can last the longest", 100, 375);
		//#############################################
		g.setFont(start.getFont("kenvector_future_thin.ttf"));
		g.drawString("Have Fun", 100, 450);
		//############################################
		g.drawString("Back To Main Menu", 320, 530);
		g2d.draw(Back);
		
		
	}
	
}
