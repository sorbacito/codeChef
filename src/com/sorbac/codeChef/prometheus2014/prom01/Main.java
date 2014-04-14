package com.sorbac.codeChef.prometheus2014.prom01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<long[]> myInputs = new ArrayList<long[]>();
        while (true) {
            long[] myInput = readNumbers(input, 2);
            if (isEndSequence(myInput)) {
                break;
            }
            myInputs.add(myInput);
        }
        outputThem(myInputs);
    }

    public static void outputThem(List<long[]> aInputs) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long[] myIn : aInputs) {
            out.append(Long.valueOf(numberOfPositions(myIn)).toString());
            out.newLine();
        }
        out.flush();
    }

    public static long numberOfPositions(long[] aInput) {
        long myA = aInput[0];
        long myB = aInput[1];
        if (aInput[0] < aInput[1]) {
            myA = aInput[1];
            myB = aInput[0];
        }
        long mySum = myA * myB * ((myA - 1) + (myB - 1)); // vertical and horizontal
        mySum += 2 * ((myA - myB + 1) * myB * (myB - 1) + 2 * (countPartialDiag(myB - 1)));
        return mySum;
    }

    public static long countPartialDiag(long aNumber) {
        long mySum = 0;
        for (long i = 2; i <= aNumber; i++) {
            mySum += i * (i - 1);
        }
        return mySum;
    }

    private static boolean isEndSequence(long[] aInput) {
        return aInput[0] == 0 && aInput[1] == 0;
    }

    private static long[] readNumbers(BufferedReader input, int aNumberOfValues) throws IOException {
        String myLine = input.readLine();
        long[] myOutput = new long[aNumberOfValues];
        String[] myNumbers = myLine.split(" ");
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Long.valueOf(myNumbers[i]);
        }
        return myOutput;
    }
}
