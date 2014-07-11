package com.sorbac.codeChef.july14.dishown;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    public static final String INVALID_QUERY = "Invalid query!";
    public static final String FIRST_CHEF = "1";
    public static final String SECOND_CHEF = "2";
    public static final String _5TH_CHEF = "5";
    public static final String _4TH_CHEF = "4";

    @Test
    public void test1() throws Exception {
        Main.TestCase myTestCase = new Main.TestCase(new int[]{11, 12, 13, 14, 15, 16, 17});
        assertThat(myTestCase.query(1, 1), is(INVALID_QUERY));
        assertThat(myTestCase.query(1), is(FIRST_CHEF));
        assertThat(myTestCase.query(2), is(SECOND_CHEF));
        assertThat(myTestCase.query(4), is(_4TH_CHEF));
        assertThat(myTestCase.query(1, 4), is(nullValue()));
        assertThat(myTestCase.query(1), is(_4TH_CHEF));
        assertThat(myTestCase.query(1, 2), is(nullValue()));
        assertThat(myTestCase.query(2), is(_4TH_CHEF));
    }
}