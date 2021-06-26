package com.BattleshipGame.src.main;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;
import com.BattleshipGame.src.main.entities.EntityC;
public class Player extends GameObject implements EntityA{
private double velX=0;
private double velY=0;
private BufferedImage player;
private Controller c;
private LinkedList<EntityB> eb;
private LinkedList<EntityC> ec;
private Game game;
public Player (double x,double y,int level,int score,BufferedImage player,Controller c,Game game)
{
	super(x,y);
	this.player=player;
	this.c=c;
	eb=c.getEntityB();
	ec=c.getEntityC();
	this.game=game;
	}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public void setvelX(int velx)
{this.velX=velx;
	}
public void setvelY(int vely)
{this.velY=vely;
	}
public void tick() {
	x+=velX;
	y+=velY;
	
	if(x<=0) {x=0;}
	
	if(x>=640-38) {x=640-38;}
	
	if(y<=0) { y=0;}
	
	if(y>=480-60) {y=480-60;}
	
	EntityB tempb;
	EntityC tempc;
	for(int i=0;i<eb.size();i++)
	{
		tempb=eb.get(i);
		if(Physics.Collision(this, tempb))
		{
			int score=game.getScore();
			score+=10;
			game.setScore(score);
			c.removeEntity(tempb);
			Game.Health-=10;
		}
	}
	for(int i=0;i<ec.size();i++)
	{
		tempc=ec.get(i);
		if(Physics.Collision(this, tempc))
		{
			c.removeEntity(tempc);
			Game.Health-=10;
		}
	}
}
public void render(Graphics g) {
	g.drawImage(player, (int)x, (int)y,null);
}
public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,45,48);
}

}
