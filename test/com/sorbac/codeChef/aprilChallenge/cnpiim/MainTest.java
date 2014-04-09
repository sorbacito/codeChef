package com.sorbac.codeChef.aprilChallenge.cnpiim;

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
 *  Time: 19:19
 *
 */
public class MainTest {

    private Main theMain = new Main();

    @Test
    public void testNumberOfMultiplications() throws Exception {
        assert theMain.getNumberOfMultiplications(1) == 1;
        assert theMain.getNumberOfMultiplications(2) == 3;
        assert theMain.getNumberOfMultiplications(3) == 5;
        assert theMain.getNumberOfMultiplications(5) == 10;
    }

    @Test
    public void testMatrices3() throws Exception {
        assert theMain.computeMatrices(3) == 2;
    }

    // 1*2 - 1 = 1 -> 1
    // 2*1 - 1 = 1 -> 1

    @Test
    public void testMatrices4() throws Exception {
        assert theMain.computeMatrices(4) == 11;
    }

    // 1*3 - 1 = 2 -> 2 + 1
    // 2*2 - 1 = 3 -> 3 + 1 + 1
    // 3*1 - 1 = 2 -> 2 + 1

    @Test
    public void testMatrices5() throws Exception {
        assert theMain.computeMatrices(5) == 30;
    }

    // 1*4 - 1 = 3 -> 3 + 1 + 1
    // 2*3 - 1 = 5 -> 5 + 2 + 1 + 1 + 1
    // 3*2 - 1 = 5 -> 5 + 2 + 1 + 1 + 1
    // 4*1 - 1 = 3 -> 3 + 1 + 1
    @Test
    public void testMatrices6() throws Exception {
        assert theMain.computeMatrices(6) == 68;
    }

    // 1*5 - 1 = 4 -> 4 + 2 + 1 + 1 = 8
    // 2*4 - 1 = 7 -> 7 + 3 + 2 + 1 + 1 + 1 + 1 = 16
    // 3*3 - 1 = 8 -> 8 + 4 + 2 + 2 + 1 + 1 + 1 + 1 = 20
    // 4*2 - 1 = 7 -> 7 + 3 + 2 + 1 + 1 + 1 + 1 = 16
    // 5*1 - 1 = 4 -> 4 + 2 + 1 + 1 = 8

}
