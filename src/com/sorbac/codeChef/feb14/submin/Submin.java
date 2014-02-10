package com.sorbac.codeChef.feb14.submin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submin {
    private final int[] theAnswers;

    public Submin(int[] aAnswers) {
        theAnswers = aAnswers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrayLength = Integer.parseInt(input.readLine());
        final Submin myAnswers = new Submin(createAnswerArray(readArray(input)));
        int numberOfInputs = Integer.parseInt(input.readLine());
        int myMin;
        for (int i = 0; i < numberOfInputs; i++) {
            myMin = Integer.parseInt(input.readLine());
            out.append(myAnswers.getAnswerString(myMin));
            out.newLine();
        }
        out.flush();
    }

    public int getAnswer(int min) {
        if (min <= theAnswers.length) {
            return theAnswers[min - 1];
        } else {
            return 0;
        }
    }

    public String getAnswerString(int min) {
        return Integer.valueOf(getAnswer(min)).toString();
    }

    public static int[] createAnswerArray(List<Integer> aInpurArray) {
        final ArrayList<List<Integer>> myMins = new ArrayList<List<Integer>>();
        myMins.add(aInpurArray);
        return createAnswerArray(aInpurArray, myMins);
    }

    private static int[] createAnswerArray(List<Integer> aInpurArray, List<List<Integer>> aMins) {
        List<Integer> myActualMins = new ArrayList<Integer>();
        final List<Integer> myLastMins = aMins.get(aMins.size() - 1);
        if (myLastMins.size() == 1) {
            return createAnswers(aMins);
        }
        int myOffset = aInpurArray.size() - myLastMins.size();
        for (int i = myOffset + 1; i < aInpurArray.size(); i++) {
            myActualMins.add(Math.min(aInpurArray.get(i), myLastMins.get(i - myOffset - 1)));
        }
        aMins.add(myActualMins);
        return createAnswerArray(aInpurArray, aMins);
    }

    private static int[] createAnswers(List<List<Integer>> aMins) {
        List<Integer> myAllMins = new ArrayList<Integer>();
        for (List<Integer> myLevel : aMins) {
            myAllMins.addAll(myLevel);
        }
        final Integer[] mySortedMins = myAllMins.toArray(new Integer[myAllMins.size()]);
        Arrays.sort(mySortedMins);
        int[] myAnswers = new int[mySortedMins[mySortedMins.length - 1]];
        for (Integer myMin : mySortedMins) {
            myAnswers[myMin - 1]++;
        }
        return myAnswers;
    }

    private static List<Integer> readArray(BufferedReader aInput) throws IOException {
        final String[] myArrayValues = aInput.readLine().split(" ");
        final List<Integer> myInteger = new ArrayList<Integer>(myArrayValues.length);
        for (String myIntegerValue : myArrayValues) {
            myInteger.add(Integer.parseInt(myIntegerValue));
        }
        return myInteger;
    }

}
