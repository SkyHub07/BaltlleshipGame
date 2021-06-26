package com.BattleshipGame.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.Graphics2D;

public class Death implements MouseListener{
	private Rectangle ExitButton=new Rectangle(Game.WIDTH/2 +75, 350,140,35);
public void render(Graphics g,int score) {
	Graphics2D g2d= (Graphics2D)g;
		Font fnt0=new Font("Chiller",Font.BOLD,25);
		Font fnt1=new Font("Chiller",Font.BOLD,50);
		Font fnt4=new Font("Segoe Script",Font.ROMAN_BASELINE,13);
		g.setFont(fnt1);
		g.setColor(Color.red);
		g.drawString("You Died...", 220, 210);
		g.setFont(fnt0);
		g.setColor(Color.red);
		g.drawString("Your Score : "+score, 235, 270);
		
		
		
		g.setFont(fnt4);
		g.setColor(Color.red);
		
		g.drawString("Click Here to Exit", ExitButton.x+9, ExitButton.y+22);
		g2d.draw(ExitButton);
		

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
	if(mx>=0 && mx<=640)
	{
		if(my>=0 && my<=480)
		{
			System.exit(1);
			
		}
	}
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}