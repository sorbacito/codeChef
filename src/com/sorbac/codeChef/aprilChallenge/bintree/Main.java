package com.sorbac.codeChef.aprilChallenge.bintree;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            out.append(Integer.valueOf(findMinPath(readCase(input))).toString());
            out.newLine();
        }
        out.flush();
    }

    static int findMinPath(int[] aNodes) {
        int myFirstNode = aNodes[0];
        int mySecondNode = aNodes[1];
        int myFirstPowerOf2 = binlog(myFirstNode);
        int mySecondPowerOf2 = binlog(mySecondNode);
        int myPowerDifference = myFirstPowerOf2 - mySecondPowerOf2;
        int myLenght = Math.abs(myPowerDifference);
        if (myPowerDifference > 0) {
            myFirstNode = (int) (myFirstNode / Math.pow(2, myPowerDifference));
        } else {
            mySecondNode = (int) (mySecondNode / Math.pow(2, -myPowerDifference));
        }
        while (myFirstNode != mySecondNode) {
            myFirstNode /= 2;
            mySecondNode /= 2;
            myLenght += 2;
        }
        return myLenght;
    }

    public static int binlog(int bits) // returns 0 for bits=0
    {
        int log = 0;
        if ((bits & 0xffff0000) != 0) {
            bits >>>= 16;
            log = 16;
        }
        if (bits >= 256) {
            bits >>>= 8;
            log += 8;
        }
        if (bits >= 16) {
            bits >>>= 4;
            log += 4;
        }
        if (bits >= 4) {
            bits >>>= 2;
            log += 2;
        }
        return log + (bits >>> 1);
    }

    private static int[] readCase(BufferedReader input) throws IOException {
        String[] myInput = input.readLine().trim().split(" ");

        return new int[]{Integer.parseInt(myInput[0]), Integer.parseInt(myInput[1])};
    }
}
