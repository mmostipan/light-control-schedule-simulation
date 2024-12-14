package org.mykhailomi.simulators.generator.illuminance;

public interface SimpleIlluminanceGenerator {
	
	/**
	 * 
	 * @param hour - time of day [h].
	 * @return light intensity (lux).
	 */
	int get(int hour);
	
}
