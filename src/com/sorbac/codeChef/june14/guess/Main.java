package com.sorbac.codeChef.june14.guess;

import java.io.*;

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
        long myGreatestCommonDivisor = findGreatestCommonDivisor(aFraction[0], aFraction[1]);
        return new long[]{aFraction[0] / myGreatestCommonDivisor, aFraction[1] / myGreatestCommonDivisor};
    }

    public static long findGreatestCommonDivisor(long aNumberA, long aNumberB) {
        long myGcd = aNumberA < aNumberB ? aNumberA : aNumberB;
        long myToDivide = aNumberA < aNumberB ? aNumberB : aNumberA;
        if (myGcd == 0 || myToDivide == 0) {
            return 1;
        }
        while (true) {
            if (myToDivide % myGcd == 0) {
                return myGcd;
            }
            myGcd = myToDivide % myGcd;
            myToDivide = myGcd;
        }
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
