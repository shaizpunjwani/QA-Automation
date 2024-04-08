import { Given, Then, When } from "@badeball/cypress-cucumber-preprocessor";
import HomePage from "../../PageObjects/HomePage";
/// <reference types="Cypress" />

const homePage=new HomePage();


When("Selecting the alphabetic filters {string}", function(Alphabetic){

    homePage.Select_Filters(Alphabetic);
})

Then("verify whether the products displayed are according to alphabetic order {string}",function(Flag){

    homePage.verifyOrder(Flag, "string");
    
})



When("Selecting the numeric filters {string}", function(Numeric){

    homePage.Select_Filters(Numeric);
})

Then("verify whether the products displayed are according numeric order {string}",function(Flag){

    homePage.verifyOrder(Flag, "numeric");

})
