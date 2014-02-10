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

    public TwoDogs(int aAppleSum) {
        theAppleSum = aAppleSum;
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
        int myMinDistance = -1;
        int myApplesCount = aApples.size();
        for (int i = 0; i < myApplesCount - 1; i++) {
            for (int j = i + 1; j < myApplesCount; j++) {
                if (aApples.get(i) + aApples.get(j) == theAppleSum) {
                    final int myDistance = Math.max(Math.min(aApples.get(i), myApplesCount - aApples.get(i)),
                            Math.min(aApples.get(j),
                                    myApplesCount - aApples.get(j)));
                    if (myMinDistance == -1) {
                        myMinDistance = myDistance;
                    } else {
                        if (myDistance < 0) {
                            myMinDistance = myDistance;
                        }
                    }
                }
            }
        }
        return myMinDistance;
    }
}
