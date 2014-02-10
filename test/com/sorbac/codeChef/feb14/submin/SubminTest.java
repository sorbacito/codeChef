package com.sorbac.codeChef.feb14.submin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
 *  Time: 11:19
 *
 */
public class SubminTest {
    private Submin answers;

    @BeforeMethod
    public void setUp() throws Exception {
        List<Integer> myInput = new ArrayList<Integer>();
        myInput.add(4);
        myInput.add(1);
        myInput.add(2);
        myInput.add(3);
        myInput.add(4);
        answers = new Submin(Submin.createAnswerArray(myInput));
    }

    @Test
    public void test1() throws Exception {
        testSubmin(3, 2);
    }

    @Test
    public void test2() throws Exception {
        testSubmin(4, 2);
    }

    @Test
    public void test3() throws Exception {
        testSubmin(6, 0);
    }

    @Test
    public void test4() throws Exception {
        testSubmin(1, 8);
    }

    private void testSubmin(int aMin, int aExpectedValue) {
        assert answers.getAnswer(aMin) == aExpectedValue;
    }
}
