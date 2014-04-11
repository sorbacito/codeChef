package com.sorbac.codeChef.aprilChallenge.tangdiv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 *  Copyright 1999,2001 Clearstream Services, Luxembourg.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information
 *  of Clearstream Services ("Confidential Information").  You
 *  shall not disclose such Confidential Information and shall use
 *  it only in accordance with the terms of the license agreement
 *  you entered into with CS.
 *
 *  @author: Stanislav Kovalcin (ky234) |HUB team|
 *  Date: 10/04/14
 *  Time: 10:04
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.valueOf(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            int[] myConfiguration = readNumbers(input, 3);
            Pair[] myOriginalPairs = readPairs(input, myConfiguration[1]);
            Pair[] myChangedPairs = readPairs(input, myConfiguration[2]);
            //out.append(new Case(myConfiguration[0], myOriginalPairs, myChangedPairs).getAnswer());
            out.newLine();
        }
        out.flush();
    }

    private static Pair[] readPairs(BufferedReader aInput, int aNumberOfOriginalPairs)
            throws IOException {
        final Pair[] myOriginalPairs = new Pair[aNumberOfOriginalPairs];
        for (int j = 0; j < aNumberOfOriginalPairs; j++) {
            int[] myPair = readNumbers(aInput, 2);
            myOriginalPairs[j] = new Pair(myPair[0], myPair[1]);
        }
        return myOriginalPairs;
    }

    private static int[] readNumbers(BufferedReader input, int aNumberOfValues) throws IOException {
        String myLine = input.readLine();
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = myLine.charAt(i) - '0';
        }
        return myOutput;
    }

    private static class Pair {
        private final int theLeft;
        private final int theRight;

        private Pair(int aLeft, int aRight) {
            theLeft = aLeft;
            theRight = aRight;
        }

        public int getLeft() {
            return theLeft;
        }

        public int getRight() {
            return theRight;
        }
    }


    private static class Case {


        public Case(int aSegments, Pair[] aOriginalPairs, Pair[] aChangedPairs) {

        }
    }
}
