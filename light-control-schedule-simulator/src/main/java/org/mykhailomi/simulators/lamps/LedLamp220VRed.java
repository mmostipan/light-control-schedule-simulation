package org.mykhailomi.simulators.lamps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LedLamp220VRed implements Lamp {
	private static final Logger LOGGER = LogManager.getLogger(LedLamp220VRed.class);

	@Override
	public void on() {
		LOGGER.info("LedLamp220VRed has been on.");
	}

	@Override
	public void off() {
		LOGGER.info("LedLamp220VRed has been off.");
	}
}
