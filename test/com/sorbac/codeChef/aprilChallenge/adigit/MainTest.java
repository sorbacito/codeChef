package com.sorbac.codeChef.aprilChallenge.adigit;

import org.testng.annotations.Test;

/*
 *  Copyright 1999,2001 Clearstream Services, Luxembourg.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information
 *  of Clearstream Services ("Confidential Information").  You
 *  shall not disclose such Confidential Information and shall use
 *  it only in accordance with the terms of the license agreement
 *  you entered into with CS.
 *
 *  @author: Stanislav Kovalcin (ky234) |HUB team|
 *  Date: 09/04/14
 *  Time: 18:13
 *
 */
public class MainTest {
    private final Main theMain = new Main(new int[]{0, 3, 2, 4, 1, 5, 2, 3, 9, 7});

    @Test
    public void test1() throws Exception {
        assert theMain.computeStep(1) == 0;
    }

    @Test
    public void test51() throws Exception {
        assert theMain.computeStep(1) == 0;
    }

    @Test
    public void test52() throws Exception {
        assert theMain.computeStep(2) == 3;
    }

    @Test
    public void test53() throws Exception {
        assert theMain.computeStep(3) == 3;
    }

    @Test
    public void test54() throws Exception {
        assert theMain.computeStep(4) == 7;
    }

    @Test
    public void test55() throws Exception {
        assert theMain.computeStep(5) == 7;
    }

    @Test
    public void test56() throws Exception {
        assert theMain.computeStep(6) == 15;
    }

    @Test
    public void test57() throws Exception {
        assert theMain.computeStep(7) == 9;
    }

    @Test
    public void test58() throws Exception {
        assert theMain.computeStep(8) == 10;
    }

    @Test
    public void test59() throws Exception {
        assert theMain.computeStep(9) == 52;
    }

    @Test
    public void test510() throws Exception {
        assert theMain.computeStep(10) == 38;
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

    @Test
    public void test100() throws Exception {
        assert new Main(new int[]{0}).computeStep(1) == 0;
    }
}
