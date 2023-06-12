/**
 * Mongoose.js sets up the Mongoose ORM so it can connect the MongoDB database with routes
 * @author Caelan Whitter
 */
const mongoose = require("mongoose");
const { Schema } = mongoose;
require("dotenv").config();

// Connect Mongoose to MongoDB Contries (do "node server/database/mongoose.js" at root dir)

mongoose.connect(process.env.ATLAS_URI, { useNewUrlParser: true });

//Get the default connection
let db = mongoose.connection;
console.log("Connected to database!\n");

//Bind connection to error event (to get notification of connection errors)
db.on("error", console.error.bind(console, "MongoDB connection error:"));

// Country Schema
const countrySchema = new Schema({
  name : String,
  capital : String,
  currency : String,
  currencyName : String,
  currencySymbol : String,
  countryCode : String,
  region : String,
  latitude : String,
  longitude : String
 
}, { collection: "country" });

const Country = mongoose.model("Country", countrySchema)



// Population Schema
const populationSchema = new Schema({
  country : String,
  continent : String,
  area : String,
  populationPercent : String,
  population22 : String,
  population20 : String,
  population15 : String,
  population10 : String
}, { collection: "population" });

const Population = mongoose.model("Population", populationSchema)



// States Schema
const statesSchema = new Schema({
  name: String,
  country : String,
  type : String,
  latitude : String,
  longitude : String
}, { collection: "states" });

const States = mongoose.model("States", statesSchema)



// Cities schema
const citiesSchema = new Schema({
  name : String,
  country : String,
  latitude : String,
  longitude: String
}, { collection: "cities" });

const Cities = mongoose.model("Cities", citiesSchema)

module.exports = { Country, Population, States, Cities };
