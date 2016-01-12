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
        int[] list;

        list = new int[]{};
        Assert.assertEquals(-1, finder.find(3, list));
        list = new int[]{1};
        Assert.assertEquals(-1, finder.find(3, list));
        Assert.assertEquals(0, finder.find(1, list));

        list = new int[]{1, 3, 5};
        Assert.assertEquals(0, finder.find(1, list));
        Assert.assertEquals(1, finder.find(3, list));
        Assert.assertEquals(2, finder.find(5, list));
        Assert.assertEquals(-1, finder.find(0, list));
        Assert.assertEquals(-1, finder.find(2, list));
        Assert.assertEquals(-1, finder.find(4, list));
        Assert.assertEquals(-1, finder.find(6, list));

        list = new int[]{1, 3, 5, 7};
        Assert.assertEquals(0, finder.find(1, list));
        Assert.assertEquals(1, finder.find(3, list));
        Assert.assertEquals(2, finder.find(5, list));
        Assert.assertEquals(3, finder.find(7, list));
        Assert.assertEquals(-1, finder.find(0, list));
        Assert.assertEquals(-1, finder.find(2, list));
        Assert.assertEquals(-1, finder.find(4, list));
        Assert.assertEquals(-1, finder.find(6, list));
        Assert.assertEquals(-1, finder.find(8, list));
    }

    /**
     * tests the recursive binary search algorithm
     */
    @Test
    public void testRecursiveSearch() {
        BSearch finder = new BSearch();
        int[] list;

        list = new int[]{};
        Assert.assertEquals(-1, finder.findRecursively(3, list));
        list = new int[]{1};
        Assert.assertEquals(-1, finder.findRecursively(3, list));
        Assert.assertEquals(0, finder.findRecursively(1, list));

        list = new int[]{1, 3, 5};
        Assert.assertEquals(0, finder.findRecursively(1, list));
        Assert.assertEquals(1, finder.findRecursively(3, list));
        Assert.assertEquals(2, finder.findRecursively(5, list));
        Assert.assertEquals(-1, finder.findRecursively(0, list));
        Assert.assertEquals(-1, finder.findRecursively(2, list));
        Assert.assertEquals(-1, finder.findRecursively(4, list));
        Assert.assertEquals(-1, finder.findRecursively(6, list));

        list = new int[]{1, 3, 5, 7};
        Assert.assertEquals(0, finder.findRecursively(1, list));
        Assert.assertEquals(1, finder.findRecursively(3, list));
        Assert.assertEquals(2, finder.findRecursively(5, list));
        Assert.assertEquals(3, finder.findRecursively(7, list));
        Assert.assertEquals(-1, finder.findRecursively(0, list));
        Assert.assertEquals(-1, finder.findRecursively(2, list));
        Assert.assertEquals(-1, finder.findRecursively(4, list));
        Assert.assertEquals(-1, finder.findRecursively(6, list));
        Assert.assertEquals(-1, finder.findRecursively(8, list));
    }
}
