package com.sorbac.codeChef.oct14.prladdu;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testMethod() throws Exception {
        assertThat(new Main.TestCase(new long[]{5, -5}).calculateDiff(), is(5));
        assertThat(new Main.TestCase(new long[]{-5, 5}).calculateDiff(), is(5));
        assertThat(new Main.TestCase(new long[]{1, 2, -3}).calculateDiff(), is(4));
        assertThat(new Main.TestCase(new long[]{-3, 2, 1}).calculateDiff(), is(4));
        assertThat(new Main.TestCase(new long[]{1, 0, -1}).calculateDiff(), is(2));
        assertThat(new Main.TestCase(new long[]{2, 0, -1, 0, -1}).calculateDiff(), is(6));
    }
}