package com.sorbac.codeChef.aprilChallenge.tangdiv;

import org.testng.annotations.Test;

import static com.sorbac.codeChef.aprilChallenge.tangdiv.Main.Pair;


public class MainTest {
    @Test
    public void testName() throws Exception {
        Pair[] myPairs = new Pair[]{new Pair(1, 4), new Pair(5, 5), new Pair(6, 10)};
        Main.MyTree myMyTree = Main.Case.createMyTree(Main.Case.prepareLeaves(Main.Case.createMap(myPairs)));
        assert myMyTree.containsPair(new Pair(5, 5), 10);
    }

    @Test
    public void testName1() throws Exception {
        Pair[] myPairs = new Pair[]{new Pair(2, 5), new Pair(10, 1), new Pair(6, 9)};
        Main.MyTree myMyTree = Main.Case.createMyTree(Main.Case.prepareLeaves(Main.Case.createMap(myPairs)));
        assert myMyTree.containsPair(new Pair(1, 1), 10);
    }

    @Test
    public void testMoreLevels() throws Exception {
        Pair[] myPairs = new Pair[]{new Pair(2, 5), new Pair(10, 11), new Pair(6, 9), new Pair(11, 1)};
        Main.MyTree myMyTree = Main.Case.createMyTree(Main.Case.prepareLeaves(Main.Case.createMap(myPairs)));
        assert myMyTree.containsPair(new Pair(4, 6), 11) == false;
    }

    @Test
    public void testExampleX() throws Exception {
        Pair[] myPairsOriginal = new Pair[]{new Pair(1, 1)};
        Pair[] myPairsNew = new Pair[]{new Pair(1, 1)};
        assert new Main.Case(10, myPairsOriginal, myPairsNew).getAnswer().equals("Yes");
    }

    @Test
    public void testExample1() throws Exception {
        Pair[] myPairsOriginal = new Pair[]{new Pair(1, 4), new Pair(5, 5), new Pair(6, 10)};
        Pair[] myPairsNew = new Pair[]{new Pair(1, 5), new Pair(6, 10)};
        assert new Main.Case(10, myPairsOriginal, myPairsNew).getAnswer().equals("Yes");
        assert new Main.Case(10, new Pair[]{new Pair(1, 4), new Pair(5, 5), new Pair(6, 10)},
                new Pair[]{new Pair(1, 5), new Pair(6, 10)}).getAnswer().equals("Yes");
    }

    @Test
    public void testExample2() throws Exception {
        Pair[] myPairsOriginal = new Pair[]{new Pair(2, 5), new Pair(10, 1), new Pair(6, 9)};
        Pair[] myPairsNew = new Pair[]{new Pair(1, 10)};
        assert new Main.Case(10, myPairsOriginal, myPairsNew).getAnswer().equals("No");
    }

    @Test
    public void testPairs() throws Exception {
        assert new Pair(2, 5).contains(new Pair(3, 4), 10);
        assert new Pair(2, 5).contains(new Pair(2, 5), 10);
        assert new Pair(2, 5).contains(new Pair(2, 4), 10);
        assert new Pair(2, 5).contains(new Pair(3, 5), 10);
        assert new Pair(2, 5).contains(new Pair(5, 5), 10);
        assert new Pair(2, 5).contains(new Pair(2, 2), 10);
        assert new Pair(2, 5).contains(new Pair(3, 3), 10);

        assert new Pair(2, 5).contains(new Pair(1, 5), 10) == false;
        assert new Pair(2, 5).contains(new Pair(2, 6), 10) == false;
        assert new Pair(2, 5).contains(new Pair(1, 6), 10) == false;
        assert new Pair(2, 5).contains(new Pair(1, 1), 10) == false;
        assert new Pair(2, 5).contains(new Pair(6, 6), 10) == false;

        assert new Pair(2, 5).contains(new Pair(5, 2), 10) == false;
        assert new Pair(2, 5).contains(new Pair(6, 2), 10) == false;
        assert new Pair(2, 5).contains(new Pair(5, 1), 10) == false;
        assert new Pair(2, 5).contains(new Pair(6, 1), 10) == false;
        assert new Pair(2, 5).contains(new Pair(6, 6), 10) == false;
        assert new Pair(2, 5).contains(new Pair(1, 1), 10) == false;
        assert new Pair(2, 5).contains(new Pair(6, 9), 10) == false;

        assert new Pair(9, 3).contains(new Pair(2, 5), 10) == false;
        assert new Pair(9, 3).contains(new Pair(9, 4), 10) == false;
        assert new Pair(9, 3).contains(new Pair(9, 3), 10);
        assert new Pair(9, 3).contains(new Pair(9, 2), 10);
        assert new Pair(9, 3).contains(new Pair(10, 2), 10);
        assert new Pair(3, 3).contains(new Pair(3, 2), 10) == false;
        assert new Pair(3, 3).contains(new Pair(3, 3), 10);
    }

    @Test
    public void testSpecialPairs() throws Exception {
        assert new Pair(2, 1).contains(new Pair(1, 2), 10) == false;
    }

    @Test
    public void testSpecialPairsA() throws Exception {
        assert new Pair(8, 3).contains(new Pair(1, 2), 10);
    }

    @Test
    public void testSpecialPairs1() throws Exception {
        assert new Pair(6, 5).contains(new Pair(1, 10), 10) == false;
    }

    @Test
    public void testSpecialPairsX() throws Exception {
        assert new Pair(2, 1).contains(new Pair(1, 1), 10);
    }

    @Test
    public void testSpecialPairs1X() throws Exception {
        assert new Pair(6, 5).contains(new Pair(1, 10), 10) == false;
    }
}
