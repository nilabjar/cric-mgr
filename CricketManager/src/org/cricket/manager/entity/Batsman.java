package org.cricket.manager.entity;

import org.cricket.manager.Delivery;
import org.cricket.manager.Shot;

public class Batsman extends Player {

	public Shot bat (Delivery d) {
		return new Shot ();
	}
}
