package com.sorbac.codeChef.aug14.crawa;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testX0() throws Exception {
        testYes(0, 0);
        testYes(1, 0);
        testYes(3, 0);
        testYes(5, 0);
        testYes(-2, 0);
        testYes(-4, 0);
    }

    @Test
    public void test0Y() throws Exception {
        testYes(0, 0);
        testYes(0, 2);
        testYes(0, -2);
        testYes(0, 4);
        testYes(0, -4);
    }

    @Test
    public void testCorners() throws Exception {
        testYes(0, 0);
        testYes(1, 0);
        testYes(1, 2);
        testYes(-2, 2);
        testYes(-2, -2);
        testYes(3, -2);
        testYes(3, 4);
    }

    @Test
    public void testBetweenCorners() throws Exception {
        testYes(0, 0);
        testYes(1, 1);
        testYes(0, 2);
        testYes(-1, 2);
        testYes(-2, 1);
        testYes(-2, 0);
        testYes(-2, -1);
        testYes(-1, -2);
        testYes(0, -2);
        testYes(1, -2);
        testYes(2, -2);
        testYes(3, -1);
        testYes(3, 0);
        testYes(3, 1);
        testYes(3, 2);
        testYes(3, 3);
    }

    @Test
    public void testNoAnswers() throws Exception {
        testNo(0, 1);
        testNo(0, -1);
        testNo(0, 3);
        testNo(0, -3);
        testNo(1, -1);
        testNo(1, -3);
        testNo(1, 3);
        testNo(2, 0);
        testNo(2, 1);
        testNo(2, -1);
        testNo(2, -3);
        testNo(2, 2);
        testNo(2, 3);
        testNo(-1, 0);
        testNo(-1, 1);
        testNo(-1, -1);
        testNo(-1, -3);
        testNo(-1, 3);
    }

    private void testYes(int aX, int aY) {
        testResult(aX, aY, "YES");
    }

    private void testNo(int aX, int aY) {
        testResult(aX, aY, "NO");
    }

    private void testResult(int aX, int aY, String aResult) {
        assertThat(new Main.TestCase(aX, aY).getAnswer(), is(aResult));
    }
}