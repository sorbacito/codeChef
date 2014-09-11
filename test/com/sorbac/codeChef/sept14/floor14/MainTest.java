package com.sorbac.codeChef.sept14.floor14;

import org.testng.annotations.Test;

public class MainTest {
	@Test
	public void testSpeed() throws Exception {
		for (int i = 1; i < 3000; i++) {
			new Main.TestCase(1000000, 100 * i).getResult();
			if (i % 100 == 0) {
				System.out.println(i);
			}
		}
	}


}