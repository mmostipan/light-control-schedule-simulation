package org.mykhailomi.simulations.generator.time;

public interface SimpleTimeGenerator {
	
	void nextHour();
	
	void nextMinute();
	
	void nextSecond();
	
	void nextHalfHour();
	
	void reset();
	
	int getDay();
	
	void setDay(int day);
	
	int getHour();
	
	void setHour(int day);
	
	int getMinute();
	
	void setMinute(int day);
	
	int getSecond();
	
	void setSecond(int day);
	
	String getPrettyFormat();

}
