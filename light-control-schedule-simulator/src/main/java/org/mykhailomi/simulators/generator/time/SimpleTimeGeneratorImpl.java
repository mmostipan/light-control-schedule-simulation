package org.mykhailomi.simulators.generator.time;

public class SimpleTimeGeneratorImpl implements SimpleTimeGenerator {
	
	private int hour; // 0-23
	
	private int minutes; // 0-59
	
	private int seconds; // 0-59
	
	public SimpleTimeGeneratorImpl() {
		hour = 0;
		minutes = 0;
		seconds = 0;
	}

	@Override
	public void nextHour() {
		if (++hour == 24) { hour = 0; }
	}
	
	@Override
	public void nextMinute() {
		if (++minutes == 60) { minutes = 0; nextHour(); }
	}
	
	@Override
	public void nextSecond() {
		if (++seconds == 60) { seconds = 0; nextMinute(); }
	}
	
	@Override
	public void nextHalfHour() {
		minutes += 30;
		
		if (minutes >= 60) { minutes = minutes - 60; nextHour(); }
	}

	@Override
	public void reset() {
		hour = 0;
		minutes = 0;
		seconds = 0;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23) { throw new IllegalArgumentException("hour must be in range from 0 to 23."); }
		
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (minutes < 0 || minutes > 59) { throw new IllegalArgumentException("minutes must be in range from 0 to 59."); }

		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59) { throw new IllegalArgumentException("seconds must be in range from 0 to 59."); }

		this.seconds = seconds;
	}
	
	public String getPrettyFormat() {
		return String.format("%02d:%02d:%02d", hour, minutes, seconds);
	}
	
}
