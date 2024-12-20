package org.mykhailomi.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mykhailomi.simulators.generator.illuminance.SimpleIlluminanceGeneratorImpl;

class IlluminanceGeneratorTest {
	private static final Logger LOGGER = LogManager.getLogger(IlluminanceGeneratorTest.class);

	@Test
	void test() {
		double lux = new SimpleIlluminanceGeneratorImpl().get(0);
		
		LOGGER.info("lux={}", lux);
		
		assertTrue(lux < 1);
	}

}
