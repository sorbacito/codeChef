package com.sorbac.codeChef.may14.chefbm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input, 3);
        Map<Integer, List<Integer>> myIncCommands = readCommandsList(input, myInputs[2]);
        for (long myResult : computeResultsByRowBySort(myInputs[0], myInputs[1], myIncCommands)) {
            out.append(Long.valueOf(myResult + myInputs[1] - 1).toString());
            out.newLine();
        }
        out.flush();
    }

    public static long[] computeResultsByRowBySort(int myInputA, int myInputB,
            Map<Integer, List<Integer>> aSortedCommands) {
        long[] myReturn = new long[myInputA];
        for (Map.Entry<Integer, List<Integer>> myEntry : aSortedCommands.entrySet()) {
            List<Integer> myToSort = myEntry.getValue();
            Collections.sort(myToSort);
            int[] isAscending = isAscendingF(myToSort, myInputB);
            if (isAscending[0] == 1) {
                if (myInputB > 1) {
                    myReturn[myEntry.getKey()] = isAscending[2] - isAscending[1];
                } else {
                    myReturn[myEntry.getKey()] = isAscending[2];
                }
            } else {
                myReturn[myEntry.getKey()] = -myInputB;
            }
        }
        return myReturn;
    }

    public static int[] isAscendingF(List<Integer> aToSort, int aMyInputB) {
        final int[] myReturn = {1, 0, 0};
        if (aToSort.size() > 0) {
            final Iterator<Integer> myIterator = aToSort.iterator();
            int myTemp = myIterator.next();
            int myPreviousTemp = 0;
            int myCount = 1;
            int myPreviousCount = 0;
            while (myIterator.hasNext()) {
                int myNew = myIterator.next();
                if (myNew == myTemp) {
                    myCount++;
                } else {
                    if (myNew - myTemp > 1) {
                        if (myPreviousCount > 1) {
                            myReturn[0] = 0;
                            return myReturn;
                        }
                    } else {
                        if (myPreviousCount - myCount > 1) {
                            myReturn[0] = 0;
                            return myReturn;
                        }
                    }
                    if (myTemp == 1) {
                        myReturn[1] = myCount;
                    }
                    myPreviousTemp = myTemp;
                    myTemp = myNew;
                    myPreviousCount = myCount;
                    myCount = 1;
                }
            }
            if (myTemp - myPreviousTemp > 1) {
                if (myPreviousCount > 1) {
                    myReturn[0] = 0;
                    return myReturn;
                }
            } else {
                if (myPreviousCount - myCount > 1) {
                    myReturn[0] = 0;
                    return myReturn;
                }
            }
            if (myTemp == aMyInputB) {
                myReturn[2] = myCount;
            }
            if (myTemp == 1) {
                myReturn[1] = myCount;
            }
            if (myCount > 1 && myTemp != aMyInputB) {
                myReturn[0] = 0;
            }
        }
        return myReturn;
    }

    private static Map<Integer, List<Integer>> readCommandsList(BufferedReader input, int myInputSize)
            throws IOException {
        Map<Integer, List<Integer>> myCommands = new TreeMap<Integer, List<Integer>>();
        String[] myInputs = input.readLine().split(" ");
        int myCommandA = Integer.parseInt(myInputs[0]);
        int myCommandB = Integer.parseInt(myInputs[1]);
        int temp = myCommandA;
        List<Integer> myTempList = new ArrayList<>();
        myTempList.add(myCommandB);
        for (int i = 0; i < myInputSize - 1; i++) {
            myInputs = input.readLine().split(" ");
            myCommandA = Integer.parseInt(myInputs[0]);
            myCommandB = Integer.parseInt(myInputs[1]);
            if (myCommandA != temp) {
                myCommands.put(temp - 1, myTempList);
                myTempList = new ArrayList<>();
                temp = myCommandA;
            }
            myTempList.add(myCommandB);
        }
        myCommands.put(temp - 1, myTempList);
        return myCommands;
    }

    private static int[] readInput(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }
}
