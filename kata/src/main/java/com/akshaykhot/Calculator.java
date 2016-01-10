package com.akshaykhot;

/**
 * Created by akshaykhot on 2016-01-09.
 */
public class Calculator {

    /**
     *
     * @param numbers String representation of 0, 1, or 2 numbers, eg. "", "1", "1,2"
     * @return sum of all the numbers in the string, 0 if empty string
     */
    int add(String numbers) {

        //parse the String to extract the numbers
        if(numbers.isEmpty()) {
            return 0;
        }
        String[] nums = numbers.split(",");
        int sum = 0;
        for(String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
