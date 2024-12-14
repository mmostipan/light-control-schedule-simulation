package org.mykhailomi.simulators.generator.illuminance;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mykhailomi.simulators.function.linearinterpolation.LICoordinates;
import org.mykhailomi.simulators.function.linearinterpolation.LinearInterpolation;
import org.mykhailomi.simulators.function.linearinterpolation.LinearInterpolationimpl;

public class SimpleIlluminanceGeneratorImpl implements SimpleIlluminanceGenerator {
	
	public static int binarySearchLeftmostHour(int[] array, int n) {
		int l = 0;
		int r = array.length;
		
		while (l < r) {
			int m = (l + r) / 2;
			
			if (array[m] == n) { return m; }
			
			if (array[m] < n) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		
		return --l;
	}
	
	private final LinearInterpolation linearInterpolation;
	
	private final Map<Integer, LICoordinates> coordinates;
	
	public SimpleIlluminanceGeneratorImpl() {
		linearInterpolation = new LinearInterpolationimpl();
		
		coordinates = new LinkedHashMap<>();
		// add coordinates
	}
	
	@Override
	public int get(int hour) {
		int[] hours = coordinates.keySet().stream().mapToInt(Integer::intValue).toArray();
		
		int index = binarySearchLeftmostHour(hours, hour);
		
		if (!coordinates.containsKey(hours[index])) { throw new IllegalArgumentException("coordinates not found by key."); }
		
		double luxLog = linearInterpolation.calculate(coordinates.get(hours[index]), hour);
		
		return 	(int) Math.pow(10, luxLog);
	}

}
