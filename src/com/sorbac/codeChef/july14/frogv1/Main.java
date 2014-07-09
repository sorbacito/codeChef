package com.sorbac.codeChef.july14.frogv1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int[] myConfiguration = readIntArray(input);
        final int myDistance = myConfiguration[1];
        final int myFrogPairs = myConfiguration[2];
        List<Integer> myFrogsPositions = readInputArray(input);
        final List<Integer> myOriginalFrogsPositions = new ArrayList<Integer>();
        myOriginalFrogsPositions.addAll(myFrogsPositions);
        Collections.sort(myFrogsPositions);
        myFrogsPositions = collapsePositions(myFrogsPositions, myDistance);
        for (int i = 0; i < myFrogPairs; i++) {
            final int[] myFrogs = readIntArray(input);
            out.append(checkReach(myOriginalFrogsPositions.get(myFrogs[0] - 1),
                    myOriginalFrogsPositions.get(myFrogs[1] - 1),
                    myDistance, myFrogsPositions) ? "Yes" : "No");
            out.newLine();
        }
        out.flush();
    }

    public static List<Integer> collapsePositions(List<Integer> aFrogsPositions, int aDistance) {
        List<Integer> myCollapsed = new ArrayList<Integer>();
        myCollapsed.add(aFrogsPositions.get(0));
        int myLastPosition = aFrogsPositions.get(0);
        for (int i = 1; i < aFrogsPositions.size(); i++) {
            if (aFrogsPositions.get(i) - myLastPosition > aDistance) {
                myCollapsed.add(aFrogsPositions.get(i));
            }
            myLastPosition = aFrogsPositions.get(i);
        }
        return myCollapsed;
    }

    public static boolean checkReach(int myFrogA, int myFrogB, int aDistance, List<Integer> myFrogsPositions) {
        if (myFrogA == myFrogB) {
            return true;
        }
        int myFroAInd = findIndex(myFrogA, myFrogsPositions);
        int myFroBInd = findIndex(myFrogB, myFrogsPositions);
        return myFroAInd == myFroBInd;
    }

    public static int findIndex(int aFrog, List<Integer> aFrogsPositions) {
        int startIndex = 0;
        int endIndex = aFrogsPositions.size() - 1;
        while (true) {
            if (aFrogsPositions.get(startIndex) <= aFrog
                    && (startIndex + 1 >= aFrogsPositions.size() || aFrogsPositions.get(startIndex + 1) > aFrog)) {
                return startIndex;
            }
            if (aFrogsPositions.get(endIndex) <= aFrog
                    && (endIndex + 1 >= aFrogsPositions.size() || aFrogsPositions.get(endIndex + 1) > aFrog)) {
                return endIndex;
            }
            int myMiddleIndex = (startIndex + endIndex) / 2;
            if (aFrogsPositions.get(myMiddleIndex) <= aFrog
                    && (myMiddleIndex + 1 >= aFrogsPositions.size() || aFrogsPositions.get(
                    myMiddleIndex + 1) > aFrog)) {
                return myMiddleIndex;
            } else if (aFrogsPositions.get(myMiddleIndex) < aFrog) {
                startIndex = myMiddleIndex;
            } else {
                endIndex = myMiddleIndex;
            }
        }
    }

    public static int smallestIndex(int aMiddleIndex, List<Integer> aFrogsPositions) {
        int myCurrentIndex = aMiddleIndex;
        while (true) {
            if (myCurrentIndex - 1 < 0 || aFrogsPositions.get(myCurrentIndex - 1) != aFrogsPositions.get(
                    aMiddleIndex)) {
                return myCurrentIndex;
            }
            myCurrentIndex--;
        }
    }


    private static List<Integer> readInputArray(BufferedReader aInput) throws IOException {
        List<Integer> myArray = new ArrayList<Integer>();
        final String[] myInput = aInput.readLine().split(" ");
        for (int i = 0; i < myInput.length; i++) {
            myArray.add(Integer.parseInt(myInput[i]));
        }
        return myArray;
    }

    private static int[] readIntArray(BufferedReader aInput) throws IOException {
        final String[] myInput = aInput.readLine().split(" ");
        final int[] myConfiguration = new int[myInput.length];
        for (int i = 0; i < myInput.length; i++) {
            myConfiguration[i] = Integer.parseInt(myInput[i]);
        }
        return myConfiguration;
    }
}
