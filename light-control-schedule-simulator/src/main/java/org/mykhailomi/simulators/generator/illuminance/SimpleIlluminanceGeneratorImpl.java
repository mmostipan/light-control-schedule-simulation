package org.mykhailomi.simulators.generator.illuminance;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mykhailomi.simulators.function.linearinterpolation.LICoordinates;
import org.mykhailomi.simulators.function.linearinterpolation.LinearInterpolation;
import org.mykhailomi.simulators.function.linearinterpolation.LinearInterpolationimpl;
import org.mykhailomi.simulators.search.SearchUtils;

public class SimpleIlluminanceGeneratorImpl implements SimpleIlluminanceGenerator {
	private static final Logger LOGGER = LogManager.getLogger(SimpleIlluminanceGeneratorImpl.class);

	private final LinearInterpolation linearInterpolation;
	
	private final Map<Integer, LICoordinates> coordinates;
	
	public SimpleIlluminanceGeneratorImpl() {
		linearInterpolation = new LinearInterpolationimpl();
		
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
		
		if (!(hour >=0 && hour <= 24)) { throw new IllegalArgumentException("hour is wrong."); }
		
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
