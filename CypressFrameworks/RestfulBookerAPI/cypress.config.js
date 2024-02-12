const { defineConfig } = require("cypress");

//let myUniqueId;

//Cypress_record_key=1c5c9e30-56e4-4416-bcd8-d7dec36d3db9

let myUniqueIds = [];
let storedJsonObjects = [];

module.exports = defineConfig({
  projectId: "o78qiy",
  e2e: {
    chromeWebSecurity: false,
    specPattern: 'cypress/integration/APITest/CRUD/*.js',
    setupNodeEvents(on, config) {
      // Custom tasks
      on('task', {
        setMyUniqueId: (ids) => {
          myUniqueIds = ids;
          return null;
        },
        getMyUniqueId: () => {
          return myUniqueIds;
        },

        storeJsonObject: (jsonObjects) => {
          storedJsonObjects = jsonObjects;
          return storedJsonObjects;
        },
        getStoredJsonObject: () => {
          return storedJsonObjects;
        },
      });
    },
  },
});
