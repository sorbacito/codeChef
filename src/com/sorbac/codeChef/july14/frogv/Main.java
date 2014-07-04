package com.sorbac.codeChef.july14.frogv;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int[] myConfiguration = readIntArray(input);
        final int[] myAxis = readIntArray(input);
        for (int i = 0; i < myConfiguration[2]; i++) {
            out.append(checkReach(myConfiguration[1], readIntArray(input), myAxis) ? "Yes" : "No");
            out.newLine();
        }
        out.flush();
    }

    private static boolean checkReach(int aDistance, int[] aInts, int[] aAxis) {
        return Math.abs(aAxis[aInts[0] - 1] - aAxis[aInts[1] - 1]) <= aDistance;
    }

    private static int[] readIntArray(BufferedReader aInput) throws IOException {
        final String[] myInput = aInput.readLine().split(" ");
        final int[] myConfiguration = new int[myInput.length];
        for (int i = 0; i < myInput.length; i++) {
            myConfiguration[i] = Integer.parseInt(myInput[i]);
        }
        return myConfiguration;
    }

}
