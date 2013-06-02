package com.pramati.problem;

/**
 * Utility functions
 * 
 * @author Dinesh S Gupta
 * 
 */
public class Utils {

	/**
	 * Rounds number up to 2 decimal places
	 * 
	 * @param num
	 *            to be rounded
	 * @return rounded number
	 */
	public static float roundOff2Digits(float num) {
		return Math.round(num * 100) / 100.0f;
	}

	/**
	 * Rounds number up to the nearest 0.05
	 * 
	 * @param num
	 *            to be rounded
	 * @return rounded number
	 */
	public static float roundOff2DigitsNearest05(float num) {
		int x = Math.round(num * 100);
		int u = x % 10;
		x = x / 10;

		if (u > 0 && u < 5) {
			u = 5;
		} else if (u > 5 && u <= 9) {
			x += 1;
			u = 0;
		}
		x = x * 10 + u;

		return x / 100.0f;
	}

	/**
	 * String representation of number such that if it contains number only up to 1 decimal place
	 * returned string will have 0 appended. So, 1.5 will be returned as 1.50 and 1.45 will be as
	 * 1.45.
	 * 
	 * @param f
	 *            input number
	 * @return String containing appended 0 if required
	 */
	public static String appendZero(float f) {
		f = roundOff2Digits(f);
		int i = Math.round(f * 100);
		if (i % 10 == 0) {
			return f + "0";
		} else {
			return f + "";
		}
	}

}
