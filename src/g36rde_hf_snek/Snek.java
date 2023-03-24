package g36rde_hf_snek;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;

public class Snek extends Colliders {
	
	private int applesEaten = 0;
	private int velocity = 0;
	private int bodyParts = 4;
	private char direction = 'D';
	private HashMap<Character,Character> directionMap = new HashMap<Character,Character>();
	
	public int getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(int bodyParts) {
		this.bodyParts = bodyParts;
	}

	public int getVelocity() {
		return velocity;
	}

	public void faster(int mod) {
		velocity++;
	}
	
	public void slower(int mod) {
		if (velocity > 0) {
			velocity--;
		}
	}	
	
	public char getDirection() {
		return directionMap.get(direction);
	}

	public Snek(GamePanel game) {
		super(game);
		color = Color.green;
		for (int i = 0; i < bodyParts; i++) {
			x[i] = game.getSCREEN_WIDTH()/2 - i*game.getUnitSize();
			y[i] = game.getSCREEN_HEIGHT()/2;
		}
		directionMap.put('D','D');
		directionMap.put('S','S');
		directionMap.put('A','A');
		directionMap.put('W','W');
	}
	
	public void move(int unit_size) {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(directionMap.get(direction)) {
		case 'W': 
			y[0] = y[0] - unit_size;
			break;
		case 'S':
			y[0] = y[0] + unit_size;
			break;
		case 'A':
			x[0] = x[0] - unit_size;
			break;
		case 'D':
			x[0] = x[0] + unit_size;
			break;
		}
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getApplesEaten() {
		return applesEaten;
	}

	public void setApplesEaten(int applesEaten) {
		this.applesEaten = applesEaten;
	}

	public void setDirection(char dir) {
		direction = dir;
	}

	public void poison() {
		Random ranGen =new Random();
		int[] generated = new int[4];
		directionMap.put('D', 
				directionConverter(generated[0] = ranGen.nextInt(4))
				);
		while (generated[1] == generated[0]) {
			generated[1] = ranGen.nextInt(4);
		}
		directionMap.put('S', directionConverter(generated[1]));
		while (generated[2] == generated[0] || generated[2] == generated[1]) {
			generated[2] = ranGen.nextInt(4);
		}
		directionMap.put('A', directionConverter(generated[2]));
		while (generated[3] == generated[0] || generated[3] == generated[1] || generated[3] == generated[2]) {
			generated[3] = ranGen.nextInt(4);
		}
		directionMap.put('W', directionConverter(generated[3]));
	}
	
	public char directionConverter(int dirCode) {
		char out = 'D';
		switch (dirCode){
			case 0 : out = 'D';
				break;
			case 1 : out = 'S';
				break;
			case 2 : out = 'A';
				break;
			case 3 : out = 'W';
				break;
		}
		return out;
	}

}
