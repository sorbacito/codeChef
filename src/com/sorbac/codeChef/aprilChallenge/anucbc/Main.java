package com.sorbac.codeChef.aprilChallenge.anucbc;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer myNumberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < myNumberOfTestCases; i++) {
            int[] myConfiguration = readInput(input, 2);

            //out.append(findNextPrime(readCaseSum(input)).toString());
            out.newLine();
        }
        out.flush();
    }

    private static int[] readInput(BufferedReader input, int aNumberOfValues) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[aNumberOfValues];
        for (int i = 0; i < aNumberOfValues; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    static class Case {
        private final long[] theNumbers;

        public Case(int aBase, long[] aNumbers) {
            theNumbers = aNumbers;

        }

        public int calculateSubsets(int aSum) {
            long[][] modulos = new long[2][2 * aSum + 1];
            int currentModulos = 0;
            for (long i : theNumbers) {
                int nextModulos = (currentModulos + 1) % 2;
                for (int j = 0; i < 2 * aSum + 1; i++) {
                    int newModulo = (int) (j - aSum + i) % aSum;
                    if (newModulo != 0) {
                        modulos[nextModulos][newModulo + aSum] += modulos[currentModulos][j];
                    } else {
                        //modulos[nextModulos][]
                    }
                }
                //modulos[(int) i % aSum + aSum - 1]++;
            }
            // return allSubsets() % 1000000009;
            return 0;
        }
    }
}
