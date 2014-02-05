package com.sorbac.codeChef.easy.sumtrian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAXIMUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer numberOfTriangles = readBytes(input).get(0);
        for (int i = 0; i < numberOfTriangles; i++) {
            out.append(findMaxSum(readTriangle(input)));
            out.newLine();
        }
        out.flush();
    }

    public static String findMaxSum(List<List<Integer>> triangle) {
        int[] sums = new int[MAXIMUM + 1];
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                sums[j] = row.get(j) + Math.max(sums[j], sums[j + 1]);
            }
        }
        int totalSum = triangle.get(0).get(0) + Math.max(sums[0], sums[1]);
        return String.valueOf(totalSum);
    }

    private static List<List<Integer>> readTriangle(BufferedReader input) throws IOException {
        Integer triangleSize = readBytes(input).get(0);
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(triangleSize);
        for (int i = 0; i < triangleSize; i++) {
            triangle.add(i, readBytes(input));
        }
        return triangle;
    }


    private static List<Integer> readBytes(BufferedReader input) throws IOException {
        List<Integer> numbers = new ArrayList<Integer>(100);
        for (String number : input.readLine().trim().split(" ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}