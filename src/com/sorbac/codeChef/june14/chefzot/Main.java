package com.sorbac.codeChef.june14.chefzot;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int mySequenceNumber = Integer.parseInt(input.readLine());
        int[] sequence = readSequence(input, mySequenceNumber);
        out.write(String.valueOf(findLongestNonzeroSequence(sequence)));
        out.flush();
    }

    public static int findLongestNonzeroSequence(int[] sequence) {
        int longest = 0;
        int current = 0;
        for (int number : sequence) {
            if (number != 0) {
                current++;
            } else {
                if (longest < current) {
                    longest = current;
                }
                current = 0;
            }
        }
        return longest > current ? longest : current;
    }

    private static int[] readSequence(BufferedReader aInput, int aSequenceNumber) throws IOException {
        String[] myNumbers = aInput.readLine().split(" ");
        int[] mySequence = new int[myNumbers.length];
        for (int i = 0; i < myNumbers.length; i++) {
            mySequence[i] = Integer.valueOf(myNumbers[i]);
        }
        return mySequence;
    }
}
