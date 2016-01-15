package com.akshaykhot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by akshaykhot on 2016-01-13.
 */
public class EPLTest {

    private final String fileName = "scoreSheet";
    EPL computer = null;

    /**
     * Before each test isn run, create the object and a test file
     */
    @Before
    public void setUp() {
        computer = new EPL();
        createFile();
    }

    /**
     * Helper method to create a file
     */
    public void createFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
            writer.println("       Team            P     W    L   D    F      A     Pts");
            writer.println("    1. Arsenal         38    26   9   3    0  -  36    87");
            writer.println("   17. Sunderland      38    10  10  18    29  -  51    40");
            writer.println("   -------------------------------------------------------");
            writer.println("   18. Ipswich         38     9   9  20    41  -  64    36");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * test to validate the program runs as expected.
     */
    @Test
    public void testCodeExecution() {
        computer.execute(fileName);
    }

    /**
     * test to validate if a file has been read successfully
     */
    @Test
    public void testReadFile() {

        //verify if the file object is nul before reading it
        Assert.assertNull(computer.getFootball());
        createFile();
        computer.readFile(fileName);
        //verify the file  object is set up after reading it
        Assert.assertNotNull(computer.getFootball());
    }

    /**
     * test to verify if a file containing goal info is parsed and a the data is stored in a map
     */
    @Test
    public void testParseFileAndStoreInMap() {


    }

    /**
     * test to verify if calculation is done correctly
     */
    @Test
    public void testcalculateTeamWithLowestGoalDifference() {

    }

    /**
     * delete the resources after test is finished
     */
    @After
    public void delete() {
        File file = new File(fileName);
        file.delete();
    }
}
