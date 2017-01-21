package main;

import input.KeyInput;
import input.MouseInput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.Enemies;
import objects.Player;
import entities.EntityE;
import entities.EntityP;

public class Game extends JPanel implements ActionListener {
	/*##################Purpose##################
	 * This is the main game class,it runs and calls all the methods for this game
	 * #################Description###############
	 * It calls all the classes and uses them
	 * Also use a similar draw and update type, 
	 * but instead called as paint and action performed
	 */
	private static final long serialVersionUID = 1L;
	//objects and variables
	Timer gameTimer;
	Player p;
	Enemies e1;
	ControlClass cc;
	InGameHUD hud;
	StartMenu start;
	AboutScreen about;
	GameOver gameEnd;
	public int enemycount = 5;
	public int enemykills = 0;
	public int points = 0;
	public int lives = 25;
	boolean shooting = false; // check if its shooting prevents auto
	public ArrayList<EntityP> ep;
	public ArrayList<EntityE> ee;

	// ################
	//creates enumerations for the different screen the game will be on
	public static enum state {
		START, GAME, GAMEOVER, ABOUT
	};
	//initialized to be on start with game runs
	public static state screen = state.START;
	// ######################
	private String background = "/images/background.png";

	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	// ###########################
	public Game() {	
		//every thing in this constructor is the initial settings for the game
		//adding the key and mouse listener, calls the corresponding classes
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput());
		setFocusable(true);
		//refreshing rate of the screen
		gameTimer = new Timer(10, this);
		gameTimer.start();

		//initial player position
		p = new Player(400, 600);
		//calls the classes being used
		cc = new ControlClass(this);
		hud = new InGameHUD(this);
		start = new StartMenu(this);
		about = new AboutScreen(this);
		gameEnd = new GameOver(this);
		
		ep = cc.getEP();
		ee = cc.getEE();
		cc.spawnenemy(enemycount);
	}

	// #############################
	public void paint(Graphics g) {
		//this is the main draw or paint method of the game
		//controls what gets painted onto the screen
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		setBackground(Color.black);
		// g2d.drawImage(getBackgroundImage(), 0, 0, this);
		if (screen == state.START) {
			//when in start screen
			start.draw(g);
		}
		else if (screen == state.ABOUT) {
			//when in the about screen
			about.draw(g);
		}
		else if (screen == state.GAMEOVER) {
			//when in the game over screen
				gameEnd.draw(g);
		}	
		else if (screen == state.GAME) {
			//when in game play screen
			p.draw(g2d);
			cc.draw(g2d);
			hud.draw(g);
		}
		if (screen == state.GAMEOVER ){
			//resets the life and points of the player
			//when changing to game over screen
			lives = 25;
			points = 0;
		}
		
	}

	// #########################
	//getters and setters for enemy count and kills
	//the count and killed are used for respawning and point recording
	//also contains getter setters for lives remaining, used in enemy class
	public int getEnemycount() {
		return enemycount;
	}

	public void setEnemycount(int enemycount) {
		this.enemycount = enemycount;
	}

	public int getEnemykills() {
		return enemykills;
	}

	public void setEnemykills(int enemykills) {
		this.enemykills = enemykills;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	// ####################################

	public void actionPerformed(ActionEvent e) {
		//this is the main update method of the game
		//updates classes' update methods by calling them, using the set timer rate
		repaint(); 	//re runs the paint super method
		if (screen == state.GAME) {
			if (p != null)//update player
				p.update();
			if (cc != null)//update control class
				cc.update();
			if (hud != null)//update hud
				hud.update();
			//update the kills and lives 
			if (enemykills >= enemycount) {
				enemycount += 1;
				enemykills = 0;
				cc.spawnenemy(enemycount);
			}
			if ((lives <= 0) || (screen == state.GAMEOVER)){
				screen = state.GAMEOVER;
				points = 0;
				lives = 25;
				hud.setSeconds(0);
				hud.setMilliseconds(0);
			}
			
		}
	}

	// #############################
	//this below is where it checks the key Input the player presses
	//if corresponding key pressed, it performs an action
	//like setting x velocity of player
	//or adding a bullet each time space is pressed
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (screen == state.GAME) {
			if (key == KeyEvent.VK_A) {
				p.setxvel(-5);
			} else if (key == KeyEvent.VK_D) {
				p.setxvel(5);
			} else if (key == KeyEvent.VK_W) {
				p.setyvel(0);
			} else if (key == KeyEvent.VK_S) {
				p.setyvel(0);
			} else if (key == KeyEvent.VK_SPACE && !shooting) {
				shooting = true; // this stops auto bullet firing
				cc.addE(new Bullets(p.getx() + 30, p.gety(), this));
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		//sets everything to false or 0 when key is released
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			p.setxvel(0);
		} else if (key == KeyEvent.VK_D) {
			p.setxvel(0);
		} else if (key == KeyEvent.VK_W) {
			p.setyvel(0);
		} else if (key == KeyEvent.VK_S) {
			p.setyvel(0);
		} else if (key == KeyEvent.VK_SPACE) {
			shooting = false;
		}
	}
	// ############################

}
