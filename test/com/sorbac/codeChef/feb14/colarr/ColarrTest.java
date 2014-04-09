package com.sorbac.codeChef.feb14.colarr;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ColarrTest {
    @Test
    public void test1() throws Exception {
        Colarr.Cell myFirstCell = new Colarr.Cell(1, Arrays.asList(1, 1), Arrays.asList(0, 1));
        Colarr.Cell mySecondCell = new Colarr.Cell(1, Arrays.asList(1, 1), Arrays.asList(0, 1));
        Colarr.Cell myThirdCell = new Colarr.Cell(2, Arrays.asList(1, 1), Arrays.asList(1, 0));
        Colarr.Cell myFourthCell = new Colarr.Cell(2, Arrays.asList(3, 1), Arrays.asList(1, 0));
        Colarr.TestCase myTestCase = new Colarr.TestCase(
                Arrays.asList(myFirstCell, mySecondCell, myThirdCell, myFourthCell));
        assert myTestCase.getMaximumPointsWithRepainting(1) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(2) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(3) == 5;
    }

    @Test
    public void testBigCosts() throws Exception {
        Colarr.Cell myFirstCell = new Colarr.Cell(1, Arrays.asList(1, 1), Arrays.asList(0, 5));
        Colarr.Cell mySecondCell = new Colarr.Cell(1, Arrays.asList(1, 1), Arrays.asList(0, 6));
        Colarr.Cell myThirdCell = new Colarr.Cell(2, Arrays.asList(1, 1), Arrays.asList(7, 0));
        Colarr.Cell myFourthCell = new Colarr.Cell(2, Arrays.asList(3, 1), Arrays.asList(1, 8));
        Colarr.TestCase myTestCase = new Colarr.TestCase(
                Arrays.asList(myFirstCell, mySecondCell, myThirdCell, myFourthCell));
        assert myTestCase.getMaximumPointsWithRepainting(0) == 4;
        assert myTestCase.getMaximumPointsWithRepainting(1) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(2) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(3) == 5;
    }

    @Test
    public void testOneCell() throws Exception {
        Colarr.Cell myFirstCell = new Colarr.Cell(1, Arrays.asList(1, 3), Arrays.asList(0, 1));
        Colarr.Cell myFirst1Cell = new Colarr.Cell(1, Arrays.asList(1, 3), Arrays.asList(0, 1));
        Colarr.TestCase myTestCase = new Colarr.TestCase(Arrays.asList(myFirstCell, myFirst1Cell));
        assert myTestCase.getMaximumPointsWithRepainting(0) == 2;
        assert myTestCase.getMaximumPointsWithRepainting(1) == 3;
        assert myTestCase.getMaximumPointsWithRepainting(2) == 4;
        assert myTestCase.getMaximumPointsWithRepainting(3) == 4;
    }

    @Test
    public void test1Cell() throws Exception {
        Colarr.Cell myFirstCell = new Colarr.Cell(1, Arrays.asList(2, 3), Arrays.asList(0, 1));
        Colarr.Cell myFirst1Cell = new Colarr.Cell(1, Arrays.asList(1, 3), Arrays.asList(0, 1));
        Colarr.Cell myFirst2Cell = new Colarr.Cell(1, Arrays.asList(1, 1), Arrays.asList(0, 1));
        Colarr.TestCase myTestCase = new Colarr.TestCase(Arrays.asList(myFirst1Cell, myFirstCell, myFirst2Cell));
        assert myTestCase.getMaximumPointsWithRepainting(0) == 4;
        assert myTestCase.getMaximumPointsWithRepainting(1) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(2) == 5;
        assert myTestCase.getMaximumPointsWithRepainting(3) == 5;
    }

    @Test
    public void testCellGetCurrentPoints() throws Exception {
        Colarr.Cell myCell = new Colarr.Cell(1, Arrays.asList(2, 4), Arrays.asList(1, 2));
        assert myCell.getCurrentPoints() == 2;
        //assert myCell.getMaximumPointsColour() == 2;
    }

}
