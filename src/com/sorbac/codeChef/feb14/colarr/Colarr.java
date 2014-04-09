package com.sorbac.codeChef.feb14.colarr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colarr {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String[] myConfiguration = input.readLine().split(" ");
            int myCellNumber = Integer.parseInt(myConfiguration[0]);
            //noinspection UnusedDeclaration
            int myColourNumber = Integer.parseInt(myConfiguration[1]);
            int myRepaintingNumber = Integer.parseInt(myConfiguration[2]);
            List<Integer> myStartColours = readIntegers(input);
            List<List<Integer>> myColourGainByCell = new ArrayList<List<Integer>>(myCellNumber);
            for (int j = 0; j < myCellNumber; j++) {
                myColourGainByCell.add(readIntegers(input));
            }
            List<List<Integer>> myColourCostByCell = new ArrayList<List<Integer>>(myCellNumber);
            for (int j = 0; j < myCellNumber; j++) {
                myColourCostByCell.add(readIntegers(input));
            }
            List<Cell> myCellConfig = new ArrayList<Cell>(myCellNumber);
            for (int j = 0; j < myCellNumber; j++) {
                myCellConfig.add(new Cell(myStartColours.get(j), myColourGainByCell.get(j), myColourCostByCell.get(j)));
            }
            out.write(Integer.valueOf(
                    new TestCase(myCellConfig).getMaximumPointsWithRepainting(myRepaintingNumber)).toString());
            out.newLine();
        }
        out.flush();
    }

    public static class TestCase {

        private final List<Cell> theStartPositions;

        public TestCase(List<Cell> aStartPositions) {
            theStartPositions = aStartPositions;
            Collections.sort(theStartPositions);
        }

        public int getMaximumPointsWithRepainting(int aNumberOfRepaintings) {
            int myCellNumber = theStartPositions.size();
            int totalPoints = 0;
            int i;
            for (i = 0; i < Math.min(aNumberOfRepaintings, theStartPositions.size()); i++) {
                Cell myCell = theStartPositions.get(myCellNumber - i - 1);
                if (!myCell.shouldBeRepainted()) {
                    aNumberOfRepaintings++;
                    totalPoints += myCell.getCurrentPoints();
                } else {
                    totalPoints += myCell.maxGain();
                }
            }
            for (; i < theStartPositions.size(); i++) {
                totalPoints += theStartPositions.get(myCellNumber - i - 1).getCurrentPoints();
            }
            return totalPoints;
        }

    }

    public static class Cell implements Comparable<Cell> {

        private final int currentColor;
        private final int currentPoints;
        private int maximumPossibleGain;
        private final List<Integer> colorGain;
        private final List<Integer> colorRepaintCost;

        public Cell(int aCurrentColor, List<Integer> aColorGain, List<Integer> aColorPay) {
            currentColor = aCurrentColor - 1;
            colorGain = aColorGain;
            colorRepaintCost = aColorPay;
            currentPoints = aColorGain.get(currentColor);
            maxPointsByRecoloring();
        }

        private void maxPointsByRecoloring() {
            int possibleMaxPoints;
            maximumPossibleGain = currentPoints;
            for (int i = 0; i < colorGain.size(); i++) {
                possibleMaxPoints = colorGain.get(i) - colorRepaintCost.get(i);
                if (possibleMaxPoints > maximumPossibleGain) {
                    maximumPossibleGain = possibleMaxPoints;
                }
            }
        }

        public int getCurrentPoints() {
            return currentPoints;
        }

        public int maxGain() {
            return Math.max(maximumPossibleGain, currentPoints);
        }

        public boolean shouldBeRepainted() {
            return currentPoints < maximumPossibleGain;
        }

        @Override
        public int compareTo(@SuppressWarnings("NullableProblems") Cell other) {
            return this.maxGain() - other.maxGain();
        }
    }

    private static List<Integer> readIntegers(BufferedReader aInput) throws IOException {
        String[] myIntegers = aInput.readLine().split(" ");
        List<Integer> myResultIntegers = new ArrayList<Integer>(myIntegers.length);
        for (String myInteger : myIntegers) {
            myResultIntegers.add(Integer.parseInt(myInteger));
        }
        return myResultIntegers;
    }
}
