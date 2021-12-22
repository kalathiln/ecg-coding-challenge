package exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * This class is responsible for parsing and processing of the csv file in the testdata
 */
public class ProcessFile {
    // Assuming correct dataset, the comma_delimiter used for parsing
    private static final String COMMA_DELIMITER = ", ";
    // Variable storing the Name of oldest person
    private static String nameOfOldestPerson;
    // Variable storing number of females
    private static int numberOfFemale;

    public static List<List<String>> parseAddressBookWithFile(String fileName) {
        List<List<String>> records = new ArrayList<>();
        // Using buffered Reader to access the csv file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    // Method responsible for evaluating required parameters
    public static void findParameters(List<List<String>> records) throws ParseException {
        // Initially used for storing the results in the hashmap
        // HashMap result = new HashMap();
        // Local variable to store intermediate number of females
        int numberOfFemales =0;
        //Local variable to store intermediate Name of the oldest Person
        String nameOfOldest = null;

        for (List<String> record:records) {
            // Calculate number of females
            String gender = record.get(1);

            // updating number of females
            if(gender.equals("Female")){
                numberOfFemales++;
            }

            // Finding Oldest person
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dob =  sdf.parse(record.get(2));
            // Passing today's date
            Date today = sdf.parse("2021-12-22");


            long diffInMillies = Math.abs(today.getTime() - dob.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long largestDateDiff = 0;
            if(diff > largestDateDiff){
                largestDateDiff = diff;
                nameOfOldest = record.get(0);
            }
            // Setting the results to static variables in order to be extracted from the Main Class.
            setNumberOfFemale(numberOfFemales);
            setNameOfOldestPerson(nameOfOldest);

        }
    }

    // Getters and Setters
    private static void setNameOfOldestPerson(String nameOfOldest) {
        nameOfOldestPerson = nameOfOldest;
    }

    public static int getNumberOfFemale() {
        return numberOfFemale;
    }

    public static void setNumberOfFemale(int numberOfFemale) {
        ProcessFile.numberOfFemale = numberOfFemale;
    }

    public static String getNameOfOldestPerson() {
        return nameOfOldestPerson;
    }
}
