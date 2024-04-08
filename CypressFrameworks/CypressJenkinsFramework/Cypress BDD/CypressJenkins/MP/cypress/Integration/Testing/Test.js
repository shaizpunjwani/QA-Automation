/// <reference types="Cypress" />

import HomePage from "../PageObjects/HomePage";
import LoginPage from "../PageObjects/LoginPage";
import 'cypress-file-upload';
import PartsPage from "../PageObjects/PartsPage";


describe("MP Framework test suite", function(){


    let datad;
    const loginpg=new LoginPage();
    const homepg=new HomePage();
    const partpg=new PartsPage();

    beforeEach(() => {

        cy.intercept({ resourceType: /xhr|fetch/ }, { log: false })

        cy.fixture("example").then(function(data){
            
            datad=data;
        })
           
        cy.visit(Cypress.env('url'));

        loginpg.Enter_Values(Cypress.env('userid'),Cypress.env('pwd'));
        homepg.Validate_Homepage();
        homepg.Navigate_Parts();
    });

    it("Navigate to Parts and Add parts", function(){
        partpg.Navigate_Upload();

        partpg.Upload_File('Upload Part Template.xlsx');
        partpg.Click_Save();
    })

    it("Verify the Added Parts and then Delete", function(){
        partpg.Search_Part();
        partpg.Delete_Part();
    })

})