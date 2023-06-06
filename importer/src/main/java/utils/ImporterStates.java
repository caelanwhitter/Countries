
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

    /**
     * Create private fields for every field of a City
     */
    private String line = " ";
    private String splitby = ",";

  
    private String stateAttributesPath;
    private List<States> stateList = new ArrayList<States>();
 
    
    private List<String> names;

    /**
     * set the paths to the csv file
     */
    public Importer(String pathCity, List<String> countries) {
        this.stateAttributesPath = pathState;
      this.names = countries;
       
    }

    public List<States> fetchDataFromDataset() throws IOException {

        System.out.println(this.stateAttributesPath);

        /**
         * a try-catch method to extract data from csv file
         */
   
        BufferedReader state = fileReader(stateAttributesPath);
        pickDataState(state);
      
        
        return  stateList;
    }
  
  public BufferedReader fileReader(String file) throws IOException {
    
          FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
      return reader;
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
                
                //System.out.println("hello");
               
                States states = new States();
                String[] stateAttributes = line.split(splitby);
                System.out.println(stateAttributes.length);

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

       
    
}
