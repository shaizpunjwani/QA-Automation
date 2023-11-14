/// <reference types="Cypress" />

describe("Handling child test suite", function(){
    it("Hanlding child tabs test case", function(){
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/");

        cy.get("#opentab").invoke("removeAttr", "target").click();

        cy.origin("https://www.qaclickacademy.com/", ()=>
        {
            cy.get("div#navbarSupportedContent a[href='about.html']").click();
           // cy.get("div.mt-50 h2").should("have.text", "Welcome to QAClick Academy ");
           
           //matching specific string so we used contain
            cy.get("div.mt-50 h2").should("contain", "QAClick Academy ");

        })
    })

})