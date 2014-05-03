package com.sorbac.codeChef.may14.compiler;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myInputs = Integer.parseInt(input.readLine());
        for (int i = 0; i < myInputs; i++) {
            out.append(Long.valueOf(countLongestPrefix(input.readLine())).toString());
            out.newLine();
        }
        out.flush();
    }

    public static long countLongestPrefix(String myInput) {
        long myCounter = 0;
        long myLastCounter = 0;
        long myDepth = 0;
        for (char myChar : myInput.toCharArray()) {
            myCounter++;
            if (myChar == '<') {
                myDepth++;
            } else {
                myDepth--;
            }
            if (myDepth < 0) {
                return myCounter - 1;
            }
            if (myDepth == 0) {
                myLastCounter = myCounter;
            }
        }
        return myLastCounter;
    }
}
