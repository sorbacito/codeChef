package com.sorbac.codeChef.may14.lebalons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            TestCase myTestCase = readTestCase(input);
            //out.append(Integer.valueOf(myMain.computeStep(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader input) throws IOException {
        int[] myConfiguration = readInput(input, 2);
        List<Integer>[] myInput = new List[40];
        for (int i = 0; i < myConfiguration[0]; i++) {
            int[] myLine = readInput(input, 2);
            if (myInput[myLine[0]] == null) {
                myInput[myLine[0]] = new ArrayList<Integer>();
            }
            myInput[myLine[0]].add(myLine[1]);
        }
        return new TestCase(myConfiguration[1], myInput);
    }

    private static int[] readInput(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    public static class TestCase {
        private final int theMinColors;
        private final List<List<Integer>> thePrices;

        public TestCase(int theMinColors, List<Integer>[] thePrices) {
            this.theMinColors = theMinColors;
            this.thePrices = sumUp(thePrices);
        }

        private List<List<Integer>> sumUp(List<Integer>[] thePrices) {
            List<List<Integer>> myReturn = new ArrayList<List<Integer>>();
            for (List<Integer> myPrices : thePrices) {
                if (myPrices != null) {
                    myReturn.add(myPrices);
                }
            }
            return myReturn;
        }
    }
}
