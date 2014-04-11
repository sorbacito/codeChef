package com.sorbac.codeChef.aprilChallenge.tangdiv;

import org.testng.annotations.Test;

import static com.sorbac.codeChef.aprilChallenge.tangdiv.Main.Pair;


public class MainTest {
    @Test
    public void testName() throws Exception {
        Pair[] myPairs = new Pair[]{new Pair(1, 4), new Pair(5, 5), new Pair(6, 10)};
        Main.MyTree myMyTree = Main.Case.createMyTree(Main.Case.prepareLeaves(Main.Case.createMap(myPairs)));
        assert myMyTree.containsPair(new Pair(5, 5));
    }

    @Test
    public void testName1() throws Exception {
        Pair[] myPairs = new Pair[]{new Pair(2, 5), new Pair(10, 1), new Pair(6, 9)};
        Main.MyTree myMyTree = Main.Case.createMyTree(Main.Case.prepareLeaves(Main.Case.createMap(myPairs)));
        assert myMyTree.containsPair(new Pair(1, 1));
    }

    @Test
    public void testExample1() throws Exception {
        Pair[] myPairsOriginal = new Pair[]{new Pair(1, 4), new Pair(5, 5), new Pair(6, 10)};
        Pair[] myPairsNew = new Pair[]{new Pair(1, 5), new Pair(6, 10)};
        assert new Main.Case(10, myPairsOriginal, myPairsNew).getAnswer().equals("Yes");
    }

    @Test
    public void testExample2() throws Exception {
        Pair[] myPairsOriginal = new Pair[]{new Pair(2, 5), new Pair(10, 1), new Pair(6, 9)};
        Pair[] myPairsNew = new Pair[]{new Pair(1, 10)};
        assert new Main.Case(10, myPairsOriginal, myPairsNew).getAnswer().equals("No");
    }

    @Test
    public void testPairs() throws Exception {
        assert new Pair(2, 5).contains(new Pair(3, 4));
        assert new Pair(2, 5).contains(new Pair(2, 5));
        assert new Pair(9, 3).contains(new Pair(2, 5)) == false;
        assert new Pair(9, 3).contains(new Pair(9, 4)) == false;
        assert new Pair(9, 3).contains(new Pair(9, 3));
        assert new Pair(9, 3).contains(new Pair(9, 2));
        assert new Pair(9, 3).contains(new Pair(10, 2));
    }
}
