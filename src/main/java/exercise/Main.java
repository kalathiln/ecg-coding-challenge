package exercise;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.System.out;

/**
 * Main class that deals with
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // Parse the csv file here and convert it into Arraylists
        List<List<String>> records = new ArrayList<>();

        try{

            LOGGER.info("======== Parsing CSV File =======");
            // Filename is passed as a fixed path coming in from testdata
            // The file is parsed and added to a List of list comprising of values from individual lines into the variable record
            records = ProcessFile.parseAddressBookWithFile("src/testdata/address-book.csv");
            LOGGER.info("======== Parsing Finished =======");
            LOGGER.info("Length of Records in the CSV File : "+records.size());
            LOGGER.info("======== Processing Required Parameter =========");

            // Parsed records are sent to the findParameter method to process the results
            ProcessFile.findParameters(records);
            LOGGER.info("======== Data Processing finished ==========");

            // Printing out the results as required.
            out.println("Number of females inside address book: "+ProcessFile.getNumberOfFemale());
            out.println("Oldest person inside address book : "+ProcessFile.getNameOfOldestPerson());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
