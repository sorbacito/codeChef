package com.sorbac.codeChef.oct14.chefgr;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testOneColumnTooHigh() throws Exception {
        assertThat(Main.isEquallableColumns(2, 3, new int[]{1, 6}), is(false));

    }
}