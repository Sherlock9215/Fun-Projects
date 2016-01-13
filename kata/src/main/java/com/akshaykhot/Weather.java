package com.akshaykhot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by akshaykhot on 2016-01-11.
 */
public class Weather {

    private File weatherFile;
    private Scanner fileScanner = null;
    private Scanner lineScanner = null;
    Map<Integer, ArrayList<Integer>> weatherMap;

    /**
     * reads the weather.txt file and parses it line by line
     */
    public void parseFile(String weatherFileName) {

        //map to store the <day, [maxTemp, minTemp]>
        weatherMap = new HashMap<Integer, ArrayList<Integer>>();

        //read and parse the file
        readFile(weatherFileName);
        while (fileScanner.hasNextLine()) {
            //add the relevant entries in the line in weatherMap
            storeEntries(fileScanner.nextLine(), weatherMap);
        }

        //now we have a weatherMap that has [Day: {maxTemp, minTemp}] structure
        findDayWithLowestTempSpread(weatherMap);
    }

    public int findDayWithLowestTempSpread(Map<Integer, ArrayList<Integer>> weatherMap) {
        return 0;
    }

    /**
     * Helper method to parse the weather line and stor it in a convenient data structure
     */
    void storeEntries(String weatherLine, Map<Integer, ArrayList<Integer>> weatherMap) {

        //parse the weatherLine
        lineScanner = new Scanner(weatherLine);
        int day, maxTemp, minTemp;
        day = Integer.parseInt(lineScanner.next());
        maxTemp = Integer.parseInt(lineScanner.next());
        minTemp = Integer.parseInt(lineScanner.next());
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(maxTemp);
        temp.add(minTemp);

        //add the values in the weatherMap
        weatherMap.put(day, temp);
    }

    /**
     * reads a file
     */
    public void readFile(String weatherFileName) {
        weatherFile = new File(weatherFileName);
        try {
            fileScanner = new Scanner(weatherFile);
            System.out.println("File was read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
}
