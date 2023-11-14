/// <reference types="Cypress" />


describe("my first test suite", function(){
    it("My first test case", function(){
        cy.visit("https://rahulshettyacademy.com/seleniumPractise/#/");
        //we need to type ca in search and get the results such that there should be only 4 products listed
        cy.get(".search-keyword").type("ca");
        cy.wait(4000);
        //cy.get("div.products-wrapper div.product").should("have.length", 4);

        //aliasing
        cy.get(".products").find(".product").as("Locator");
        
        cy.get("@Locator").should("have.length", 4).then(function(){
            console.log("promise done");
        })
        //cy.get(".products").find(".product").eq(2).contains("ADD TO CART").click();
        //dynamic way to click on specific element
        cy.get("@Locator").each(($el, index, $list) => {
            
           const veg_text=$el.find(".product-name").text();
           if(veg_text.includes("Cashews"))
           {
            //whenever u got jquery object use cy.wrap as this waits for the promise of jquery object resolves
            cy.wrap($el).find("button").click();
           }
        })

        cy.get(".brand").as("BrandLocator");

        cy.get("@BrandLocator").then(function(logo){
            cy.log(logo.text());
            cy.get("@BrandLocator").should("have.text", "GREENKART");

        })
    })
})