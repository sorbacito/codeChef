package com.sorbac.codeChef.july14.frogv1;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void testCheckReach() throws Exception {
        assertThat(Main.checkReach(1, 4, 2, Arrays.asList(1, 4, 6)), is(false));
        assertThat(Main.checkReach(1, 4, 3, Arrays.asList(1, 4, 6)), is(true));
        assertThat(Main.checkReach(4, 4, 0, Arrays.asList(1, 2, 4, 6)), is(true));
    }

    @Test
    public void testFindIndex() throws Exception {
        assertThat(Main.findIndex(1, Arrays.asList(1)), is(0));
        assertThat(Main.findIndex(1, Arrays.asList(1, 2, 3)), is(0));
        assertThat(Main.findIndex(2, Arrays.asList(1, 2, 3, 10)), is(1));
        assertThat(Main.findIndex(3, Arrays.asList(1, 2, 3, 10)), is(2));
        assertThat(Main.findIndex(3, Arrays.asList(1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 10)), is(8));
    }

    @Test
    public void testCollapse() throws Exception {
        assertThat(Main.collapsePositions(Arrays.asList(1, 3, 5), 1).size(), is(3));
        assertThat(Main.collapsePositions(Arrays.asList(1, 3, 5), 2).size(), is(1));
        assertThat(Main.collapsePositions(Arrays.asList(1), 2).size(), is(1));
        assertThat(Main.collapsePositions(Arrays.asList(1, 1, 1, 1), 0).size(), is(1));
    }

    @Test
    public void testMax() {
        int myMax = 0;
        Random myRandom = new Random();
        List<Integer> myInput = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            final int myRand = myRandom.nextInt(1000000000);
            myInput.add(myRand);
        }
        int[] myCouplesA = new int[100000];
        int[] myCouplesB = new int[100000];
        for (int i = 0; i < 100000; i++) {
            myCouplesA[i] = myInput.get(myRandom.nextInt(myInput.size()));
            myCouplesB[i] = myInput.get(myRandom.nextInt(myInput.size()));
        }

        Collections.sort(myInput);
        int myYes = 0;
        int myNo = 0;
        for (int i = 0; i < 100000; i++) {
            final int myDistance = myRandom.nextInt(100000);
            List<Integer> myTempInput = Main.collapsePositions(myInput, myDistance);
            if (Main.checkReach(myCouplesA[i], myCouplesB[i], myDistance, myTempInput)) {
                myYes++;
            } else {
                myNo++;
            }
            if (i % 10000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("YES count :" + myYes);
        System.out.println("NO count :" + myNo);
    }
}