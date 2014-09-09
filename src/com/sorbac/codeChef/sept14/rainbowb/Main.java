package com.sorbac.codeChef.sept14.rainbowb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static final int MODULO = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int myInput = Integer.parseInt(input.readLine());
		out.append(String.valueOf(calculateRainbowNumber(myInput)));
		out.flush();
	}

	public static long calculateRainbowNumber(int aInput) {
		long myReturn = 1;
		int myUpper = ((aInput + 1) / 2) - 1;
		if (myUpper >= 6) {
			List<Integer> myNumbs = new ArrayList<Integer>();
			for (int i = 0; i < 6; i++) {
				myNumbs.add(myUpper - i);
			}
			myNumbs = changeNumbers(myNumbs);
			for (Integer myNumb : myNumbs) {
				myReturn = (myReturn * myNumb) % MODULO;
			}
			return myReturn;
		} else {
			return 0l;
		}
	}

	public static List<Integer> changeNumbers(List<Integer> aNumbs) {
		Integer myCount2 = 4;
		Integer myCount3 = 2;
		Integer myCount5 = 1;
		List<Integer> myNewNumbs = new ArrayList<Integer>();
		for (Integer aNumb : aNumbs) {
			while (aNumb % 2 == 0 && myCount2 > 0) {
				aNumb /= 2;
				myCount2--;
			}
			while (aNumb % 3 == 0 && myCount3 > 0) {
				aNumb /= 3;
				myCount3--;
			}
			while (aNumb % 5 == 0 && myCount5 > 0) {
				aNumb /= 5;
				myCount5--;
			}
			myNewNumbs.add(aNumb);
		}
		return myNewNumbs;
	}
}
