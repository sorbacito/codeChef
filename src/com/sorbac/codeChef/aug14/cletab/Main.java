package com.sorbac.codeChef.aug14.cletab;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (long i = 0; i < myInputs[0]; i++) {
            TestCase myTestCase = readTestCase(input);
            out.append(Integer.valueOf(myTestCase.getCleaningNumber()).toString());
            out.newLine();
        }
        out.flush();
    }

    private static TestCase readTestCase(BufferedReader aInput) throws IOException {
        String[] myConfiguration = aInput.readLine().split(" ");
        String[] myCustomersOrderStrings = aInput.readLine().split(" ");
        int[] myCustomersOrder = new int[myCustomersOrderStrings.length];
        for (int i = 0; i < myCustomersOrderStrings.length; i++) {
            myCustomersOrder[i] = Integer.valueOf(myCustomersOrderStrings[i]);
        }
        return new TestCase(Integer.valueOf(myConfiguration[0]), myCustomersOrder);
    }

    private static int[] readInput(BufferedReader input) throws IOException {
        String[] myInputs = input.readLine().split(" ");
        int[] myOutput = new int[myInputs.length];
        for (int i = 0; i < myInputs.length; i++) {
            myOutput[i] = Integer.parseInt(myInputs[i]);
        }
        return myOutput;
    }

    public static class TestCase {
        private final int theTablesCount;
        private final int[] theCustomersOrder;
        private int theCleanedTables;
        private int[] theCustomerFrequency;
        private int theMaxCustomer;

        public TestCase(int aTablesCount, int[] aCustomersOrder) {
            theTablesCount = aTablesCount;
            theCustomersOrder = aCustomersOrder;
            theCustomerFrequency = calculateCustomerFrequency(aCustomersOrder);
            calculateLeastCleans();
        }

        private int[] calculateCustomerFrequency(int[] aCustomersOrder) {
            int myMax = -1;
            for (int myCustomerOrder : aCustomersOrder) {
                myMax = Math.max(myMax, myCustomerOrder);
            }
            theMaxCustomer = myMax;
            int[] myFrequency = new int[theMaxCustomer];
            for (int myCustomerOrder : aCustomersOrder) {
                myFrequency[myCustomerOrder - 1]++;
            }
            return myFrequency;
        }

        void calculateLeastCleans() {
            Map<Integer, Integer> myLeftOrders = initiateTables(theCustomersOrder);
            if (theCleanedTables < theTablesCount) {
                return;
            }
            List<Map<Integer, Integer>> myLevel = new ArrayList<Map<Integer, Integer>>();
            myLevel.add(myLeftOrders);
            final int myProcessedTables = myLeftOrders.get(theMaxCustomer + 1);
            myLeftOrders.put(theMaxCustomer + 1, theCleanedTables);
            for (int i = myProcessedTables; i < theCustomersOrder.length; i++) {
                List<Map<Integer, Integer>> myNewLevel = new ArrayList<Map<Integer, Integer>>();
                int myMin = Integer.MAX_VALUE;
                for (Map<Integer, Integer> myMap : myLevel) {
                    if (myMap.get(theCustomersOrder[i]) == null) {
                        boolean foundZeroFrequency = false;
                        for (Integer myKey : myMap.keySet()) {
                            if (theCustomerFrequency[myKey - 1] == 0) {
                                myMap.remove(myKey);
                                myMap.put(theCustomersOrder[i], Integer.MAX_VALUE);
                                myMap.put(theMaxCustomer + 1, myMap.get(theMaxCustomer + 1) + 1);
                                foundZeroFrequency = true;
                                break;
                            }
                        }
                        if (!foundZeroFrequency) {
                            for (Integer myKeyToRemove : myMap.keySet()) {
                                Map<Integer, Integer> myNewMap = new HashMap<Integer, Integer>();
                                myNewMap.putAll(myMap);
                                myNewMap.remove(myKeyToRemove);
                                myNewMap.put(theCustomersOrder[i], Integer.MAX_VALUE);
                                myNewMap.put(theMaxCustomer + 1, myMap.get(theMaxCustomer + 1) + 1);
                                myNewLevel.add(myNewMap);
                            }
                        }
                    }
                    myMin = Math.min(myMin, myMap.get(theMaxCustomer + 1));
                }
                theCleanedTables = Math.max(theCleanedTables, myMin);
                myLevel.addAll(myNewLevel);
            }
        }

        private Map<Integer, Integer> initiateTables(int[] aCustomersOrder) {
            int iterator = 0;
            Map<Integer, Integer> myInitialState = new HashMap<Integer, Integer>();
            while (theCleanedTables < theTablesCount && iterator < theCustomersOrder.length) {
                if (myInitialState.get(theCustomersOrder[iterator]) == null) {
                    myInitialState.put(theCustomersOrder[iterator], Integer.MAX_VALUE);
                    theCleanedTables++;
                }
                theCustomerFrequency[theCustomersOrder[iterator++] - 1]--;
            }
            myInitialState.put(theMaxCustomer + 1, iterator);
            return myInitialState;
        }

        public int getCleaningNumber() {
            return theCleanedTables;
        }
    }
}
