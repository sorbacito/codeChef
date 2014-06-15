package com.sorbac.codeChef.june14.forgetpw;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testLeadingZeros() throws Exception {
        assertThat(Main.TestCase.calculateLeadingZerosNumber(new char[]{'0', '0', '.'}), is(2));
        assertThat(Main.TestCase.calculateLeadingZerosNumber(new char[]{'3', '0', '0', '.'}), is(0));
    }

    @Test
    public void testTrailingZeros() throws Exception {
        assertThat(Main.TestCase.calculateTrailingZerosNumber(new char[]{'0', '.', '0'}), is(1));
        assertThat(Main.TestCase.calculateTrailingZerosNumber(new char[]{'0', '.', '0', '3'}), is(0));
    }

    @Test
    public void testDecode() throws Exception {
        char[] myCodeRules = new char[95];
        myCodeRules['A' - '!'] = 'X';
        assertThat(Main.TestCase.decodePassword("aAbC", myCodeRules), is(new char[]{'a', 'X', 'b', 'C'}));
        assertThat(Main.TestCase.decodePassword("aAbA", myCodeRules), is(new char[]{'a', 'X', 'b', 'X'}));
        assertThat(Main.TestCase.decodePassword("aAby", myCodeRules), is(new char[]{'a', 'X', 'b', 'y'}));
    }

    @Test
    public void testGetDecodedPassword() throws Exception {
        char[] myCodeRules = new char[95];
        myCodeRules['5' - '!'] = '3';
        myCodeRules['3' - '!'] = '1';
        assertThat(new Main.TestCase(myCodeRules, "5").getDecodedPassword(), is("3"));
        myCodeRules = new char[95];
        assertThat(new Main.TestCase(myCodeRules, "01800.00").getDecodedPassword(), is("1800"));
        myCodeRules = new char[95];
        assertThat(new Main.TestCase(myCodeRules, "0.00100").getDecodedPassword(), is(".001"));
        myCodeRules = new char[95];
        myCodeRules['x' - '!'] = '0';
        myCodeRules['d' - '!'] = '3';
        myCodeRules['#' - '!'] = '.';
        assertThat(new Main.TestCase(myCodeRules, "0xd21#dd098x").getDecodedPassword(), is("321.33098"));
    }

    @Test
    public void testSpecialCase() throws Exception {
        assertThat(new Main.TestCase(new char[95], "000").getDecodedPassword(), is("0"));
        assertThat(new Main.TestCase(new char[95], "0050").getDecodedPassword(), is("50"));
        assertThat(new Main.TestCase(new char[95], "006").getDecodedPassword(), is("6"));

        assertThat(new Main.TestCase(new char[95], "000.000").getDecodedPassword(), is("0"));
        assertThat(new Main.TestCase(new char[95], "0.000").getDecodedPassword(), is("0"));
        assertThat(new Main.TestCase(new char[95], "0500.000").getDecodedPassword(), is("500"));

        assertThat(new Main.TestCase(new char[95], "0000.0500").getDecodedPassword(), is(".05"));
        assertThat(new Main.TestCase(new char[95], "0000.0006").getDecodedPassword(), is(".0006"));

        assertThat(new Main.TestCase(new char[95], "04000.0006").getDecodedPassword(), is("4000.0006"));
        assertThat(new Main.TestCase(new char[95], "40000.0006").getDecodedPassword(), is("40000.0006"));

        assertThat(new Main.TestCase(new char[95], "400300.0000").getDecodedPassword(), is("400300"));

        assertThat(new Main.TestCase(new char[95], "500").getDecodedPassword(), is("500"));
        assertThat(new Main.TestCase(new char[95], "008800").getDecodedPassword(), is("8800"));
        assertThat(new Main.TestCase(new char[95], "500.00").getDecodedPassword(), is("500"));
        assertThat(new Main.TestCase(new char[95], "00500.100").getDecodedPassword(), is("500.1"));

    }
}