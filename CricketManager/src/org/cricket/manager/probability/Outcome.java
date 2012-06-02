package org.cricket.manager.probability;

import java.util.ArrayList;

public abstract class Outcome {
	ArrayList<ProbabilityFactor> factors = new ArrayList<ProbabilityFactor>();

	public ArrayList<ProbabilityFactor> getFactors() {
		return factors;
	}
	
	public void addFactor(ProbabilityFactor factor) {
		factors.add(factor);
	}

}
