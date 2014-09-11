package com.sorbac.codeChef.sept14.cheflr;

import java.io.*;
import java.math.BigDecimal;

public class Main {

	public static final long MODULO = (long) Math.pow(10, 9) + 7;
	public static final long BIG_MODULO = 3 * MODULO;
	public static final int SMALL_LEVEL = 16;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int myInputs = Integer.valueOf(input.readLine());
		for (long i = 0; i < myInputs; i++) {
			String myInput = input.readLine().trim();
			out.append(String.valueOf(getPosition(myInput)));
			out.newLine();
		}
		out.flush();
	}

	public static long getPosition(String myInput) {
		return myInput.length() == 0 ? 1 : calculateNodeNumber(calculateNodePosition(myInput));
	}

	public static long calculateNodeNumber(long[] aPosition) {
		long myLevel = aPosition[0];
		long myNumbers = 1;
		if (myLevel % 2 == 1) {
			myLevel--;
			/*while (myLevel >= SMALL_LEVEL) {
				myNumbers = (myNumbers * _2_32_AFTER_MODULO) % BIG_MODULO;
				myLevel -= SMALL_LEVEL;
			}*/
			myNumbers = new BigDecimal(2).pow((int) myLevel).subtract(BigDecimal.ONE).multiply(
					new BigDecimal(4)).divide(new BigDecimal(3)).remainder(new BigDecimal(MODULO)).intValue();
			//myNumbers = ((4 * (myNumbers * (long) Math.pow(2, myLevel) - 1)) / 3) % MODULO;
		} else {
			/*while (myLevel >= SMALL_LEVEL) {
				myNumbers = (myNumbers * _2_32_AFTER_MODULO) % BIG_MODULO;
				myLevel -= SMALL_LEVEL;
			}*/
			myNumbers = new BigDecimal(2).pow((int) myLevel).subtract(BigDecimal.ONE).multiply(
					new BigDecimal(2)).divide(new BigDecimal(3)).subtract(BigDecimal.ONE).remainder(
					new BigDecimal(MODULO)).intValue();
			//myNumbers = (((2 *(myNumbers * (long) Math.pow(2, myLevel) - 1)) / 3) - 1) % MODULO;
		}
		return (myNumbers + 2 * aPosition[1]) % MODULO;
	}

	public static long[] calculateNodePosition(String aInput) {
		long myIndex = 1;
		for (char myChar : aInput.toCharArray()) {
			if (myChar == 'l') {
				myIndex = 2 * (myIndex - 1) + 1;
			} else {
				myIndex = 2 * (myIndex - 1) + 2;
			}
		}
		return new long[]{aInput.length(), myIndex};
	}
}
