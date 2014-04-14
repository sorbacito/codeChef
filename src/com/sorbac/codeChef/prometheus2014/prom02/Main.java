package com.sorbac.codeChef.prometheus2014.prom02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAXIMUM = 45;
    private static int[] theFibonacciNumbers = new int[MAXIMUM];
    private static int theHighest = 0;

    static {
        theFibonacciNumbers[0] = 1;
        theFibonacciNumbers[1] = 2;
        for (int i = 2; i < MAXIMUM; i++) {
            theFibonacciNumbers[i] = theFibonacciNumbers[i - 1] + theFibonacciNumbers[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        List<long[]> myInputs = new ArrayList<long[]>();
        int myNumberOfTestCases = Integer.valueOf(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            out.append(Long.valueOf(calculatePassword(Integer.valueOf(input.readLine()))).toString());
            out.newLine();
        }
        out.flush();
    }

    private static long calculatePassword(Integer aInteger) {
        int myInt = aInteger;
        int myAnswer = findHighestLowerFibNumberIndex(aInteger);
        while (myInt > 0) {

        }
        return 0;
    }

    public static int findHighestLowerFibNumberIndex(Integer aInteger) {
        int myIndex = 0;
        int maxIndex = MAXIMUM;
        while (!(theFibonacciNumbers[myIndex] <= aInteger && theFibonacciNumbers[myIndex + 1] > aInteger)) {
            if (theFibonacciNumbers[myIndex] < aInteger) {
                myIndex = (maxIndex + myIndex) / 2;
            } else {
                maxIndex = myIndex;
                myIndex /= 2;
            }
        }
        return myIndex;
    }
}
