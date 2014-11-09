package com.sorbac.codeChef.nov14.dischar;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myInputs = Integer.parseInt(input.readLine());
        for (long i = 0; i < myInputs; i++) {
            String myConfiguration = input.readLine();
            out.append(String.valueOf(numberOfDistinctChars(myConfiguration)));
            out.newLine();
        }
        out.flush();
    }

    private static int numberOfDistinctChars(String aConfiguration) {
        boolean[] myExistChar = new boolean['z' - 'a' + 1];
        for (char myChar : aConfiguration.toCharArray()) {
            myExistChar[myChar - 'a'] = true;
        }
        int i = 0;
        for (boolean myExist : myExistChar) {
            if (myExist) {
                i++;
            }
        }
        return i;
    }
}
