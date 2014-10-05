package com.sorbac.codeChef.oct14.chefgr;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (long i = 0; i < myInputs[0]; i++) {
            int[] myConfiguration = readInput(input);
            int[] myColumns = readInput(input);
            out.append(isEquallableColumns(myConfiguration[0], myConfiguration[1], myColumns) ? "Yes" : "No");
            out.newLine();
        }
        out.flush();
    }

    public static boolean isEquallableColumns(int aColumnsNumber, int aToAdd, int[] aColumnsHigh) {
        long[] myMaxValueAndSum = calculateMaxAndSum(aColumnsHigh);
        long myMax = myMaxValueAndSum[0];
        long mySum = myMaxValueAndSum[1];
        boolean myModullable = ((mySum + aToAdd) % aColumnsNumber) == 0;
        if (myModullable) {
            int myEqualHigh = (int) (mySum + aToAdd) / aColumnsNumber;
            return myEqualHigh >= myMax;
        }
        return false;
    }

    private static long[] calculateMaxAndSum(int[] aColumnsHigh) {
        int myMax = 0;
        long mySum = 0;
        for (int myColumnHigh : aColumnsHigh) {
            myMax = Math.max(myMax, myColumnHigh);
            mySum += myColumnHigh;
        }
        return new long[]{myMax, mySum};
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
