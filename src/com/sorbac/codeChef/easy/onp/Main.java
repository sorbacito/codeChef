package com.sorbac.codeChef.easy.onp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInputs = Integer.parseInt(input.readLine());
        List<String> myExpressions = readExpressions(input, numberOfInputs);
        for (int i = 0; i < numberOfInputs; i++) {
            out.append(processLine(myExpressions.get(i)));
            out.newLine();
        }
        out.flush();
    }

    public static String processLine(String myLine) throws Exception {
        Node tree = createTree(myLine);
        return tree.toStringBuffer().toString();
    }

    private static Node createTree(String myExpression) throws Exception {
        if (myExpression.startsWith("(")) {
            myExpression = myExpression.substring(1, myExpression.length() - 1);
        }
        if (myExpression.length() == 1) {
            return new Node(null, myExpression.charAt(0), null);
        } else {
            int myEndBracket = findEndBracket(myExpression);
            if (myEndBracket == 0) {
                return new Node(new Node(null, myExpression.charAt(0), null),
                        myExpression.charAt(1),
                        createTree(myExpression.substring(2, myExpression.length())));
            } else {
                return new Node(createTree(myExpression.substring(0, myEndBracket + 1)),
                        myExpression.charAt(myEndBracket + 1),
                        createTree(myExpression.substring(myEndBracket + 2, myExpression.length())));
            }
        }
    }

    private static int findEndBracket(String aMyExpression) throws Exception {
        int myLevel = 0;
        char[] myChars = aMyExpression.toCharArray();
        for(int i = 0;i < aMyExpression.length(); i++) {
            if (myChars[i] == '(') {
                myLevel++;
            } else if (myChars[i] == ')') {
                myLevel--;
            }
            if (myLevel == 0) {
                return i;
            }
        }
        throw new Exception("End bracket not found!");
    }

    private static List<String> readExpressions(BufferedReader aInput, int aNumberOfInputs) throws IOException {
        List<String> myExpressions = new ArrayList<String>(aNumberOfInputs);
        for(int i = 0; i < aNumberOfInputs; i++) {
            myExpressions.add(aInput.readLine());
        }
        return myExpressions;
    }

    public static class Node {
        private char value;
        private Node rightNode;
        private Node leftNode;

        public Node(Node leftNode, char value, Node rightNode) {
            this.value = value;
            this.rightNode = rightNode;
            this.leftNode = leftNode;
        }

        public StringBuffer toStringBuffer() {
            if (rightNode == null && leftNode == null) {
                return new StringBuffer(String.valueOf(value));
            } else {
                StringBuffer leftNode = this.leftNode.toStringBuffer();
                StringBuffer rightNode = this.rightNode.toStringBuffer();
                return leftNode.append(rightNode).append(String.valueOf(value));
            }
        }
    }
}
