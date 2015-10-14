package com.nemyrovskiy.o.geekhub;

import junit.framework.TestCase;

/**
 * Created by Alex on 14.10.2015.
 */
public class FunctionTest extends TestCase {

    public void testFactorial() throws Exception {
        assertEquals(TuskTwoActivity.factorial(0), 1);
        assertEquals(TuskTwoActivity.factorial(1), 1);
        assertEquals(TuskTwoActivity.factorial(2), 2);
        assertEquals(TuskTwoActivity.factorial(3), 6);
        assertEquals(TuskTwoActivity.factorial(4), 24);
    }
}
