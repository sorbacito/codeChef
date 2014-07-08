package com.sorbac.codeChef.july14.retpo;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int myTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myTestCases; i++) {
            out.append(String.valueOf(calculateSteps(readIntArray(input))));
            out.newLine();
        }
        out.flush();
    }

    public static long calculateSteps(long[] aXY) {
        long aX = aXY[0];
        long aY = aXY[1];
        if (aX >= 0) {
            if (aY >= 0) {
                return calculateSteps(aX, aY);
            } else {
                return 1 + calculateSteps(-(aY + 1), aX);
            }
        } else {
            if (aY >= 1) {
                return 1 + calculateSteps(aY - 1, -aX);
            } else {
                return 1 + calculateSteps(-(aY + 1), -aX);
            }
        }
    }

    private static long calculateSteps(long aAX, long aAY) {
        long myDiag = Math.min(aAX, aAY);
        long myRest = aAX - myDiag == 0 ? aAY - myDiag : aAX - myDiag;
        long myRestEven = myRest / 2;
        long myRestOdd = (myRest + 1) / 2;
        if (aAX > aAY) {
            return 2 * myDiag + 3 * myRestOdd + myRestEven;
        } else {
            return 2 * myDiag + myRestOdd + 3 * myRestEven;
        }
    }

    private static long[] readIntArray(BufferedReader aInput) throws IOException {
        final String[] myInput = aInput.readLine().split(" ");
        final long[] myConfiguration = new long[myInput.length];
        for (int i = 0; i < myInput.length; i++) {
            myConfiguration[i] = Long.parseLong(myInput[i]);
        }
        return myConfiguration;
    }

}
