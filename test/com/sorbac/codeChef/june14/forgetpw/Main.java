package com.sorbac.codeChef.june14.forgetpw;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(myTestCase.getDecodedPassword());
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        char[] myRules = new char[95];
        int myNumberOfRules = Integer.valueOf(aInput.readLine());
        for (int i = 0; i < myNumberOfRules; i++) {
            String[] myRule = aInput.readLine().split(" ");
            myRules[(char) Integer.parseInt(myRule[0]) - '!'] = (char) Integer.parseInt(myRule[1]);
        }
        String myPassword = aInput.readLine();
        return new TestCase(myRules, myPassword);
    }

    public static class TestCase {
        private final char[] codeRules;
        private final String password;

        public TestCase(char[] aCodeRules, String aPassword) {
            codeRules = aCodeRules;
            password = aPassword;
        }


        public String getDecodedPassword() {
            char[] myDecodedPassword = new char[password.length()];
            for (int i = 0; i < password.length(); i++) {
                if (codeRules[password.charAt(i) - '!'] != 0) {
                    myDecodedPassword[i] = codeRules[password.charAt(i) - '!'];
                } else {
                    myDecodedPassword[i] = password.charAt(i);
                }
            }

            return new String(myDecodedPassword);
        }
    }
}
