package com.nemyrovskiy.o.geekhub;

import junit.framework.TestCase;

/**
 * Created by Alex on 14.10.2015.
 */
public class FunctionTest extends TestCase {

    public void testFactorial() throws Exception {
        assertEquals(TaskTwoActivity.factorial(0), 1);
        assertEquals(TaskTwoActivity.factorial(1), 1);
        assertEquals(TaskTwoActivity.factorial(2), 2);
        assertEquals(TaskTwoActivity.factorial(3), 6);
        assertEquals(TaskTwoActivity.factorial(4), 24);
    }

    public void testFib() throws Exception {
        assertEquals(TaskTwoActivity.fib(0), 0);
        assertEquals(TaskTwoActivity.fib(1), 1);
        assertEquals(TaskTwoActivity.fib(2), 1);
        assertEquals(TaskTwoActivity.fib(3), 2);

    }
}
