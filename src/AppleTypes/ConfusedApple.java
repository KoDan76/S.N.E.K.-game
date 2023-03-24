package AppleTypes;

import java.awt.Color;

import g36rde_hf_snek.Snek;

public class ConfusedApple extends Apple {

	public ConfusedApple(){
		color = Color.pink;
	}
	
	@Override
	public void appleEffect(Snek snek) {
		snek.faster(1);		
	}

}
