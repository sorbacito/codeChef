package com.sorbac.codeChef.june14.guess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            long[] myNumbers = readTestCase(input);
            long[] myFraction = countFraction(myNumbers);
            long[] myIrreducibleFraction = reduceFraction(myFraction);
            out.append(String.valueOf(myIrreducibleFraction[0]));
            out.append("/");
            out.append(String.valueOf(myIrreducibleFraction[1]));
            out.newLine();
        }
        out.flush();
    }

    public static long[] reduceFraction(long[] aFraction) {
        List<Long> myDelimiters = findPrimeDelimiters(aFraction[0] < aFraction[1] ? aFraction[0] : aFraction[1]);
        long[] reducedFraction = new long[]{aFraction[0], aFraction[1]};
        for (Long myDelimiter : myDelimiters) {
            while ((reducedFraction[0] % myDelimiter == 0) && (reducedFraction[1] % myDelimiter == 0)) {
                reducedFraction[0] = reducedFraction[0] / myDelimiter;
                reducedFraction[1] = reducedFraction[1] / myDelimiter;
            }
        }
        return reducedFraction;
    }

    public static List<Long> findPrimeDelimiters(long aNumber) {
        List<Long> myPrimes = findPrimesTo((int) aNumber);
        List<Long> myDelimiters = new ArrayList<Long>();
        for (Long myPrime : myPrimes) {
            if (aNumber % myPrime == 0) {
                myDelimiters.add(myPrime);
            }
        }
        return myDelimiters;
    }

    public static List<Long> findPrimesTo(int aNumber) {
        long[] myCandidates = new long[aNumber + 1];
        for (int i = 2; i <= aNumber; i++) {
            myCandidates[i] = i;
        }
        int current = 2;
        while (current <= aNumber) {
            if (myCandidates[current] != 0) {
                for (int i = 2 * current; i <= aNumber; i = i + current) {
                    myCandidates[i] = 0;
                }
            }
            current++;
        }
        List<Long> myPrimes = new ArrayList<Long>();
        for (Long myCandidate : myCandidates) {
            if (myCandidate != 0) {
                myPrimes.add(myCandidate);
            }
        }
        return myPrimes;
    }

    public static long[] countFraction(long[] aNumbers) {
        long myFirstOddNumber = countOddNumber(aNumbers[0]);
        long myFirstEvenNumber = countEvenNumber(aNumbers[0]);
        long mySecondOddNumber = countOddNumber(aNumbers[1]);
        long mySecondEvenNumber = countEvenNumber(aNumbers[1]);
        long[] myFraction = new long[2];
        myFraction[0] = myFirstEvenNumber * mySecondOddNumber + myFirstOddNumber * mySecondEvenNumber;
        myFraction[1] = aNumbers[0] * aNumbers[1];
        return myFraction;
    }

    public static long countOddNumber(long aNumber) {
        return (aNumber + 1) / 2;
    }

    public static long countEvenNumber(long aNumber) {
        return aNumber / 2;
    }

    private static long[] readTestCase(BufferedReader aInput) throws IOException {
        long[] numbers = new long[2];
        String[] myStrings = aInput.readLine().split(" ");
        numbers[0] = Long.valueOf(myStrings[0]);
        numbers[1] = Long.valueOf(myStrings[1]);
        return numbers;
    }
}
