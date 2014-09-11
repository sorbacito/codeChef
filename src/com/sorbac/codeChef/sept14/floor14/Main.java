package com.sorbac.codeChef.sept14.floor14;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] myInputs = readInput(input);
		for (long i = 0; i < myInputs[0]; i++) {
			int[] myInput = readInput(input);
			TestCase myTestCase = readTestCase(myInput[0], myInput[1]);
			out.append(Integer.valueOf(myTestCase.getResult()).toString());
            out.newLine();
        }
        out.flush();
	}

	private static TestCase readTestCase(int aArrayCount, int aModulo) {
		return new TestCase(aArrayCount, aModulo);
	}

	private static int[] readInput(BufferedReader input) throws IOException {
		String[] myInputs = input.readLine().split(" ");
		int[] myOutput = new int[myInputs.length];
		for (int i = 0; i < myInputs.length; i++) {
			myOutput[i] = Integer.parseInt(myInputs[i]);
		}
		return myOutput;
	}

	public static class TestCase {
		private final int theArrayCount;
		private final int theModulo;
        private final int[] theModuloArray4;
        private final int[] theModuloArray2;
        private final int theResult;

		public TestCase(int aArrayCount, int aModulo) {
			theArrayCount = aArrayCount;
			theModulo = aModulo;
            theModuloArray4 = new int[aArrayCount > aModulo ? aModulo : aArrayCount];
            theModuloArray2 = new int[aArrayCount > aModulo ? aModulo : aArrayCount];
            theResult = calculate();
        }

		public int getResult() {
			return theResult;
		}

		private int calculate() {
			int myResult = 0;
			for (int i = 1; i <= theArrayCount; i++) {
				/*if ((theArrayCount / i) == 1) {
					return myResult + countOnes(i);
				}*/
                int myRem = i % theModulo;
                if (theModuloArray4[myRem] == 0) {
                    int myRem2 = (int) ((long) myRem * (long) myRem % theModulo);
                    if (myRem2 < 0) {
                        System.out.println("myRem : " + myRem);
                        System.out.println("myRem2 : " + myRem2);
                    }
                    if (theModuloArray2[myRem2] == 0) {
                        theModuloArray2[myRem2] = (myRem * myRem % theModulo) + 1;
                    }
                    theModuloArray4[myRem] = theModuloArray2[myRem2];
                }
                myResult += (theModuloArray4[myRem] - 1) * (theArrayCount / i);
                //myResult %= theModulo;
            }
            return myResult;
		}

		private int countOnes(int aI) {
			int myOnesSum = 0;
			int myDifference = theArrayCount - aI;
			for (int i = 0; i < theArrayCount; i++) {
                myOnesSum += theModuloArray4[(aI + i) % theModulo] * (myDifference / theModulo) % theModulo;
            }
            return myOnesSum;
		}

		private static int[] createModuloArray(int i) {
			int[] myModulo = new int[i];
			for (int j = 0; j < i; j++) {
				myModulo[j] = (((((j * j) % i) * j) % i) * j) % i;
			}
			return myModulo;
		}


	}
}
