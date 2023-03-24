package g36rde_hf_snek;

import java.awt.event.*;

public class MyKeyAdapter extends KeyAdapter {
	private char direction;
	
	@Override
	public void keyPressed(KeyEvent e) {	
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			if(direction != 'D' ) {
				direction = 'A';
			}
			break;
		case KeyEvent.VK_D:
			if(direction != 'A') {
				direction = 'D';
			}
			break;
		case KeyEvent.VK_W 		:
			if(direction != 'S') {
				direction = 'W';
			}
			break;
		case KeyEvent.VK_S:
			if(direction != 'W') {
				direction = 'S';
			}
			break;
		}
	}
	
	public char getDirection() {
		return direction;
	}

}
