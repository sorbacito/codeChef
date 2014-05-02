package com.sorbac.codeChef.may14.ojumps;

import junit.framework.TestCase;

public class MainTest extends TestCase {
    public void testYes() throws Exception {
        assert Main.isJumpable(1);
        assert Main.isJumpable(3);
        assert Main.isJumpable(6);
        assert Main.isJumpable(7);
        assert Main.isJumpable(1000000000000000000l);
    }

    public void testNo() throws Exception {
        assert Main.isJumpable(2) == false;
        assert Main.isJumpable(4) == false;
        assert Main.isJumpable(5) == false;
        assert Main.isJumpable(8) == false;
    }
}