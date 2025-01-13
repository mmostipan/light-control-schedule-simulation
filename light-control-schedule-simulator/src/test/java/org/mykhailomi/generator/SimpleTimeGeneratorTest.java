package org.mykhailomi.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mykhailomi.simulators.generator.time.SimpleTimeGeneratorImpl;

class SimpleTimeGeneratorTest {
	private static final Logger LOGGER = LogManager.getLogger(SimpleTimeGeneratorTest.class);

	@Test
	void test() {
		SimpleTimeGeneratorImpl stg = new SimpleTimeGeneratorImpl();
		stg.setHour(12);
		stg.setMinutes(45);
		stg.setSeconds(59);
		
		stg.nextHour();
		stg.nextMinute();
		stg.nextSecond();
		stg.nextHalfHour();
		
		LOGGER.info("Time={}", stg.getPrettyFormat());
		
		assertEquals(14, stg.getHour());
		
		assertEquals(17, stg.getMinutes());
		
		assertEquals(0, stg.getSeconds());
	}

}
