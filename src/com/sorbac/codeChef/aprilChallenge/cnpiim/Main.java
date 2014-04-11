package com.sorbac.codeChef.aprilChallenge.cnpiim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Integer[] PRIMES_1250 = getFirstPrimes(1300);

    private static Integer[] getFirstPrimes(int aMaxValue) {
        int[] myIntegers = new int[aMaxValue];
        for (int i = 0; i < aMaxValue; i++) {
            myIntegers[i] = i;
        }
        myIntegers[1] = 0;
        for (int i = 2; i < Math.sqrt(aMaxValue); i++) {
            if (myIntegers[i] != 0) {
                for (int j = 2; j * i < aMaxValue; j++) {
                    myIntegers[j * i] = 0;
                }
            }
        }
        List<Integer> myPrimes = new ArrayList<Integer>();
        for (int i = 2; i < aMaxValue; i++) {
            if (myIntegers[i] != 0) {
                myPrimes.add(i);
            }
        }
        return myPrimes.toArray(new Integer[myIntegers.length]);
    }

    private final long[] theResults = new long[1250 * 1250];
    private int theHighestComputed = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long myNumberOfTestCases = Integer.parseInt(input.readLine());
        final Main myMain = new Main();
        for (long i = 0; i < myNumberOfTestCases; i++) {
            out.append(Long.valueOf(myMain.computeMatrices(Integer.parseInt(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    long computeMatrices(int aTrace) {
        long myMatrices = 0;
        for (int i = 1; i < (aTrace + 1) / 2; i++) {
            myMatrices += getNumberOfMultiplications(i * (aTrace - i) - 1);
        }
        if (aTrace % 2 == 0) {
            return 2 * myMatrices + getNumberOfMultiplications((aTrace / 2) * (aTrace / 2) - 1);
        } else {
            return 2 * myMatrices;
        }
    }

    long getNumberOfMultiplications(int aNumber) {
        if (theResults[aNumber] == 0) {
            for (int i = theHighestComputed + 1; i <= aNumber; i++) {
                int myAddition = 1;
                int myI = i;
                for (int j = 0; PRIMES_1250[j] <= Math.sqrt(i); j++) {
                    int myFactor = 0;
                    while (myI % PRIMES_1250[j] == 0 && myI > 1) {
                        myI /= PRIMES_1250[j];
                        myFactor++;
                    }
                    myAddition *= myFactor + 1;
                }
                if (myI > 1) {
                    myAddition *= 2;
                }
                theResults[i] = theResults[i - 1] + myAddition;
            }
            theHighestComputed = aNumber;
        }
        return theResults[aNumber];
    }
}
