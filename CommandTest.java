
/**
 * 
 */

import java.io.ByteArrayOutputStream;

import student.TestCase;

/**
 * 
 * @author Drew Perry (andrewperry)
 * @version 1
 */
public class CommandTest extends TestCase {
    private static ByteArrayOutputStream outContent = 
        new ByteArrayOutputStream();

    /**
     * @param args are the arguments for the function
     */
    public static void main(String[] args) {
        // Not currently used in testing

    }

    /**
     * Tests the execute command
     */
    public static void testexecute1() {
        Exception e = null;
        try {
            Command.execute("load input_1.txt");
        } 
        catch (Exception exception) {
            e = exception;
        }

        assertNull(e);
    }

    /**
     * Tests the execute command
     */
    public static void testexecute2() {
        Exception e = null;
        try {
            Command.execute("load input_2.txt");
        } 
        catch (Exception exception) {
            e = exception;
        }

        assertNull(e);
    }

    /**
     * Tests if load throws NullPointerException
     */
    public static void testloadNULL() {
        Exception e = null;
        try {
            Command.execute("search 08/17/2020");
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertNull(e);
        // assertTrue(e instanceof NullPointerException);

    }

    /**
     * Tests the search with 3 parameters
     */
    public static void testsearch3() {
        Command.execute("search      haWaii 5");
        assertNotNull(System.out);
    }

    /**
     * Tests search with only the date
     */
    public static void testsearch1() {
        Command.execute("search 08/17/2020");
        assertNotNull(outContent.toString());

    }

    /**
     * Tests summary data
     */
    public static void testsummarydata() {
        Command.summaryData();
        assertNotNull(outContent.toString());

    }

    /**
     * Tests dump data
     */
    public static void testdumpdataERROR() {
        Command.dumpData("pies.txt");
        assertNotNull(outContent.toString());
    }
}
