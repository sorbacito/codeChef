package com.sorbac.codeChef.may14.rrstone;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    @Test
    public void test1() throws Exception {
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 0, new long[]{5, -1, 7, 0});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 1, new long[]{2, 8, 0, 7});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 2, new long[]{6, 0, 8, 1});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 3, new long[]{2, 8, 0, 7});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 4, new long[]{6, 0, 8, 1});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 5, new long[]{2, 8, 0, 7});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 6, new long[]{6, 0, 8, 1});
        testInput(new long[]{5, -1, 7, 0, 7, -1}, 1000000000, new long[]{6, 0, 8, 1});
    }

    @Test
    public void test2() throws Exception {
        testInput(new long[]{0, 0, 0, 0, 0}, 0, new long[]{0, 0, 0});
        testInput(new long[]{0, 0, 0, 0, 0}, 1, new long[]{0, 0, 0});
        testInput(new long[]{0, 0, 0, 0, 0}, 2, new long[]{0, 0, 0});
    }

    @Test
    public void test3() throws Exception {
        testInput(new long[]{1, 2, 3, 3, 1}, 0, new long[]{1, 2, 3});
        testInput(new long[]{1, 2, 3, 3, 1}, 1, new long[]{2, 1, 0});
        testInput(new long[]{1, 2, 3, 3, 1}, 2, new long[]{0, 1, 2});
        testInput(new long[]{1, 2, 3, 3, 1}, 3, new long[]{2, 1, 0});
    }

    @Test
    public void test4() throws Exception {
        testInput(new long[]{-1, -2, -3, -1, -3}, 0, new long[]{-1, -2, -3});
        testInput(new long[]{-1, -2, -3, -1, -3}, 1, new long[]{0, 1, 2});
        testInput(new long[]{-1, -2, -3, -1, -3}, 2, new long[]{2, 1, 0});
        testInput(new long[]{-2, -2, -3, -1, -3}, 3, new long[]{0, 1, 2});
    }

    @Test
    public void test5() throws Exception {
        testInput(new long[]{-2000000000, 2000000000, 2000000000, -2000000000}, 0, new long[]{-2000000000, 2000000000});
        testInput(new long[]{-2000000000, 2000000000, 2000000000, -2000000000}, 1, new long[]{4000000000l, 0});
        testInput(new long[]{-2000000000, 2000000000, 2000000000, -2000000000}, 2, new long[]{0, 4000000000l});
        testInput(new long[]{-2000000000, 2000000000, 2000000000, -2000000000}, 1000000000, new long[]{0, 4000000000l});
    }

    @Test
    public void test6() throws Exception {
        testInput(new long[]{3, 3, 3}, 0, new long[]{3});
        testInput(new long[]{3, 3, 3}, 1, new long[]{0});
        testInput(new long[]{3, 3, 3}, 2, new long[]{0});
    }

    private void testInput(long[] myInput, int myTurns, long[] myExpectedOutput) {
        long[] myResult = Main.computeResult(myInput, myTurns);
        for (int i = 0; i < myResult.length; i++) {
            assert myResult[i] == myExpectedOutput[i];
        }
    }
}