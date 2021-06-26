package com.BattleshipGame.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;
import com.BattleshipGame.src.main.entities.EntityC;

public class Controller {
private LinkedList<EntityA> ea=new LinkedList<EntityA>();
private LinkedList<EntityB> eb=new LinkedList<EntityB>();
private LinkedList<EntityC> ec=new LinkedList<EntityC>();
private Game game;
EntityA Tempa;
EntityB Tempb;
EntityC Tempc;
Random r=new Random();
public Controller(Game game)
{
	this.game=game;
}
public void createObstacle(int obstacleCount,BufferedImage obstacle) {
	for(int i=0;i<obstacleCount;i++)
	{
		addEntity(new Obstacle(r.nextInt(640),10,obstacle,this,game));
	}
}
public void createEnemy(int enemyCount,BufferedImage enemy,BufferedImage bullet)
{
	for(int i=0;i<enemyCount;i++)
	{
		addEntity(new Enemy(r.nextInt(600),10,enemy,bullet,this,game));
	}
}

public void tick() {
	for(int i=0;i<ea.size();i++)
	{
		Tempa = ea.get(i);
		if(Tempa.getY()<0)
		{
			removeEntity(Tempa);
		}
		Tempa.tick();
	}
	for(int i=0;i<eb.size();i++)
	{
		Tempb = eb.get(i);
		//if(Tempb.getY()>Game.HEIGHT * Game.SCALE)
		//{
			//removeEntity(Tempb);
		//}
		Tempb.tick();
	}
	for(int i=0;i<ec.size();i++)
	{
		Tempc = ec.get(i);
		//if(Tempb.getY()>Game.HEIGHT * Game.SCALE)
		//{
			//removeEntity(Tempb);
		//}
		Tempc.tick();
	}
}
public void render(Graphics g) {
	for(int i=0;i<ea.size();i++)
	{
		Tempa = ea.get(i);
		Tempa.render(g);
	}
	for(int i=0;i<eb.size();i++)
	{
		Tempb = eb.get(i);
		Tempb.render(g);
	}
	for(int i=0;i<ec.size();i++)
	{
		Tempc = ec.get(i);
		Tempc.render(g);
	}
	
}
public void addEntity(EntityA block) {
	ea.add(block);
}
public void removeEntity(EntityA block) {
	ea.remove(block);
}
public void addEntity(EntityC block) {
	ec.add(block);
}
public void removeEntity(EntityC block) {
	ec.remove(block);
}
public void addEntity(EntityB block) {
	eb.add(block);
}
public void removeEntity(EntityB block) {
	eb.remove(block);
}
public LinkedList<EntityA> getEntityA(){
	return ea;
}
public LinkedList<EntityB> getEntityB(){
	return eb;
}
public LinkedList<EntityC> getEntityC(){
	return ec;
}
}
