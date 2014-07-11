package com.sorbac.codeChef.july14.dishown;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int myTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myTestCases; i++) {
            final TestCase myTestCase = readTestCase(input);
            final String myNumberOfQueries = input.readLine();
            for (int j = 0; j < Integer.parseInt(myNumberOfQueries); j++) {
                String[] myQuery = input.readLine().split(" ");
                String myQueryAnswer = null;
                if (myQuery.length == 2) {
                    myQueryAnswer = myTestCase.query(Integer.parseInt(myQuery[1]));
                } else {
                    myQueryAnswer = myTestCase.query(Integer.parseInt(myQuery[1]), Integer.parseInt(myQuery[2]));
                }
                if (myQueryAnswer != null) {
                    out.append(myQueryAnswer);
                    out.newLine();
                }
            }
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        aInput.readLine();
        String[] myDishesValues = aInput.readLine().split(" ");
        int[] myScores = new int[myDishesValues.length];
        for (int i = 0; i < myDishesValues.length; i++) {
            myScores[i] = Integer.parseInt(myDishesValues[i]);
        }
        return new TestCase(myScores);
    }

    public static class TestCase {
        private Node[] theDishes;

        public TestCase(int[] theScores) {
            theDishes = createDishes(theScores);
        }

        private Node[] createDishes(int[] aScores) {
            Node[] myNodes = new Node[aScores.length];
            for (int i = 0; i < aScores.length; i++) {
                myNodes[i] = new Node(i + 1, aScores[i]);
            }
            return myNodes;
        }

        public String query(int aDish) {
            return String.valueOf(getChef(aDish).getChef());
        }

        private Node getChef(int aDish) {
            Node myNode = theDishes[aDish - 1];
            int myDepth = 0;
            while (myNode.getParent() != null) {
                myNode = myNode.getParent();
                myDepth++;
            }
            if (myDepth > 0) {
                theDishes[aDish - 1].setParent(myNode);
            }
            return myNode;
        }

        public String query(int aDishA, int aDishB) {
            Node myChefA = getChef(aDishA);
            Node myChefB = getChef(aDishB);
            if (myChefA.getChef() == myChefB.getChef()) {
                return "Invalid query!";
            } else {
                final int myDishAValue = myChefA.getBestScore();
                final int myDishBValue = myChefB.getBestScore();
                if (myDishAValue == myDishBValue) {
                    //do nothing
                } else if (myDishAValue < myDishBValue) {
                    myChefA.setParent(myChefB);
                } else if (myDishAValue > myDishBValue) {
                    myChefB.setParent(myChefA);
                }
                return null;
            }
        }
    }

    public static class Node {
        private int theChef;
        private int theBestScore;
        private Node theParent;

        public Node(int aValue, int aBestScore) {
            theChef = aValue;
            theBestScore = aBestScore;
        }

        public int getChef() {
            return theChef;
        }

        public int getBestScore() {
            return theBestScore;
        }

        public Node getParent() {
            return theParent;
        }

        public void setParent(Node aParent) {
            theParent = aParent;
        }
    }
}
