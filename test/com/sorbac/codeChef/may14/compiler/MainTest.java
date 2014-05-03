package com.sorbac.codeChef.may14.compiler;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    @Test
    public void test1() throws Exception {
        assert Main.countLongestPrefix("<<>>") == 4;
        assert Main.countLongestPrefix("<<>><") == 4;
        assert Main.countLongestPrefix("><") == 0;
        assert Main.countLongestPrefix("<>>>") == 2;
        assert Main.countLongestPrefix("<<<<>>>") == 0;
        assert Main.countLongestPrefix("<>") == 2;
        assert Main.countLongestPrefix("<><>") == 4;
        assert Main.countLongestPrefix(">>") == 0;
        assert Main.countLongestPrefix("><><") == 0;
    }
}