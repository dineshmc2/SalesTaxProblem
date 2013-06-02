package com.pramati.problem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pramati.problem.Utils;

public class UtilsTest {

	@Test
	public void testRoundOff2Digits() {
		assertTrue(Utils.roundOff2Digits(1.573f) == 1.57f);
		assertTrue(Utils.roundOff2Digits(1.575f) == 1.58f);
		assertTrue(Utils.roundOff2Digits(1.50f) == 1.50f);
		assertTrue(Utils.roundOff2Digits(1.55f) == 1.55f);
	}

	@Test
	public void testRoundOff2DigitsNearest05() {
		assertTrue(Utils.roundOff2DigitsNearest05(1.555f) == 1.60f);
		assertTrue(Utils.roundOff2DigitsNearest05(1.545f) == 1.55f);
		assertTrue(Utils.roundOff2DigitsNearest05(1.50f) == 1.50f);
		assertTrue(Utils.roundOff2DigitsNearest05(1.55f) == 1.55f);
	}

	@Test
	public void testAppendZero() {
		assertTrue(Utils.appendZero(1.5f).equals("1.50"));
		assertTrue(Utils.appendZero(1).equals("1.00"));
		assertTrue(Utils.appendZero(1.55f).equals("1.55"));
		assertTrue(Utils.appendZero(1.555f).equals("1.56"));
		assertTrue(Utils.appendZero(1.0f).equals("1.00"));
	}
}
