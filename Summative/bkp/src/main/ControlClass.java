package main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import entities.EntityE;
import entities.EntityP;
import objects.Enemies;

public class ControlClass {

	private ArrayList<EntityP> ep = new ArrayList<EntityP>();
	private ArrayList<EntityE> ee = new ArrayList<EntityE>();
	
	Random r = new Random();
	
	Game game;
	EntityP ePlayer;
	EntityE eEnemies;
	
	public ControlClass (Game game){
		this.game = game;
		addEE (new Enemies(r.nextInt(535),0,this,game));
	}
	
	public void spawnenemy (int enemycount){		// re-spawn method for enemies
		addEE (new Enemies(r.nextInt(535),0,this,game));
	}
	
	public void update(){		//get size of array list update each bullet object using for loop
		for(int i = 0;i<ep.size();i++){
			ePlayer = ep.get(i);
			if (ePlayer.gety() < 10)//remove bullet when hits border
				removeEP(ePlayer);
			ePlayer.update();
		}
		for(int i = 0;i<ee.size();i++){
			eEnemies = ee.get(i);
			eEnemies.update();
		}
	}
	public void draw(Graphics2D g2d){	//draw or render bullets
		for(int i = 0;i<ep.size();i++){
			ePlayer = ep.get(i);
			ePlayer.draw(g2d);
		}
		for(int i = 0;i<ee.size();i++){
			eEnemies = ee.get(i);	
			eEnemies.draw(g2d);
		}
	}
	
	public void addEP (EntityP e){
		ep.add(e);
	}
	public void removeEP (EntityP e){
		ep.remove(e);
	}
	public void addEE (EntityE p){
		ee.add(p);
	}
	public void removeEE (EntityE p){
		ee.remove(p);
	}
	
	//////////////////////Check list of entities
	public ArrayList<EntityP> getEP(){
		return ep;
	}
	public ArrayList<EntityE> getEE(){
		return ee;
	}

}
