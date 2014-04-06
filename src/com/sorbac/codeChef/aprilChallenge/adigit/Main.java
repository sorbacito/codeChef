package com.sorbac.codeChef.aprilChallenge.adigit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    private final int[] theNumbers;
    private final List<SortedMap<Integer, Case>> theResult = new ArrayList<SortedMap<Integer, Case>>(10);

    {
        for (int i = 0; i < 10; i++) {
            theResult.add(new TreeMap<Integer, Case>());
        }
    }

    public Main(int[] aNumbers) {
        theNumbers = aNumbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myNumberOfTestCases = readInput(input, 2);
        final Main myMain = new Main(readNumbers(input, myNumberOfTestCases[0]));
        for (int i = 0; i < myNumberOfTestCases[1]; i++) {
            out.append(Integer.valueOf(myMain.computeStep(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    int computeStep(int aIndex) {
        int b1 = 0;
        int b2 = 0;
        SortedMap<Integer, Case> myHeadMap = theResult.get(theNumbers[aIndex - 1]).headMap(aIndex);
        Integer myHighestIndex;
        Case myCase;
        if (myHeadMap.size() == 0) {
            myHighestIndex = 1;
            myCase = new Case();
        } else {
            myHighestIndex = myHeadMap.lastKey();
            myCase = theResult.get(theNumbers[aIndex - 1]).get(myHighestIndex);
        }
        for (int i = myHighestIndex; i < aIndex; i++) {
            myCase.addCount(theNumbers[i - 1]);
        }
        theResult.get(theNumbers[aIndex - 1]).put(aIndex, myCase);
        return myCase.calculateSum(theNumbers[aIndex - 1]);
    }

    private static int[] readInput(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    private static int[] readNumbers(BufferedReader input, int aNumberOfValues) throws IOException {
        String myLine = input.readLine();
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = myLine.charAt(i) - '0';
        }
        return myOutput;
    }

    class Case {
        private final int[] theCounts;

        Case() {
            theCounts = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        }

        Case(Case aCase) {
            this.theCounts = aCase.theCounts;
        }

        public void addCount(int aDigit) {
            theCounts[aDigit]++;
        }

        public int calculateSum(int aDigit) {
            int mySum = 0;
            for (int i = 0; i < 10; i++) {
                if (i - aDigit > 0) {
                    mySum += theCounts[i] * (i - aDigit);
                } else {
                    mySum += theCounts[i] * (aDigit - i);
                }
            }
            return mySum;
        }
    }
}
