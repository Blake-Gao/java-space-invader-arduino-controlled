package main;
import input.KeyInput;

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

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Timer gameTimer;
	Player p;
	Enemies e1;
	ControlClass cc;
	Bullets bu;
	boolean shooting = false; // check if its shooting prevents auto
	public ArrayList<EntityP> ep;
	public ArrayList<EntityE> ee;
	
	private String background = "/images/background.png";
	public Image getBackgroundImage(){
		ImageIcon i =new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	//###########################
	public Game() {
		addKeyListener( new KeyInput(this));
		setFocusable(true);
		gameTimer = new Timer(10,this);
		gameTimer.start();
		
		//e1 = new Enemies(0,0);
		p = new Player(300, 300);
		cc = new ControlClass(this);
		
		
		ep = cc.getEP();
		ee = cc.getEE();
	}
	
	//#############################
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Color bkcolor = new Color(100,200,100);
		setBackground(Color.black);
		//g2d.drawImage(getBackgroundImage(), 0, 0, this);
		p.draw(g2d);
		cc.draw(g2d);
	}
	//#########################
	public int enemycount = 1;
	public int enemykills = 0;
	
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
	//####################################
	
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (p != null)
			p.update();
		if (e1 != null)
			e1.update();
		if (cc != null)
			cc.update();
		if  (bu != null)
			bu.update();
		
		if (enemykills >= enemycount){
			enemykills = 0;
			cc.spawnenemy(enemycount);
		}
		
	}
	//#############################
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A){
			p.setxvel(-5);
		}
		else if (key == KeyEvent.VK_D){
			p.setxvel(5);
		}
		else if (key == KeyEvent.VK_W){
			p.setyvel(-5);
		}
		else if (key == KeyEvent.VK_S){
			p.setyvel(5);
		}
		else if (key == KeyEvent.VK_SPACE && !shooting){
			shooting = true;
			cc.addEP(new Bullets(p.getx() + 30, p.gety(),this));
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A){
			p.setxvel(0);
		}
		else if (key == KeyEvent.VK_D){
			p.setxvel(0);
		}
		else if (key == KeyEvent.VK_W){
			p.setyvel(0);
		}
		else if (key == KeyEvent.VK_S){
			p.setyvel(0);
		}
		else if (key == KeyEvent.VK_SPACE){
			shooting = false;
		}
	}
	//############################
	

}
