import { Given, Then, When } from "@badeball/cypress-cucumber-preprocessor";
/// <reference types="Cypress" />
import Checkout from "../../PageObjects/Checkout";
import Homepage from "../../PageObjects/Homepage";
import Productpage from "../../PageObjects/Productpage";
import Purchase from "../../PageObjects/Purchase";

const homepage=new Homepage();
const productpage=new Productpage();
const checkout=new Checkout();
const purchase=new Purchase();
var sum=0;
var name_datatable;


Given("Navigate to Ecommerce page", function(){
    const url=Cypress.env('url');
    cy.visit(url);
});

When("Add the items to the cart", function(){

    homepage.Get_Shop_Tab().click();
    this.data.products.forEach(function(element){
        cy.SelectProduct(element);
    });
});

When("Validate the total prices of the products added", function(){
    
    productpage.Get_Checkout_Tab().click();

    checkout.get_price_each().each(($el, index, $list) => {
        const price=$el.text();
        const new_price=price.split(" ")[1].trim();
        sum=sum+Number(new_price);
    });

    checkout.get_total_price().then(function(element){
        const price=element.text();
        const new_price=price.split(" ")[1].trim();
        expect(sum).to.equal(Number(new_price));
    })
});

Then('Select the country submit and verify {string}', function(msg){
    checkout.get_checkout_btn().click();
        Cypress.config("defaultCommandTimeout", 9000);
        purchase.get_country().type(this.data.country);
        
    purchase.get_option().click();
        purchase.get_checkbox_terms().click({force:true});
        purchase.get_purchase_btn().click();
    
    // purchase.get_validation().should("contain.text", "Your order will be delivered in next few weeks :-).");
    purchase.get_validation().then(function(data){
        const text=data.text();
        expect(text.includes(msg)).to.be.true;
    })
});


When("Fill the form details", function(dataTable){
    homepage.Get_name_edit_box().type(dataTable.rawTable[1][0]);
    homepage.Get_Gender().select(dataTable.rawTable[1][1]);
    name_datatable=dataTable.rawTable[1][0];
});

Then("Validate the added details", function(){
    homepage.Get_two_way_binding().should("have.value", name_datatable);
    homepage.Get_name_edit_box().should("have.attr", "minlength", "2");
    homepage.Get_Enterpreneur_radio().should("be.disabled").debug();
});



