/// <reference types="Cypress" />


describe("my second test suite", function(){
    it("My second test case", function(){
        cy.visit("https://rahulshettyacademy.com/seleniumPractise/#/");
        //we need to type ca in search and get the results such that there should be only 4 products listed
        cy.get(".search-keyword").type("ca");
        cy.wait(2000);

        //aliasing
        cy.get(".products").find(".product").as("Locator");
        
        cy.get("@Locator").each(($el, index, $list) => {
            
           const veg_text=$el.find(".product-name").text();
           if(veg_text.includes("Cashews"))
           {
            //whenever u got jquery object use cy.wrap as this waits for the promise of jquery object resolves
            cy.wrap($el).find("button").click();
           }
        })

        cy.get('.cart-icon > img').click();

        cy.contains("PROCEED TO CHECKOUT").click();
        cy.get(':nth-child(14)').click();
    })
})