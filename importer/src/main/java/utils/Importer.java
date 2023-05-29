package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * ImporterCities.java reads through every line of dataset
 * @author Caelan Whitter
 */
public class Importer {
    /**
     * Create private fields for every field of a City
     */
    private String cityAttributesPath;
    private String stateAttributesPath;
    private String countryAttributesPath;
    private List<Cities> cityList = new ArrayList<Cities>();
    private List<States> cityList = new ArrayList<States>();
    private List<Country> cityList = new ArrayList<Country>();

    /**
     * set the paths to the csv file
     */
    public Importer(String pathCity, String pathState, String pathCountry) {
        this.cityAttributesPath = path;
        this.stateAttributesPath = path;
        this.countryAttributesPath = path;
    }

    public ArrayList[] fetchDataFromDataset() throws IOException {

        String line = " ";
        String splitby = ",";

        /**
         * a try-catch method to extract data from csv file
         */
        fileReader(cityAttributesPath);
        fileReader(stateAttributesPath);
        fileReader(countryAttributesPath);
      
      
        try {
           

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        /**
         * Return the List of Cities
         */
        return new ArrayList[] {cityList, stateList, countryList};
    }
  
  public void fileReader(String file) throws IOException {
    
          FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
  }
}
