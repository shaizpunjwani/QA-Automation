const { defineConfig } = require("cypress");
const excelToJson = require('convert-excel-to-json');
const fs = require('fs');

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

  // Make sure to return the config object as it might have been modified by the plugin.
  return config;
}

module.exports = defineConfig({


  env: {
    url: "https://dev-vodafone-marketplace.shields-e.com/Account/Login",
    userid: "saad.abbasi@shields-e.com",
    pwd: "LegendUser2020"
  },

  e2e: {

    setupNodeEvents,
    specPattern: 'cypress/Integration/Testing/*.js',
    chromeWebSecurity: false,
    viewportWidth:1200,
  },
  defaultCommandTimeout: 10000
});
