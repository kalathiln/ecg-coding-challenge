package exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ProcessFile {

    private static final String COMMA_DELIMITER = ", ";
    private static String nameOfOldestPerson;
    private static int numberOfFemale;

    public static List<List<String>> parseAddressBookWithFile(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/testdata/address-book.csv"))) {
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

    public static void findParameters(List<List<String>> records) throws ParseException {
        
        HashMap result = new HashMap();
        int numberOfFemales =0;
        String nameOfOldest = null;
        for (List<String> record:records) {
            // Calculate number of females
            String gender = record.get(1);

            if(gender.equals("Female")){
                numberOfFemales++;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dob =  sdf.parse(record.get(2));
            Date today = sdf.parse("2021-12-22");


            long diffInMillies = Math.abs(today.getTime() - dob.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long largestDateDiff = 0;
            if(diff > largestDateDiff){
                largestDateDiff = diff;
                nameOfOldest = record.get(0);
            }
            setNumberOfFemale(numberOfFemales);
            setNameOfOldestPerson(nameOfOldest);

        }
    }

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
