package com.sorbac.codeChef.aprilChallenge.adigit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainOld {
    private final int[] theNumbers;
    private final SortedMap<Integer, Case> theResult = new TreeMap<Integer, Case>();

    public MainOld(int[] aNumbers) {
        theNumbers = aNumbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myNumberOfTestCases = readInput(input, 2);
        final MainOld myMainOld = new MainOld(readNumbers(input, myNumberOfTestCases[0]));
        for (int i = 0; i < myNumberOfTestCases[1]; i++) {
            out.append(Integer.valueOf(myMainOld.computeStep(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    int computeStep(int aIndex) {
        SortedMap<Integer, Case> myHeadMap = theResult.headMap(aIndex + 1);
        Integer myHighestIndex;
        Case myCase;
        if (myHeadMap.size() == 0) {
            myHighestIndex = 1;
            myCase = new Case();
        } else {
            myHighestIndex = myHeadMap.lastKey();
            myCase = new Case(theResult.get(myHeadMap.lastKey()));
        }
        if (myHighestIndex != aIndex) {
            for (int i = myHighestIndex; i < aIndex; i++) {
                myCase.addCount(theNumbers[i - 1]);
            }
            theResult.put(aIndex, myCase);
        }
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
            this.theCounts = aCase.theCounts.clone();
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
