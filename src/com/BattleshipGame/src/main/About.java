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

public class About implements MouseListener{
	private Rectangle ExitButton=new Rectangle(Game.WIDTH/2 +75, 350,140,35);


public void render(Graphics g) {
	
		
		Font fnt0=new Font("italic",Font.BOLD,40);
		Font fnt1=new Font("Bold",Font.BOLD,30);
		Font fnt2=new Font("Bold",Font.BOLD,23);
		Font fnt3=new Font("Segoe Script",Font.ROMAN_BASELINE,22);
		Font fnt4=new Font("Segoe Script",Font.ROMAN_BASELINE,13);
		//Graphics2D g2d= (Graphics2D)g;
		
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("ABOUT", 200, 80);
		
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Developers :",60, 160);
		g.setFont(fnt2);
		g.setColor(Color.white);
		
		Graphics2D g2d= (Graphics2D)g;
		g.drawString("  Akash Singh", 75, 195);
		g.drawString("  Mayank Taksande" , 75, 225);
		
		
		
		g.setFont(fnt4);
		g.setColor(Color.WHITE);
		
		g.drawString("Click Here to Exit", ExitButton.x+9, ExitButton.y+20);
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