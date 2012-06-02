package org.cricket.manager.probability;

public interface ProbabilityEngine {
	
	/**
	 * @param outcomes
	 * @return
	 * This method will return the final outcome. Should only be called from event listeners.
	 * It accepts an array of all possible outcomes and returns the winning outcome.
	 * Internally it will feed each outcome to the probabiity function and generate a weight
	 * for each. This will allow it to create the probability distribution for the event.
	 */
	Outcome winningOutcome(Outcome[] outcomes);

}
