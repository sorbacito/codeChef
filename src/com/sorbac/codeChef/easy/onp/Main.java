package com.sorbac.codeChef.easy.onp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sorbac on 6.2.2014.
 */
public class Main {

    public static List<String> processInput(List<String> aLines) {
        ArrayList<String> processedLines = new ArrayList<String>();
        for (String myLine : aLines) {
            processedLines.add(processLine(myLine));
        }
        return processedLines;
    }

    private static String processLine(String myLine) {
        Node tree = createTree(myLine);
        return tree.toStringBuffer().toString();
    }

    private static Node createTree(String myExpression) {
        if (myExpression.length() == 1) {
            return new Node(null, myExpression.charAt(0), null);
        }
        int level = countLevel(myExpression);
        if (level == 0) {
            return new Node(new Node(null, myExpression.charAt(0), null),
                    myExpression.charAt(1),
                    new Node(null, myExpression.charAt(2), null));
        } else {
            int sameLevelIndex = myExpression.indexOf("(", level + 1);
            return new Node(createTree(myExpression.substring(level, sameLevelIndex - 2)),
                    myExpression.charAt(sameLevelIndex - 1),
                    createTree(myExpression.substring(sameLevelIndex + 1, myExpression.length() - 2)));
        }
    }

    public static int countLevel(String myLine) {
        int level = 0;
        while (myLine.charAt(level) == '(') {
            level++;
        }
        return level;
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
