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
    public void testMatrices() throws Exception {
        assert theMain.computeMatrices(3) == 2;
    }
}
