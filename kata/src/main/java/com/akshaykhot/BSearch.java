package com.akshaykhot;

/**
 * Created by akshaykhot on 2016-01-09.
 */

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.ArrayList.*;

public class BSearch {

    /**
     * Perform the binary search on a sorted list of integers and find the location of the search target
     * @param target int search target
     * @param list sorted int array
     * @return foundLocation int index of the target in the list
     */
    int find(int target, int[] list) {

        int foundLocation = -1;
        int leftIndex = 0;
        int rightIndex = list.length-1;

        do {
            int noOfItemsInList = list.length;

            //find the middle element in the sorted array
            int middleIndex = (leftIndex+rightIndex)/2;
            int middleNumber = list[middleIndex];

            //compare the target with the middle element
            //if the target is the middle element, change foundLocation to middle index, and return it
            if (target == middleNumber) {
                foundLocation = middleIndex;
                return foundLocation;
            } else if (target > middleNumber) {
                //if the target is greater than middle element, update leftIndex
                leftIndex = middleIndex+1;
            } else {
                //target is smaller than middle element, update rightIndex
                rightIndex = middleIndex-1;
            }
        } while (leftIndex <= rightIndex);  //repeat the above process, as long as there are numbers in the list

        return foundLocation;
    }

    /**
     * Divides a list into two lists, depending on a dividing index
     * @param listToDivide array of ints to divide
     * @param divider int index which is the separator
     * @return rightHalf int array of numbers on the right of the index, excluding index
     */
    public int[] updateListToRightHalf(int[] listToDivide, int divider) {
        return Arrays.copyOfRange(listToDivide, (divider+1), listToDivide.length);
    }

    /**
     * Divides a list into two lists, depending on a dividing index
     * @return leftHalf int array of numbers on the left of the index, including index
     */
    public int[] updateListToLeftHalf(int[] listToDivide, int divider) {
        return Arrays.copyOfRange(listToDivide, 0, divider);
    }


}
