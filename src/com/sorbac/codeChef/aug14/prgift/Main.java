package com.sorbac.codeChef.aug14.prgift;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (int i = 0; i < myInputs[0]; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(myTestCase.getAnswer());
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        int[] myConfiguration = readInput(aInput);
        int[] myArray = readInput(aInput);
        return new TestCase(myArray, myConfiguration[1]);
    }

    private static int[] readInput(BufferedReader input) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[myInputs.length];
        for (int i = 0; i < myInputs.length; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    public static class TestCase {
        private final String theAnswer;

        public TestCase(int[] aArray, int aMinCount) {
            final long myEvenNumbers = countEvenNumbers(aArray);
            if (aMinCount == 0) {
                theAnswer = aArray.length > myEvenNumbers ? "YES" : "NO";
            } else {
                theAnswer = myEvenNumbers >= aMinCount ? "YES" : "NO";
            }
        }

        private int countEvenNumbers(int[] aArray) {
            int myCount = 0;
            for (int myNumber : aArray) {
                if (myNumber % 2 == 0) {
                    myCount++;
                }
            }
            return myCount;
        }

        public String getAnswer() {
            return theAnswer;
        }
    }
}
