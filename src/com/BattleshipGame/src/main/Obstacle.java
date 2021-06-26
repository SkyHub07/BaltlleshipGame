package com.BattleshipGame.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;

public class Obstacle extends GameObject implements EntityB{
	Random r=new Random();
	private BufferedImage obstacle;
	private Game game;
	private Controller c;
	private int speed=r.nextInt(3)+1;
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
public Obstacle(double x,double y,BufferedImage image,Controller c,Game game) {
	super(x,y);
	this.obstacle=image;
	this.game=game;
	this.c=c;
}
public void tick() {
	this.y+=speed;
	if(y > (Game.HEIGHT * Game.SCALE))
	{
		speed=r.nextInt(3)+1;
		x=r.nextInt(600);
		y = 0;
	}
	for(int i=0;i<game.ea.size();i++)
	{
		EntityA temp=game.ea.get(i);
		if(Physics.Collision(this, temp))
		{
			int score=game.getScore();
			score+=10;
			//int obstaclecount=game.getObstacleCount();
			int obstaclekilled=game.getObstaclekilled();
			obstaclekilled++;
			game.setObstaclekilled(obstaclekilled);
			game.setScore(score);
			c.removeEntity(temp);
			c.removeEntity(this);
		}
	}
}
public void render(Graphics g) {
	g.drawImage(obstacle, (int)x, (int)y, null);
	
}
public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,45,48);
}
}

