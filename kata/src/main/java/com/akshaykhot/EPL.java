package com.akshaykhot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by akshaykhot on 2016-01-13.
 * program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.
 */
public class EPL {

    private Scanner fileReader = null;
    private Scanner lineReader = null;
    private File football;
    private Map<String, Integer> teamToGoalDifference;

    public void execute(String fileName) {
        readFile(fileName);
        parseFileAndStoreInMap();
        calculateTeamWithLowestGoalDifference();
    }

    public void readFile(String fileName) {
        football = new File(fileName);

        try {
            fileReader = new Scanner(football);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void parseFileAndStoreInMap() {
        String team = "";
        int goalsForTeam = 0, goalsAgainstTeam = 0, goalDifference = 0;
        teamToGoalDifference = new HashMap<String, Integer>();

        while (fileReader.hasNextLine()) {
            String scoreLine = fileReader.nextLine();

            //ignore the lines containing headers and dashes
            if (scoreLine.startsWith("   -") || scoreLine.startsWith("       Team")) continue;
            lineReader = new Scanner(scoreLine);
            while (lineReader.hasNext()) {
                lineReader.next(); //ignore number
                team = lineReader.next();
                lineReader.next();
                lineReader.next();
                lineReader.next();
                lineReader.next(); //ignore next 4 numbers
                goalsForTeam = Integer.parseInt(lineReader.next());
                lineReader.next(); //ignore the dash
                goalsAgainstTeam = Integer.parseInt(lineReader.next());
                goalDifference = goalsForTeam - goalsAgainstTeam;
                lineReader.next(); //ignore last number
                teamToGoalDifference.put(team, goalDifference);
            }
        }
        System.out.println("\nMap of team to goals is created");
    }

    private void calculateTeamWithLowestGoalDifference() {

        String teamWithLowestGoalDiff = "";
        int lowestGoalDiff = 100;  //Assumption: goal difference won't be greater than 100
        for (Map.Entry<String, Integer> entry : teamToGoalDifference.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue() < lowestGoalDiff) {
                lowestGoalDiff = entry.getValue();
                teamWithLowestGoalDiff = entry.getKey();
            }
        }
        System.out.println("Team with lowest goal difference is found, it's " + teamWithLowestGoalDiff + " with " + lowestGoalDiff + " goal difference");
    }


}
