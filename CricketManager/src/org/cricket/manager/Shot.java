package org.cricket.manager;

import java.util.Random;

public class Shot {
	
	public enum Outcome {
	    OUT, 
	    DOT, 
	    SINGLE, 
	    TWO, 
	    THREE,
	    FOUR, 
	    SIX
	}
	
	public Outcome result;
	
	private final int totalOutcomes = 7;
	
	static private Random generator = new Random ();
	
	Shot () {
		int res = generator.nextInt(totalOutcomes);
		
		switch (res) {
		case 0:
			result = Outcome.OUT;
			break;
		case 1:
			result = Outcome.DOT;
			break;
		case 2:
			result = Outcome.SINGLE;
			break;
		case 3:
			result = Outcome.TWO;
			break;
		case 4:
			result = Outcome.THREE;
			break;
		case 5:
			result = Outcome.FOUR;
			break;
		case 6:
			result = Outcome.SIX;
			break;			
		}
	}	
}
