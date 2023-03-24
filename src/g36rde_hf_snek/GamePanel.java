package g36rde_hf_snek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener, Serializable{
	private final int SPEED_STEPS = 10;
	private int SCREEN_WIDTH = 900;
	private int SCREEN_HEIGHT = 600;
	final int UNIT_SIZE = 30;
	final int UNIT_NUMBER = (int)((SCREEN_HEIGHT*SCREEN_HEIGHT) / UNIT_SIZE);
	private Walls walls;
	private Apples apples;
	
	
	public int getUnitNum() {
		return UNIT_NUMBER;
	}
	
	private boolean running = false;
	final int BASE_DELAY = 150;
	private Snek player;
	Timer timer;
	Random random;
	
	public GamePanel(){
		
	}
	
	public GamePanel(SnekOptions opt){
		addKeyListener(new MyKeyAdapter());
		walls = new Walls(this, opt);
		apples = new Apples(this,opt);
		random = new Random();		
		player = new Snek(this);
		player.setColor(opt.getSnekColor());
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(new MyKeyAdapter());
		timer = new Timer(BASE_DELAY, this);
		timer.start();
		startGame();
	}
	
	public void startGame() {
		running =true;
		apples.newApple(player, walls, this, 0);
	}

	public int getSCREEN_HEIGHT() {
		return SCREEN_HEIGHT;
	}

	public int getSCREEN_WIDTH() {
		return SCREEN_WIDTH;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		draw(g);
	}
	
	public void draw(Graphics g) {	
		g.setColor(player.getColor());
		for(int i = 0; i < player.getBodyParts(); i++) {
			
			g.fillRect(player.getXAt(i), player.getYAt(i), UNIT_SIZE, UNIT_SIZE);
		}	
		
		g.setColor(walls.getColor());
		for (int i = 0; i < walls.wallsNum(); i++) {
			g.fillRect(walls.getXAt(i), walls.getYAt(i), UNIT_SIZE, UNIT_SIZE);
		}
		
		for (int i = 0; i < apples.getApplesSpawned(); i++) {
			g.setColor(apples.getAppleAt(i).getColor());
			g.fillOval(apples.getXAt(i), apples.getYAt(i), UNIT_SIZE, UNIT_SIZE);			
		}
		
	}
	
	public void updateVelocity() {
		timer.setDelay(BASE_DELAY - player.getVelocity()*SPEED_STEPS);
	}
	
	public void checkApple() {
		int appleIndex = apples.findCoordiantes(player.getXAt(0), player.getYAt(0));		
		if ( appleIndex != -1 ) {
			System.out.println("megettem");
			apples.destroyApple(appleIndex);
			apples.getAppleAt(appleIndex).appleEffect(player);
			apples.newApple(player, walls, this, appleIndex);
		}
	}
	
	public void checkCollisions() {
		// Checks if Snek touched himself
		for(int i = player.getBodyParts(); i > 0; i--) {
			if(player.getXAt(0) == player.getXAt(i) && player.getYAt(0) == player.getYAt(i)) {
				running = false;
			}
		}		
		
		// Checks if Snek touched the border walls
		if (walls.findCoordiantes(player.getXAt(0), player.getYAt(0)) != -1 )
		{
			running = false;
		}
				
		if (!running) {
			timer.stop();
		}
	}
	
	public void gameOver() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			player.move(UNIT_SIZE);
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {	
			
			switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				if(player.getDirection() != 'D' ) {
					player.setDirection('A');
				}
				break;
			case KeyEvent.VK_D:
				if(player.getDirection() != 'A') {
					player.setDirection('D');
				}
				break;
			case KeyEvent.VK_W:
				if(player.getDirection() != 'S') {
					player.setDirection('W');
				}
				break;
			case KeyEvent.VK_S:
				if(player.getDirection() != 'W') {
					player.setDirection('S');
				}
				break;
			}
		}
	}

	public int getUnitSize() {
		return UNIT_SIZE;
	}
}
