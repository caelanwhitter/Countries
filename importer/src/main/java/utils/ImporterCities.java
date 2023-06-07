
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
 * ImporterCities.java reads through every line of dataset
 * @author Caelan Whitter
 */
public class ImporterCities {
    
    /**
     * Create private fields for every field of a City
     */
    private String line = " ";
    private String splitby = ",";

    private String cityAttributesPath;


    private List<Cities> cityList = new ArrayList<Cities>();

    
    List<String> countryNames = new ArrayList<String>();
    /**
     * set the paths to the csv file
     */
    public ImporterCities(String pathCity, List<String> countries ) {
        this.cityAttributesPath = pathCity;
      this.countryNames = countryNames;
    }

    public List<Cities> fetchDataFromDataset() throws IOException {

     

        /**
         * a try-catch method to extract data from csv file
         */
       
        BufferedReader city = fileReader(cityAttributesPath);
        pickDataCity(city);
     
        
        return  cityList;
    }
  
  public BufferedReader fileReader(String file) throws IOException {
    
          FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
      return reader;
  }
    
      public void pickDataCity(BufferedReader reader) throws IOException {
    
       try {
            boolean firstLine = true;
            while ((this.line = reader.readLine()) != null) {
                /**
                 * Skip the first line of the csv file
                 */
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Cities cities = new Cities();

                String[] cityAttributes = line.split(this.splitby);
               
                /**
                 * Set name, country, longitude and latitude
                 */
                
                if(countryNames.contains(cityAttributes[7])){
                
                cities.setName(cityAttributes[1]);
                cities.setCountry(cityAttributes[7]);
                cities.setLongitude(cityAttributes[8]);
                cities.setLatitude(cityAttributes[9]);

                /* Add Cities into list */
                cityList.add(cities);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
  }
    


        
 
    
}
