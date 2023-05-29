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
    private String line = " ";
    private String splitby = ",";

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


        /**
         * a try-catch method to extract data from csv file
         */
        BufferedReader city = fileReader(cityAttributesPath);
        BufferedReader state = fileReader(stateAttributesPath);
        BufferedReader country = fileReader(countryAttributesPath);
        
        pickDataCity(city);
        pickDataState(state);
        pickDataCountry(country);
        
        return new ArrayList[] {cityList, stateList, countryList};
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
                // System.out.println(cityAttributes[1] + ", " + cityAttributes[7] + ", " + cityAttributes[8] + ", "
                //         + cityAttributes[9]);
                /**
                 * Set name, country, longitude and latitude
                 */
                cities.setName(cityAttributes[1]);
                cities.setCountry(cityAttributes[7]);
                cities.setLongitude(cityAttributes[8]);
                cities.setLatitude(cityAttributes[9]);

                /* Add Cities into list */
                cityList.add(cities);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
  }
    
    public void pickDataState(BufferedReader reader) throws IOException {
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
                States states = new States();

                String[] stateAttributes = line.split(splitby);
                // System.out.println(stateAttributes[1] + ", " + stateAttributes[4] + ", " + stateAttributes[6] + ", " + stateAttributes[7] + ", "
                //         + stateAttributes[8]);
                /**
                 * Set name, country name, type, longitude and latitude 
                 */
                states.setName(stateAttributes[1]);
                states.setCountry(stateAttributes[4]);
                states.setType(stateAttributes[6]);
                states.setLongitude(stateAttributes[7]);
                states.setLatitude(stateAttributes[8]);

                /* Add Cities into list */
                stateList.add(states);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
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
                // System.out.println(countryAttributes[1] + ", " + countryAttributes[6] + ", " + countryAttributes[7] + ", " + countryAttributes[8] +
                // ", " + countryAttributes[9] + ", " + countryAttributes[12] + ", " + countryAttributes[15] + ", " + countryAttributes[16]);
                /**
                 * Set name, capital,currency, currency name, currency symbol, region, longitude and latitude
                 */
                countries.setName(countryAttributes[1]);
                countries.setCapital(countryAttributes[6]);
                countries.setCurrency(countryAttributes[7]);
                countries.setCurrencyName(countryAttributes[8]);
                countries.setCurrencySymbol(countryAttributes[9]);
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
