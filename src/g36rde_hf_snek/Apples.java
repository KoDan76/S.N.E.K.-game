package g36rde_hf_snek;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import AppleTypes.*;

// Apple type 0normal, 1poison, 2slow, 3speed, 4confusion 

public class Apples extends Colliders {
	ArrayList<Apple> types=  new ArrayList<Apple>();
	private final int APPLES_AT_ONCE = 10;
	private int applesSpawned = 0;
	
	public int getApplesSpawned() {
		return applesSpawned;
	}

	public Apples(GamePanel game, SnekOptions opt) {
		super(game);
	}	
	
	protected void initialize(GamePanel game) {
		x = new int[APPLES_AT_ONCE];
		y = new int[APPLES_AT_ONCE];
		
	}
	
	public void newApple(Snek snek, Walls walls, GamePanel game, int I) {	
		Random random = new Random();
		if (applesSpawned <= APPLES_AT_ONCE && I != -1) {
			do {
				x[I] = random.nextInt((int)(game.getSCREEN_WIDTH()/game.getUnitSize()))*game.getUnitSize();
				y[I] = random.nextInt((int)(game.getSCREEN_HEIGHT()/game.getUnitSize()))*game.getUnitSize();				
				int type = random.nextInt(5);
				if (type < 4){
					types.add(I, new NormalApple());
				} else {
					type = random.nextInt(4);
					switch (type) {					
					case 0:
						types.add(I, new PoisonApple());
						break;
					case 1:
						types.add(I, new SlowApple());
						break;
					case 2:
						types.add(I, new SpeedApple());
						break;
					case 3:
						types.add(I, new ConfusedApple());
						break;
					}
				}		
				System.out.println(walls.findCoordiantes(x[I], y[I]));
			} while((walls.findCoordiantes(x[I], y[I]) != -1) || (snek.findCoordiantes(x[I], y[I]) != -1));
		}
		applesSpawned++;
	}
	
	public Apple getAppleAt(int index) {
		return types.get(index);
	}

	public void destroyApple(int appleIndex) {
		applesSpawned--;
	};
	
}
