package com.sorbac.codeChef.sept14.rotation;

import java.io.*;

public class Main {
	private static int[] theArray;
	private static int theIntsNumber;
	private static int thePosition;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] myInputs = readInput(input);
		theIntsNumber = myInputs[0];
		theArray = readInput(input);
		thePosition = 0;
		for (long i = 0; i < myInputs[1]; i++) {
			String[] myInput = input.readLine().split(" ");
			final String myCommand = myInput[0];
			final Integer myShift = Integer.valueOf(myInput[1]);
			if (myCommand.equalsIgnoreCase("C")) {
				moveClockwise(myShift);
			} else if (myCommand.equalsIgnoreCase("A")) {
				moveAnticlockwise(myShift);
			} else {
				out.append(queryValueAtPosition(myShift));
				out.newLine();
			}
		}
		out.flush();
	}

	private static void moveClockwise(int aShift) {
		thePosition = (thePosition + aShift) % theIntsNumber;
	}

	private static void moveAnticlockwise(int aShift) {
		thePosition = (thePosition + theIntsNumber - aShift) % theIntsNumber;
	}

	private static String queryValueAtPosition(Integer aShift) {
		return String.valueOf(theArray[(thePosition + theIntsNumber + aShift - 1) % theIntsNumber]);
	}

	private static int[] readInput(BufferedReader input) throws IOException {
		String[] myInputs = input.readLine().split(" ");
		int[] myOutput = new int[myInputs.length];
		for (int i = 0; i < myInputs.length; i++) {
			myOutput[i] = Integer.parseInt(myInputs[i]);
		}
		return myOutput;
	}
}
