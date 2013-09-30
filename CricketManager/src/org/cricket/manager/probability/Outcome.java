package org.cricket.manager.probability;

import java.util.ArrayList;

public abstract class Outcome {
	ArrayList<ProbabilityFactory> factors = new ArrayList<ProbabilityFactory>();

	public ArrayList<ProbabilityFactory> getFactors() {
		return factors;
	}
	
	public void addFactor(ProbabilityFactory factor) {
		factors.add(factor);
	}

}
