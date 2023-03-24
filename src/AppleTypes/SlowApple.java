package AppleTypes;

import java.awt.Color;

import g36rde_hf_snek.Snek;

public class SlowApple extends Apple {
	protected Color color;
	
	public SlowApple(){
		color = Color.white;
	}

	@Override
	public void appleEffect(Snek snek) {
		snek.slower(1);
	}

}
