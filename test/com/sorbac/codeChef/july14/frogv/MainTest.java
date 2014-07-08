package com.sorbac.codeChef.july14.frogv;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainTest {
    @Test
    public void testLinkedList() throws Exception {
        List<Main.Pair> myPairs = Main.createLinkedList(new int[]{11, 4, 8}, 1);
        assert myPairs.size() == 3;
        assert myPairs.get(0).getStartIndex() == 4;
        assert myPairs.get(0).getEndIndex() == 4;
        assert myPairs.get(0).compareAxis(3) == 0;
        assert myPairs.get(0).compareAxis(5) == 0;
        assert myPairs.get(1).getStartIndex() == 8;
        assert myPairs.get(1).getEndIndex() == 8;
        assert myPairs.get(2).getStartIndex() == 11;
        assert myPairs.get(2).getEndIndex() == 11;
        assert myPairs.get(2).compareAxis(9) == -1;
        assert myPairs.get(2).compareAxis(13) == 1;
    }

    @Test
    public void testLinkedListEnlargement() throws Exception {
        List<Main.Pair> myPairs = Main.createLinkedList(new int[]{11, 4, 8}, 6);
        assert myPairs.size() == 1;
        assert myPairs.get(0).getStartIndex() == 4;
        assert myPairs.get(0).getEndIndex() == 11;
    }

    @Test
    public void test1() throws Exception {
        LinkedList<Main.Pair> myPairs = Main.createLinkedList(new int[]{0, 5, 7}, 2);
        assert Main.findIndex(myPairs, 2) == 0;
        assert Main.findIndex(myPairs, 0) == 0;
        assert Main.findIndex(myPairs, 3) == 1;
        assert Main.findIndex(myPairs, 7) == 1;
        assert Main.findIndex(myPairs, 9) == 1;
    }

    @Test
    public void testFindIndex() throws Exception {
        LinkedList<Main.Pair> myPairs = new LinkedList<Main.Pair>();
        myPairs.add(0, new Main.Pair(11, 1));
        myPairs.add(0, new Main.Pair(7, 1));
        myPairs.add(0, new Main.Pair(3, 1));
        assert Main.findIndex(myPairs, 1) == 0;
        assert Main.findIndex(myPairs, 2) == 0;
        assert Main.findIndex(myPairs, 3) == 0;
        assert Main.findIndex(myPairs, 4) == 0;
        assert Main.findIndex(myPairs, 5) == 1;
        assert Main.findIndex(myPairs, 6) == 1;
        assert Main.findIndex(myPairs, 7) == 1;
        assert Main.findIndex(myPairs, 8) == 1;
        assert Main.findIndex(myPairs, 9) == 2;
        assert Main.findIndex(myPairs, 12) == 2;
        assert Main.findIndex(myPairs, 13) == 3;
        assert Main.findIndex(myPairs, 17) == 3;
    }

    @Test(enabled = false)
    public void testRandom() throws Exception {
        Random myRandom = new Random();
        final int myK = 1000000000;
        for (int i = 0; i < 1000000; i++) {
            final int iRandom = myRandom.nextInt(100000);
            int[] myInput = new int[iRandom];
            for (int j = 0; j < iRandom; j++) {
                myInput[j] = myRandom.nextInt(myK);
            }
            try {
                Main.createLinkedList(myInput, myRandom.nextInt(myK));
            } catch (Exception e) {
                for (int myIn : myInput) {
                    System.out.print(myIn + " ");
                }
                System.out.println();
                System.out.println(e);
                throw e;
            }
        }
    }
}