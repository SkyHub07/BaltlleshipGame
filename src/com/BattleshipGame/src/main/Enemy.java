package com.BattleshipGame.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;

public class Enemy extends GameObject implements EntityB{
	Random r=new Random();
	private BufferedImage enemy;
	private Game game;
	private Controller c;
	private int speed=r.nextInt(3)+1;
	private int health=99;
	private int direction=r.nextInt(1);
	private long timer=System.currentTimeMillis();
	private BufferedImage bullet;
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
public Enemy(double x,double y,BufferedImage image,BufferedImage bullet,Controller c,Game game) {
	super(x,y);
	this.enemy=image;
	this.game=game;
	this.c=c;
	this.bullet=bullet;
}
public void tick() {
	if(this.direction==1)
	{
		this.x-=speed;
		if(x<=0)
		{
			this.direction=0;
		}
	}
	else
	{
		this.x+=speed;
		if(x>600)
		{
			this.direction=1;
		}
	}
	for(int i=0;i<game.ea.size();i++)
	{
		EntityA temp=game.ea.get(i);
		if(Physics.Collision(this, temp))
			
		{	
			
			if(health==0)
			{
				int enemykilled=game.getEnemykilled();
				enemykilled++;
				game.setEnemykilled(enemykilled);
				c.removeEntity(this);
				
			}
			else
			{
				health-=33;
				int score=game.getScore();
				score+=10;
				game.setScore(score);
			}
			
		}
	}
	if(System.currentTimeMillis()-timer>=1000)
	{
		timer+=1000;
		c.addEntity(new EnemyBullet(this.x+20,this.y,bullet));
	}
	
}
public void render(Graphics g) {
	g.drawImage(enemy, (int)x, (int)y, null);
	
}
public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,45,48);
}
}
