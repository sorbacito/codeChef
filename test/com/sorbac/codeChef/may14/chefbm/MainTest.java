package com.sorbac.codeChef.may14.chefbm;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    @Test
    public void test1() throws Exception {
        Main.computeResults(4, 4, new int[][] {{2, 2}, {3, 2}, {3, 2}, {4, 3}, {4, 4}, {4, 3}});
    }
}