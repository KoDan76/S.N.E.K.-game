package AppleTypes;

import java.awt.Color;

import g36rde_hf_snek.Snek;

public class PoisonApple extends Apple {
	
	public PoisonApple() {
		color = Color.yellow;
	}
	@Override
	public void appleEffect(Snek snek) {
		snek.poison();		
	}

}
