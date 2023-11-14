const { defineConfig } = require("cypress");
const excelToJson = require('convert-excel-to-json');
const fs = require('fs');

const {
  addCucumberPreprocessorPlugin,
} = require("@badeball/cypress-cucumber-preprocessor");
const {
  preprocessor,
} = require("@badeball/cypress-cucumber-preprocessor/browserify");

async function setupNodeEvents(on, config) {

  on('task', {

    ExceltoJsonConverter(filepath)
    {
        const result = excelToJson({
        source: fs.readFileSync(filepath) // fs.readFileSync return a Buffer
    });
        return result;
    }
  })

  // This is required for the preprocessor to be able to generate JSON reports after each run, and more,
  await addCucumberPreprocessorPlugin(on, config);

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
