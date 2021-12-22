package exercise;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        // Parse the csv file here and convert it into Arraylists
        List<List<String>> records = new ArrayList<>();

        try{
            out.println("================ Parsing CSV File =======");
            records = ProcessFile.parseAddressBookWithFile("src/testdata/address-book.csv");
            out.println("================ CSV Parsed =======");
            out.println("Length of Records in the CSV File : "+records.size());
            out.println("======= Processing Required Parameter =========");
            ProcessFile.findParameters(records);
            out.println("======= Data Processing finished ==========");

            out.println("Number of females inside address book: "+ProcessFile.getNumberOfFemale());
            out.println("Oldest person inside address book : "+ProcessFile.getNameOfOldestPerson());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
