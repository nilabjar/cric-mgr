package org.cricket.manager.probability;

/**
 * @author Baby's
 * Abstract factory for creating Probability functions. Each probability function will be 
 */
public interface ProbabilityFunctionFactory {
	ProbabilityFunction getProbabilityFunction();
}
