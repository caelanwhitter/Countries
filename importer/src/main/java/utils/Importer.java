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
public class Importer {
    
    
    //https://www.worldometers.info/geography/flags-of-the-world/
//https://flagpedia.net/download/api
    
    
    
    /**
     * Create private fields for every field of a City
     */
    private String line = " ";
    private String splitby = ",";

    private String cityAttributesPath;
    private String stateAttributesPath;
    private String countryAttributesPath;
    private String populationAttributesPath;

    private List<Cities> cityList = new ArrayList<Cities>();
    private List<States> stateList = new ArrayList<States>();
    private List<Country> countryList = new ArrayList<Country>();
    private List<Population> populationList = new ArrayList<Population>();
    
    private List<String> names = new ArrayList<String>();

    /**
     * set the paths to the csv file
     */
    public Importer(String pathCity, String pathState, String pathCountry, String pathPopulation) {
        this.cityAttributesPath = pathCity;
        this.stateAttributesPath = pathState;
        this.countryAttributesPath = pathCountry;
        this.populationAttributesPath = pathPopulation;
    }

    public List<List<? extends Object>> fetchDataFromDataset() throws IOException {


        /**
         * a try-catch method to extract data from csv file
         */
        BufferedReader country = fileReader(countryAttributesPath);
        BufferedReader city = fileReader(cityAttributesPath);
        BufferedReader state = fileReader(stateAttributesPath);
        BufferedReader population = fileReader(populationAttributesPath);
        
        // pickDataCountry(country);
        //pickDataCity(city);
        pickDataState(state);
        //pickDataPopulation(population);
        
        return  Arrays.asList(cityList, stateList, countryList);
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
                
                if(names.contains(cityAttributes[7])){
                
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
    
  public void pickDataState(BufferedReader reader) throws IOException {
      int count = 0;
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
                if(names.contains(stateAttributes[4])){
                    if (stateAttributes.length <= 6) {

                        states.setName(stateAttributes[1]);
                        states.setCountry(stateAttributes[4]);

                    }
                    else if (stateAttributes.length == 7) {
                        states.setName(stateAttributes[1]);
                        states.setCountry(stateAttributes[4]);
                        states.setType(stateAttributes[6]);

                    }
                    else{

             
                    states.setName(stateAttributes[1]);
                    states.setCountry(stateAttributes[4]);
                    states.setType(stateAttributes[6]);
                    states.setLongitude(stateAttributes[7]);
                    states.setLatitude(stateAttributes[8]);
                    }
                     /* Add Cities into list */
                stateList.add(states);
                }
                

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
        
         public void pickDataPopulation(BufferedReader reader) throws IOException {
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
                Population population = new Population();

                String[] populationAttributes = line.split(splitby);
               
                  
     
                population.setName(countryAttributes[1]);
                population.setCapital(countryAttributes[6]);
                population.setCurrency(countryAttributes[7]);
                population.setCurrencyName(countryAttributes[8]);
                population.setCurrencySymbol(countryAttributes[9]);

                /* Add Populations into list */
                populationList.add(population);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

  }
    
}
