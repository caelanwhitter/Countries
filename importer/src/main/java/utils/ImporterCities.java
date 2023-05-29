package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Importer.java reads through every line of dataset, cleans each line and creates a Movie object
 * @author Caelan Whitter & Daniel Lam 
 */
public class ImporterCities {
    /**
     * Create private fields for every field of a movie
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
        //BufferedReader reader = new BufferedReader(new FileReader(movieAttributesPath));

        try {
            boolean firstLine = true;
            // File file = new File("D:\\sample.txt");
            //         // Instantiating the PrintStream class
            //         PrintStream stream = new PrintStream(file);
            //         System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
            //         System.setOut(stream);
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
                 * Set title, rating, genre and releaseYear since they never change even if a
                 * line is missing information
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
         * Return the List of movies
         */
        return cityList;
    }
}
