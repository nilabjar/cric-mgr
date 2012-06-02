package org.cricket.manager.probability;

/**
 * @author Baby's
 * Probability functions are used by the probability engine to create the distribution.
 * Each outcome will have a function attached to it.
 */
public interface ProbabilityFunction {
	
	/**
	 * @param factors
	 * @return
	 * calculateWeight method will generate the chances of this outcome coming true.
	 * It accepts an outcome and calculates weight(chance) of the outcome coming true.
	 * 
	 */
	abstract Weight calculateWeight(Outcome outcome);

}
