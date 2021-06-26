package com.BattleshipGame.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.Graphics2D;

public class Help implements MouseListener{
	private Rectangle ExitButton=new Rectangle(Game.WIDTH/2 +75, 350,140,35);


public void render(Graphics g) {
		
		Font fnt0=new Font("Segoe Print",Font.BOLD,12);
		Font fnt1=new Font("Algerian",Font.BOLD,50);
		Font fnt3=new Font("Segoe Script",Font.ROMAN_BASELINE,13);
		Font fnt4=new Font("Segoe Script",Font.ROMAN_BASELINE,13);
		Graphics2D g2d= (Graphics2D)g;
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("HELP",235,70);
		g.setFont(fnt0);
		g.setColor(Color.white);
		
		g.drawString(" PRESS 'W' TO MOVE UPWARDS",80,100);
		g.drawString(" PRESS 'S' TO MOVE DOWN",80,130);
		g.drawString(" PRESS 'A' TO MOVE LEFT", 80,160);
		g.drawString(" PRESS 'D' TO MOVE RIGHT", 80, 190);
		g.drawString(" PRESS 'SPACE' TO SHOT THE ENEMY",80, 220);
		g.drawString(" PRESS 'QUIT' TO EXIT THE THE GAME",80,250);
		g.drawString(" SCORE INCREASES BY 10 FOR OBSTACLE AND 30 FOR ENEMY",80, 340);
		g.drawString(" AT EVERY LEVEL OBSTACKLE WILL INCREASE", 80, 280);
		g.drawString(" AT EVERY EVEN LEVEL ENEMY WILL INCREASE", 80, 310);
		
		g.setFont(fnt4);
		g.setColor(Color.WHITE);
		
		g.drawString("Click Here to Exit", ExitButton.x+9, ExitButton.y+20);
		g2d.draw(ExitButton);
	}

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
