package com.sorbac.codeChef.feb14.twodogs;

import org.testng.annotations.Test;

import java.util.Arrays;

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
 *  Date: 10/02/14
 *  Time: 18:21
 *
 */
public class TwoDogsTest {

    @Test
    public void test1() throws Exception {
        assert new TwoDogs(5).getSolution(Arrays.asList(2, 4, 3, 2, 1)) == 2;
    }

    @Test
    public void test2() throws Exception {
        assert new TwoDogs(5).getSolution(Arrays.asList(2, 4, 9, 2, 5)) == -1;
    }
}
