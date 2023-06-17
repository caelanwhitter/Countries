package utils;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ImporterIndependance {

    private String independanceAttributesPath;
    private List<Independance> independanceList = new ArrayList<Independance>();

    public ImporterIndependance(String pathIndependance) {
      
        this.independanceAttributesPath = pathIndependance;
      
    }


 public List<Independance> fetchDataFromDataset() throws IOException {
        Independance independance = new Independance();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(independanceAttributesPath)) {
            // Parse the JSON file
            Object obj = parser.parse(reader);

            // Convert the parsed JSON object to a JSON array
            JSONArray jsonArray = (JSONArray) obj;

            // Iterate over the JSON array
            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;

                // Access the JSON object's properties
                independance.setName((String) jsonObject.get("Country"));
                independance.setIndependanceDay((String) jsonObject.get("IndependenceDay"));
                independance.setYear((String) jsonObject.get("Year"));

                independanceList.add(independance);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return independanceList;
    }
}
