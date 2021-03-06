package com.sorbac.codeChef.oct14.prladdu;

import java.io.*;

public class MainSuccessful {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (long i = 0; i < myInputs[0]; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(String.valueOf(myTestCase.calculateDiff()));
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        aInput.readLine();
        String[] myInts = aInput.readLine().split(" ");
        long[] myLongs = new long[myInts.length];
        for (int i = 0; i < myInts.length; i++) {
            myLongs[i] = Long.parseLong(myInts[i]);
        }
        return new TestCase(myLongs);
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
        private final long[] theVillages;

        public TestCase(long[] aVillages) {
            theVillages = aVillages;
        }

        public long calculateDiff() {
            long myActualSize = 0;
            long myActualSum = 0;
            for (long myVillage : theVillages) {
                myActualSum += Math.abs(myActualSize);
                myActualSize += myVillage;
            }
            return myActualSum;
        }
    }
}
