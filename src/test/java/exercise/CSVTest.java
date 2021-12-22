package exercise;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class CSVTest {

    // your unit tests here
    @Test
    void parseAddressBookWithFileFound() throws FileNotFoundException {
        // To test if the file exists
        List<List<String>> records = new ArrayList<>();
        // Using buffered Reader to access the csv file
        BufferedReader br = new BufferedReader(new FileReader("src/testdata/address-book.csv"));
        Assertions.assertNotNull(br);

    }


    @Test
    void findParameters() {
            // TODO tests to test the processing and evaluation of results
            List<String> record1 = new ArrayList<>();
            record1.add("Nik");
            record1.add("Male");
            record1.add("1988-03-03");


    }

}
