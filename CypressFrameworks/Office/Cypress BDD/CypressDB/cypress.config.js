const { defineConfig } = require("cypress");
const sqlServer = require('cypress-sql-server');


const {
  addCucumberPreprocessorPlugin,
} = require("@badeball/cypress-cucumber-preprocessor");
const {
  preprocessor,
} = require("@badeball/cypress-cucumber-preprocessor/browserify");

async function setupNodeEvents(on, config) {

//     config.db = {
//      user: "DESKTOP-BFV",
//     // password: "",
//     domain: "DESKTOP-BFVPL0E",
//     server: "localhost",
//     options: {
//         database: "Northwind",
//         encrypt: true,
//         trustServerCertificate: "false",
//         rowCollectionOnRequestCompletion : true
//     }
// }
  // This is required for the preprocessor to be able to generate JSON reports after each run, and more,
  await addCucumberPreprocessorPlugin(on, config);

  // tasks = sqlServer.loadDBPlugin(config.db);
  // on('task', tasks);

  on("file:preprocessor", preprocessor(config));

  // Make sure to return the config object as it might have been modified by the plugin.
  return config;
}


module.exports = defineConfig({
  // reporter: 'mochawesome',
  // reporterOptions: {
  //   charts: true,
  //   reportPageTitle: 'SwagLabs',
  //   embeddedScreenshots: true,
  //   inlineAssets: true,
  //   saveAllAttempts: false,

  //   code: (test) => {
  //     if (test.state === "failed") {
  //       return " ";
  //     }
  //   }
  // },
  // "screenshotsFolder":"cypress/screenshots",
 defaultCommandTimeout: 8000,
 screenshotOnRunFailure: true,
  // retries: {
  //   runMode: 1,
  //   },

  // projectId: "zg8sb1",
  env: {
    url: "https://rahulshettyacademy.com/angularpractice/",
    userid: "Shaiz",
    pwd: "12345"
  },

  
  
  e2e: {
    setupNodeEvents,
    //specPattern: 'cypress/integration/examples/BDD/*.feature',
    specPattern: 'cypress/integration/examples/*.js',
    // modifyObstructiveCode: false,
    chromeWebSecurity: false
    },
});
