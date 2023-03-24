package g36rde_hf_snek;

import java.awt.Color;
import java.io.*;

public class SnekOptions implements Serializable {
//	private SnekColor;
	private String name;
	private int RandomWallsNumber;
	private int NumberOfSpecials;
	private int fieldSizeX;
	private int fieldSizeY;
	private Color snekColor = Color.green;
	private int wallNum = 15; 
	
	public SnekOptions(){		
	}

	public int getRandomWallsNumber() {
		return RandomWallsNumber;
	}

	public void setRandomWallsNumber(int randomWallsNumber) {
		RandomWallsNumber = randomWallsNumber;
	}

	public int getNumberOfSpecials() {
		return NumberOfSpecials;
	}

	public void setNumberOfSpecials(int numberOfSpecials) {
		NumberOfSpecials = numberOfSpecials;
	}

	public Color getSnekColor() {
		return snekColor;
	}

	public void setSnekColor(Color snekColor) {
		this.snekColor = snekColor;
	}

	int getWallNum() {
		// TODO Auto-generated method stub
		return wallNum;
	}
}
