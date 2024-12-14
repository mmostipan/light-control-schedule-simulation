package org.mykhailomi.simulators.generator.time;

public class SimpleTimeGeneratorImpl implements SimpleTimeGenerator {
	
	private int hour;
	
	public SimpleTimeGeneratorImpl() {
		hour = 0;
	}

	@Override
	public int nextHour() {
		if (hour > 24) { hour = 0; } 
		
		return hour++;
	}

	@Override
	public void reset() {
		hour = 0;
	}

}
