import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.List;

public class ImporterIndependance {

    private String independanceAttributesPath;

    public ImporterIndependance(String pathIndependance, List<String> countryNames) {
      
        this.independanceAttributesPath = pathIndependance;
      
    }


    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("path/to/your/json/file.json")) {
            // Parse the JSON file
            Object obj = parser.parse(reader);

            // Convert the parsed JSON object to a JSON array
            JSONArray jsonArray = (JSONArray) obj;

            // Iterate over the JSON array
            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;

                // Access the JSON object's properties
                String name = (String) jsonObject.get("name");
                int age = ((Long) jsonObject.get("age")).intValue();

                // Print the values
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
