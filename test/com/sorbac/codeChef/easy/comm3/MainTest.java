package com.sorbac.codeChef.easy.comm3;

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
 *  Date: 07/02/14
 *  Time: 14:02
 *
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        Main.TestCase myTestCase = new Main.TestCase(1, new Main.Position(0, 1), new Main.Position(0, 0),
                new Main.Position(1, 0));
        assert myTestCase.canCommunicate().equalsIgnoreCase("yes");
    }

    @Test
    public void test2() throws Exception {
        Main.TestCase myTestCase = new Main.TestCase(2, new Main.Position(0, 1), new Main.Position(0, 0),
                new Main.Position(1, 0));
        assert myTestCase.canCommunicate().equalsIgnoreCase("yes");
    }

    @Test
    public void test3() throws Exception {
        Main.TestCase myTestCase = new Main.TestCase(2, new Main.Position(0, 0), new Main.Position(0, 2),
                new Main.Position(2, 1));
        assert myTestCase.canCommunicate().equalsIgnoreCase("no");
    }

}
