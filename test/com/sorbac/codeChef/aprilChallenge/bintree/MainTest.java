package com.sorbac.codeChef.aprilChallenge.bintree;

import org.testng.annotations.Test;

/**
 * Created by sorbac on 6.4.2014.
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        assert Main.findMinPath(new int[]{1, 2}) == 1;
    }

    @Test
    public void test2() throws Exception {
        assert Main.findMinPath(new int[]{2, 3}) == 2;
    }

    @Test
    public void test3() throws Exception {
        assert Main.findMinPath(new int[]{4, 3}) == 3;
    }

    @Test
    public void test4() throws Exception {
        assert Main.findMinPath(new int[]{4, 4}) == 0;
    }

    @Test
    public void test5() throws Exception {
        assert Main.findMinPath(new int[]{3, 3}) == 0;
    }

    @Test
    public void test6() throws Exception {
        assert Main.findMinPath(new int[]{1, 5}) == 2;
    }
}
