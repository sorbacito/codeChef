package com.sorbac.codeChef.june14.guess;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testOddNumber() throws Exception {
        assertThat(Main.countOddNumber(1), is(1l));
        assertThat(Main.countOddNumber(2), is(1l));
        assertThat(Main.countOddNumber(3), is(2l));
    }

    @Test
    public void testEvenNumber() throws Exception {
        assertThat(Main.countEvenNumber(1), is(0l));
        assertThat(Main.countEvenNumber(2), is(1l));
        assertThat(Main.countEvenNumber(3), is(1l));
        assertThat(Main.countEvenNumber(4), is(2l));
    }

    @Test
    public void testCountFraction() throws Exception {
        assertThat(Main.countFraction(new long[]{1, 1}), is(new long[]{0, 1}));
        assertThat(Main.countFraction(new long[]{1, 2}), is(new long[]{1, 2}));
        assertThat(Main.countFraction(new long[]{2, 3}), is(new long[]{3, 6}));
    }

    @Test
    public void testGcd() throws Exception {
        assertThat(Main.findGreatestCommonDivisor(15, 6), is(3l));
        assertThat(Main.findGreatestCommonDivisor(19, 2), is(1l));
        assertThat(Main.findGreatestCommonDivisor(1000000000, 999999998), is(2l));
        assertThat(Main.findGreatestCommonDivisor(1000000000, 999999990), is(10l));
        assertThat(Main.findGreatestCommonDivisor(100, 50), is(50l));
    }

    @Test
    public void testReduceFraction() throws Exception {
        assertThat(Main.reduceFraction(new long[]{3, 6}), is(new long[]{1, 2}));
        assertThat(Main.reduceFraction(new long[]{3, 12}), is(new long[]{1, 4}));
        assertThat(Main.reduceFraction(new long[]{6, 12}), is(new long[]{1, 2}));
    }
}