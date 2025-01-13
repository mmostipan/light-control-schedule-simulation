package org.mykhailomi.simulators.generator.time;

public interface SimpleTimeGenerator {
	
	void nextHour();
	
	void nextMinute();
	
	void nextSecond();
	
	void nextHalfHour();
	
	void reset();

}
