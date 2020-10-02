
/**
 * 
 */

import student.TestCase;

/**
 * @author Drew Perry (andrewperry)
 * @version 1
 *
 */
public class Covid19TrackingManagerTest extends TestCase {
    /**
     * array used for testing
     */
    private static String[] recs = 
    { "20200819", "KS", "35167", "319095", "2034", "24",
        "200", "1409", "A+", "405" };

    /**
     * tester is the record
     */
    private static Record tester = new Record(recs);
    
    /**
     * CovidTrackingManager used for testing
     */
    @SuppressWarnings("unused")
    private Covid19TrackingManager test = 
        new Covid19TrackingManager("input_1.txt");

    /**
     * Tests the tracking manager
     * 
     */
    public void testCovid19TrackingManager() {
        test = new Covid19TrackingManager("input_1.txt");
        assertNotNull(Covid19TrackingManager.getStateKey());
        assertNotNull(Covid19TrackingManager.getDateKey());

    }

    /**
     * Tests the tracking manager if file DNE
     * 
     */
    public void testCovid19TrackingManagerDNE() {
        Exception e = null;
        try {
            test = new Covid19TrackingManager("input_2.txt");

        } 
        catch (Exception exception) {
            e = exception;
        }

        assertNull(e);
        // assertTrue(e instanceof FileNotFoundException);

    }

    /**
     * Tests if the date list is properly updated
     */
    public void testupdateDateList() {
        Exception e = null;
        try {
            Covid19TrackingManager.updateDateList(tester);
        } 
        catch (Exception exception) {
            e = exception;
        }

        assertNull(e);

    }

    /**
     * 
     */
    public void testmain() {
        String[] args = { "input_1.txt" };
        Covid19TrackingManager.main(args);
        assertNotNull(systemOut().getHistory());
        // String myOutput = systemOut().getHistory();
        // assertEquals(<answer string>`, myOutput);
    }

    /**
     * Tests if the state list is properly updates
     */
    public void testupdateStateList() {
        Exception e = null;
        try {
            Covid19TrackingManager.updateStateList(tester);
        } 
        catch (Exception exception) {
            e = exception;
        }

        assertNull(e);
    }

}
