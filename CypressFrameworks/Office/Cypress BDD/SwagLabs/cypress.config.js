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

  reporter: 'mochawesome',
  reporterOptions: {
    charts: true,
    reportPageTitle: 'SwagLabs',
    embeddedScreenshots: true,
    inlineAssets: true,
    saveAllAttempts: true,

    code: (test) => {
      if (test.state === "failed") {
        return " ";
      }
    }
  },
  "screenshotsFolder":"cypress/screenshots",

  env: {
    url: "https://www.saucedemo.com/",
    
  },

  e2e: {
    setupNodeEvents,
    specPattern: 'cypress/Integration/BDD/*.feature',
    // specPattern: 'cypress/support/Excel/*.js',
    chromeWebSecurity: false
  },

  defaultCommandTimeout: 8000,
  screenshotOnRunFailure: true
});
