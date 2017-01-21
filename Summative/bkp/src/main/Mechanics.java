package main;

import java.util.ArrayList;

import entities.EntityE;
import entities.EntityP;

public class Mechanics {

	//checks if player entities collides with enemy entities
	//by checking the outlines of the rectangle around entities
	
	
	public static boolean Collision (EntityP ep, ArrayList<EntityE> ee){
		for (int i =0; i< ee.size(); i++){
			if (ep.getOutline().intersects(ee.get(i).getOutline()))
				return true;
		}
		return false;
	}	
	public static boolean Collision (EntityE ee, ArrayList<EntityP> ep){
		for (int i =0; i< ep.size(); i++){
			if (ee.getOutline().intersects(ep.get(i).getOutline()))
				return true;
		}
		return false;
	}

}
