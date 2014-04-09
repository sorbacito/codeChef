package com.sorbac.codeChef.aprilChallenge.cnpiim;

import java.io.*;

public class Main {
    private static final int[] theResults = new int[1250 * 1250];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        final Main myMain = new Main();
        for (int i = 0; i < myNumberOfTestCases; i++) {
            out.append(Integer.valueOf(myMain.computeMatrices(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    int computeMatrices(int aTrace) {
        int myMatrices = 0;
        for (int i = 1; i < (aTrace + 1) / 2; i++) {
            myMatrices += getNumberOfMultiplications(i * (aTrace - i) - 1);
        }
        if (aTrace % 2 == 0) {
            return 2 * myMatrices + getNumberOfMultiplications((aTrace / 2) * (aTrace / 2) - 1);
        } else {
            return 2 * myMatrices;
        }
    }

    int getNumberOfMultiplications(int aNumber) {
        int mySum = 0;
        if (theResults[aNumber] == 0) {
            final int myTreshold = (aNumber + 1) / 2;
            for (int i = 1; i <= myTreshold; i++) {
                mySum += aNumber / i;
            }
            mySum += aNumber - myTreshold;
            theResults[aNumber] = mySum;
            return mySum;
        } else {
            return theResults[aNumber];
        }
    }
}
