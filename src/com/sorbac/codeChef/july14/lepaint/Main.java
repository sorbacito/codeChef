package com.sorbac.codeChef.july14.lepaint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int myTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myTestCases; i++) {
            final TestCase myConfiguration = readTestCase(input);
            //out.append(checkReach(readIntArray(input), myPositions, myAxises) ? "Yes" : "No");
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        final int[] myConfiguration = readIntArray(aInput);
        final List<int[]> myColoring = new ArrayList<int[]>();
        for (int i = 0; i < myConfiguration[2]; i++) {
            myColoring.add(readIntArray(aInput));
        }
        return new TestCase(myConfiguration[1], myColoring, myConfiguration[0]);
    }

    private static int[] readIntArray(BufferedReader aInput) throws IOException {
        final String[] myInput = aInput.readLine().split(" ");
        final int[] myArray = new int[myInput.length];
        for (int i = 0; i < myInput.length; i++) {
            myArray[i] = Integer.parseInt(myInput[i]);
        }
        return myArray;
    }

    public static class TestCase {
        private final int theColor;
        private final int[] theColorsCount;
        private final int[][] theRepaintColors;
        private final double[] theExpectedValue;

        public TestCase(int aColor, List<int[]> aColoring, int aNumberOfObjects) {
            theColor = aColor;
            theColorsCount = countColorsCount(aColoring, aNumberOfObjects);
            theRepaintColors = createRepaintColors(aColor);
            theExpectedValue = createExpectedValues(aColor, getMax(theColorsCount));
        }

        private double[] createExpectedValues(int aColor, int aMax) {
            final double[] myExpVal = new double[aMax];
            long[] myCurrentCount = new long[aColor];
            myCurrentCount[1] = 1;
            for (int i = 0; i < aMax; i++) {

            }
            return myExpVal;
        }

        private int getMax(int[] aColorsCount) {
            int max = 0;
            for (Integer myCount : aColorsCount) {
                max = Math.max(myCount, max);
            }
            return max;
        }

        private int[] countColorsCount(List<int[]> aColoring, int aNumberOfObjects) {
            final int[] myColorsCount = new int[aNumberOfObjects];
            for (int[] myColors : aColoring) {
                for (Integer aColor : myColors) {
                    myColorsCount[aColor]++;
                }
            }
            return myColorsCount;
        }

        private int[][] createRepaintColors(int aColor) {
            final int[][] myRepaintColors = new int[aColor][aColor];
            for (int i = 0; i < aColor; i++) {
                for (int j = 0; j < aColor; j++) {
                    myRepaintColors[i][j] = (i * j) % aColor;
                }
            }
            return myRepaintColors;
        }


    }
}
