package com.sorbac.codeChef.july14.sgarden;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static final int MODULO = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int myTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myTestCases; i++) {
            final TestCase myTestCase = readTestCase(input);
            out.append(String.valueOf(myTestCase.getAnswer()));
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        aInput.readLine();
        String[] myInputs = aInput.readLine().split(" ");
        int[] myInts = new int[myInputs.length];
        for (int i = 0; i < myInputs.length; i++) {
            myInts[i] = Integer.parseInt(myInputs[i]);
        }
        return new TestCase(myInts);
    }

    public static class TestCase {
        private final int[] theSwitches;
        private final Set<Integer> theLoops;
        private final int theAnswer;

        public TestCase(int[] aSwitches) {
            theSwitches = convertSwitches(aSwitches);
            theLoops = countLoops(theSwitches);
            theAnswer = calculateLeastCommonMultiple(theLoops);
        }

        public static int calculateLeastCommonMultiple(Set<Integer> aLoops) {
            List<Integer> myPrimes = initPrimes(aLoops);
            int[] myPrimesFactor = new int[myPrimes.size()];
            for (Integer myLoop : aLoops) {
                myPrimesFactor = changePrimesFactor(myLoop, myPrimes, myPrimesFactor);
            }
            int mySteps = 1;
            for (int i = 0; i < myPrimesFactor.length; i++) {
                mySteps = (mySteps * (int) (Math.pow(myPrimes.get(i), myPrimesFactor[i]) % MODULO)) % MODULO;
            }
            return mySteps;
        }

        public int getAnswer() {
            return theAnswer;
        }

        public static int[] changePrimesFactor(Integer aLoop, List<Integer> aPrimes, int[] aPrimesFactor) {
            for (int i = 0; i < aPrimes.size(); i++) {
                int currentFactor = 0;
                while (aLoop % aPrimes.get(i) == 0) {
                    currentFactor++;
                    aLoop /= aPrimes.get(i);
                }
                aPrimesFactor[i] = Math.max(currentFactor, aPrimesFactor[i]);
            }
            return aPrimesFactor;
        }

        public static List<Integer> initPrimes(Set<Integer> aLoops) {
            int max = 0;
            for (Integer myLoop : aLoops) {
                max = Math.max(myLoop, max);
            }
            int[] myPrimes = new int[max];
            List<Integer> myFinalPrimes = new ArrayList<Integer>();
            for (int i = 1; i < max; i++) {
                if (myPrimes[i] == 0) {
                    myPrimes[i] = 1;
                    myFinalPrimes.add(i + 1);
                    for (int j = 2; j * (i + 1) <= max; j++) {
                        myPrimes[j * (i + 1)] = 2;
                    }
                }
            }
            return myFinalPrimes;
        }

        public static int[] convertSwitches(int[] aSwitches) {
            int[] convertedSwitches = new int[aSwitches.length];
            for (int aSwitch : aSwitches) {
                convertedSwitches[aSwitches[aSwitch - 1] - 1] = aSwitch;
            }
            return convertedSwitches;
        }

        public static Set<Integer> countLoops(int[] aSwitches) {
            int[] aLoops = new int[aSwitches.length];
            Set<Integer> myFinalLoops = new HashSet<Integer>();
            for (int i = 0; i < aSwitches.length; i++) {
                if (aLoops[i] == 0) {
                    List<Integer> visitedPositions = new ArrayList<Integer>();
                    visitedPositions.add(i);
                    int currentPosition = aSwitches[i];
                    int myLoops = 1;
                    while (i + 1 != currentPosition) {
                        visitedPositions.add(currentPosition - 1);
                        currentPosition = aSwitches[currentPosition - 1];
                        myLoops++;
                    }
                    for (Integer myVisitedPosition : visitedPositions) {
                        aLoops[myVisitedPosition] = myLoops;
                    }
                    myFinalLoops.add(myLoops);
                }
            }
            return myFinalLoops;
        }
    }
}
