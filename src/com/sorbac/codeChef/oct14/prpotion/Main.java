package com.sorbac.codeChef.oct14.prpotion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        String[] myInts = aInput.readLine().split(" ");
        int myDivisions = Integer.parseInt(myInts[myInts.length - 1]);
        long myRedMax = 0;
        long myGreenMax = 0;
        long myBlueMax = 0;
        String[] myRed = aInput.readLine().split(" ");
        String[] myGreen = aInput.readLine().split(" ");
        String[] myBlue = aInput.readLine().split(" ");
        for (String myLong : myRed) {
            myRedMax = Math.max(myRedMax, Long.parseLong(myLong));
        }
        for (String myLong : myGreen) {
            myGreenMax = Math.max(myGreenMax, Long.parseLong(myLong));
        }
        for (String myLong : myBlue) {
            myBlueMax = Math.max(myBlueMax, Long.parseLong(myLong));
        }
        List<Long> myMaxs = new ArrayList<Long>(3);
        myMaxs.add(myRedMax);
        myMaxs.add(myGreenMax);
        myMaxs.add(myBlueMax);
        Collections.sort(myMaxs);
        for (int i = 0; i < myDivisions; i++) {
            long myMax = myMaxs.get(2) / 2;
            myMaxs.remove(2);
            myMaxs.add(2, myMax);
            Collections.sort(myMaxs);
        }
        return myMaxs.get(2);
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
