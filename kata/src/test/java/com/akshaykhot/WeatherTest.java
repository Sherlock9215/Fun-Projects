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
    Scanner scanner = null;

    /**
     * Helper method to create a sample text file for reading and parsing
     */
    public void createFile(String fileName) {
        try {
            writer = new PrintWriter(fileName);
            writer.println("The first line");

            writer.println("The second line");
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
        scanner = new Scanner(weatherLine);
        Map<Integer, ArrayList<Integer>> weatherMap = new HashMap<Integer, ArrayList<Integer>>();

        //get the actual values
        int actualDay = 0, actualMinTemp = 0, actualMaxTemp = 0;
        Weather weather = new Weather();
        weather.storeEntries(weatherLine, weatherMap);

        //iterating over keys only
        for (Integer key : weatherMap.keySet()) {
            actualDay = key;
        }
        //iterating over values only
        for (List<Integer> value : weatherMap.values()) {
            actualMinTemp = value.get(0);
            actualMaxTemp = value.get(1);
        }

        Assert.assertEquals(3, actualDay);
        Assert.assertEquals(77, actualMinTemp);
        Assert.assertEquals(55, actualMaxTemp);

    }
}
