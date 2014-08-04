package com.sorbac.codeChef.aug14.crawa;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] myInputs = readInput(input);
        for (long i = 0; i < myInputs[0]; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(myTestCase.getAnswer());
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        long[] myInput = readInput(aInput);
        return new TestCase(myInput[0], myInput[1]);
    }

    private static long[] readInput(BufferedReader input) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        long[] myOutput = new long[myInputs.length];
        for (int i = 0; i < myInputs.length; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    public static class TestCase {
        private final String theAnswer;

        public TestCase(long aX, long aY) {
            theAnswer = findAnswer(aX, aY);
        }

        private String findAnswer(long aX, long aY) {
            long maxY;
            long minY;
            if (aX > 0) {
                if ((aX >= aY - 1) && (aX >= 1 - aY)) {
                    return aX % 2 == 1 ? "YES" : "NO";
                } else {
                    return aY % 2 == 0 ? "YES" : "NO";
                }
            } else {
                if ((aX <= -aY) && (aX <= aY)) { // within left quarter
                    return aX % 2 == 0 ? "YES" : "NO";
                } else { // aX < -aY
                    return aY % 2 == 0 ? "YES" : "NO";
                }
            }
        }

        public String getAnswer() {
            return theAnswer;
        }
    }
}
