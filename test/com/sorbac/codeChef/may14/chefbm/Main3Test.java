package com.sorbac.codeChef.may14.chefbm;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Main3Test {
    @Test
    public void testInvalid() throws Exception {
        checkInvalidProcess(2, 1, 1, 1, 1, 2, 2);
        checkInvalidProcess(3, 1, 1);
        checkInvalidProcess(3, 1, 1, 1, 1, 2, 2);
        checkInvalidProcess(3, 2, 2);
        checkInvalidProcess(3, 1, 1, 1, 2, 2);
        checkInvalidProcess(4, 2, 2, 4);
        checkInvalidProcess(5, 2, 2, 4);
    }

    @Test
    public void testValid() throws Exception {
        checkValidProcess(2, 2, 1, 1, 1, 2);
        checkValidProcess(2, 1, 0, 1);
        checkValidProcess(2, 0, 1, 2);
        checkValidProcess(3, 2, 0, 1, 1, 2);
        checkValidProcess(3, 3, 1, 1, 1, 1, 2, 2, 3);
        checkValidProcess(3, 1, 1, 1, 3);
        checkValidProcess(4, 0, 1, 2, 4);
        checkValidProcess(5, 0, 0, 2, 2, 3, 4);

        checkValidProcess(3, 3, 4, 1, 1, 1, 2, 2, 3, 3, 3, 3);
        checkValidProcess(3, 0, 4, 2, 2, 3, 3, 3, 3);
        checkValidProcess(3, 1, 4, 1, 2, 2, 3, 3, 3, 3);
        checkValidProcess(3, 0, 4, 3, 3, 3, 3);
        checkValidProcess(3, 0, 0, -1);
        checkValidProcess(1, 2, 2, 1, 1);
    }

    @Test
    public void testFailing() {

    }

    private void checkInvalidProcess(int aMyInputB, int... aInputs) {
        final ArrayList<Integer> myToSort = new ArrayList<Integer>();
        if (aInputs[0] != -1) {
            for (int i : aInputs) {
                myToSort.add(i);
            }
        }
        int[] myResponse = Main3.isAscendingF2(myToSort, aMyInputB);
        assert myResponse[0] == 0;
    }

    private void checkValidProcess(int aMyInputB, int aFirst, int aLast, int... aInputs) {
        final ArrayList<Integer> myToSort = new ArrayList<Integer>();
        for (int i : aInputs) {
            myToSort.add(i);
        }
        int[] myResponse = Main3.isAscendingF2(myToSort, aMyInputB);
        assert myResponse[0] == 1;
        assert myResponse[1] == aFirst;
        assert myResponse[2] == aLast;
    }
}