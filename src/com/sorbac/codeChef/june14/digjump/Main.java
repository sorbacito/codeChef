package com.sorbac.codeChef.june14.digjump;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<List<Integer>> indices;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Main myMain = new Main();
        out.append(String.valueOf(myMain.findJumps(input.readLine())));
        out.flush();
    }

    private int findJumps(int[] aSequence) {
        int myLastIndex = aSequence.length - 1;
        int[] myJumps = new int[myLastIndex + 1];
        List<Integer> myPositions = new ArrayList<Integer>();
        int myJump = 1;
        myPositions.add(0);
        myJumps[0] = -1;
        while (true) {
            List<Integer> myNewPositions = new ArrayList<Integer>();
            for (Integer myPosition : myPositions) {
                if (myPosition > 0 && myJumps[myPosition - 1] == 0) {
                    myJumps[myPosition - 1] = myJump;
                    myNewPositions.add(myPosition - 1);
                } else if (myPosition < myLastIndex && myJumps[myPosition + 1] == 0) {
                    if (myPosition + 1 == myLastIndex) {
                        return myJump;
                    }
                    myJumps[myPosition + 1] = myJump;
                    myNewPositions.add(myPosition + 1);
                }
                for (Integer mySameIndex : indices.get(aSequence[myPosition])) {
                    if (mySameIndex == myLastIndex) {
                        return myJump;
                    }
                    myJumps[mySameIndex] = myJump;
                }
                myNewPositions.addAll(indices.get(aSequence[myPosition]));
                indices.get(aSequence[myPosition]).clear();
            }
            myPositions = myNewPositions;
            myJump++;
        }
    }

    public int findJumps(String as) {
        return findJumps(readSequence(as));
    }

    private int[] readSequence(String s) {
        int[] mySequnce = new int[s.length()];
        List<List<Integer>> myNumbers = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            myNumbers.add(new ArrayList<Integer>());
        }
        char[] myInput = s.toCharArray();
        for (int i = 0; i < myInput.length; i++) {
            mySequnce[i] = myInput[i] - '0';
            if (i > 0) {
                myNumbers.get(mySequnce[i]).add(i);
            }
        }
        indices = myNumbers;
        return mySequnce;
    }
}
