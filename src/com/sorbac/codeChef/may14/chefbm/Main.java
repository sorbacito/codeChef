package com.sorbac.codeChef.may14.chefbm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input, 3);
        int[][] myIncCommands = readCommands(input, myInputs[2]);
        for (long myResult : computeResults(myInputs[0], myInputs[1], myIncCommands)) {
            out.append(Long.valueOf(myResult).toString());
            out.newLine();
        }
        out.flush();
    }

    public static long[] computeResults(int myInput, int myInput1, int[][] myIncCommands) {
        long[][] myMatrix = new long[myInput1 + 1][myInput];
        for (int i = 0; i < myInput1; i ++) {
            myMatrix[myInput1][i] = myInput - 1;
        }
        for (int[] myCommand : myIncCommands) {
            if (myMatrix[myInput1][myCommand[0] - 1] != -1) {
                myMatrix[myCommand[1] - 1][myCommand[0] - 1]++;
                if (myCommand[1] < myInput1 - 1 &&
                        myMatrix[myCommand[1] - 1][myCommand[0] - 1] > myMatrix[myCommand[1]][myCommand[0] - 1] + 1) {
                    myMatrix[myInput1][myCommand[0] - 1] = -1;
                }
                if (myCommand[1] == myInput1) {
                    myMatrix[myInput1][myCommand[0] - 1]++;
                }
            }
        }
        return myMatrix[myInput1];
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
