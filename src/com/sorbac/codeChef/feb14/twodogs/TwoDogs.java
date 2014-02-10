package com.sorbac.codeChef.feb14.twodogs;

import java.util.List;

public class TwoDogs {

    private final int theAppleSum;

    public TwoDogs(int aAppleSum) {
        theAppleSum = aAppleSum;
    }

    public int getSolution(List<Integer> aApples) {
        Solution mySolution = null;
        int myApplesCount = aApples.size();
        for (int i = 0; i < myApplesCount - 1; i++) {
            for (int j = i + 1; j < myApplesCount; j++) {
                if (aApples.get(i) + aApples.get(j) == theAppleSum) {
                    final Solution myTempSolution = new Solution(aApples.get(i), aApples.get(j), myApplesCount);
                    if (mySolution == null) {
                        mySolution = myTempSolution;
                    } else {
                        if (myTempSolution.compareTo(mySolution) < 0) {
                            mySolution = myTempSolution;
                        }
                    }
                }
            }
        }
        return mySolution == null ? -1 : mySolution.distance();
    }

    public static class Solution implements Comparable<Solution> {
        private final int apple1Position;
        private final int apple2Position;
        private final int numberOfApples;

        public Solution(int aApple1, int aApple2, int aNumberOfApples) {
            apple1Position = aApple1;
            apple2Position = aApple2;
            numberOfApples = aNumberOfApples;
        }

        public int distance() {
            return Math.max(Math.min(apple1Position, numberOfApples - apple1Position), Math.min(apple2Position,
                    numberOfApples - apple2Position));
        }

        @Override
        public int compareTo(Solution other) {
            return other.distance() - other.distance();
        }
    }
}
