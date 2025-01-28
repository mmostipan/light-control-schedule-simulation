package org.mykhailomi.simulators.app;

import org.mykhailomi.simulators.conf.AppConfiguration;
import org.mykhailomi.simulators.simulator.LightControlScheduleSimulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		LightControlScheduleSimulator simulator = ctx.getBean("lightControlScheduleSimulator", LightControlScheduleSimulator.class);
		simulator.start(1);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
