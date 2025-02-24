package org.mykhailomi.simulations.function.linear_interpolation;

public interface LinearInterpolation {
	
	double calculate(LICoordinates coordinates, double x) throws IllegalArgumentException;

}
