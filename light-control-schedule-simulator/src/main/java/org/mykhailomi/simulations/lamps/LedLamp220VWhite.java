package org.mykhailomi.simulations.lamps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("ledLamp220VWhite")
public class LedLamp220VWhite implements Lamp {
	private static final Logger LOGGER = LogManager.getLogger(LedLamp220VWhite.class);

	@Override
	public void on() {
		LOGGER.info("LedLamp220VWhite has been on.");
	}

	@Override
	public void off() {
		LOGGER.info("LedLamp220VWhite has been off.");
	}

}
