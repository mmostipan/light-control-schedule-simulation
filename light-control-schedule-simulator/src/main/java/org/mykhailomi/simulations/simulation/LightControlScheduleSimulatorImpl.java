package org.mykhailomi.simulations.simulation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mykhailomi.simulations.generator.illuminance.SimpleIlluminanceGenerator;
import org.mykhailomi.simulations.generator.time.SimpleTimeGenerator;
import org.mykhailomi.simulations.lamps.Lamp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lightControlScheduleSimulator")
public class LightControlScheduleSimulatorImpl implements LightControlScheduleSimulator {
	private static final Logger LOGGER = LogManager.getLogger(LightControlScheduleSimulatorImpl.class);

	private static final int DARK_IN_LUX = 5;
	
	private final SimpleIlluminanceGenerator illuminanceGenerator;
	
	private final SimpleTimeGenerator timeGenerator;
	
	private final Lamp ledLamp220VRed;
	
	private final Lamp ledLamp220VWhite;
	
	private boolean isFirstLampOn;
	
	private boolean isSecondLampOn;
	
	public LightControlScheduleSimulatorImpl(SimpleIlluminanceGenerator illuminanceGenerator,
			SimpleTimeGenerator timeGenerator,
			@Qualifier("ledLamp220VRed") Lamp ledLamp220VRed,
			@Qualifier("ledLamp220VWhite") Lamp ledLamp220VWhite) {
		this.illuminanceGenerator = illuminanceGenerator;
		this.timeGenerator = timeGenerator;
		this.ledLamp220VRed = ledLamp220VRed;
		this.ledLamp220VWhite = ledLamp220VWhite;

		isFirstLampOn = false;
		isSecondLampOn = false;
	}
	
	@Override
	public void start(int days) {
		while (timeGenerator.getDay() < days) {
			LOGGER.info("Time: {}", timeGenerator.getPrettyFormat());
			
			double lux = illuminanceGenerator.get(timeGenerator.getHour());
			
			LOGGER.info("Lux: {}", lux);
			
			if (isItShoneOutside(lux)) {
				if (isFirstLampOn) {
					ledLamp220VRed.off();
					isFirstLampOn = false;
				}
				
				if (isSecondLampOn) {
					ledLamp220VWhite.off();
					isSecondLampOn = false;
				}
			} else {
				processFirstLamp();

				processSecondLamp();
			}
			
			timeGenerator.nextHalfHour();
		}
	}

	private boolean isItShoneOutside(double lux) {
		  return lux > DARK_IN_LUX;
	}
	
	void processFirstLamp() {
		if (!isFirstLampOn && ((timeGenerator.getHour() == 6 && timeGenerator.getMinute() == 0) || (timeGenerator.getHour() == 21 && timeGenerator.getMinute() == 0))) {
			ledLamp220VRed.on();
			isFirstLampOn = true;
		} else if (isFirstLampOn && ((timeGenerator.getHour() == 6 && timeGenerator.getMinute() == 30) || (timeGenerator.getHour() == 21 && timeGenerator.getMinute() == 30))) {
			ledLamp220VRed.off();
			isFirstLampOn = false;
		}
	}

	void processSecondLamp() {
		if (!isSecondLampOn && ((timeGenerator.getHour() == 6 && timeGenerator.getMinute() == 30) || (timeGenerator.getHour() > 6 && timeGenerator.getHour() < 21))) {
			ledLamp220VWhite.on();
			isSecondLampOn = true;
		} else if (isSecondLampOn && (timeGenerator.getHour() >= 21 || timeGenerator.getHour() < 6 || (timeGenerator.getHour() == 6 && timeGenerator.getMinute() < 30))) {
			ledLamp220VWhite.off();
			isSecondLampOn = false;
		}
	}

}
