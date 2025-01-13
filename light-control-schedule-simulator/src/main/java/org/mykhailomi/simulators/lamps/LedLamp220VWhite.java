package org.mykhailomi.simulators.lamps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LedLamp220VWhite implements Lamp {
	private static final Logger LOGGER = LogManager.getLogger(LedLamp220VWhite.class);

	@Override
	public void on() {
		LOGGER.info("{} has been on.", LedLamp220VWhite.class.getName());
	}

	@Override
	public void off() {
		LOGGER.info("{} has been on.", LedLamp220VWhite.class.getName());
	}

}
