package com.sorbac.codeChef.aug14.reverse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myInputs = readInput(input);
        for (long i = 0; i < 1; i++) {
            TestCase myTestCase = readTestCase(myInputs[0], myInputs[1], input);
            out.append(Integer.valueOf(myTestCase.getDistance()).toString());
        }
        out.flush();
    }


    private static TestCase readTestCase(int aVertices, int aEdges, BufferedReader aInput) throws IOException {
        int[][] myEdges = new int[aEdges][];
        for (int i = 0; i < aEdges; i++) {
            myEdges[i] = readInput(aInput);
        }
        return new TestCase(aVertices, myEdges);
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
        private final List<int[]>[] theEdges;
        private final int[] theAnswer;

        public TestCase(int aVertices, int[][] aEdges) {
            theEdges = (List<int[]>[]) new List[aVertices];
            prepareMatrice(aEdges);
            theAnswer = aVertices == 1 ? new int[]{0, 0} : doDijkstra(aVertices, theEdges, 0);
        }

        public int getDistance() {
            return theAnswer[1] == -1 ? -1 : theAnswer[0];
        }

        private void prepareMatrice(int[][] aEdges) {
            for (int[] myEdge : aEdges) {
                addEdge(myEdge[0] - 1, myEdge[1] - 1, 0);
                addEdge(myEdge[1] - 1, myEdge[0] - 1, 1);
            }
        }

        private void addEdge(int aVertex1, int aVertex2, int aDistance) {
            if (theEdges[aVertex1] == null) {
                theEdges[aVertex1] = new ArrayList<int[]>();
            }
            theEdges[aVertex1].add(new int[]{aVertex2, aDistance});
        }

        public static int[] doDijkstra(int aVertices, List<int[]>[] aDistances, int from) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(from);

            boolean[] closed = new boolean[aVertices];
            int[] distances = new int[aVertices];
            for (int i = 0; i < aVertices; i++) {
                if (i != from) {
                    distances[i] = Integer.MAX_VALUE;
                } else {
                    distances[i] = 0;
                }
            }


            int[] predecessors = new int[aVertices];
            predecessors[from] = -1;
            predecessors[aVertices - 1] = -1;

            while (!set.isEmpty()) {
                //najdi nejblizsi dosazitelny uzel
                int minDistance = Integer.MAX_VALUE;
                int node = -1;
                for (Integer i : set) {
                    if (distances[i] < minDistance) {
                        minDistance = distances[i];
                        node = i;
                    }
                }

                set.remove(node);
                closed[node] = true;

                //zkrat vzdalenosti
                for (int i = 0; i < (aDistances[node] == null ? 0 : aDistances[node].size()); i++) {
                    //existuje tam hrana
                    final int myDistance = aDistances[node].get(i)[1];
                    final int myOtherVertex = aDistances[node].get(i)[0];
                    if (myDistance != Integer.MAX_VALUE) {
                        if (!closed[myOtherVertex]) {
                            //cesta se zkrati
                            if (distances[node] + myDistance < distances[myOtherVertex]) {
                                distances[myOtherVertex] = distances[node] + myDistance;
                                predecessors[myOtherVertex] = node;
                                set.add(myOtherVertex); // prida uzel mezi kandidaty, pokud je jiz obsazen, nic se nestane
                            }
                        }
                    }
                }
            }
            return new int[]{distances[aVertices - 1], predecessors[aVertices - 1]};
        }
    }

}
