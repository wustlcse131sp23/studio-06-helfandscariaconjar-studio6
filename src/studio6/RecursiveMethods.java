package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n==0) {
			return 0;
		}
		else {
			return Math.pow(.5, n) + geometricSum(n-1);
		}
		
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0 || p == 0) {
			return 0;
		}
		else if (p == 1 || q == 1) {
			return 1;
		}
		else {
			if (p > q) {
				if (p % q == 0) {
					return q;
				}
				else {
					return gcd(q, p % q);
				}
			}
			else {
				if (q % p == 0) {
					return p;
				}
				else {
					return gcd(p, q%p);
				}
			}
		}		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[]reversed = new int[array.length];
		if (array.length == 0) {
			reversed.equals(array);
			return reversed;
		}
		else if (array.length ==1) {
			reversed[0] = array[0];
			return reversed;
		}
		else {
			return helperReversed(array.length-1, 0, array, reversed);
		}		
	}
	
	public static int[] helperReversed(int i, int j, int[]array, int[]reversed) {
		reversed[j] = array[i];
		if (i > 0) {
			return helperReversed(i-1, j+1, array, reversed);
		}
		else {
			return reversed;
		}
	}

	
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius > radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter, yCenter, radius);
			
			circlesUponCircles(xCenter-radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter+radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter+radius, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter-radius, radius/3.0, radiusMinimumDrawingThreshold);
		}
		
		// FIXME
	}
}
