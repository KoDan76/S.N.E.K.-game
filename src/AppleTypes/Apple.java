package AppleTypes;

import java.awt.*;
import g36rde_hf_snek.*;

public abstract class Apple {
	protected Color color = Color.red;

	public Color getColor() {
		return color;
	}
	
	abstract public void appleEffect(Snek snek);
}
