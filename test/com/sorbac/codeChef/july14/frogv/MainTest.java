package com.sorbac.codeChef.july14.frogv;

import org.testng.annotations.Test;

import java.util.List;

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
        assert myPairs.get(0).getStartIndex() == 0;
        assert myPairs.get(0).getEndIndex() == 17;
    }
}