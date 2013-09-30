package org.cricket.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Shot {
	
	Map<Outcome, Double> shotProb = new HashMap<Outcome, Double>();
	private Outcome[] outcomeArray = new Outcome[100];
	
	void populateProbs() {
		shotProb.put(Outcome.OUT, .05); //5% chance of getting out.
		shotProb.put(Outcome.SIX, .05); //5% chance of getting six.		
		shotProb.put(Outcome.DOT, .2); //20% chance of dot ball.
		shotProb.put(Outcome.SINGLE, .3); //30% chance of single.
		shotProb.put(Outcome.TWO, .2); //20% chance of two.
		shotProb.put(Outcome.FOUR, .1); //10% chance of boundary.
		shotProb.put(Outcome.THREE, .1); //10% chance of three.
	}
	
	public void createArray() {
		int i = 0;
		int temp = 0;
		for(;i < shotProb.get(Outcome.OUT)*100;i++) {
			outcomeArray[i] = Outcome.OUT;
		}
		temp = i;
		
		for(;i < (temp + shotProb.get(Outcome.SIX)*100);i++) {
			outcomeArray[i] = Outcome.SIX;
		}
		
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.DOT)*100;i++) {
			outcomeArray[i] = Outcome.DOT;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.SINGLE)*100;i++) {
			outcomeArray[i] = Outcome.SINGLE;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.TWO)*100;i++) {
			outcomeArray[i] = Outcome.TWO;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.THREE)*100;i++) {
			outcomeArray[i] = Outcome.THREE;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.FOUR)*100;i++) {
			outcomeArray[i] = Outcome.FOUR;
		}
	}
	
	public enum Outcome {
	    OUT, 
	    DOT, 
	    SINGLE, 
	    TWO, 
	    THREE,
	    FOUR, 
	    SIX
	}
	
	private final int totalOutcomes = 100;
	
	static private Random generator = new Random ();
	
	public Outcome getResult(Delivery d) {
		int res = generator.nextInt(totalOutcomes);
		//create the probability range for the shot outcomes
		populateProbs();
		createArray();
		return outcomeArray[res];		
	}
	
	public Shot () {
	}	
}
