package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Importer.java reads through every line of dataset and creates a State object
 * @author Caelan Whitter
 */
public class ImporterStates {
    /**
     * Create private fields for every field of a movie
     */
    private String cityAttributesPath;
    private List<States> stateList = new ArrayList<States>();

    /**
     * set the path to the csv file
     */
    public ImporterStates(String path) {
        this.cityAttributesPath = path;
    }

    public List<Cities> fetchDataFromDataset() throws IOException {

        String line = " ";
        String splitby = ",";

        /**
         * a try-catch method to extract data from csv file
         */

        FileInputStream fis = new FileInputStream(cityAttributesPath);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
    

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
                // System.out.println(stateAttributes + ", " + stateAttributes + ", " + stateAttributes + ", " + stateAttributes + ", "
                //         + stateAttributes);
                /**
                 * Set name, country name, longitude and latitude 
                 */
                states.setName(stateAttributes[1]);
                states.setCountry(stateAttributes[]);
                states.setType(stateAttributes[]);
                states.setLongitude(stateAttributes[]);
                states.setLatitude(stateAttributes[]);

                /* Add Cities into list */
                stateList.add(states);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        /**
         * Return the List of States
         */
        return stateList;
    }
}
