package com.sorbac.codeChef.oct14.prladdu;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainSuccessfulTest {
    @Test
    public void testMethod() throws Exception {
        assertThat(new MainSuccessful.TestCase(new long[]{5, -5}).calculateDiff(), is(5l));
        assertThat(new MainSuccessful.TestCase(new long[]{-5, 5}).calculateDiff(), is(5l));
        assertThat(new MainSuccessful.TestCase(new long[]{1, 2, -3}).calculateDiff(), is(4l));
        assertThat(new MainSuccessful.TestCase(new long[]{-3, 2, 1}).calculateDiff(), is(4l));
        assertThat(new MainSuccessful.TestCase(new long[]{1, 0, -1}).calculateDiff(), is(2l));
        assertThat(new MainSuccessful.TestCase(new long[]{2, 0, -1, 0, -1}).calculateDiff(), is(6l));
        assertThat(new MainSuccessful.TestCase(new long[]{-2, 0, 1, 0, 1}).calculateDiff(), is(6l));
        assertThat(new MainSuccessful.TestCase(new long[]{0, 0, -2, 0, 1, 0, 1, 0, 0}).calculateDiff(), is(6l));
        assertThat(new MainSuccessful.TestCase(new long[]{-2, 0, 0, 0, 1, 1}).calculateDiff(), is(9l));
        assertThat(new MainSuccessful.TestCase(new long[]{-2, 2, -1, -1, 1, 1}).calculateDiff(), is(6l));
    }
}