package org.mykhailomi.simulators.function.linearinterpolation;

public class LinearInterpolationimpl implements LinearInterpolation {

	@Override
	public double calculate(LICoordinates coordinates, double x)throws IllegalArgumentException {
		if (coordinates == null) { throw new IllegalArgumentException("coordinates cannot be null."); }

		return coordinates.getY1() + ((x - coordinates.getX1()) * (coordinates.getY2() - coordinates.getY1())) / (coordinates.getX2() - coordinates.getX1());
	}

}
