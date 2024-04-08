import { Given, Then, When } from "@badeball/cypress-cucumber-preprocessor";
import HomePage from "../../PageObjects/HomePage";
import CartPage from "../../PageObjects/CartPage";
import CheckoutStep1Page from "../../PageObjects/CheckoutStep1Page";
import CheckoutStep2Page from "../../PageObjects/CheckoutStep2Page";
/// <reference types="Cypress" />

const homePage=new HomePage();
const cartPage=new CartPage();
const checkout=new CheckoutStep1Page();
const checkout2=new CheckoutStep2Page();

var counter=0;


When("Add all the products", function(){

    homePage.Add_Products("None");

})

When("Add the products which contains {string} in their name", function(prodname){

    homePage.Add_Products(prodname)

})

Then("Validate the added products", function(){
    

    homePage.Click_Shopping_Cart();
    cartPage.Validate_Added_Products();
})

When("Remove item from cart",function(){

    cartPage.Remove_Products_Cart();

})

When("Proceed to checkout", function(){

    cartPage.Proceed_Checkout();
})

When("Enter the form data", function(){

   checkout.Enter_Values_Form();

})

Then("Validate the added products along with their prices and end message {string}",function(msg){

    checkout2.Get_Each_Prices();

    checkout2.Get_Tax_Price();
    checkout2.Get_Total_Price();

    checkout2.Get_Final_msg(msg)
})