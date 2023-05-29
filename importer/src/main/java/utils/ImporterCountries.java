package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * ImporterCities.java reads through every line of dataset and creates a Country object
 * @author Caelan Whitter
 */
public class ImporterCountries {
    /**
     * Create private fields for every field of a country
     */
    private String cityAttributesPath;
    private List<Country> countryList = new ArrayList<Country>();

    /**
     * set the path to the csv file
     */
    public Importer(String path) {
        this.countryAttributesPath = path;
    }

    public List<Country> fetchDataFromDataset() throws IOException {

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

        /**
         * Return the List of countries
         */
        return countryList;
    }
}
