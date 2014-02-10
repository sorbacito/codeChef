package com.sorbac.codeChef.feb14.lcpesy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final int NUMBER_OF_CHARACTERS = 26;
    private static final int NUMBER_OF_DIGITS = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInputs = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            out.append(Integer.valueOf(getLongestCommonPatternLength(input.readLine(), input.readLine())).toString());
            out.newLine();
        }
        out.flush();
    }

    public static int getLongestCommonPatternLength(String aFirst, String aSecond) {
        int[] myFirstStringOccurences = countOcurrencesInString(aFirst);
        int[] mySecondStringOccurences = countOcurrencesInString(aSecond);
        return countNumberOfSameChars(myFirstStringOccurences, mySecondStringOccurences);
    }

    private static int countNumberOfSameChars(int[] aFirstStringOccurences, int[] aSecondStringOccurences) {
        int totalCount = 0;
        for (int i = 0; i < aFirstStringOccurences.length; i++) {
            totalCount += Math.min(aFirstStringOccurences[i], aSecondStringOccurences[i]);
        }
        return totalCount;
    }

    private static int[] countOcurrencesInString(String aString) {
        final int[] myInts = new int[2 * NUMBER_OF_CHARACTERS + NUMBER_OF_DIGITS];
        for (char myChar : aString.toCharArray()) {
            if (myChar > 'Z') {
                myInts[myChar - 'a' + NUMBER_OF_CHARACTERS + NUMBER_OF_DIGITS]++;
            } else if (myChar >= 'A') {
                myInts[myChar - 'A' + NUMBER_OF_DIGITS]++;
            } else {
                myInts[myChar - '0']++;
            }
        }
        return myInts;
    }
}
