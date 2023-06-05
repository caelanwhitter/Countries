/**
 * Start server and listen on port 3001 or PORT environment variable
 * @author Caelan Whitter
 */
const dotenv = require("dotenv");
dotenv.config();
const session = require("express-session");
const app = require("./app");

// Server listening to port 3001
app.listen(process.env.PORT || 3001, () => {
  console.log(`Server listening on port ${process.env.PORT || 3001}...`);
}) 
