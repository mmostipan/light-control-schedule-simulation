package org.mykhailomi.simulators.generator.time;

public interface SimpleTimeGenerator {
	
	/**
	 * Generates cyclically 24 hour clock times of the day and night.
	 * @return time
	 */
	int nextHour();
	
	/**
	 * Set time to zero.
	 */
	void reset();

}
