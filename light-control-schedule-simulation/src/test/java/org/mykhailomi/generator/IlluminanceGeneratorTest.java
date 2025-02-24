package org.mykhailomi.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mykhailomi.simulations.conf.AppConfiguration;
import org.mykhailomi.simulations.generator.illuminance.SimpleIlluminanceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class IlluminanceGeneratorTest {
	private static final Logger LOGGER = LogManager.getLogger(IlluminanceGeneratorTest.class);

	@Test
	void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		SimpleIlluminanceGenerator illuminanceGenerator = ctx.getBean("illuminanceGenerator", SimpleIlluminanceGenerator.class);
		
		double lux = illuminanceGenerator.get(22);
		
		LOGGER.info("lux={}", lux);
		
		((ConfigurableApplicationContext) ctx).close();
		
		assertTrue(lux < 1);
	}

}
