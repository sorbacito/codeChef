package com.sorbac.codeChef.may14.rrstone;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] myConfiguration = readInputWithMax(input, 2);
        long[] myInput = readInputWithMax(input, (int) myConfiguration[0]);
        long myCounter = 0;
        long[] myResults = computeResult(myInput, myConfiguration[1]);
        for (long myResult : myResults) {
            myCounter++;
            out.append(Long.valueOf(myResult).toString());
            if (myCounter != myInput.length) {
                out.append(" ");
            }
        }
        out.flush();
    }

    public static long[] computeResult(long[] myInput, long myTurns) {
        long myMaximum = myInput[myInput.length - 2];
        long myMinimum = myInput[myInput.length - 1];

        long[] myResult = new long[myInput.length - 2];
        if (myTurns == 0) {
            for (int i = 0; i < myInput.length - 2; i++) {
                myResult[i] = myInput[i];
            }
            return myResult;
        }
        for (int i = 0; i < myInput.length - 2; i++) {
            myResult[i] = myMaximum - myInput[i];
        }

        if (myTurns % 2 == 0) {
            for (int i = 0; i < myInput.length - 2; i++) {
                myResult[i] = myMaximum - myMinimum - myResult[i];
            }
        }

        return myResult;
    }

    private static long[] readInputWithMax(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        long[] myOutput = new long[aNumberOfValues + 2];
        long myMaximum = Long.MIN_VALUE;
        long myMinimum = Long.MAX_VALUE;
        for (int i = 0; i < aNumberOfValues; i++) {
            long myValue = Long.parseLong(myInputs[i]);
            myOutput[i] = myValue;
            if (myValue > myMaximum) {
                myMaximum = myValue;
            }
            if (myValue < myMinimum) {
                myMinimum = myValue;
            }
        }
        myOutput[aNumberOfValues] = myMaximum;
        myOutput[aNumberOfValues + 1] = myMinimum;
        return myOutput;
    }
}
