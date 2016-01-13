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
     * reads the weather.txt file and parses it line by line to store in a map
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

    /**
     * @param weatherMap Map of day to [maxtemp, minTemp], all integers
     * @return day with the lowest temperature spread
     */
    public int findDayWithLowestTempSpread(Map<Integer, ArrayList<Integer>> weatherMap) {
        int dayWithLowestSpread = 0;
        int day, maxTemp, minTemp;
        //Assumption, temperature spread won't be greater than 100
        int spread, lowestSpread = 100;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : weatherMap.entrySet()) {
            day = entry.getKey();
            maxTemp = entry.getValue().get(0);
            minTemp = entry.getValue().get(1);
            spread = maxTemp - minTemp;

            if (spread < lowestSpread) {
                lowestSpread = spread;
                dayWithLowestSpread = day;
            }
        }
        System.out.println("The lowest spread is: " + lowestSpread + " and the day is: " + dayWithLowestSpread);
        return dayWithLowestSpread;
    }

    /**
     * Helper method to parse the weather line and stor it in a convenient data structure
     */
    void storeEntries(String weatherLine, Map<Integer, ArrayList<Integer>> weatherMap) {

        ArrayList<Integer> temp = new ArrayList<Integer>();

        //parse the weatherLine
        lineScanner = new Scanner(weatherLine);
        int day, maxTemp, minTemp;
        try {
            day = Integer.parseInt(lineScanner.next());
            maxTemp = Integer.parseInt(lineScanner.next());
            minTemp = Integer.parseInt(lineScanner.next());
            temp.add(maxTemp);
            temp.add(minTemp);
            //add the values in the weatherMap
            weatherMap.put(day, temp);
        } catch (NumberFormatException e) {
            System.out.println("Reached end of file.");
        }
    }

    /**
     * reads a file
     */
    public void readFile(String weatherFileName) {
        weatherFile = new File(weatherFileName);
        try {
            fileScanner = new Scanner(weatherFile);
            //ignore the first line which contains the metadata, and the next blank line
            fileScanner.nextLine();
            fileScanner.nextLine();
            System.out.println("File was read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
}
