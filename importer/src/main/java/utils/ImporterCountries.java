package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ImporterCountries.java reads through every line of dataset
 * @author Caelan Whitter
 */
public class ImporterCountries {
    

    private String line = " ";
    private String splitby = ",";

    private String countryAttributesPath;

    private List<Country> countryList = new ArrayList<Country>();

    
    private List<String> names = new ArrayList<String>();

    /**
     * set the paths to the csv file
     */
    public ImporterCountries(String pathCountry,List<String> countries) {
      
        this.countryAttributesPath = pathCountry;
      this.name = countries; 
    }

    public List<Country> fetchDataFromDataset() throws IOException {

        /**
         * a try-catch method to extract data from csv file
         */
        BufferedReader country = fileReader(countryAttributesPath);

        
         pickDataCountry(country);
      
        
        return  countryList;
    }
  
  public BufferedReader fileReader(String file) throws IOException {
    
          FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
      return reader;
  }
    
  
    
    public void pickDataCountry(BufferedReader reader) throws IOException {
        try {
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                /**
                 * Skip the first line of the csv file
                 */
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Country countries = new Country();

                String[] countryAttributes = line.split(splitby);

                names.add(countryAttributes[1]);

                countries.setName(countryAttributes[1]);
                countries.setCapital(countryAttributes[6]);
                countries.setCurrency(countryAttributes[7]);
                countries.setCurrencyName(countryAttributes[8]);
                countries.setCurrencySymbol(countryAttributes[9]);
                countries.setCountryCode(countryAttributes[3]);
                countries.setRegion(countryAttributes[12]);
                countries.setLongitude(countryAttributes[15]);
                countries.setLatitude(countryAttributes[16]);

                /* Add Countries into list */
                countryList.add(countries);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
        
        
    
}
