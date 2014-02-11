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

    @Test
    public void test3() throws Exception {
        assert new TwoDogs(6).getSolution(Arrays.asList(2, 1, 3, 3, 6)) == -1;
    }

    @Test
    public void test31() throws Exception {
        assert new TwoDogs(6).getSolution(Arrays.asList(2, 3, 3, 3, 6)) == -1;
    }

    @Test
    public void test32() throws Exception {
        assert new TwoDogs(4).getSolution(Arrays.asList(3, 3, 3, 3, 3, 3)) == -1;
    }

    @Test
    public void test5() throws Exception {
        assert new TwoDogs(6).getSolution(Arrays.asList(1, 3, 3, 4)) == -1;
    }

    @Test
    public void test4() throws Exception {
        assert new TwoDogs(4).getSolution(Arrays.asList(1, 2, 3, 4, 5, 6)) == 3;
    }

    @Test
    public void test6() throws Exception {
        assert new TwoDogs(4).getSolution(Arrays.asList(1, 1, 1, 3, 1, 1, 1)) == 4;
    }

    @Test
    public void test7() throws Exception {
        assert new TwoDogs(3).getSolution(Arrays.asList(1, 2)) == 1;
    }

    @Test
    public void test8() throws Exception {
        assert new TwoDogs(6).getSolution(Arrays.asList(2, 3)) == -1;
    }

    @Test
    public void test9() throws Exception {
        assert new TwoDogs(6).getSolution(Arrays.asList(6, 3, 2, 3, 6)) == -1;
    }
}
