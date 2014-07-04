package com.sorbac.codeChef.july14.csub;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            input.readLine(); //Read line with digit counts
            long myNumbers = readTestCase(input);
            out.append(String.valueOf((myNumbers * (myNumbers + 1)) / 2));
            out.newLine();
        }
        out.flush();
    }

    private static long readTestCase(BufferedReader aInput) throws IOException {
        long myCount = 0;
        for (char myChar : aInput.readLine().toCharArray()) {
            if (myChar == '1') {
                myCount++;
            }
        }
        return myCount;
    }
}
