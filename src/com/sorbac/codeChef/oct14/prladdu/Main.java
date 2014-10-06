package com.sorbac.codeChef.oct14.prladdu;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (long i = 0; i < myInputs[0]; i++) {
            out.append(String.valueOf(calculateDiff(input)));
            out.newLine();
        }
        out.flush();
    }

    private static long calculateDiff(BufferedReader aInput) throws IOException {
        aInput.readLine();
        String[] myInts = aInput.readLine().split(" ");
        long myActualSize = 0;
        long myActualSum = 0;
        for (String myInt : myInts) {
            if (myActualSize >= 0) {
                myActualSum += myActualSize;
            } else {
                myActualSum -= myActualSize;
            }
            myActualSize += Long.parseLong(myInt);
        }
        return myActualSum;
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
