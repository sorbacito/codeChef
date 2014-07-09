package com.sorbac.codeChef.july14.frogv;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int[] myConfiguration = readIntArray(input);
        final int[] myPositions = readIntArray(input);
        final LinkedList<Pair> myAxises = createLinkedList(myPositions, myConfiguration[1]);
        for (int i = 0; i < myConfiguration[2]; i++) {
            out.append(checkReach(readIntArray(input), myPositions, myAxises) ? "Yes" : "No");
            out.newLine();
        }
        out.flush();
    }

    public static boolean checkReach(int[] aInts, int[] aPositions, LinkedList<Pair> aAxis) {
        int myIndex = findPair(aAxis, aPositions[aInts[0] - 1]);
        return aAxis.size() > myIndex && aAxis.get(myIndex).compareAxis(aPositions[aInts[1] - 1]) == 0;
    }

    public static LinkedList<Pair> createLinkedList(int[] aAxises, long aDistance) {
        LinkedList<Pair> myPairs = new LinkedList<Pair>();
        for (int myAxis : aAxises) {
            int myPairIndex = findPair(myPairs, myAxis);
            if (myPairs.size() > myPairIndex && myPairs.get(myPairIndex).compareAxis(myAxis) == 0) {
                myPairs.get(myPairIndex).enlargeIndices(myAxis);
                makeEnlargement(myPairs, myPairIndex);
            } else {
                myPairs.add(myPairIndex, new Pair(myAxis, myAxis, aDistance));
                makeEnlargement(myPairs, myPairIndex);
            }
        }
        return myPairs;
    }

    private static void makeEnlargement(LinkedList<Pair> aPairs, int aPairIndex) {
        int previousIndex = aPairIndex - 1;
        long firstValue = aPairs.get(aPairIndex).getStartIndex();
        long lastValue = aPairs.get(aPairIndex).getEndIndex();
        if (previousIndex >= 0 && aPairs.get(previousIndex).compareAxis(firstValue) == 0) {
            aPairs.remove(aPairIndex);
            aPairIndex--;
            aPairs.get(previousIndex).setEndIndex(lastValue);
        }

        int nextIndex = aPairIndex + 1;
        if (nextIndex < aPairs.size() && aPairs.get(nextIndex).compareAxis(lastValue) == 0) {
            aPairs.remove(aPairIndex);
            nextIndex--;
            aPairs.get(nextIndex).setStartIndex(firstValue);
        }
    }

    public static int findPair(LinkedList<Pair> aPairs, int aAxis) {
        int startIndex = 0;
        int endIndex = aPairs.size() > 0 ? aPairs.size() - 1 : 0;
        while (startIndex != endIndex) {
            int myMiddleIndex = (startIndex + endIndex) / 2;
            final int myComparison = aPairs.get(myMiddleIndex).compareAxis(aAxis);
            if (myComparison == 0) {
                return myMiddleIndex;
            } else if (myComparison < 0) {
                endIndex = myMiddleIndex == endIndex ? myMiddleIndex - 1 : myMiddleIndex;
            } else {
                startIndex = myMiddleIndex == startIndex ? myMiddleIndex + 1 : myMiddleIndex;
            }
        }
        return startIndex;
    }

    private static int[] readIntArray(BufferedReader aInput) throws IOException {
        final String[] myInput = aInput.readLine().split(" ");
        final int[] myConfiguration = new int[myInput.length];
        for (int i = 0; i < myInput.length; i++) {
            myConfiguration[i] = Integer.parseInt(myInput[i]);
        }
        return myConfiguration;
    }

    public static class Pair {
        private static long MAX_INDEX = 1000000000;
        private long theStartIndex;
        private long theEndIndex;
        private long theDistance;

        public Pair(long aStartIndex, long aEndIndex, long aDistance) {
            theStartIndex = aStartIndex;
            theEndIndex = aEndIndex;
            theDistance = aDistance;
        }

        public void setStartIndex(long aStartIndex) {
            theStartIndex = aStartIndex;
        }

        public void setEndIndex(long aEndIndex) {
            theEndIndex = aEndIndex;
        }

        public long getStartIndex() {
            return theStartIndex;
        }

        public long getEndIndex() {
            return theEndIndex;
        }

        public void enlargeIndices(long aAddedAxis) {
            if (theStartIndex > aAddedAxis) {
                theStartIndex = aAddedAxis;
            }
            if (theEndIndex < aAddedAxis) {
                theEndIndex = aAddedAxis;
            }
        }

        public int compareAxis(long aIndex) {
            if (aIndex < theStartIndex - theDistance) {
                return -1;
            } else if (theStartIndex - theDistance <= aIndex && theEndIndex + theDistance >= aIndex) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
