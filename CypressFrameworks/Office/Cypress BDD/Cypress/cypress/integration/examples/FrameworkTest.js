/// <reference types="Cypress" />
import Checkout from "./PageObjects/Checkout";
import Homepage from "./PageObjects/Homepage";
import Productpage from "./PageObjects/Productpage";
import Purchase from "./PageObjects/Purchase";
let datad;

describe("Framework test suite", function(){

    before(() => {

        cy.fixture("example").then(function(data){
            this.data=data;
        })
        
    });

    // afterEach(function () {
    //     if (this.currentTest.state === "failed") {
    //       this.currentTest.title = "Test failed for following reason below: " + this.currentTest.title;
    //     }
    //   });

    it("insert data", function(){
        const homepage=new Homepage();
        const productpage=new Productpage();
        const checkout=new Checkout();
        const purchase=new Purchase();
        var sum=0;

        const url=Cypress.env('url');

        cy.visit(url);
        homepage.Get_name_edit_box().type(this.data.name);
        homepage.Get_Gender().select(this.data.gender);
        homepage.Get_two_way_binding().should("have.value", this.data.name);
        homepage.Get_name_edit_box().should("have.attr", "minlength", "2");

        homepage.Get_Enterpreneur_radio().should("be.disabled").debug();
        homepage.Get_Shop_Tab().click();

        this.data.products.forEach(function(element){
            cy.SelectProduct(element);
        });

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


        checkout.get_checkout_btn().click();
        Cypress.config("defaultCommandTimeout", 9000);
        purchase.get_country().type(this.data.country);
        
        purchase.get_option().click();
         purchase.get_checkbox_terms().click({force:true});
         purchase.get_purchase_btn().click();
        
        // purchase.get_validation().should("contain.text", "Your order will be delivered in next few weeks :-).");
        purchase.get_validation().then(function(data){
            const text=data.text();
            expect(text.includes("Thank you")).to.be.true;
        })

        
    });
});