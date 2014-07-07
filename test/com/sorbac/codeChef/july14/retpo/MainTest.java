package com.sorbac.codeChef.july14.retpo;

import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testPosPos() throws Exception {
        assert Main.calculateSteps(new long[]{1, 1}) == 2;
        assert Main.calculateSteps(new long[]{0, 1}) == 1;
        assert Main.calculateSteps(new long[]{1, 0}) == 3;
        assert Main.calculateSteps(new long[]{3, 3}) == 6;
        assert Main.calculateSteps(new long[]{3, 4}) == 7;
    }

    @Test
    public void testPosNeg() throws Exception {
        assert Main.calculateSteps(new long[]{1, -1}) == 2;
        assert Main.calculateSteps(new long[]{2, -1}) == 5;
    }

    @Test
    public void testNegNeg() throws Exception {
        assert Main.calculateSteps(new long[]{-1, -1}) == 2;
        assert Main.calculateSteps(new long[]{-1, -3}) == 6;
        assert Main.calculateSteps(new long[]{-2, -3}) == 5;
    }

    @Test
    public void testNegPos() throws Exception {
        assert Main.calculateSteps(new long[]{-1, -1}) == 2;
        assert Main.calculateSteps(new long[]{-1, 0}) == 3;
        assert Main.calculateSteps(new long[]{-2, 0}) == 4;
    }
}