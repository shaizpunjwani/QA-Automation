/// <reference types="Cypress" />

describe("Database Testing", function(){

    it("Getting data from customers table", function(){

        const filePath = "D:\\Cypress BDD\\CypressDB\\cypress\\integration\\examples\\db.js";

       cy.exec("node ${filePath}").then((result)=>{
        expect(result.code).to.equal(0); // Check if the command ran successfully (exit code 0).
        expect(result.stdout).to.contain("Connected to SSMS");
       });

    });
});