package com.BattleshipGame.src.main;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.BattleshipGame.src.main.entities.EntityA;

public class Bullet extends GameObject implements EntityA{
	private BufferedImage bullet;
public Bullet(double x,double y,BufferedImage bullet) {
	super(x,y);
	this.bullet=bullet;
}
public void tick() {
	this.y-=10;
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
public void render(Graphics g){
	g.drawImage(bullet, (int)x, (int)y,null);
}
public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,7,25);
}
}
