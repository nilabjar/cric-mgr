package org.cricket.manager;


public class Game {

	public Match startMatch () {
		
		Match m = new Match ();
		m.startPlay();
		
		return m;
	}
}
