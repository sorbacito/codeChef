package com.sorbac.codeChef.sept14.rainbowb;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class MainTest {
	@Test
	public void testAll() throws Exception {
		for (int i = 0; i <= 1000000; i++) {
			final long myValue = Main.calculateRainbowNumber(i);
			if (i % 100000 == 0) {
				System.out.println(i + " : " + myValue);
			}
			assertThat(myValue, greaterThanOrEqualTo(0l));
		}
	}
}