package com.sorbac.codeChef.aprilChallenge.tangdiv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.valueOf(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            int[] myConfiguration = readNumbers(input, 3);
            Pair[] myOriginalPairs = readPairs(input, myConfiguration[1]);
            Pair[] myChangedPairs = readPairs(input, myConfiguration[2]);
            out.append(new Case(myConfiguration[0], myOriginalPairs, myChangedPairs).getAnswer());
            out.newLine();
        }
        out.flush();
    }

    private static Pair[] readPairs(BufferedReader aInput, int aNumberOfPairs) throws IOException {
        final Pair[] myOriginalPairs = new Pair[aNumberOfPairs];
        for (int j = 0; j < aNumberOfPairs; j++) {
            int[] myPair = readNumbers(aInput, 2);
            myOriginalPairs[j] = new Pair(myPair[0], myPair[1]);
        }
        return myOriginalPairs;
    }

    private static int[] readNumbers(BufferedReader input, int aNumberOfValues) throws IOException {
        String myLine = input.readLine();
        int[] myOutput = new int[aNumberOfValues];
        String[] myNumbers = myLine.split(" ");
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.valueOf(myNumbers[i]);
        }
        return myOutput;
    }

    public static class Pair {
        private final int theLeft;
        private final int theRight;

        public Pair(int aLeft, int aRight) {
            theLeft = aLeft;
            theRight = aRight;
        }

        public boolean contains(Pair value) {
            if (value.getLeft() < value.getRight()) {
                return theLeft <= value.getLeft() && (value.getRight() <= theRight || theRight < theLeft);
            } else {
                if (theLeft > theRight) {
                    return (value.getLeft() >= theLeft || value.getLeft() <= theRight) &&
                            (value.getRight() <= theRight || value.getRight() >= theLeft);
                } else {
                    return (value.getLeft() == value.getRight())
                            && (theLeft <= value.getLeft() && theRight >= value.getRight());
                }
            }
        }

        public int getLeft() {
            return theLeft;
        }

        public int getRight() {
            return theRight;
        }
    }


    static class Case {
        private final int theSegments;
        private final Pair[] theOriginalPairsMap;
        private final TreeMap<Integer, Pair> theChangedPairsMap;

        public Case(int aSegments, Pair[] aOriginalPairs, Pair[] aChangedPairs) {
            theSegments = aSegments;
            theOriginalPairsMap = aOriginalPairs;
            theChangedPairsMap = createMap(aChangedPairs);
        }

        public static TreeMap<Integer, Pair> createMap(Main.Pair[] aOriginalPairs) {
            TreeMap<Integer, Pair> myMap = new TreeMap<Integer, Pair>();
            for (Main.Pair myPair : aOriginalPairs) {
                myMap.put(myPair.getLeft(), myPair);
            }
            return myMap;
        }

        public String getAnswer() {
            ArrayList<MyTree> myNewPairs = prepareLeaves(theChangedPairsMap);
            MyTree myChangedPairs = createMyTree(myNewPairs);
            for (Pair myPair : theOriginalPairsMap) {
                if (!myChangedPairs.containsPair(myPair)) {
                    return "No";
                }
            }
            return "Yes";
        }

        public static ArrayList<MyTree> prepareLeaves(TreeMap<Integer, Pair> aChangedPairsMap) {
            ArrayList<MyTree> myNewPairs = new ArrayList<MyTree>();
            for (Main.Pair myPair : aChangedPairsMap.values()) {
                myNewPairs.add(new Main.MyTree(myPair, null, null));
            }
            return myNewPairs;
        }

        public static MyTree createMyTree(ArrayList<MyTree> aSortedPairs) {
            if (aSortedPairs.size() != 1) {
                int pairsNumber = aSortedPairs.size() / 2;
                ArrayList<MyTree> myNewPairs = new ArrayList<MyTree>();
                for (int i = 0; i < pairsNumber; i++) {
                    final MyTree myLeft = aSortedPairs.get(i * 2);
                    final MyTree myRight = aSortedPairs.get(i * 2 + 1);
                    myNewPairs.add(new MyTree(new Pair(myLeft.value.getLeft(),
                            myRight != null ? myRight.value.getRight() : myLeft.value.getRight()), myLeft, myRight));
                }
                if (aSortedPairs.size() % 2 == 1) {
                    myNewPairs.add(new MyTree(aSortedPairs.get(aSortedPairs.size() - 1).value,
                            aSortedPairs.get(aSortedPairs.size() - 1), null));
                }
                return createMyTree(myNewPairs);
            } else {
                return aSortedPairs.get(0);
            }
        }
    }

    static class MyTree {
        private final Pair value;
        private final MyTree left;
        private final MyTree right;

        MyTree(Pair aValue, MyTree aLeft, MyTree aRight) {
            value = aValue;
            left = aLeft;
            right = aRight;
        }

        boolean containsPair(Pair myPair) {
            if (left == null && right == null) {
                return value.contains(myPair);
            } else {
                if (left != null && left.value.contains(myPair)) {
                    return left.value.contains(myPair);
                } else {
                    return right.value.contains(myPair);
                }
            }
        }

    }
}
