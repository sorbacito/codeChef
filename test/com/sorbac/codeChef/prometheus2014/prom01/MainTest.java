package com.sorbac.codeChef.prometheus2014.prom01;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTest {

    private static final int MODULO = 1000001;

    @Test
    public void testExample1() throws Exception {
        assert Main.numberOfPositions(new long[]{2, 2}) == 12;
    }

    @Test
    public void testExample2() throws Exception {
        assert Main.numberOfPositions(new long[]{100, 223}) == 10907100;
    }

    @Test
    public void testMyExample1() throws Exception {
        assert Main.numberOfPositions(new long[]{0, 0}) == 0;
    }

    @Test
    public void testMyExample2() throws Exception {
        assert Main.numberOfPositions(new long[]{1, 1}) == 0;
    }

    @Test
    public void testMyExample3() throws Exception {
        assert Main.numberOfPositions(new long[]{1, 3}) == 6;
    }

    @Test
    public void testMyExample4() throws Exception {
        assert Main.numberOfPositions(new long[]{4, 1}) == 12;
    }

    @Test
    public void testMyExample5() throws Exception {
        assert Main.numberOfPositions(new long[]{4, 2}) == 44;
    }

    @Test
    public void testMyExample6() throws Exception {
        assert Main.numberOfPositions(new long[]{5, 5}) == 320;
    }

    @Test
    public void testMyExampleMax() throws Exception {
        assert Main.numberOfPositions(new long[]{1000000, 1000000}) > 0;
    }

    @Test
    public void testDiag() throws Exception {
        assert Main.countPartialDiag(1) == 0;
        assert Main.countPartialDiag(2) == 2;
        assert Main.countPartialDiag(3) == 8;
        assert Main.countPartialDiag(4) == 20;
    }

    @Test(enabled = false)
    public void testRandom() throws Exception {
        List<long[]> myData = new ArrayList<long[]>();
        Random myRandom = new Random();
        for (int i = 0; i < 200000; i++) {
            myData.add(new long[]{myRandom.nextInt(MODULO), myRandom.nextInt(MODULO)});
        }
        for (long[] myRow : myData) {
            assert Main.numberOfPositions(myRow) > 0;
        }
        //Main.outputThem(myData);
    }
}
