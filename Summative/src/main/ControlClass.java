package main;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import objects.Barrier;
import objects.Enemies;
import entities.EntityE;
import entities.EntityP;
/*###############Purpose##################
 * This class controls all the entity spawning and how they 
 * created and updated
 * #############Description##############
 * This class makes use of arraylist to store objects
 * So for example when an bullet is shot,alien spawn
 * Similar to array instead stores objects
 * adds initial barriers
 * control wave spawning,updating the each entity type
 * methods to add and remove each entity
 */
public class ControlClass {
	//declares and assign each type of entity to it
	private ArrayList<EntityP> ep = new ArrayList<EntityP>();
	private ArrayList<EntityE> ee = new ArrayList<EntityE>();
	
	Random r = new Random();
	
	Game game;
	EntityP ePlayer;
	EntityE eEnemies;
	
	public ControlClass (Game game){
		//being called from the game class
		this.game = game;
		//adds the initial four barriers to the game
		addE (new Barrier (50,380,this, game));
		addE (new Barrier (250,380,this, game));
		addE (new Barrier (450,380,this, game));
		addE (new Barrier (650,380,this, game));
		
	}
	//######################################################
	public void spawnenemy (int enemycount){
		//begins new wave of enemies when called
		for (int i = 0;i<enemycount;i++){
			addE (new Enemies(r.nextInt(794),-10,this,game));
		}
	}
	//######################################################
	public void update(){		//get size of array list update each bullet object using for loop
		for(int i = 0;i<ep.size();i++){	//update of player entities using for loop
			ePlayer = ep.get(i);
			if (ePlayer.gety() < 10)//remove bullet when hits border
				removeE(ePlayer);
			ePlayer.update();
		}
		for(int i = 0;i<ee.size();i++){	//updates enemy entities(aliens)
			eEnemies = ee.get(i);
			eEnemies.update();
		}
	}
	//########################################################
	public void draw(Graphics2D g2d){	//draw or render bullets
		for(int i = 0;i<ep.size();i++){
			ePlayer = ep.get(i);
			ePlayer.draw(g2d);
		}
		for(int i = 0;i<ee.size();i++){//draw enemies 
			eEnemies = ee.get(i);	
			eEnemies.draw(g2d);
		}
	}
	//############################################################
	//these methods below are called to add or remove and object from the arraylist
	//to add to remove from the screen
	public void addE (EntityP e){
		ep.add(e);
	}
	public void removeE (EntityP e){
		ep.remove(e);
	}
	public void addE (EntityE e){
		ee.add(e);
	}
	public void removeE (EntityE e){
		ee.remove(e);
	}
	
	//####################Check list of entities###################
	
	public ArrayList<EntityP> getEP(){
		return ep;
	}
	public ArrayList<EntityE> getEE(){
		return ee;
	}

}
