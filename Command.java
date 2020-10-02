// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Avni Trasi (avnitrasi)
// -- Drew Perry (andrewperry)

/**
 * @author Avni Trasi (avnitrasi)
 *
 * @version 1
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class uses the commands with Covid19TrackingManager in order to properly
 * output
 * 
 * @author Drew Perry
 * @author Avni Trasi
 * @version 1
 */
public class Command {

    /**
     * 
    */
    public Command() {
        // for setup later
    }

    /**
     * Counts up lines in file
     */
    private static int lines;

    /**
     * Executes the command based on what is entered
     * 
     * @param command is the command to be executed
     */
    public static void execute(String command) {
        command = command.trim();
        if (command.trim().startsWith("load")) {
		String load[] = command.split(" +");
		if (load.length == 2) {
            		load((load[1]).trim());
		}
        } 
        else if (command.trim().startsWith("search")) {
            String[] array = command.split(" +");
            String numRecords;
            String state;
            String original;
            switch (array.length) {
                case 1: // date search (no specific date given)
                    search(null);
                    break;
                case 2: // date search
                    search(array[1]);
                    break;
                case 3: // state code search or state name search
                    original = array[1].trim();
                    state = Record.states().get(array[1].trim().toUpperCase());
                    if (state == null) {
                        state = array[1].trim().toUpperCase();
                    }

                    if (Record.states().containsValue(state)) {
                        numRecords = array[2].trim();
                        search(state, Integer.valueOf(numRecords), 
                            array[1].trim());
                    } 
                    else {
                        // Print error message
                        System.out
                            .println("State of " + original + 
                                " does not exist!");
                    }
                    break;
                case 4: // 2 word state name search
                    state = Record.states().get(
                        (array[1].trim() + " " + 
                            array[2].trim()).toUpperCase());
                    numRecords = array[3].trim();
                    search(state, Integer.valueOf(numRecords),
                        array[1].trim() + " " + array[2].trim());
                    break;
                case 5: // 3 word state name search
                    state = Record.states().get((array[1].trim() + " "
                        + array[2].trim() + " " 
                        + array[3].trim()).toUpperCase());
                    numRecords = array[4].trim();
                    search(state, Integer.valueOf(numRecords), 
                            array[1].trim() + " " + array[2].trim() + " " 
                                + array[3].trim());
                    break;
                default:
                    break;
            }
        } 
        else if (command.trim().startsWith("summarydata")) {
            summaryData();
        } 
        else if (command.trim().startsWith("dumpdata")) {
            dumpData((command.split(" +")[1]).trim());
        }
//        else {
//            // Blank line or unsupported command
//        }
    }

    /**
     * Loads in the designated file
     * 
     * @param fileName is the file to load
     */
    public static void load(String fileName) {
        try {
            setLines(0);
            Scanner scanner = new Scanner(new File(fileName));
            Record.setHeaders(scanner.nextLine().split(",")); // header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                if (line.split(",", -1).length < 9) {
                    continue;
                }

                Record record = new Record(line.split(",", -1));
                Covid19TrackingManager.updateStateList(record);
                Covid19TrackingManager.updateDateList(record);
                setLines(getLines() + 1);
            }
            scanner.close();
            System.out.println("Finished loading " + fileName + " file");
            System.out.println(getLines() + " records have been loaded");
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for the recent number of records for a state
     * 
     * @param state         is the key to find the state
     * @param numRecords    is the number of records to be printed
     * @param originalState is the state to be printed
     */
    public static void search(String state, int numRecords,
        String originalState) {

        // Missing state, date, or quality grade.

        if (Covid19TrackingManager.getStateKey().containsKey(state)) {
            // print data
            int size = Covid19TrackingManager.getStateKey().get(state).size();
            if (size > numRecords) {
                size = numRecords;
            }
            System.out.println(size
                + " records are printed out for the state of " + originalState);
            System.out.println(Record.getSTATEHEADER());
            for (int i = 0; i < size; i++) {
                System.out.println(
                    Covid19TrackingManager.getStateKey().get(state)
                    .get(i).toStringState());
            }
        } 
        else {
            System.out.println("There are no records from " + originalState);
        }
    }

    /**
     * Searches for a record based on specific date
     * 
     * @param date is the date to be found
     */
    public static void search(String date) {
        if (date == null) {
            // no specific date given
            // print out latest
            String[] keys = Covid19TrackingManager.getDateKey().keySet()
                .toArray(new String[Covid19TrackingManager.
                                    getDateKey().size()]);
            Arrays.sort(keys, Collections.reverseOrder());

            // print data
            int size = Covid19TrackingManager.getDateKey().get(keys[0]).size();
            System.out.println("There are " + size + " records on "
                + keys[0].substring(4, 6) + "/" + keys[0].substring(6) + "/"
                + keys[0].substring(0, 4));
            System.out.println(Record.getDATEHEADER());
            for (int i = 0; i < size; i++) {
                System.out.println(Covid19TrackingManager.getDateKey()
                    .get(keys[0]).get(i).toStringDate());
            }
        } 
        else {
            String[] dateArray = date.trim().split("/");
            String modifiedDate = dateArray[2] + dateArray[0] + dateArray[1];
            if (Covid19TrackingManager.getDateKey().containsKey(modifiedDate)) {
                // print data
                int size = Covid19TrackingManager.getDateKey().get(modifiedDate)
                    .size();
                System.out.println("There are " + size + " records on " + date);
                System.out.println(Record.getDATEHEADER());
                for (int i = 0; i < size; i++) {
                    System.out.println(Covid19TrackingManager.getDateKey()
                        .get(modifiedDate).get(i).toStringDate());
                }
            } 
            else {
                // print error
                System.out.println("There are no records on " + date);
            }
        }
    }

    /**
     * Prints out a summary of the data
     */
    public static void summaryData() {
        // print data 
        int size = Covid19TrackingManager.getStateKey().size();
        System.out.println("Data Summary for " + size + " states:");
        System.out.println(Record.getSUMMARYHEADER());
        int totalCases = 0;
        int totalDeaths = 0;
        int totalHospitalized = 0;
//        for (ArrayList<Record> value : Covid19TrackingManager.getStateKey()
//            .values()) {
        for (String s : Record.states().values()) {
            ArrayList<Record> value = Covid19TrackingManager.getStateKey()
                .get(s);
            if (value == null) {
                continue;
            }
            int cases = 0;
            int deaths = 0;
            int hospitalized = 0;
            Record record = value.get(0);
            for (int i = 0; i < value.size(); i++) {
                record = value.get(i);
                cases = cases + (record.getPositive().trim().equals("") ? 0
                    : (int) Float.parseFloat(record.getPositive()));
                deaths = deaths + (record.getDeath().trim().equals("") ? 0
                    : (int) Float.parseFloat(record.getDeath()));
                hospitalized = hospitalized
                    + ((record.getHospitalized().trim().equals("")) ? 0
                        : (int) Float.parseFloat(record.getHospitalized()));
            }
            System.out
                .println(record.toStringSummary(cases, deaths, hospitalized));
            totalCases = totalCases + cases;
            totalDeaths = totalDeaths + deaths;
            totalHospitalized = totalHospitalized + hospitalized;
        }
        System.out.println("Total Cases: " + String.format("%,d", totalCases));
        System.out.println("Total Death: " + String.format("%,d", totalDeaths));
        System.out.println(
            "Total Hospitalized: " + String.format("%,d", totalHospitalized));
    }

    /**
     * Dumps the data into another file
     * 
     * @param fileName is the file to be dumped to
     */
    public static void dumpData(String fileName) {
        try {
            // print data to file
            PrintWriter writer = new PrintWriter(fileName);
            writer.println(Record.getHEADER());
            int count = 0;
            for (ArrayList<Record> value : Covid19TrackingManager.getStateKey()
                .values()) {
                int size = value.size();
                count = count + size;
                for (int i = 0; i < size; i++) {
                    writer.println(value.get(i).toString());
                }
            }
            writer.close();
            System.out.println(count + " records have been saved in the "
                + fileName + " file");
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns # of lines
     * @return # of lines in file
     */
    public static int getLines() {
        return lines;
    }
    
    /**
     * Sets lines in file
     * @param lines to set
     */
    public static void setLines(int lines) {
        Command.lines = lines;
    }
}
