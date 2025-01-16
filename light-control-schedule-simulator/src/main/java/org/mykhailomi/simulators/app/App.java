package org.mykhailomi.simulators.app;

import org.mykhailomi.simulators.simulator.LightControlScheduleSimulatorImpl;

public class App {
	
	public static void main(String[] args) {
		new LightControlScheduleSimulatorImpl().start(1);
	}

}
