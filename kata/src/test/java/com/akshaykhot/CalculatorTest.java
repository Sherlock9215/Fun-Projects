package com.akshaykhot;

/**
 * Created by akshaykhot on 2016-01-09.
 */

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    /**
     * test the add for empty string
     */
    public void testAddEmptyString() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.add(""));
    }

    /**
     * test the add for string having a single number
     */
    public void testAddOne() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(3, calculator.add("1,2"));
    }

    /**
     * test the add for string having two numbers
     */
    public void testAddTwo() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(7, calculator.add("3,4"));
    }


}
