/// <reference types="Cypress" />

let username="standard_user";
let pwd="secret_sauce";
let product="Sauce";
let fname="john";
let lname="cena";
let zip="12345";

describe("Saucedemo test suite", function(){

    beforeEach(() => {
        cy.visit("https://www.saucedemo.com/");
        cy.get("#user-name").type(username);
        cy.get("#password").type(pwd);
        cy.get("#login-button").click();
        cy.contains("Swag Labs").should("have.text", "Swag Labs");
    });

    it("Grabbing the Item which contain T-Shirt and asserting the added items when checkout", function(){
        let count=0;
        cy.get(".inventory_list").find(".inventory_item").each(($el, index, $list) => {

            const prod_name=$el.find(".inventory_item_name").text();
            if(prod_name.includes(product))
            {
                cy.wrap($el).find(".btn_primary").click().then(function(){
                    count=count+1;
                })
            }
        })

        cy.get('.shopping_cart_link').click();
        cy.get('[data-test="checkout"]').click();

        cy.get("#first-name").type(fname);
        cy.get("#last-name").type(lname);
        cy.get("#postal-code").type(zip);
        cy.get("#continue").click();

        cy.get(".cart_item").should(($items) => {
            expect($items).to.have.length(count);
        })

        cy.get('[data-test="finish"]').click();
        cy.get('.complete-header').should("contain.text", "Thank you");
    })
})