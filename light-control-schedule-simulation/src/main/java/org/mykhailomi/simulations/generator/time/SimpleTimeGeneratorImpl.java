package org.mykhailomi.simulations.generator.time;

import org.springframework.stereotype.Component;

@Component("timeGenerator")
public class SimpleTimeGeneratorImpl implements SimpleTimeGenerator {
	
	private int day;
	
	private int hour; // 0-23
	
	private int minute; // 0-59
	
	private int second; // 0-59
	
	public SimpleTimeGeneratorImpl() {
		day = 0;
		hour = 0;
		minute = 0;
		second = 0;
	}

	@Override
	public void nextHour() {
		if (++hour == 24) { hour = 0; day++; }
	}
	
	@Override
	public void nextMinute() {
		if (++minute == 60) { minute = 0; nextHour(); }
	}
	
	@Override
	public void nextSecond() {
		if (++second == 60) { second = 0; nextMinute(); }
	}
	
	@Override
	public void nextHalfHour() {
		minute += 30;
		
		if (minute >= 60) { minute = minute - 60; nextHour(); }
	}

	@Override
	public void reset() {
		day = 0;
		hour = 0;
		minute = 0;
		second = 0;
	}
	
	@Override
	public int getDay() {
		return day;
	}

	@Override
	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public int getHour() {
		return hour;
	}
	
	@Override
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) { throw new IllegalArgumentException("hour must be in range from 0 to 23."); }
		
		this.hour = hour;
	}

	@Override
	public int getMinute() {
		return minute;
	}

	@Override
	public void setMinute(int minutes) {
		if (minutes < 0 || minutes > 59) { throw new IllegalArgumentException("minutes must be in range from 0 to 59."); }

		this.minute = minutes;
	}

	@Override
	public int getSecond() {
		return second;
	}

	@Override
	public void setSecond(int seconds) {
		if (seconds < 0 || seconds > 59) { throw new IllegalArgumentException("seconds must be in range from 0 to 59."); }

		this.second = seconds;
	}
	
	@Override
	public String getPrettyFormat() {
		return String.format("%02d %02d:%02d:%02d", day, hour, minute, second);
	}
	
}
