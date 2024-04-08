import { defineStep } from '@badeball/cypress-cucumber-preprocessor'
import LoginPage from "../../Integration/PageObjects/LoginPage"
import HomePage from "../../Integration/PageObjects/HomePage";
/// <reference types="Cypress" />

const url=Cypress.env('url');
const loginPage=new LoginPage();
const homePage=new HomePage();

defineStep("Navigate to SwagLabs website", function(){
    cy.visit(url);
});

defineStep("Fill the Login credentials {string} and {string}", function(username, password){

    loginPage.Enter_Credentials(username, password);
})

defineStep("Validate the landed page", function(){
    homePage.Validate_Landed_Page("Swag Labs");
})