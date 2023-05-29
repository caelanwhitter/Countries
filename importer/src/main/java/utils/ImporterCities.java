package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * ImporterCities.java reads through every line of dataset and creates a City object
 * @author Caelan Whitter
 */
public class ImporterCities {
    /**
     * Create private fields for every field of a City
     */
    private String cityAttributesPath;
    private List<Cities> cityList = new ArrayList<Cities>();

    /**
     * set the path to the csv file
     */
    public Importer(String path) {
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
                Cities cities = new Cities();

                String[] cityAttributes = line.split(splitby);
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

        /**
         * Return the List of Cities
         */
        return cityList;
    }
}
