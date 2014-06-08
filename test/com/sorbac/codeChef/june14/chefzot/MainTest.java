package com.sorbac.codeChef.june14.chefzot;

import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testLongest() throws Exception {
        assert Main.findLongestNonzeroSequence(new int[]{1, 0, 2, 3, 0, 4}) == 2;
        assert Main.findLongestNonzeroSequence(new int[]{0}) == 0;
        assert Main.findLongestNonzeroSequence(new int[]{1, 0, 1}) == 1;
        assert Main.findLongestNonzeroSequence(new int[]{1, 0, 1, 2}) == 2;
    }
}