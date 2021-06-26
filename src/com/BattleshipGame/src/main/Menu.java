package com.BattleshipGame.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Menu implements MouseListener {
	private BufferedImage title;
	private Rectangle playButton=new Rectangle(Game.WIDTH/2 +75, 200,150,50);
	private Rectangle helpButton=new Rectangle(Game.WIDTH/2 +75, 250,150,50);
	private Rectangle aboutButton=new Rectangle(Game.WIDTH/2 +75, 300,150,50);
	private Rectangle quitButton=new Rectangle(Game.WIDTH/2 +75, 350,150,50);
	public Menu(BufferedImage title)
	{
		this.title=title;
	}
public void render(Graphics g) {
	g.drawImage(title, 50, 50,500,150,null);
	Font fnt0=new Font("arial",Font.BOLD,35);
	
	Graphics2D g2d= (Graphics2D)g;
	g.setFont(fnt0);
	g.setColor(Color.LIGHT_GRAY);
	g.drawString("PLAY", playButton.x+9, playButton.y+40);
	g2d.draw(playButton);
	g.drawString("HELP", helpButton.x+9, helpButton.y+40);
	g2d.draw(helpButton);
	g.drawString("ABOUT", aboutButton.x+9, aboutButton.y+40);
	g2d.draw(aboutButton);
	g.drawString("QUIT", quitButton.x+9, quitButton.y+40);
	g2d.draw(quitButton);
	Font fnt1=new Font("arial",Font.ITALIC,15);
	g.setFont(fnt1);
	g.setColor(Color.GRAY);
	g.drawString("Version 1.2.0", 530,450);
}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	int mx=e.getX();
	int my=e.getY();
	if(mx>=Game.WIDTH/2+75 && mx<= Game.WIDTH/2+225)
	{
		if(my>=200 && my<=250)
		{
			Game.State=Game.STATE.GAME;
		}
	}
	if(mx>=Game.WIDTH/2+75 && mx<=Game.WIDTH/2+225) {
		if(my >=250 && my<=300) {
			Game.State=Game.State.HELP;
		}
	}
	if(mx>=Game.WIDTH/2+75 && mx<=Game.WIDTH/2+225) {
		if(my>=300 && my<=350) {
			Game.State=Game.STATE.ABOUT;
		}
	}
	if(mx>=Game.WIDTH/2+75 && mx<= Game.WIDTH/2+225)
	{
		if(my>=350 && my<=400)
		{
			System.exit(1);;
		}
	}
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
