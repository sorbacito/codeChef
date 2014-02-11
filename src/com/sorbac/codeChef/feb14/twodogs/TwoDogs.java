package com.sorbac.codeChef.feb14.twodogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TwoDogs {

    private final int theAppleSum;
    private final int[] shortestPaths;
    private int minimalPath;

    public TwoDogs(int aAppleSum) {
        theAppleSum = aAppleSum;
        shortestPaths = new int[aAppleSum - 1];
        minimalPath = theAppleSum + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int expectedAppleSum = Integer.parseInt(input.readLine().split(" ")[1]);
        List<Integer> myApples = getApples(input);
        out.write(Integer.valueOf(new TwoDogs(expectedAppleSum).getSolution(myApples)).toString());
        out.flush();
    }

    private static List<Integer> getApples(BufferedReader aInput) throws IOException {
        String[] myApples = aInput.readLine().split(" ");
        List<Integer> myApplesToReturn = new ArrayList<Integer>(myApples.length);
        for (String myApple : myApples) {
            myApplesToReturn.add(Integer.parseInt(myApple));
        }
        return myApplesToReturn;
    }

    public int getSolution(List<Integer> aApples) {
        int myApplesCount = aApples.size();
        for (int i = 0; i < myApplesCount; i++) {
            if (aApples.get(i) < theAppleSum && (2 * aApples.get(i) != theAppleSum)) {
                int path = Math.min(i + 1, myApplesCount - i);
                if (shortestPaths[aApples.get(i) - 1] == 0 || shortestPaths[aApples.get(i) - 1] > path) {
                    updatePaths(aApples.get(i), path);
                }
            }
        }
        return minimalPath == theAppleSum + 1 ? -1 : minimalPath;
    }

    private void updatePaths(int aAppleValue, Integer aPathLength) {
        shortestPaths[aAppleValue - 1] = aPathLength;
        if (shortestPaths[theAppleSum - aAppleValue - 1] != 0) {
            updateMinimalPath(shortestPaths[theAppleSum - aAppleValue - 1], aPathLength);
        }
    }

    private void updateMinimalPath(int aPath1, int aPath2) {
        int candidate = Math.max(aPath1, aPath2);
        if (candidate < minimalPath) {
            minimalPath = candidate;
        }
    }
}
