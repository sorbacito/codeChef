package com.sorbac.codeChef.june14.guess;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;

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
    public void testPrimes() throws Exception {
        assertThat(Main.findPrimesTo(0), is(emptyIterable()));
        assertThat(Main.findPrimesTo(1), is(emptyIterable()));
        assertThat(Main.findPrimesTo(2), containsInAnyOrder(2l));
        assertThat(Main.findPrimesTo(3), containsInAnyOrder(2l, 3l));
        assertThat(Main.findPrimesTo(6), containsInAnyOrder(2l, 3l, 5l));
        assertThat(Main.findPrimesTo(11), containsInAnyOrder(2l, 3l, 5l, 7l, 11l));
    }

    @Test
    public void testDelimiters() throws Exception {
        assertThat(Main.findPrimeDelimiters(15), containsInAnyOrder(3l, 5l));
        assertThat(Main.findPrimeDelimiters(16), containsInAnyOrder(2l));
    }

    @Test
    public void testReduceFraction() throws Exception {
        assertThat(Main.reduceFraction(new long[]{3, 6}), is(new long[]{1, 2}));
        assertThat(Main.reduceFraction(new long[]{3, 12}), is(new long[]{1, 4}));
        assertThat(Main.reduceFraction(new long[]{6, 12}), is(new long[]{1, 2}));
    }
}