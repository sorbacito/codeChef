package com.sorbac.codeChef.easy.comm3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
 *  Copyright 1999,2001 Clearstream Services, Luxembourg.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information
 *  of Clearstream Services ("Confidential Information").  You
 *  shall not disclose such Confidential Information and shall use
 *  it only in accordance with the terms of the license agreement
 *  you entered into with CS.
 *
 *  @author: Stanislav Kovalcin (ky234) |HUB team|
 *  Date: 07/02/14
 *  Time: 13:43
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInputs = Integer.parseInt(input.readLine());
        List<TestCase> myTestCases = readTestCases(input, numberOfInputs);
        for (TestCase myTestCase : myTestCases) {
            out.append(myTestCase.canCommunicate());
            out.newLine();
        }
        out.flush();
    }

    private static List<TestCase> readTestCases(BufferedReader aInput, int aNumberOfInputs) throws IOException {
        int maximumDistance;
        Position myPosition1;
        Position myPosition2;
        Position myPosition3;
        List<TestCase> myTestCases = new ArrayList<TestCase>();
        for(int i = 0; i < aNumberOfInputs; i++) {
            maximumDistance = Integer.parseInt(aInput.readLine());
            myPosition1 = createPosition(aInput.readLine());
            myPosition2 = createPosition(aInput.readLine());
            myPosition3 = createPosition(aInput.readLine());
            myTestCases.add(new TestCase(maximumDistance, myPosition1, myPosition2, myPosition3));
        }
        return myTestCases;
    }

    private static Position createPosition(String myLine) {
        String[] myCoordinates = myLine.split(" ");
        return new Position(Integer.parseInt(myCoordinates[0]), Integer.parseInt(myCoordinates[1]));
    }

    public static class Position {
        private final int x;
        private final int y;

        public Position(int aX, int aY) {
            x = aX;
            y = aY;
        }

        public Double distance(Position aPosition) {
            if (aPosition != null) {
                return Math.sqrt(Math.pow(x - aPosition.x, 2) + Math.pow(y - aPosition.y, 2));
            } else {
                return null;
            }
        }
    }

    public static class TestCase {
        private final int maximumDistance;
        private final Position positionOne;
        private final Position positionTwo;
        private final Position positionThree;

        public TestCase(int aMaximumDistance, Position aPositionOne, Position aPositionTwo, Position aPositionThree) {
            maximumDistance = aMaximumDistance;
            positionOne = aPositionOne;
            positionTwo = aPositionTwo;
            positionThree = aPositionThree;
        }

        public String canCommunicate() {
            double distanceOneTwo = positionOne.distance(positionTwo);
            double distanceOneThree = positionOne.distance(positionThree);
            double distanceTwoThree = positionTwo.distance(positionThree);
            int commLines = Double.compare(distanceOneTwo, maximumDistance) <= 0 ? 1 : 0;
            commLines = Double.compare(distanceOneThree, maximumDistance) <= 0 ? commLines + 1 : commLines;
            commLines = Double.compare(distanceTwoThree, maximumDistance) <= 0 ? commLines + 1: commLines;
            if (commLines >= 2) {
                return "yes";
            } else {
                return "no";
            }
        }
    }
}
