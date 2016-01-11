package com.akshaykhot;

/**
 * Created by akshaykhot on 2016-01-09.
 */

import org.junit.Assert;
import org.junit.Test;

public class BSearchTest {

    public void testBSearch() {
        BSearch finder = new BSearch();
        int[] list = {1,2,4,6,8,9,14};
        int foundLocation = finder.find(6, list);
        Assert.assertEquals(3, foundLocation);
    }

    /**
     * test to verify if the list is updated to contain the right half of the list
     */
    @Test
    public void testupdateListToRightHalf() {
        BSearch finder = new BSearch();
        int[] list = {1,2,4,6,8,9,14};
        int index = 4;

        int[] atualRightHalf = finder.updateListToRightHalf(list, index);
        int[] expectedRightHalf = {9,14};

        Assert.assertArrayEquals(expectedRightHalf, atualRightHalf);
    }

    /**
     * test to verify if the list is updated to contain the left half of the list
     */
    @Test
    public void testupdateListToLeftHalf() {
        BSearch finder = new BSearch();
        int[] list = {1,2,4,6,8,9,14};
        int index = 4;

        int[] actualLeftHalf = finder.updateListToLeftHalf(list, index);
        int[] expectedLeftHalf = {1,2,4,6,8};

        Assert.assertArrayEquals(expectedLeftHalf, actualLeftHalf);
    }


}
