
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
 * ImporterPopulation.java reads through every line of dataset
 * @author Caelan Whitter
 */
public class ImporterPopulation {
    
    private String line = " ";
    private String splitby = ",";


    private String populationAttributesPath;

    private List<Population> populationList = new ArrayList<Population>();
    
    private List<String> countryNames;


    /**
     * set the paths to the csv file
     */
    public ImporterPopulation(String pathPopulation, List<String> countries) {

        this.populationAttributesPath = pathPopulation;
      this.countryNames = countries;
    }

    public List<Population> fetchDataFromDataset() throws IOException {

        System.out.println(this.stateAttributesPath);

        /**
         * a try-catch method to extract data from csv file
**/
        BufferedReader population = fileReader(populationAttributesPath);
        
        pickDataPopulation(population);
        
        return  populationList;
    }
  
  public BufferedReader fileReader(String file) throws IOException {
    
          FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
      return reader;
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
               
                  
                if(countryNames.contains(populationAttributes[2])){
                population.setCountry(populationAttributes[2]);
                population.setContinent(populationAttributes[4]);
                population.setArea(populationAttributes[13]);
                population.setPopulationPercent(populationAttributes[16]);
                population.setPopulation22(populationAttributes[5]);
                population.setPopulation20(populationAttributes[6]);
                population.setPopulation15(populationAttributes[7]);
                population.setPopulation10(populationAttributes[8]);

                /* Add Populations into list */
                populationList.add(population);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

  }
    
}
