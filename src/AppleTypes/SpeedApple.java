package AppleTypes;

import java.awt.Color;

import g36rde_hf_snek.Snek;

public class SpeedApple extends Apple{
	public SpeedApple(){
		color = Color.blue;
	}

	@Override
	public void appleEffect(Snek snek) {
		snek.faster(1);		
	}

}
