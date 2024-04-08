const { defineConfig } = require("cypress");
const excelToJson = require('convert-excel-to-json');
const fs = require('fs');


async function setupNodeEvents(on, config) {


  on('task', {

    ExceltoJsonConverter(filepath)
    {
        const result = excelToJson({
        source: fs.readFileSync(filepath)
    });
        return result;
    }
  })
  return config;
}


module.exports = defineConfig({
  e2e: {
    specPattern: 'cypress/integration/Testing/*.js',
    setupNodeEvents
  },
});
