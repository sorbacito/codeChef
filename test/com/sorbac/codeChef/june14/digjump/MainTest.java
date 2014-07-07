package com.sorbac.codeChef.june14.digjump;

import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    @Test
    public void testSequence() throws Exception {
        assertThat(new Main().findJumps("01234567890"), is(1));
        assertThat(new Main().findJumps("012134444444443"), is(4));
    }

    @Test
    public void testRandom() throws Exception {
        int myNumbers = 10000000;
        int[] mySequence = new int[myNumbers];
        Random myRandom = new Random();
        StringBuilder myStringBuilder = new StringBuilder();
        for (int i = 0; i < myNumbers; i++) {
            mySequence[i] = myRandom.nextInt(10);
            myStringBuilder.append(mySequence[i]);
        }
        System.out.println(myStringBuilder.toString());
        System.out.print(new Main().findJumps(myStringBuilder.toString()));
    }
}