package com.akshaykhot;

/**
 * Created by akshaykhot on 2016-01-09.
 */

import org.junit.Assert;
import org.junit.Test;

public class BSearchTest {

    /**
     * tests the binary search algorithm
     */
    @Test
    public void testBSearch() {
        BSearch finder = new BSearch();
        int[] list = {1,2,4,6,8,9,14};
        int foundLocation = finder.find(6, list);
        Assert.assertEquals(3, foundLocation);
    }

    /**
     * tests the recursive binary search algorithm
     */
    @Test
    public void testRecursiveSearch() {
        BSearch finder = new BSearch();
        int[] list = {1,2,4,6,8,9,14};
        int foundLocation = finder.findRecursively(4, list);
        Assert.assertEquals(2, foundLocation);
    }
}
