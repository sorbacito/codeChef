package com.sorbac.codeChef.june14.forgetpw;

import java.io.*;
import java.util.Arrays;

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
            myRules[myRule[0].charAt(0) - '!'] = myRule[1].charAt(0);
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
            char[] myDecodedPassword = decodePassword(password, codeRules);
            int myLeadingZerosNumber = calculateLeadingZerosNumber(myDecodedPassword);
            int myTrailingZerosNumber = calculateTrailingZerosNumber(myDecodedPassword);
            int myDecimalPointPosition = new String(myDecodedPassword).indexOf(".");
            if (myDecimalPointPosition >= 0) { // has decimal part
                myDecodedPassword = Arrays.copyOfRange(myDecodedPassword, myLeadingZerosNumber, myDecodedPassword.length - myTrailingZerosNumber);
            } else {
                myDecodedPassword = Arrays.copyOfRange(myDecodedPassword, myLeadingZerosNumber, myDecodedPassword.length);
            }
            if (myDecodedPassword.length > 0 && myDecodedPassword[myDecodedPassword.length - 1] == '.') {
                myDecodedPassword = Arrays.copyOfRange(myDecodedPassword, 0, myDecodedPassword.length - 1);
            }
            if (myDecodedPassword.length == 0) {
                return "0";
            } else {
                return new String(myDecodedPassword);
            }
        }

        public static char[] decodePassword(String aString, char[] aCodeRules) {
            char[] myDecodedPassword = new char[aString.length()];
            for (int i = 0; i < aString.length(); i++) {
                if (aCodeRules[aString.charAt(i) - '!'] != 0) {
                    myDecodedPassword[i] = aCodeRules[aString.charAt(i) - '!'];
                } else {
                    myDecodedPassword[i] = aString.charAt(i);
                }
            }
            return myDecodedPassword;
        }

        public static int calculateTrailingZerosNumber(char[] aPassword) {
            int myCount = 0;
            for (int i = aPassword.length - 1; i > 0; i--) {
                if (aPassword[i] == '0') {
                    myCount++;
                } else {
                    break;
                }
            }
            return myCount;
        }

        public static int calculateLeadingZerosNumber(char[] aString) {
            int myCount = 0;
            for (char myChar : aString) {
                if (myChar == '0') {
                    myCount++;
                } else {
                    break;
                }
            }
            return myCount;
        }
    }
}
