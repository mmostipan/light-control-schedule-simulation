package org.mykhailomi.simulations.app;

import org.mykhailomi.simulations.conf.AppConfiguration;
import org.mykhailomi.simulations.simulation.LightControlScheduleSimulation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		LightControlScheduleSimulation simulator = ctx.getBean("lightControlScheduleSimulator", LightControlScheduleSimulation.class);
		simulator.start(1);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
