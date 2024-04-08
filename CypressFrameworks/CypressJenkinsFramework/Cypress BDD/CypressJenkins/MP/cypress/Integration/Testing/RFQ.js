/// <reference types="Cypress" />

import HomePage from "../PageObjects/HomePage";
import LoginPage from "../PageObjects/LoginPage";
import 'cypress-file-upload';
import PartsPage from "../PageObjects/PartsPage";


describe("MP Framework test suite", function(){


    let datad;
    const loginpg=new LoginPage();
    const homepg=new HomePage();
    

    beforeEach(() => {

        cy.intercept({ resourceType: /xhr|fetch/ }, { log: false })

        cy.fixture("example").then(function(data){
            
            datad=data;
        })
           
        cy.visit(Cypress.env('url'));

        loginpg.Enter_Values(Cypress.env('userid'),Cypress.env('pwd'));
        homepg.Validate_Homepage();
    });

    it("Add parts and raise rfq", function(){
        homepg.Enter_PartNo("RDH 102 47/2");
        homepg.Click_Suggested_part();
        homepg.Enter_Qty(2);
    })


})