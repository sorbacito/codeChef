package com.sorbac.codeChef.easy.onp;

import org.testng.annotations.Test;

public class MainTest {

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
        test("((a+t)*((b+(a+c))^(c+d)))", "at+bac++cd+^*");
    }

    private void test(String aInput, String aOutput) throws Exception {
        final String myResult = Main.processLine(aInput);
        System.out.println("Processed : " + myResult);
        System.out.println("Expected : " + aOutput);
        System.out.println();

        assert myResult.equalsIgnoreCase(aOutput);
    }
}
