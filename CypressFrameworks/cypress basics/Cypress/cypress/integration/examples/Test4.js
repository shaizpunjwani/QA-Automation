/// <reference types="Cypress" />

describe("my first test suite", function(){
    it("My first test case", function(){
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/");
        cy.get("#alertbtn").click();
        cy.get("input[value='Confirm']").click();

        cy.on("window:alert", (str)=>
        {
            expect(str).to.equal("Hello , share this practice page and share your knowledge");
            //could not use should with cy.on as cy.on works on events and should works on dom elements which we get using cy.get so use expect in it

            //cy.on("window:alert").should("have.text", "Hello , share this practice page and share your knowledge");
        })

        cy.on("window:confirm", (str)=>
        {
            expect(str).to.equal("Hello , Are you sure you want to confirm?");
        })
    })

})