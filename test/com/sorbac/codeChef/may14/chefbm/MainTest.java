package com.sorbac.codeChef.may14.chefbm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sorbac.codeChef.may14.chefbm.Main.sortCommands;

public class MainTest {

    @Test
    public void testUpdateOneCommand() throws Exception {
        int myProblemsCount = 0;
        final long[] myProblems = {0, 0, 0};
        final long[] myLine = {0, 0, 0};
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 2);
        // {0, 1, 0}
        assert myProblemsCount == 0;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 2);
        // {0, 2, 0}
        assert myProblemsCount == 1;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 1);
        // {1, 2, 0}
        assert myProblemsCount == 1;
        assert myProblems[1] == 1;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 1);
        // {2, 2, 0}
        assert myProblemsCount == 1;
        assert myProblems[1] == 1;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 1);
        // {3, 2, 0}
        assert myProblemsCount == 1;
        assert myProblems[1] == 1;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 1);
        // {4, 2, 0}
        assert myProblemsCount == 2;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 2);
        // {4, 3, 0}
        assert myProblemsCount == 1;
        assert myProblems[1] == 2;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 3);
        // {4, 3, 1}
        assert myProblemsCount == 1;
        assert myProblems[1] == 1;
        myProblemsCount = Main.updateWithCommand(3, myLine, myProblems, myProblemsCount, 3);
        // {4, 3, 2}
        assert myProblemsCount == 0;
    }

    @DataProvider(name = "a")
    public static Object[][] a() {
        Random myRandom = new Random();
        final int numOfCommands = 1000000;
        int[][] myInts = new int[numOfCommands][2];
        for (int i = 0; i < numOfCommands; i++) {
            myInts[i][0] = myRandom.nextInt(100000) + 1;
            myInts[i][1] = myRandom.nextInt(100000) + 1;
        }
        return new Object[][]{{myInts}};
    }

    @Test(dataProvider = "a")
    public void testMaximumTable(int[][] aCommands) throws Exception {
        Main.computeResultsByRow(100000, 100000, aCommands);
        assert true;
    }

    @Test(dataProvider = "a")
    public void testMaximumTable2(int[][] aCommands) throws Exception {
        Map<Integer, List<Integer>> aSortedCommands = sortCommands(aCommands);
        //Main2.computeResultsByRow(100000, 100000, aSortedCommands);
        assert true;
    }

    @Test(dataProvider = "a")
    public void testMaximumTable2BySort(int[][] aCommands) throws Exception {
        Map<Integer, List<Integer>> aSortedCommands = sortCommands(aCommands);
        //Main2.computeResultsByRowBySort(100000, 100000, aSortedCommands);
        assert true;
    }

    @Test(dataProvider = "a")
    public void testMaximumTable3BySort(int[][] aCommands) throws Exception {
        Map<Integer, List<Integer>> aSortedCommands = sortCommands(aCommands);
        Main3.computeResultsByRowBySort(100000, 100000, aSortedCommands);
        assert true;
    }

}