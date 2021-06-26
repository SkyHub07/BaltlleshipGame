package com.BattleshipGame.src.main;

import java.util.LinkedList;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;
import com.BattleshipGame.src.main.entities.EntityC;

public class Physics {
public static boolean Collision(EntityA ea,EntityB eb) {
		if(ea.getBounds().intersects(eb.getBounds())) {
			return true;
		}
			
	return false;
}
public static boolean Collision(EntityA ea,EntityC ec) {
	if(ea.getBounds().intersects(ec.getBounds())) {
		return true;
	}
		
return false;
}
public static boolean Collision(EntityB eb,EntityA ea) {

		if(eb.getBounds().intersects(ea.getBounds())) {
		return true;
		}
	
	return false;
}
}
