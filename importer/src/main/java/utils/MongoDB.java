package utils;

import java.io.IOException;
import java.util.List;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * MongoDB.java sets up initial connection to MongoDB database, creates Importer
 * and inserts movies into database
 * 
 * @author Caelan Whitter
 */
public class MongoDB {
        public static void main( String[] args ) throws IOException {

                Dotenv dotenv = Dotenv.load();
                final String ATLAS_URI = dotenv.get("ATLAS_URI");
                final String DATABASE_NAME = "citydb";
                final String COLLECTION_NAME = "cities";
        
                System.out.println("Importing data into: '" + DATABASE_NAME + "'...");
        
                ConnectionString connectionString = new ConnectionString(ATLAS_URI);
                CodecRegistry pojoCodecRegistry = CodecRegistries
                        .fromProviders(PojoCodecProvider.builder().automatic(true).build());
                CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        pojoCodecRegistry);
                MongoClientSettings clientSettings = MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .codecRegistry(codecRegistry).build();
                MongoClient client = MongoClients.create(clientSettings);
        
                MongoDatabase database = client.getDatabase(DATABASE_NAME);
                MongoCollection<Country> countries = database.getCollection(COLLECTION_NAME, Country.class);
        
                Importer importer = new Importer("importer/src/main/java/utils/resources/cities.csv","importer/src/main/java/utils/resources/states.csv",
                "importer/src/main/java/utils/resources/countries.csv","importer/src/main/java/utils/resources/world_population.csv");
                
               // ImporterCities importerCity = new ImporterCities("importer/src/main/java/utils/resources/cities.csv");
                //ImporterCountries importerCountry = new ImporterCountries("importer/src/main/java/utils/resources/countries.csv");
                //ImporterStates importerState = new ImporterStates("importer/src/main/java/utils/resources/states.csv");
                //ImporterPop importerPop = new ImporterPop("importer/src/main/java/utils/resources/world_population.csv");
                List<List<? extends Object>> countryList = importer.fetchDataFromDataset();
                
               
                // for (Object c : countryList) {
                //         System.out.println(c);
                // }
                
            
        
                System.out.println("Importing data into: '" + DATABASE_NAME + "' done!");
            }
        }

// country=2
// continent=4
// 22=5
// 20=6
// 15=7
// 10=8
// area=12
// populationpercentage=15
        
