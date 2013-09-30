package org.cricket.manager.probability;

import java.util.HashMap;
import java.util.Map;

import org.cricket.manager.Delivery;
import org.cricket.manager.Shot.Outcome;

public enum DistributionManager {
	INSTANCE;
	//distribution is probability for the events: out, six, dot, single, two, four, three. In that order.
	//below data will eventualy have to be migrated to a database.
	double[] yorker = {10, 1, 44, 30, 10, 2, 3};
	double[] defaultCase = {5, 5, 20, 30, 20, 10,10};
	double[] fullToss = {1, 10, 1, 10, 30, 20, 28};
	double[] goodLength = {7, 3, 25, 35, 20, 5, 5};
	double[] halfVolley = {2, 9, 1, 10, 30, 20, 28};	
	
	private double[] getShotProbabilityDistributionArray(Delivery d) {
		switch(d.getLength()) {
			case YORKER:
				return yorker;
			case FULL_TOSS:
				return fullToss;
			case GOOD_LENGTH:
				return goodLength;
			case HALF_VOLLEY:
				return halfVolley;
			default:
				return defaultCase;
		}

	}
	
	public Map<Outcome, Double> getShotProbabilityDistribution(Delivery d) {
		Map<Outcome, Double> shotProb = new HashMap<Outcome, Double>();
		double[] shotProbDist =  this.getShotProbabilityDistributionArray(d);
		shotProb.put(Outcome.OUT, shotProbDist[0]); //5% chance of getting out.
		shotProb.put(Outcome.SIX, shotProbDist[1]); //5% chance of getting six.		
		shotProb.put(Outcome.DOT, shotProbDist[2]); //20% chance of dot ball.
		shotProb.put(Outcome.SINGLE, shotProbDist[3]); //30% chance of single.
		shotProb.put(Outcome.TWO, shotProbDist[4]); //20% chance of two.
		shotProb.put(Outcome.FOUR, shotProbDist[5]); //10% chance of boundary.
		shotProb.put(Outcome.THREE, shotProbDist[6]); //10% chance of three.
		
		return shotProb;
	}

}
