const { defineConfig } = require("cypress");

module.exports = defineConfig({
  reporter: 'mochawesome',
  reporterOptions: {
    charts: true,
    reportPageTitle: 'SwagLabs',
    embeddedScreenshots: true,
    inlineAssets: true,
    saveAllAttempts: false,

    code: (test) => {
      if (test.state === "failed") {
        return " ";
      }
    }
  },
  "screenshotsFolder":"cypress/screenshots",
  defaultCommandTimeout: 8000,
  retries: {
    runMode: 1,
    },

  projectId: "zg8sb1",
  env: {
    url: "https://rahulshettyacademy.com/angularpractice/",
    userid: "Shaiz",
    pwd: "12345"
  },
  
  e2e: {
    setupNodeEvents(on, config) {
      // require('cypress-mochawesome-reporter/plugin')(on);
    },
    specPattern: 'cypress/integration/examples/*.js',
    modifyObstructiveCode: false,
    chromeWebSecurity: false
    },
});
