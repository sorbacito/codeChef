package com.sorbac.codeChef.feb14.lcpesy;

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
 *  Date: 10/02/14
 *  Time: 09:25
 *
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        test("abcd", "xyz", 0);
    }

    @Test
    public void test2() throws Exception {
        test("abcd", "bcda", 4);
    }

    @Test
    public void test3() throws Exception {
        test("aabc", "acaa", 3);
    }

    @Test
    public void test4() throws Exception {
        test("Codechef", "elfedcc", 5);
    }

    @Test
    public void testNumbers() throws Exception {
        test("Co1d1e3chef", "e1lf33edcc", 7);
    }

    private void test(String aFirst, String aSecond, int aExpectedLongestCommonPatterLength) {
        assert Main.getLongestCommonPatternLength(aFirst, aSecond) == aExpectedLongestCommonPatterLength;
    }
}
