package com.sorbac.codeChef.prometheus2014.prom02;

import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testFibFinder() throws Exception {
        assert Main.findHighestLowerFibNumberIndex(4) == 2;
        assert Main.findHighestLowerFibNumberIndex(5) == 3;
        assert Main.findHighestLowerFibNumberIndex(6) == 3;
        assert Main.findHighestLowerFibNumberIndex(7) == 3;
        assert Main.findHighestLowerFibNumberIndex(8) == 4;
        assert Main.findHighestLowerFibNumberIndex(12) == 4;
        assert Main.findHighestLowerFibNumberIndex(20) == 5;
    }
}
