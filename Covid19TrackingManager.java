// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Avni Trasi (avnitrasi)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Outputs COVID stats based on commands and file to be loaded
 * 
 * @author Avni Trasi (avnitrasi)
 * @author Drew Perry (andrewperry)
 * @version 1
 *
 */
public class Covid19TrackingManager {

    private static TreeMap<String, ArrayList<Record>> stateKey;
    private static HashMap<String, ArrayList<Record>> dateKey;
    
    /**
     * Reads in the commands from the file
     * @param commandFile commands to be read
     */
    public Covid19TrackingManager(String commandFile) {

        try {
            Scanner scanner = new Scanner(new File(commandFile));
            while (scanner.hasNextLine()) {
                Command.execute(scanner.nextLine());
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the HashMap for dates based on the record
     * 
     * @param record is the record's date to be added
     */
    public static void updateDateList(Record record) {
        if (getDateKey() == null) {
            setDateKey(new HashMap<String, ArrayList<Record>>());
        }
        ArrayList<Record> array = getDateKey().get(record.getDate());
        if (array == null) {
            array = new ArrayList<Record>();
        }
        boolean add = true;
        for (int i = 0; i < array.size(); i++) {
            Record oldRecord = array.get(i);
            if (oldRecord.isSame(record)) {
                // overwrite
                if (oldRecord.update(record)) {
                    System.out.println(
                        "Low quality data rejected for " + record.getState());
                    // System.out.println("Data has been updated for the missing
                    // data in " +
                    // record.getState());
                    Command.setLines(Command.getLines() - 1);
                } 
                else {
                    System.out.println("Data has been updated for "
                        + record.getState() + " " + record.getDate());
                }
                add = false;
            }
        }
        if (add) {
            // add
            if (record.getState().trim().equals("")
                || record.getDate().trim().length() != 8
                || record.getDataQualityGrade().trim().equals("")) {
                System.out.println("Discard invalid record");
                   //*********talk to Drew********** Command.setLines(Command.getLines() - 1);
            } 
            else {
                array.add(record);
                Collections.sort(array, Record.getStateComparator());
                getDateKey().put(record.getDate(), array);
            }
        }
    }

    /**
     * Updates the state map based on the record
     * 
     * @param record is the record to get the key from
     */
    public static void updateStateList(Record record) {
        if (getStateKey() == null) {
            setStateKey(new TreeMap<String, ArrayList<Record>>());
        }
        ArrayList<Record> array = getStateKey().get(record.getState());
        if (array == null) {
            array = new ArrayList<Record>();
        }
        boolean add = true;
        for (int i = 0; i < array.size(); i++) {
            Record oldRecord = array.get(i);
            if (oldRecord.isSame(record)) {
                // overwrite
                add = false;
            }
        }
        if (add) {
            array.add(record);
            Collections.sort(array);
            getStateKey().put(record.getState(), array);
        }
    }

    /**
     * main argument to run the Covid tracking manager
     * 
     * @param args is the argument
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Covid19TrackingManager covid19TrackingManager = 
            new Covid19TrackingManager(
            args[0]);
    }

    /**
     * @return the stateKey
     */
    public static TreeMap<String, ArrayList<Record>> getStateKey() {
        return stateKey;
    }

    /**
     * @param stateKey the stateKey to set
     */
    public static void setStateKey(TreeMap<String, ArrayList<Record>> stateKey) 
    {
        Covid19TrackingManager.stateKey = stateKey;
    }

    /**
     * @return the dateKey
     */
    public static HashMap<String, ArrayList<Record>> getDateKey() {
        return dateKey;
    }

    /**
     * @param dateKey the dateKey to set
     */
    public static void setDateKey(HashMap<String, ArrayList<Record>> dateKey) {
        Covid19TrackingManager.dateKey = dateKey;
    }
}
