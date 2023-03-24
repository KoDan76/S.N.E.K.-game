package AppleTypes;

import java.awt.Color;

import g36rde_hf_snek.Snek;

public class NormalApple extends Apple{

	public NormalApple(){
		color = Color.red;
	}
	@Override
	public void appleEffect(Snek snek) {
		snek.setApplesEaten(snek.getApplesEaten()+1);	
		snek.setBodyParts(snek.getBodyParts()+1);
	}
}
