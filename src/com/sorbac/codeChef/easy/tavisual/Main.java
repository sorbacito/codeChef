package com.sorbac.codeChef.easy.tavisual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * Solution for http://www.codechef.com/problems/TAVISUAL
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInputs = Integer.parseInt(input.readLine());
        List<BallCupsGame> myReadBallCupsGames = readBallCupsGames(input, numberOfInputs);
        for (BallCupsGame myBallCupsGame : myReadBallCupsGames) {
            out.append(Integer.valueOf(myBallCupsGame.computeBallPositionAfterAllMoves()).toString());
            out.newLine();
        }
        out.flush();
    }

    private static List<BallCupsGame> readBallCupsGames(BufferedReader aInput, int aNumberOfInputs) throws IOException {
        String[] gameConfiguration;
        int ballPosition;
        int numberOfMoves;
        List<Pair> moves;
        String[] move;
        List<BallCupsGame> myBallCupsGames = new ArrayList<BallCupsGame>(aNumberOfInputs);
        for(int i = 0; i < aNumberOfInputs; i++) {
            gameConfiguration = aInput.readLine().split(" ");
            ballPosition = Integer.parseInt(gameConfiguration[1]);
            numberOfMoves = Integer.parseInt(gameConfiguration[2]);
            moves = new ArrayList<Pair>(numberOfMoves);
            for(int j = 0; j < numberOfMoves; j++) {
                move = aInput.readLine().split(" ");
                moves.add(new Pair(Integer.parseInt(move[0]), Integer.parseInt(move[1])));
            }
            myBallCupsGames.add(new BallCupsGame(ballPosition, moves));
        }
        return myBallCupsGames;
    }

    public static class BallCupsGame {
        private int ballPosition;
        private final List<Pair> moves;

        public BallCupsGame(int aBallPosition, List<Pair> aMoves) {
            ballPosition = aBallPosition;
            moves = aMoves;
        }

        public int computeBallPositionAfterAllMoves() {
            int myBallPosition = ballPosition;
            for(Pair move : moves) {
                if (move.isWithinRange(myBallPosition)) {
                    myBallPosition = Math.round(2 * move.getCentreOfRotation() - myBallPosition);
                }
            }
            return myBallPosition;
        }
    }

    public static class Pair {
        private final int left;
        private final int right;

        public Pair(int aLeft, int aRight) {
            left = aLeft;
            right = aRight;
        }

        public boolean isWithinRange(int aPosition) {
            return left <= aPosition && right >= aPosition;
        }

        public float getCentreOfRotation() {
            return ((float)left + (float )right)/2;
        }
    }
}
