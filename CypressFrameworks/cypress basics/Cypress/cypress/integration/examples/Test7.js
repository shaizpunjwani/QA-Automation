/// <reference types="Cypress" />

describe("Handling Web Tables test suite", function(){
    it("Hanlding web tables test case", function(){
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/");

        cy.get(".mouse-hover-content").invoke("show");
        cy.contains("Top").click();
        cy.url().should("include", "top");

        cy.contains("Reload").click({ force: true });
    })

})