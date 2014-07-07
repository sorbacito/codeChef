package com.sorbac.codeChef.may14.lebalons;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    public static final int MILLION = 1000000;

    @Test
    public void testFill() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1, 1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 1);
        assert myReturn[0] == 7;
    }

    @Test
    public void testFill2() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1, 1, 1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 1);
        assert myReturn[0] == 15;
    }

    @Test
    public void testFill3() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1, 1));
        myInput.add(Arrays.asList(1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 1);
        assert myReturn[0] == 14;
    }

    @Test
    public void testFill3With2Colours() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1, 1));
        myInput.add(Arrays.asList(1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 2);
        assert myReturn[0] == 7;
        assert myReturn[1] == 0;
    }

    @Test
    public void testFill4() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 2);
        assert myReturn[0] == 3;
        assert myReturn[1] == 1;
    }

    @Test
    public void testFill4Multiple() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1));
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(1));
        long[] myReturn = Main.TestCase.fillCounts(myInput, 2);
        assert myReturn[0] == 3 * 3;
        assert myReturn[1] == 1;
    }

    @Test
    public void testTestCase() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(4));
        myInput.add(Arrays.asList(7));
        Main.TestCase myTestCase = new Main.TestCase(2, myInput);
        assert Double.compare(myTestCase.calculate(), 11d) == 0;
    }

    @Test
    public void testTestCase2() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(4));
        myInput.add(Arrays.asList(7));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCase3() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(7));
        myInput.add(Arrays.asList(4, 19));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, (double) 120 / 7);
    }

    @Test
    public void testTestCase8() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(4, 5));
        myInput.add(Arrays.asList(7));
        myInput.add(Arrays.asList(3));
        Main.TestCase myTestCase = new Main.TestCase(3, myInput);
        doTest(myTestCase, (double) (18 + 21 + 9) / 3);
    }

    @Test
    public void testTestCase4() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 2));
        myInput.add(Arrays.asList(3, 4));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, (double) 80 / 15);
    }

    @Test
    public void testTestCase5() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 2));
        myInput.add(Arrays.asList(3, 4));
        Main.TestCase myTestCase = new Main.TestCase(2, myInput);
        doTest(myTestCase, (double) 60 / 9);
    }

    @Test
    public void testTestCase6() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(2));
        myInput.add(Arrays.asList(3));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, (double) 24 / 7);
    }

    @Test
    public void testTestCase7() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(2));
        myInput.add(Arrays.asList(3));
        Main.TestCase myTestCase = new Main.TestCase(3, myInput);
        doTest(myTestCase, (double) 6);
    }

    @Test
    public void testTestCaseMaximum() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION));
        Main.TestCase myTestCase = new Main.TestCase(3, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCaseMaximum2() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION,
                MILLION, MILLION, MILLION, MILLION, MILLION));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCaseMaximum1() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(MILLION, MILLION));
        myInput.add(Arrays.asList(6, 78));
        myInput.add(Arrays.asList(1));
        myInput.add(Arrays.asList(869, 4458));
        Main.TestCase myTestCase = new Main.TestCase(2, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCase11() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(MILLION, MILLION, MILLION));
        myInput.add(Arrays.asList(MILLION, MILLION));
        myInput.add(Arrays.asList(MILLION));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCase12() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 1));
        myInput.add(Arrays.asList(1));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, 7.333333333d);
    }

    @Test
    public void testTestCase9() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(1, 2));
        Main.TestCase myTestCase = new Main.TestCase(1, myInput);
        doTest(myTestCase, 2d);
    }

    @Test
    public void testTestCase10() throws Exception {
        List<List<Integer>> myInput = new ArrayList<List<Integer>>();
        myInput.add(Arrays.asList(3));
        myInput.add(Arrays.asList(1, 2));
        Main.TestCase myTestCase = new Main.TestCase(2, myInput);
        doTest(myTestCase, 5d);
    }

    private void doTest(Main.TestCase myTestCase, double aExpectedValue) {
        double epsilon = 0.000001d;
        assert Math.abs(myTestCase.calculate() - aExpectedValue) < epsilon;
    }
}