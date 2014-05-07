package com.sorbac.codeChef.may14.chefbm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input, 3);
        int[][] myIncCommands = readCommands(input, myInputs[2]);
        for (long myResult : computeResultsByRow(myInputs[0], myInputs[1], myIncCommands)) {
            out.append(Long.valueOf(myResult + myInputs[1] - 1).toString());
            out.newLine();
        }
        out.flush();
    }

    public static long[] computeResultsByRow(int myInputA, int myInputB, int[][] myIncCommands) {
        long[] myReturn = new long[myInputA];
        Map<Integer, List<Integer>> mySortedCommands = sortCommands(myIncCommands);
        for (Map.Entry<Integer, List<Integer>> myEntry : mySortedCommands.entrySet()) {
            long[] myLine = createNewLine(myInputB);
            long[] myProblems = createNewLine(myInputB);
            int myProblemsCount = 0;
            myProblemsCount = updateOneRow(myInputB, myEntry, myLine, myProblems, myProblemsCount);
            updateMyReturn(myInputB, myReturn, myEntry, myLine, myProblemsCount);
        }
        return myReturn;
    }

    private static int updateOneRow(int myInputB, Map.Entry<Integer, List<Integer>> myEntry, long[] aLine,
            long[] aProblems, int aProblemsCount) {
        for (Integer myCommand : myEntry.getValue()) {
            aProblemsCount = updateWithCommand(myInputB, aLine, aProblems, aProblemsCount, myCommand);
        }
        return aProblemsCount;
    }

    private static void updateMyReturn(int myInputB, long[] aReturn, Map.Entry<Integer, List<Integer>> myEntry,
            long[] aLine, int aProblemsCount) {
        if (aProblemsCount == 0) {
            aReturn[myEntry.getKey()] = aLine[myInputB - 1] - aLine[0];
        } else {
            aReturn[myEntry.getKey()] = -myInputB;
        }
    }

    private static long[] createNewLine(int myInputB) {
        return new long[myInputB];
    }

    public static Map<Integer, List<Integer>> sortCommands(int[][] aIncCommands) {
        Map<Integer, List<Integer>> mySortedCommandsMap = new HashMap<Integer, List<Integer>>();
        for (int[] myCommand : aIncCommands) {
            if (mySortedCommandsMap.get(myCommand[0] - 1) == null) {
                mySortedCommandsMap.put(myCommand[0] - 1, new ArrayList<Integer>());
            }
            mySortedCommandsMap.get(myCommand[0] - 1).add(myCommand[1]);
        }
        return mySortedCommandsMap;
    }

    public static int updateWithCommand(int myInputB, long[] aLine, long[] aProblems, int aProblemsCount,
            int myCommandB) {
        int myProblemsCount = aProblemsCount;
        aLine[myCommandB - 1]++;
        if (myCommandB < myInputB &&
                aLine[myCommandB - 1] > aLine[myCommandB] + 1) {
            if (aProblems[myCommandB - 1] == 0) {
                myProblemsCount++;
            }
            aProblems[myCommandB - 1]++;
        }
        if (myCommandB - 2 >= 0 && aProblems[myCommandB - 2] > 0) {
            if (aProblems[myCommandB - 2] == 1) {
                myProblemsCount--;
            }
            aProblems[myCommandB - 2]--;
        }
        return myProblemsCount;
    }

    private static int[][] readCommands(BufferedReader input, int myInput) throws IOException {
        int[][] myCommands = new int[myInput][2];
        for (int i = 0; i < myInput; i++) {
            String[] myInputs = input.readLine().split(" ");
            myCommands[i][0] = Integer.parseInt(myInputs[0]);
            myCommands[i][1] = Integer.parseInt(myInputs[1]);
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
