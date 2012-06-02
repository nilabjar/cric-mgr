package org.cricket.manager.entity;

import org.cricket.manager.Delivery;

public class Bowler extends Player {

	public Delivery bowl () {
		return new Delivery ();
	}
}
