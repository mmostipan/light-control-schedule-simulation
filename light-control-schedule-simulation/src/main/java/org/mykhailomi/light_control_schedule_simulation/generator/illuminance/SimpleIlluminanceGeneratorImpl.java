package org.mykhailomi.light_control_schedule_simulation.generator.illuminance;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mykhailomi.light_control_schedule_simulation.linear_interpolation.LICoordinates;
import org.mykhailomi.light_control_schedule_simulation.linear_interpolation.LinearInterpolation;
import org.mykhailomi.light_control_schedule_simulation.search.SearchUtils;
import org.springframework.stereotype.Component;

@Component("illuminanceGenerator")
public class SimpleIlluminanceGeneratorImpl implements SimpleIlluminanceGenerator {
	private static final Logger LOGGER = LogManager.getLogger(SimpleIlluminanceGeneratorImpl.class);

	private final LinearInterpolation linearInterpolation;
	
	private final Map<Integer, LICoordinates> coordinates;
	
	public SimpleIlluminanceGeneratorImpl(LinearInterpolation linearInterpolation) {
		this.linearInterpolation = linearInterpolation;
		
		coordinates = new LinkedHashMap<>();
		coordinates.put(0, new LICoordinates(0, -3.1, 3, -3.1));
		coordinates.put(3, new LICoordinates(3, -3.1, 4, -3.3));
		coordinates.put(4, new LICoordinates(4, -3.3, 6, 3));
		coordinates.put(6, new LICoordinates(6, 3, 8, 4.5));
		coordinates.put(8, new LICoordinates(8, 4.5, 12, 5.2));
		coordinates.put(12, new LICoordinates(12, 5.2, 16, 4.5));
		coordinates.put(16, new LICoordinates(16, 4.5, 18, 3.5));
		coordinates.put(18, new LICoordinates(18, 3.5, 20, -3.1));
		coordinates.put(20, new LICoordinates(20, -3.1, 24, -3.2));
	}
	
	@Override
	public double get(int hour) throws IllegalArgumentException {
		LOGGER.debug("hour={}", hour);
		
		if (hour < 0 || hour > 23) { throw new IllegalArgumentException("hour must be in range from 0 to 23."); }
		
		int[] hours = coordinates.keySet().stream().mapToInt(Integer::intValue).toArray();
		
		int index = SearchUtils.binarySearchLeftmostHour(hours, hour);
		
		LOGGER.debug("index={}", index);
		
		LOGGER.debug("hours[index]={}", hours[index]);
		
		if (!coordinates.containsKey(hours[index])) { throw new IllegalArgumentException("coordinates not found by key."); }
		
		double luxLog = linearInterpolation.calculate(coordinates.get(hours[index]), hour);
		
		LOGGER.debug("luxLog={}", luxLog);
		
		return Math.pow(10, luxLog);
	}

}
