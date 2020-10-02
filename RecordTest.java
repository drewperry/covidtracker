
/**
 * 
 */

import student.TestCase;

/**
 * @author Drew Perry
 *
 */
public class RecordTest extends TestCase {
    static String[] recs = { "20200818", "KS", "35167", "319095", "2034", "24",
        "200", "1409", "A+", "405" };
    static Record tester = new Record(recs);

    static String[] recs2 = { "20200818", "KS", "35167", "319095", "2034", "24",
        "200", "1409", "A", "405" };

    static Record tester2 = new Record(recs2);

    /**
     * 
     */
    public static void testSTATES() {
        assert tester.states() != null;
    }

    /**
     * 
     */
    public void testRecord() {
        Record test2 = new Record(recs);
        assert test2 != null;
        assert test2.getDataQualityGrade().equals("A+");
    }

    /**
     *     
     */
    public void testupdate() {

        tester2.update(tester);
        assertTrue(tester2.getDataQualityGrade().equals("A+"));
    }

    /**
     * 
     */
    public void testgetState() {
        assert tester.getState().equals("KS");
    }

    /**
    * 
    */
    public void testgetDate() {
        assert tester.getDate().equals("20200818");
    }

    /**
     * 
     */
    public void testgetHospitalized() {
        assert tester.getHospitalized().equals("2034");
    }

    /**
     * 
     */
    public void testgetPositive() {
        assert tester.getPositive().equals("35167");
    }

    /**
     * 
     */
    public void testgetNegative() {
        assert tester.getNegative().equals("319095");
    }

    /**
     * 
     */
    public void testgetOnVentilatorCurrently() {
        assert tester.getOnVentilatorCurrently().equals("24");
    }

    /**
     * 
     */
    public void testgetDataQualityGrade() {
        assert tester.getDataQualityGrade().equals("A+");
    }

    /**
     * 7
     */
    public void testgetRecovered() {
        assert tester.getRecovered().equals("1409");
    }

    /**
     * 
     */
    public void testgetDeath() {
        assertTrue(tester.getDeath().equals("405"));
    }

    /**
     * 
     */
    public void testisSame() {
        assertTrue(tester.isSame(tester2));
    }

    /**
     * 
     */
    public void testtoString() {
        assertNotNull(tester.toString());
    }

    /**
     * 
     */
    public void testtoStringSummary() {
        assertNotNull(tester.toStringSummary(1, 1, 1));
    }

//    /**
//     * 
//     */
//    public void testtoStringDate() {
//
//    }
//
//    /**
//     * 
//     */
//    public void testtoStringState() {
//
//    }
//
//    /**
//     * 
//     */
//    public void testcompareTo() {
//
//    }
}
