package com.sorbac.codeChef.aprilChallenge.adigit;

import org.testng.annotations.Test;

/**
 * Created by sorbac on 6.4.2014.
 */
public class MainTest {

    private final Main theMain = new Main(new int[]{0, 3, 2, 4, 1, 5, 2, 3, 9, 7});

    @Test
    public void test1() throws Exception {
        assert theMain.computeStep(1) == 0;
    }

    @Test
    public void test2() throws Exception {
        assert theMain.computeStep(4) == 7;
    }

    @Test
    public void test3() throws Exception {
        assert theMain.computeStep(7) == 9;
    }

    @Test
    public void test4() throws Exception {
        assert theMain.computeStep(10) == 38;
    }

    @Test
    public void test5() throws Exception {
        theMain.computeStep(2);
        theMain.computeStep(8);
    }
}
