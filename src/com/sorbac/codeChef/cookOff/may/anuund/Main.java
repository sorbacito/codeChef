package com.sorbac.codeChef.cookOff.may.anuund;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            int[] myNumbers = readTestCase(input);
            int[] mySort = sort(myNumbers);
            for (int j = 0; j < mySort.length; j++) {
                out.append(String.valueOf(mySort[j]));
                if (j < mySort.length - 1) {
                    out.append(" ");
                }
            }
            out.newLine();
        }
        out.flush();
    }

    public static int[] sort(int[] aNumbers) {
        int temp;
        int myUp = 1;
        for (int i = 0; i < aNumbers.length - 1; i++) {
            if (aNumbers[i] * myUp > aNumbers[i + 1] * myUp) {
                temp = aNumbers[i];
                aNumbers[i] = aNumbers[i + 1];
                aNumbers[i + 1] = temp;
            }
            myUp *= -1;
        }
        return aNumbers;
    }

    private static int[] readTestCase(BufferedReader aInput) throws IOException {
        aInput.readLine();
        String[] myNumbers = aInput.readLine().split(" ");
        int[] myReturn = new int[myNumbers.length];
        for (int i = 0; i < myNumbers.length; i++) {
            myReturn[i] = Integer.parseInt(myNumbers[i]);
        }
        return myReturn;
    }
}
