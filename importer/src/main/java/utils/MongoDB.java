package utils;

import java.io.IOException;
import java.util.ArrayList;
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
 * and inserts countries into database
 * 
 * @author Caelan Whitter
 */


    //https://www.worldometers.info/geography/flags-of-the-world/
//https://flagpedia.net/download/api

public class MongoDB {
        public static void main( String[] args ) throws IOException {

                Dotenv dotenv = Dotenv.load();
                final String ATLAS_URI = dotenv.get("ATLAS_URI");
                final String DATABASE_NAME = "countrydb";
                final String COLLECTION_NAME = "countries";
        
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
                MongoCollection<States> states = database.getCollection(COLLECTION_NAME, States.class);
                MongoCollection<Cities> cities = database.getCollection(COLLECTION_NAME, Cities.class);
                MongoCollection<Population> population = database.getCollection(COLLECTION_NAME, Population.class);

        
                ImporterCountries importerCountry = new ImporterCountries("importer/src/main/java/utils/resources/countries.csv");
                List<Country> countryList = importerCountry.fetchDataFromDataset();

                List<String> countryNames = new ArrayList<String>();
                for(int i =0; i< countryList.size(); i++)
                {
                        countryNames.add(countryList.get(i).getName());
                }
            
            
                ImporterPopulation importerPopulation = new ImporterPopulation("importer/src/main/java/utils/resources/world_population.csv",countryNames);
                List<Population> populationList = importerPopulation.fetchDataFromDataset();

                ImporterStates importerStates = new ImporterStates("importer/src/main/java/utils/resources/states.csv",countryNames);
                List<States> statesList = importerStates.fetchDataFromDataset();

                ImporterCities importerCities = new ImporterCities("importer/src/main/java/utils/resources/cities.csv",countryNames);
                List<Cities> citiesList = importerCities.fetchDataFromDataset();
            
            
                countries.insertMany(countryList);
                states.insertMany(statesList);
                population.insertMany(populationList);
                cities.insertMany(citiesList);

                
            
        
                System.out.println("Importing data into: '" + DATABASE_NAME + "' done!");
            }
        }

