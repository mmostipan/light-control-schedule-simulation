package org.mykhailomi.simulators.function.linearinterpolation;

public interface LinearInterpolation {
	
	double calculate(LICoordinates coordinates, double x) throws IllegalArgumentException;

}
