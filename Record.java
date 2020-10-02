// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Avni Trasi (avnitrasi)

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
/**
 * Stores the important fields for record
 * @author Drew Perry
 * @version 1
 *
 */
public class Record implements Comparable<Record> {

    private static String header;
    private static String stateHeader;
    private static String dateHeader;
    private static String summaryHeader;
    private static TreeMap<String, String> stateList;
    private static HashMap<String, String> fullStateName;

    private String date;
    private String state;
    private String stateName;
    private String positive;
    private String negative;
    private String hospitalized;
    private String onVentilatorCurrently;
    private String onVentilatorCumulative;
    private String recovered;
    private String dataQualityGrade;
    private String death;
    private HashMap<String, Integer> grades;
    
    /**
     * All the valid states
     * @return TreeMap of the states
     */
    public static TreeMap<String, String> states() {

        if (stateList == null) {
            stateList = new TreeMap<String, String>();
            stateList.put("ALABAMA", "AL");
            stateList.put("ALASKA", "AK");
            stateList.put("AMERICAN SAMOA", "AS");
            stateList.put("ARIZONA", "AZ");
            stateList.put("ARKANSAS", "AR");
            stateList.put("CALIFORNIA", "CA");
            stateList.put("COLORADO", "CO");
            stateList.put("CONNECTICUT", "CT");
            stateList.put("DELAWARE", "DE");
            stateList.put("DISTRICT OF COLUMBIA", "DC");
            stateList.put("FLORIDA", "FL");
            stateList.put("GEORGIA", "GA");
            stateList.put("GUAM", "GU");
            stateList.put("HAWAII", "HI");
            stateList.put("IDAHO", "ID");
            stateList.put("ILLINOIS", "IL");
            stateList.put("INDIANA", "IN");
            stateList.put("IOWA", "IA");
            stateList.put("KANSAS", "KS");
            stateList.put("KENTUCKY", "KY");
            stateList.put("LOUISIANA", "LA");
            stateList.put("MAINE", "ME");
            stateList.put("MARSHALL ISLANDS", "MH");
            stateList.put("MARYLAND", "MD");
            stateList.put("MASSACHUSETTS", "MA");
            stateList.put("MICHIGAN", "MI");
            stateList.put("MICRONESIA", "FM");
            stateList.put("MINNESOTA", "MN");
            stateList.put("MISSISSIPPI", "MS");
            stateList.put("MISSOURI", "MO");
            stateList.put("MONTANA", "MT");
            stateList.put("NEBRASKA", "NE");
            stateList.put("NEVADA", "NV");
            stateList.put("NEW HAMPSHIRE", "NH");
            stateList.put("NEW JERSEY", "NJ");
            stateList.put("NEW MEXICO", "NM");
            stateList.put("NEW YORK", "NY");
            stateList.put("NORTH CAROLINA", "NC");
            stateList.put("NORTH DAKOTA", "ND");
            stateList.put("NORTHERN MARIANAS", "MP");
            stateList.put("OHIO", "OH");
            stateList.put("OKLAHOMA", "OK");
            stateList.put("OREGON", "OR");
            stateList.put("PALAU", "PW");
            stateList.put("PENNSYLVANIA", "PA");
            stateList.put("PUERTO RICO", "PR");
            stateList.put("RHODE ISLAND", "RI");
            stateList.put("SOUTH CAROLINA", "SC");
            stateList.put("SOUTH DAKOTA", "SD");
            stateList.put("TENNESSEE", "TN");
            stateList.put("TEXAS", "TX");
            stateList.put("UTAH", "UT");
            stateList.put("VERMONT", "VT");
            stateList.put("VIRGINIA", "VA");
            stateList.put("VIRGIN ISLANDS", "VI");
            stateList.put("WASHINGTON", "WA");
            stateList.put("WEST VIRGINIA", "WV");
            stateList.put("WISCONSIN", "WI");
            stateList.put("WYOMING", "WY");
        }
        return stateList;
    }

    /**
     * HashMap of the full state names
     * @return a HashMap of the full state names
     */
    public HashMap<String, String> fullStateName() {

        if (fullStateName == null) {
            fullStateName = new HashMap<String, String>();
            fullStateName.put("AL", "ALABAMA");
            fullStateName.put("AK", "ALASKA");
            fullStateName.put("AS", "AMERICAN SAMOA");
            fullStateName.put("AZ", "ARIZONA");
            fullStateName.put("AR", "ARKANSAS");
            fullStateName.put("CA", "CALIFORNIA");
            fullStateName.put("CO", "COLORADO");
            fullStateName.put("CT", "CONNECTICUT");
            fullStateName.put("DE", "DELAWARE");
            fullStateName.put("DC", "DISTRICT OF COLUMBIA");
            fullStateName.put("FL", "FLORIDA");
            fullStateName.put("GA", "GEORGIA");
            fullStateName.put("GU", "GUAM");
            fullStateName.put("HI", "HAWAII");
            fullStateName.put("ID", "IDAHO");
            fullStateName.put("IL", "ILLINOIS");
            fullStateName.put("IN", "INDIANA");
            fullStateName.put("IA", "IOWA");
            fullStateName.put("KS", "KANSAS");
            fullStateName.put("KY", "KENTUCKY");
            fullStateName.put("LA", "LOUISIANA");
            fullStateName.put("ME", "MAINE");
            fullStateName.put("MH", "MARSHALL ISLANDS");
            fullStateName.put("MD", "MARYLAND");
            fullStateName.put("MA", "MASSACHUSETTS");
            fullStateName.put("MI", "MICHIGAN");
            fullStateName.put("FM", "MICRONESIA");
            fullStateName.put("MN", "MINNESOTA");
            fullStateName.put("MS", "MISSISSIPPI");
            fullStateName.put("MO", "MISSOURI");
            fullStateName.put("MT", "MONTANA");
            fullStateName.put("NE", "NEBRASKA");
            fullStateName.put("NV", "NEVADA");
            fullStateName.put("NH", "NEW HAMPSHIRE");
            fullStateName.put("NJ", "NEW JERSEY");
            fullStateName.put("NM", "NEW MEXICO");
            fullStateName.put("NY", "NEW YORK");
            fullStateName.put("NC", "NORTH CAROLINA");
            fullStateName.put("ND", "NORTH DAKOTA");
            fullStateName.put("MP", "NORTHERN MARIANAS");
            fullStateName.put("OH", "OHIO");
            fullStateName.put("OK", "OKLAHOMA");
            fullStateName.put("OR", "OREGON");
            fullStateName.put("PW", "PALAU");
            fullStateName.put("PA", "PENNSYLVANIA");
            fullStateName.put("PR", "PUERTO RICO");
            fullStateName.put("RI", "RHODE ISLAND");
            fullStateName.put("SC", "SOUTH CAROLINA");
            fullStateName.put("SD", "SOUTH DAKOTA");
            fullStateName.put("TN", "TENNESSEE");
            fullStateName.put("TX", "TEXAS");
            fullStateName.put("UT", "UTAH");
            fullStateName.put("VT", "VERMONT");
            fullStateName.put("VA", "VIRGINIA");
            fullStateName.put("VI", "VIRGIN ISLANDS");
            fullStateName.put("WA", "WASHINGTON");
            fullStateName.put("WV", "WEST VIRGINIA");
            fullStateName.put("WI", "WISCONSIN");
            fullStateName.put("WY", "WYOMING");
        }
        return fullStateName;
    }

    /**
     * Record that stores all the data collected
     * @param record is String[] to be read
     */
    public Record(String[] record) {
        // if date.length != 8 print "discard invalid record"
        date = record[0];

        // if no state print "discard invalid record"
        state = record[1];
        positive = record[2].trim().equals("") ? "0" : record[2];
        negative = record[3].trim().equals("") ? "0" : record[3];
        hospitalized = record[4].trim().equals("") ? "0" : record[4];
        onVentilatorCurrently = record[5].trim().equals("") ? "0" : record[5];
        onVentilatorCumulative = record[6].trim().equals("") ? "0" : record[6];
        recovered = record[7].trim().equals("") ? "0" : record[7];

        stateName = this.fullStateName().get(state.toUpperCase());
        // if no data quality grade print "discard invalid record"
        dataQualityGrade = record[8];

        death = record[9].trim().equals("") ? "0" : record[9];
        grades = new HashMap<String, Integer>();
        grades.put("A+", 14);
        grades.put("A", 13);
        grades.put("A-", 12);
        grades.put("B+", 11);
        grades.put("B", 10);
        grades.put("B-", 9);
        grades.put("C+", 8);
        grades.put("C", 7);
        grades.put("C-", 6);
        grades.put("D+", 5);
        grades.put("D", 4);
        grades.put("D-", 3);
        grades.put("E", 2);
        grades.put("F", 1);
    }

    /**
     * Sets the headers to be printed
     * @param header is the String[] to be read
     */
    public static void setHeaders(String[] header) {
        setHEADER(header[0] + "," + header[1] + "," + header[2] + "," + header[3]
            + "," + header[4] + "," + header[5] + "," + header[6] + ","
            + header[7] + "," + header[8] + "," + header[9]);
        setSTATEHEADER(String.format(
            "%-15s%-12s%-15s%-15s%-24s%-26s%-12s%-19s%-8s", header[0],
            header[2], header[3], header[4], header[5], header[6], header[7],
            header[8], header[9]));
        setDATEHEADER(String.format(
            "%-8s%-12s%-15s%-15s%-24s%-26s%-12s%-19s%-8s", header[1], header[2],
            header[3], header[4], header[5], header[6], header[7], header[8],
            header[9]));
        setSUMMARYHEADER(String.format("%-8s%-12s%-14s%-18s", "State",
            "Total Case", "Total Death", "Total Hospitalized"));
    }

    /**
     * updates a record if it needs to
     * @param record is record to checl
     * @return updated record
     */
    public boolean update(Record record) {
        if (grades.get(this.getDataQualityGrade()) != null
            && grades.get(record.getDataQualityGrade()) != null) {
            if (grades.get(this.getDataQualityGrade()).intValue() >= grades
                .get(record.getDataQualityGrade()).intValue()) {
                this.hospitalized = this.hospitalized.equals("")
                    ? record.getHospitalized()
                    : this.hospitalized;
                this.positive = this.positive.equals("") ? record.getPositive()
                    : this.positive;
                this.negative = this.hospitalized.equals("")
                    ? record.getNegative()
                    : this.negative;
                this.onVentilatorCurrently = this.onVentilatorCurrently
                    .equals("") ? record.getOnVentilatorCurrently()
                        : this.onVentilatorCurrently;
                this.onVentilatorCumulative = this.onVentilatorCumulative
                    .equals("") ? record.getOnVentilatorCumulative()
                        : this.onVentilatorCumulative;
                this.recovered = this.recovered.equals("")
                    ? record.getRecovered()
                    : this.recovered;
                this.death = this.death.equals("") ? record.getDeath()
                    : this.death;
                return true;
            } 
            else {
                this.hospitalized = record.getHospitalized();
                this.positive = record.getPositive();
                this.negative = record.getNegative();
                this.onVentilatorCurrently = record.getOnVentilatorCurrently();
                this.onVentilatorCumulative = record
                    .getOnVentilatorCumulative();
                this.recovered = record.getRecovered();
                this.dataQualityGrade = record.getDataQualityGrade();
                this.death = record.getDeath();
            }
        }
        return false;
    }
    /**
     * Getter method for state name
     * @return full state
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Getter method for state
     * @return abreviated state
     */
    public String getState() {
        return state;
    }

    /**
     * Getter method for date
     * @return the date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Getter method for hospitalized
     * @return String for # of Hospitalized
     */
    public String getHospitalized() {
        return hospitalized;
    }
    
    /**
     * Getter method for positive cases
     * @return positive cases
     */
    public String getPositive() {
        return positive;
    }
    
    /**
     * Getter method for negative cases
     * @return negative cases
     */
    public String getNegative() {
        return negative;
    }
    
    /**
     * Getter method for onVentCurrently
     * @return # of Ventilator
     */
    public String getOnVentilatorCurrently() {
        return onVentilatorCurrently;
    }
    
    /**
     * Getter method for cumulative ventilator
     * @return cumulative on vent
     */
    public String getOnVentilatorCumulative() {
        return onVentilatorCumulative;
    }

    /**
     * Getter method for data quality grade
     * @return the quality grade
     */
    public String getDataQualityGrade() {
        return dataQualityGrade;
    }

    /**
     * Getter method for recovered
     * @return string of those recovered
     */
    public String getRecovered() {
        return recovered;
    }

    /**
     * Getter method for deaths
     * @return string of deaths
     */
    public String getDeath() {
        return death;
    }

    /**
     * Checks if two records are the same
     * @param record is the record to check
     * @return whether the two are the same
     */
    public boolean isSame(Record record) {
        return (this.date.equals(record.date) && 
            this.state.equals(record.state));
    }

    /**
     * Overrides original two string method
     */
    @Override
    public String toString() {
        return date + "," + state + "," + positive + "," + negative + ","
            + hospitalized + "," + onVentilatorCurrently + ","
            + onVentilatorCumulative + "," + recovered + "," + dataQualityGrade
            + "," + death;
    }

    /**
     * Creates summary of the two string method
     * @param cases # of cases
     * @param deaths # of deaths
     * @param hospitalize # of hospitalized
     * @return the summarized toString format
     */
    public String toStringSummary(int cases, int deaths, int hospitalize) {
        return String.format("%-8s%,-12d%,-14d%,-18d", state, cases, deaths,
            hospitalize);
    }

    /**
     * THe summarized toStringDates
     * @return the summarized dates
     */
    public String toStringDate() {
        return String.format(
            "%-8s%,-12d%,-15d%,-15d%,-24d%,-26d%,-12d%-19s%,-8d", state,
            (int) Float.parseFloat(positive), (int) Float.parseFloat(negative),
            (int) Float.parseFloat(hospitalized),
            (int) Float.parseFloat(onVentilatorCurrently),
            (int) Float.parseFloat(onVentilatorCumulative),
            (int) Float.parseFloat(recovered), dataQualityGrade,
            (int) Float.parseFloat(death));
    }
    
    /**
     * Specific toString for states
     * @return is the state to return
     */
    public String toStringState() {
        return String.format(
            "%-15s%,-12d%,-15d%,-15d%,-24d%,-26d%,-12d%-19s%,-8d",
            date.substring(4, 6) + "/" + date.substring(6) + "/"
                + date.substring(0, 4),
            (int) Float.parseFloat(positive), (int) Float.parseFloat(negative),
            (int) Float.parseFloat(hospitalized),
            (int) Float.parseFloat(onVentilatorCurrently),
            (int) Float.parseFloat(onVentilatorCumulative),
            (int) Float.parseFloat(recovered), dataQualityGrade,
            (int) Float.parseFloat(death));
    }

    /**
     * Compares the records based on date
     */
    @Override
    public int compareTo(Record record) {
        return record.getDate().compareTo(this.date);
    }

    /**
     * @return the sTATEHEADER
     */
    public static String getSTATEHEADER() {
        return stateHeader;
    }

    /**
     * @param sTATEHEADER the sTATEHEADER to set
     */
    public static void setSTATEHEADER(String sTATEHEADER) {
        stateHeader = sTATEHEADER;
    }

    /**
     * @return the dATEHEADER
     */
    public static String getDATEHEADER() {
        return dateHeader;
    }

    /**
     * @param dATEHEADER the dATEHEADER to set
     */
    public static void setDATEHEADER(String dATEHEADER) {
        dateHeader = dATEHEADER;
    }

    /**
     * @return the sUMMARYHEADER
     */
    public static String getSUMMARYHEADER() {
        return summaryHeader;
    }

    /**
     * @param sUMMARYHEADER the sUMMARYHEADER to set
     */
    public static void setSUMMARYHEADER(String sUMMARYHEADER) {
        summaryHeader = sUMMARYHEADER;
    }

    /**
     * @return the hEADER
     */
    public static String getHEADER() {
        return header;
    }

    /**
     * @param hEADER the hEADER to set
     */
    public static void setHEADER(String hEADER) {
        header = hEADER;
    }

    /**
     * @return the stateComparator
     */
    public static Comparator<Record> getStateComparator() {
        return stateComparator;
    }

    /**
     * @param stateComparator the stateComparator to set
     */
    public static void setStateComparator(Comparator<Record> stateComp) {
        stateComparator = stateComp;
    }

    /**
     * Makes comparator for states
     */
    private static Comparator<Record> stateComparator = 
        new Comparator<Record>() {
        @Override
        /**
         * compared the states
         */
        public int compare(Record record1, Record record2) {

//            String state1 = record1.getState().toUpperCase();
//            String state2 = record2.getState().toUpperCase();

            String state1 = record1.getStateName().toUpperCase();
            String state2 = record2.getStateName().toUpperCase();

            // ascending order
            return state1.compareTo(state2);
        }

    };
}
