package com.BattleshipGame.src.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.BattleshipGame.src.main.entities.EntityA;
import com.BattleshipGame.src.main.entities.EntityB;


public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1l;
	public static final int WIDTH= 320;
	public static final int HEIGHT=WIDTH / 12 * 9;
	public static final int SCALE=2;
	public final String TITLE="Battleship Game";
	
	private boolean running=false;
	private Thread thread;
	private boolean is_shooting=false;
	public static int Health=100;
	private int level=1;
	private int score=0;
	private int enemyCount=0;
	private int enemykilled=0;
	private int obstaclekilled=0;
	private int oldscore=0;
	private int obstacleCount=1;
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	
	public static enum STATE{
		MENU,
		HELP,
		ABOUT,
		DEATH,
		GAME
	};
	
	public static STATE State=STATE.MENU;
	
	private BufferedImage image= new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage player;
	private BufferedImage bullet;
	private BufferedImage enemybullet;
	private BufferedImage background;
	private BufferedImage enemy;
	private BufferedImage obstacle;
	private BufferedImage title;
	
	private Player p;
	private Controller c;
	private Menu menu;
	private Help help;
	private About about;
	private Death death;
	public static boolean addedlistener=false;
	
public synchronized void start() {
	if(running)
		return;
	running=true;
	thread=new Thread(this);
	thread.start();
}
public void init() {
	requestFocus();
	BufferedImageLoader loader=new BufferedImageLoader();
	try {
		player=loader.LoadImage("/player.png");
		bullet=loader.LoadImage("/bullet2.png");
		enemybullet=loader.LoadImage("/bullet1.png");
		background=loader.LoadImage("/background.png");
		enemy=loader.LoadImage("/enemy.png");
		obstacle=loader.LoadImage("/obstacle.png");
		title=loader.LoadImage("/title.png");
	}
	catch(IOException e){
		e.printStackTrace();
	}
	
	c = new Controller(this);
	p = new Player(320-45,480-48,level,score,player,c,this);
	menu=new Menu(title);
	help=new Help();
	about=new About();
	death=new Death();
	
	ea=c.getEntityA();
	eb=c.getEntityB();
	
	this.addKeyListener(new KeyboardInput(this));
	this.addMouseListener(menu);
	c.createObstacle(level, obstacle);
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public void run() {
	init();
	long lasttime=System.nanoTime();
	final double amountofTicks=60.0;
	double delta=0;
	double ns=1000000000/amountofTicks;
	int update=0;
	long timer=System.currentTimeMillis();
	int frames=0;
	while(running)
	{
		long now=System.nanoTime();
		delta+=(now-lasttime)/ns;
		lasttime=now;
		if(delta>=1)
		{
			tick();
			update++;
			delta--;
		}
		render();
		frames++;
		
		if(System.currentTimeMillis()-timer > 1000)
		{
			timer+=1000;
			System.out.println(update + " Ticks, FPS = "+ frames);
			update=0;
			frames=0;
		}
	}
	stop();
}
private void tick() {
	if(State==STATE.GAME) {
		p.tick();
		c.tick();
	}
	if(level%2==0)
	{
		if(score==oldscore+15*level+10*level)
		{
			level++;
			oldscore=score;
			obstacleCount++;
			c.createObstacle(obstacleCount, obstacle);
		}
	}
	else
	{
		if(score==oldscore+10*level)
		{
			level++;
			oldscore=score;
			obstacleCount++;
			c.createObstacle(obstacleCount, obstacle);
			enemyCount++;
			c.createEnemy(enemyCount, enemy,enemybullet);
		}
	}
			
		
	if(Game.Health==0) {
		Game.State=Game.STATE.DEATH;
	}
}
public int getEnemyCount() {
	return enemyCount;
}
public void setEnemyCount(int enemyCount) {
	this.enemyCount = enemyCount;
}
public int getEnemykilled() {
	return enemykilled;
}
public void setEnemykilled(int enemykilled) {
	this.enemykilled = enemykilled;
}
public int getObstaclekilled() {
	return obstaclekilled;
}
public void setObstaclekilled(int obstaclekilled) {
	this.obstaclekilled = obstaclekilled;
}
public int getObstacleCount() {
	return obstacleCount;
}
public void setObstacleCount(int obstacleCount) {
	this.obstacleCount = obstacleCount;
}
private void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if(bs==null)
	{
		createBufferStrategy(3);
		return;
	}
	Graphics g= bs.getDrawGraphics();
	
	g.drawImage(image, 0, 0,getWidth(),getHeight(),this);
	g.drawImage(background, 0, 0,null);
	
	
	if(State==STATE.GAME)
	{
		p.render(g);
		c.render(g);
		
		g.setColor(Color.lightGray);
		g.fillRect(1,445, 100, 25);
		
		g.setColor(Color.green);
		g.fillRect(1, 445, Health, 25);
		
		g.drawString("Level "+level, 570, 430);
		g.drawString("Score "+score, 570, 450);
	}
	else if(State==STATE.MENU)
	{
		menu.render(g);
	}
	else if(State==STATE.HELP) {
		
		help.render(g);
	}
    else if(State==STATE.ABOUT) {
		
		about.render(g);
	}
    else if(State==STATE.DEATH) {
	    death.render(g,this.score);
    }
	
	g.dispose();
	bs.show();
}
public void stop() {
	if(!running)
		return;
	try {
		thread.join();
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
	System.exit(1);
}
public static void main(String args[]) {
	Game game=new Game();
	
	game.setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
	game.setMaximumSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
	game.setMinimumSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
	
	JFrame frame=new JFrame(game.TITLE);
	frame.add(game);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	game.start();
}
public void keyPressed(KeyEvent e) {
	if(State==STATE.GAME)
	{
		int k=e.getKeyCode();
		if(k==KeyEvent.VK_D)
		{
			p.setvelX(5);
		}
		else if(k==KeyEvent.VK_A)
		{
			p.setvelX(-5);
		}
		else if(k==KeyEvent.VK_W)
		{
			p.setvelY(-5);
		}
		else if(k==KeyEvent.VK_S)
		{
			p.setvelY(5);
		}
		else if(k==KeyEvent.VK_SPACE && !is_shooting)
		{
			is_shooting=true;
			c.addEntity(new Bullet(p.getX()+20,p.getY(),bullet));
		}
	}
}
public void keyReleased(KeyEvent e)
{
	int k=e.getKeyCode();
	if(k==KeyEvent.VK_D)
	{
		p.setvelX(0);
	}
	else if(k==KeyEvent.VK_A)
	{
		p.setvelX(0);
	}
	else if(k==KeyEvent.VK_W)
	{
		p.setvelY(0);
	}
	else if(k==KeyEvent.VK_S)
	{
		p.setvelY(0);
	}
	else if(k==KeyEvent.VK_SPACE)
	{
		is_shooting=false;
	}
	}
}
