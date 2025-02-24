package org.mykhailomi.simulations.generator.illuminance;

public interface SimpleIlluminanceGenerator {
	
	/**
	 * 
	 * @param hour - time (in h).
	 * @return light intensity (in lux).
	 */
	double get(int hour) throws IllegalArgumentException ;
	
}
