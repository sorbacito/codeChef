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
        assert theMain.getNumberOfMultiplications(4) == 8;
        assert theMain.getNumberOfMultiplications(5) == 10;
        assert theMain.getNumberOfMultiplications(6) == 14;
        assert theMain.getNumberOfMultiplications(7) == 16;
    }

    @Test
    public void testHighest() throws Exception {
        assert theMain.getNumberOfMultiplications(1250 * 1250 - 1) > 0;

    }

    @Test
    public void testMatrices() throws Exception {
        assert theMain.computeMatrices(3) == 2;
        assert theMain.computeMatrices(4) == 11;
        assert theMain.computeMatrices(5) == 30;
        assert theMain.computeMatrices(2500) > 0;
    }

    @Test
    public void testMatrices3() throws Exception {
        assert theMain.computeMatrices(3) == 2;
    }

    // 1 -> 1, 2 -> 3, 3 -> 5, 4 -> 8, 5 -> 10, 6 -> 14, 7 -> 16
    // 1 -> 1,1
    // 2 -> 1,2 2,1
    // 3 -> 1,3 3,1
    // 4 -> 1,4 2,2 4,1
    // 5 -> 1,5 5,1
    // 6 -> 1,6 2,3 3,2 6,1
    // 7 -> 1,7 7,1
    // 8 -> 1,8 2,4 4,2 8,1
    // 9 -> 1,9 3,3 9,1

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
