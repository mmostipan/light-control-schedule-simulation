package org.mykhailomi.light_control_schedule_simulation.generator.illuminance;

public interface SimpleIlluminanceGenerator {
	
	/**
	 * 
	 * @param hour - time (in h).
	 * @return light intensity (in lux).
	 */
	double get(int hour) throws IllegalArgumentException ;
	
}
