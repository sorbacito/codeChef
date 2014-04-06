package com.sorbac.codeChef.aprilChallenge.potatoes;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Integer[] PRIMES_2000 = getFirstPrimes(2020);

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

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            out.append(findNextPrime(readCaseSum(input)).toString());
            out.newLine();
        }
        out.flush();
    }

    private static Integer findNextPrime(Integer myPotatoes) {
        for (Integer aPRIMES_2000 : PRIMES_2000) {
            if (aPRIMES_2000 > myPotatoes) {
                return aPRIMES_2000 - myPotatoes;
            }
        }
        return -1;
    }

    private static Integer readCaseSum(BufferedReader input) throws IOException {
        int mySum = 0;
        for (String number : input.readLine().trim().split(" ")) {
            mySum += Integer.parseInt(number);
        }
        return mySum;
    }
}
