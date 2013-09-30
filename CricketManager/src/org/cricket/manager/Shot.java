package org.cricket.manager;

import java.util.Map;
import java.util.Random;

import org.cricket.manager.probability.DistributionManager;

public class Shot {
	
	Map<Outcome, Double> shotProb = null;
	private Outcome[] outcomeArray = new Outcome[100];
	
	void populateProbs(Delivery d) {
		shotProb = DistributionManager.INSTANCE.getShotProbabilityDistribution(d);
	}
	
	public void createArray() {
		int i = 0;
		int temp = 0;
		for(;i < shotProb.get(Outcome.OUT);i++) {
			outcomeArray[i] = Outcome.OUT;
		}
		temp = i;
		
		for(;i < (temp + shotProb.get(Outcome.SIX));i++) {
			outcomeArray[i] = Outcome.SIX;
		}
		
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.DOT);i++) {
			outcomeArray[i] = Outcome.DOT;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.SINGLE);i++) {
			outcomeArray[i] = Outcome.SINGLE;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.TWO);i++) {
			outcomeArray[i] = Outcome.TWO;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.THREE);i++) {
			outcomeArray[i] = Outcome.THREE;
		}
		temp = i;
		
		for(;i < temp + shotProb.get(Outcome.FOUR);i++) {
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
		populateProbs(d);
		createArray();
		return outcomeArray[res];		
	}
	
	public Shot () {
	}	
}
