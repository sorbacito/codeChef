package com.sorbac.codeChef.aprilChallenge.adigit;

import org.testng.annotations.Test;

/**
 * Created by sorbac on 6.4.2014.
 */
public class MainOldTest {

    private final MainOld theMainOld = new MainOld(new int[]{0, 3, 2, 4, 1, 5, 2, 3, 9, 7});

    @Test
    public void test1() throws Exception {
        assert theMainOld.computeStep(1) == 0;
    }

    @Test
    public void test51() throws Exception {
        assert theMainOld.computeStep(1) == 0;
    }

    @Test
    public void test52() throws Exception {
        assert theMainOld.computeStep(2) == 3;
    }

    @Test
    public void test53() throws Exception {
        assert theMainOld.computeStep(3) == 3;
    }

    @Test
    public void test54() throws Exception {
        assert theMainOld.computeStep(4) == 7;
    }

    @Test
    public void test55() throws Exception {
        assert theMainOld.computeStep(5) == 7;
    }

    @Test
    public void test56() throws Exception {
        assert theMainOld.computeStep(6) == 15;
    }

    @Test
    public void test57() throws Exception {
        assert theMainOld.computeStep(7) == 9;
    }

    @Test
    public void test58() throws Exception {
        assert theMainOld.computeStep(8) == 10;
    }

    @Test
    public void test59() throws Exception {
        assert theMainOld.computeStep(9) == 52;
    }

    @Test
    public void test510() throws Exception {
        assert theMainOld.computeStep(10) == 38;
    }

    @Test
    public void test2() throws Exception {
        assert theMainOld.computeStep(4) == 7;
    }

    @Test
    public void test3() throws Exception {
        assert theMainOld.computeStep(7) == 9;
    }

    @Test
    public void test4() throws Exception {
        assert theMainOld.computeStep(10) == 38;
    }

    @Test
    public void test5() throws Exception {
        theMainOld.computeStep(2);
        theMainOld.computeStep(8);
    }

    @Test
    public void test100() throws Exception {
        assert new MainOld(new int[]{0}).computeStep(1) == 0;
    }
}
