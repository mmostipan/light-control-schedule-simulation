package org.mykhailomi.light_control_schedule_simulation.linear_interpolation;

public interface LinearInterpolation {
	
	double calculate(LICoordinates coordinates, double x) throws IllegalArgumentException;

}
