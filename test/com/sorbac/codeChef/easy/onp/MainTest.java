package com.sorbac.codeChef.easy.onp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sorbac on 6.2.2014.
 */
public class MainTest {
    private Main theMain;

    @BeforeMethod
    public void setUp() throws Exception {
        theMain = new Main();
    }

//    @Test
//    public void testLevel() throws Exception {
//        assert Main.countLevel("(a+(b*c))") == 1;
//        assert Main.countLevel("((a+t)*((b+(a+c))^(c+d)))") == 2;
//    }

    @Test
    public void testFirstLine() throws Exception {
        test("(a+(b*c))", "abc*+");
    }

    @Test
    public void testSecondLine() throws Exception {
        test("((a+b)*(z+x))", "ab+zx+*");
    }

    @Test
    public void testThirdLine() throws Exception {
        test("((a+t)*((b+(a+c))^(c+d)))", "at+bac++cd+^**+");
    }

    private void test(String aInput, String aOutput) {
        final List<String> myResult = Main.processInput(Arrays.asList(aInput));
        System.out.println("Processed : " + myResult);
        System.out.println("Expected : " + aOutput);
        System.out.println();

        assert myResult.get(0).equalsIgnoreCase(aOutput);
    }
}
