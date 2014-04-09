package com.sorbac.codeChef.aprilChallenge.adigit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final int[] theResults;

    public Main(int[] aNumbers) {
        theResults = calculateResults(aNumbers);
    }

    private int[] calculateResults(int[] aNumbers) {
        final int[] myCount = new int[10];
        final int[] myResult = new int[aNumbers.length];
        for (int i = 0; i < aNumbers.length; i++) {
            myResult[i] = calculateSum(myCount, aNumbers[i]);
            myCount[aNumbers[i]]++;
        }
        return myResult;
    }

    private int calculateSum(int[] aCount, int aNumber) {
        int mySum = 0;
        for (int i = 0; i < aCount.length; i++) {
            if (i - aNumber > 0) {
                mySum += aCount[i] * (i - aNumber);
            } else {
                mySum += aCount[i] * (aNumber - i);
            }
        }
        return mySum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myNumberOfTestCases = readInput(input, 2);
        final Main myMain = new Main(readNumbers(input, myNumberOfTestCases[0]));
        for (int i = 0; i < myNumberOfTestCases[1]; i++) {
            out.append(Integer.valueOf(myMain.computeStep(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    int computeStep(int i) {
        return theResults[i - 1];
    }

    private static int[] readInput(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    private static int[] readNumbers(BufferedReader input, int aNumberOfValues) throws IOException {
        String myLine = input.readLine();
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = myLine.charAt(i) - '0';
        }
        return myOutput;
    }
}
