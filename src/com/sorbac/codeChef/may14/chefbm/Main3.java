package com.sorbac.codeChef.may14.chefbm;

import java.io.*;
import java.util.*;

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
            int[] isAscending = isAscendingF2(myToSort, myInputB);
            if (isAscending[0] == 1) {
                if (myInputB > 1) {
                    myReturn[myEntry.getKey()] = isAscending[2] - isAscending[1];
                } else {
                    myReturn[myEntry.getKey()] = -myInputB + 1;
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

    public static int[] isAscendingF2(List<Integer> aToSort, int aInputB) {
        int[] myReturn = {1, 0, 0};
        if (aToSort.size() > 0) {
            final Iterator<Integer> myIterator = aToSort.iterator();
            int myPreviousTemp = -1;
            int myPreviousCount = 0;
            int myTemp = myIterator.next();
            int myCount = 1;
            while (myIterator.hasNext()) {
                int myNew = myIterator.next();
                if (myNew == myTemp) {
                    myCount++;
                } else {
                    if (!areValid(myPreviousTemp, myPreviousCount, myTemp, myCount)) {
                        myReturn[0] = 0;
                        return myReturn;
                    }
                    myReturn = setReturn(myTemp, myCount, aInputB, myReturn);
                    myPreviousTemp = myTemp;
                    myPreviousCount = myCount;
                    myTemp = myNew;
                    myCount = 1;
                }
            }
            if (!areValid(myPreviousTemp, myPreviousCount, myTemp, myCount)
                    || (myTemp < aInputB && myCount > 1)) {
                myReturn[0] = 0;
                return myReturn;
            }
            myReturn = setReturn(myTemp, myCount, aInputB, myReturn);
        }
        return myReturn;
    }

    private static int[] setReturn(int myTemp, int myCount, int aInputB, int[] myReturn) {
        if (myTemp == 1) {
            myReturn[1] = myCount;
        }
        if (myTemp == aInputB) {
            myReturn[2] = myCount;
        }
        return myReturn;
    }

    private static boolean areValid(int myPreviousTemp, int myPreviousCount, int myTemp, int myCount) {
        if (myTemp - myPreviousTemp == 1) {
            if (myPreviousCount - myCount > 1) {
                return false;
            }
        } else {
            if (myPreviousCount > 1) {
                return false;
            }
        }
        return true;
    }


    private static Map<Integer, List<Integer>> readCommandsList(BufferedReader input, int myInputSize)
            throws IOException {
        Map<Integer, List<Integer>> myCommands = new TreeMap<Integer, List<Integer>>();
        int myCommandA;
        int myCommandB;
        for (int i = 0; i < myInputSize; i++) {
            String[] myInputs = input.readLine().split(" ");
            myCommandA = Integer.parseInt(myInputs[0]);
            myCommandB = Integer.parseInt(myInputs[1]);
            if (myCommands.get(myCommandA - 1) == null) {
                myCommands.put(myCommandA - 1, new ArrayList<Integer>());
            }
            List<Integer> myList = myCommands.get(myCommandA - 1);
            myList.add(myCommandB);
            myCommands.put(myCommandA - 1, myList);
        }
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
