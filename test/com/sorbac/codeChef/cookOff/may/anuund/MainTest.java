package com.sorbac.codeChef.cookOff.may.anuund;

import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void test1() throws Exception {
        doTest(new int[]{3, 2});
    }

    @Test
    public void test2() throws Exception {
        doTest(new int[]{10, 5, 2});
    }

    @Test
    public void test3() throws Exception {
        doTest(new int[]{1, 2, 1, 2, 1, 2, 1});

    }

    private void doTest(int[] aNumbers) {
        int[] mySorted = Main.sort(aNumbers);
        int myUp = 1;
        for (int i = 0; i < mySorted.length - 1; i++) {
            assert aNumbers[i] * myUp <= aNumbers[i + 1] * myUp;
            myUp *= -1;
        }
    }
}