package com.akshaykhot;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by akshaykhot on 2016-01-11.
 */
public class WeatherTest {

    PrintWriter writer = null;
    File file = null;
    Scanner lineScanner = null;

    /**
     * Helper method to create a sample text file for reading and parsing
     */
    public void createFile(String fileName) {
        try {
            writer = new PrintWriter(fileName);
            writer.println("1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create the file");
        }
    }

    /**
     * Helper method to delete the file after its purpose is finished
     */
    public void deleteFile(String fileName) {
        file = new File(fileName);
        file.delete();
        System.out.println("file was deleted");
    }

    /**
     * test to verify if the code is able to read the file as expected
     */
    @Test
    public void testReadFile() {
        String fileName = "sample.txt";
        createFile(fileName);

        //try to read the file
        Weather weather = new Weather();
        weather.readFile("sample.txt");

        deleteFile(fileName);
    }

    @Test
    public void testParseFile() {
        String fileName = "sample.txt";
        createFile(fileName);

        //try to read the file
        Weather weather = new Weather();
        weather.readFile("sample.txt");
        //try to parse the file
        weather.parseFile(fileName);

        deleteFile(fileName);
    }

    /**
     * tests the parsing of a line in the weather.txt file
     */
    @Test
    public void testStoreEntries() {
        String weatherLine = "3  77    55    66          39.6       0.00         350  5.0 350   9  2.8  59 24 1016.8";
        lineScanner = new Scanner(weatherLine);
        Map<Integer, ArrayList<Integer>> weatherMap = new HashMap<Integer, ArrayList<Integer>>();

        //get the actual values
        int actualDay = 0, actualMaxTemp = 0, actualMinTemp = 0;
        Weather weather = new Weather();
        weather.storeEntries(weatherLine, weatherMap);

        //iterating over keys only
        for (Integer key : weatherMap.keySet()) {
            actualDay = key;
        }
        //iterating over values only
        for (List<Integer> value : weatherMap.values()) {
            actualMaxTemp = value.get(0);
            actualMinTemp = value.get(1);
        }

        Assert.assertEquals(3, actualDay);
        Assert.assertEquals(77, actualMaxTemp);
        Assert.assertEquals(55, actualMinTemp);

    }

    /**
     * tests the code which finds the day depending on the lowest temp spread
     */
    @Test
    public void testFindDayWithLowestTempSpread() {
        Map<Integer, ArrayList<Integer>> weatherMap = new HashMap<Integer, ArrayList<Integer>>();
        weatherMap.put(2, new ArrayList<Integer>(Arrays.asList(88, 59)));
        weatherMap.put(5, new ArrayList<Integer>(Arrays.asList(79, 63)));
        weatherMap.put(8, new ArrayList<Integer>(Arrays.asList(79, 77)));

        Weather weather = new Weather();
        int dayWithLowestTempSpread = weather.findDayWithLowestTempSpread(weatherMap);
        Assert.assertEquals(8, dayWithLowestTempSpread);
    }
}
