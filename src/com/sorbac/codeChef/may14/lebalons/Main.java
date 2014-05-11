package com.sorbac.codeChef.may14.lebalons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int COLORS = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(String.format("%.9f", myTestCase.calculate()));
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader input) throws IOException {
        int[] myConfiguration = readInput(input, 2);
        List<Integer>[] myInput = new List[COLORS];
        for (int i = 0; i < myConfiguration[0]; i++) {
            int[] myLine = readInput(input, 2);
            if (myInput[myLine[0] - 1] == null) {
                myInput[myLine[0] - 1] = new ArrayList<Integer>();
            }
            myInput[myLine[0] - 1].add(myLine[1]);
        }
        List<List<Integer>> myFinalInput = new ArrayList<List<Integer>>();
        for (int i = 0; i < COLORS; i++) {
            if (myInput[i] != null) {
                myFinalInput.add(myInput[i]);
            }
        }
        return new TestCase(myConfiguration[1], myFinalInput);
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
        private long[] theCounts;

        public TestCase(int aMinColors, List<List<Integer>> aPrices) {
            theMinColors = aMinColors;
            thePrices = aPrices;
            theCounts = fillCounts(aPrices, theMinColors);
        }

        public static long[] fillCounts(List<List<Integer>> aPrices, int theMinColors) {
            long[] myReturn = new long[2];
            List<List<Integer>> myPricesWith = new ArrayList<List<Integer>>();
            List<List<Integer>> myPricesWithout = new ArrayList<List<Integer>>();
            myPricesWith.addAll(aPrices);
            myPricesWith.remove(aPrices.get(0));
            myPricesWithout.addAll(aPrices);
            myPricesWithout.remove(aPrices.get(0));
            myReturn[0] = ((long) Math.pow(2, aPrices.get(0).size()) - 1)
                    * calculateCounts(myPricesWith, theMinColors - 1);
            myReturn[1] = calculateCounts(myPricesWithout, theMinColors);
            return myReturn;
        }

        private static long calculateCounts(List<List<Integer>> aPrices, int aMinColors) {
            if (aMinColors <= 0) {
                long myCount = 0;
                for (List<Integer> myPrices : aPrices) {
                    myCount += myPrices.size();
                }
                return (long) Math.pow(2, myCount);
            }
            if (aPrices.size() == 0) {
                return 0;
            }
            if (aPrices.size() < aMinColors) {
                return 0;
            }
            List<List<Integer>> myPricesWith = new ArrayList<List<Integer>>();
            List<List<Integer>> myPricesWithout = new ArrayList<List<Integer>>();
            myPricesWith.addAll(aPrices);
            myPricesWith.remove(aPrices.get(0));
            myPricesWithout.addAll(aPrices);
            myPricesWithout.remove(aPrices.get(0));
            return ((long) Math.pow(2, aPrices.get(0).size()) - 1)
                    * calculateCounts(myPricesWith, aMinColors - 1)
                    + calculateCounts(myPricesWithout, aMinColors);
        }

        public double calculate() {
            double myReturn = 0;
            double myCoefficient = (theCounts[0] * Math.pow(2, thePrices.get(0).size() - 1))
                    / ((theCounts[0] + theCounts[1]) * (Math.pow(2, thePrices.get(0).size()) - 1));
            for (List<Integer> myPrices : thePrices) {
                for (Integer myPrice : myPrices) {
                    myReturn += myPrice;
                }
            }
            myReturn *= myCoefficient;
            return myReturn;
        }
    }
}
