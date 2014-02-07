package com.sorbac.codeChef.easy.tavisual;

import org.testng.annotations.Test;

import java.util.ArrayList;

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
 *  Time: 14:33
 *
 */
public class MainTest {
    @Test
    public void test1() throws Exception {
        final ArrayList<Main.Pair> myMoves = new ArrayList<Main.Pair>();
        myMoves.add(new Main.Pair(1, 4));
        myMoves.add(new Main.Pair(3, 5));
        myMoves.add(new Main.Pair(1, 5));
        Main.BallCupsGame myGame = new Main.BallCupsGame(2, myMoves);
        assert myGame.computeBallPositionAfterAllMoves() == 1;
    }
}
