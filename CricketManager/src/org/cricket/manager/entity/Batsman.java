package org.cricket.manager.entity;

import org.cricket.manager.Delivery;
import org.cricket.manager.Shot;
import org.cricket.manager.Shot.Outcome;

public class Batsman extends Player {
	Shot shot = null;
	public Batsman() {
		shot = new Shot();
	}

	public Outcome bat (Delivery d) {
		return shot.getResult(d);
	}
}
