package com.BattleshipGame.src.main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		
		
	}


	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		/*
		 * private Rectangle playButton=new Rectangle(Game.WIDTH/2 +75, 200,150,50);
		private Rectangle helpButton=new Rectangle(Game.WIDTH/2 +75, 250,150,50);
		private Rectangle aboutButton=new Rectangle(Game.WIDTH/2 +75, 300,150,50);
		private Rectangle quitButton=new Rectangle(Game.WIDTH/2 +75, 350,150,50);
		 */
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


	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}
