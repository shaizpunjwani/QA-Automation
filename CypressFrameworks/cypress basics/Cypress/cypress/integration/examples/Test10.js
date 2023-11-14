/// <reference types="Cypress" />

let fname="User";
let lname="secret";
let postcode="12345";
let code="";

describe("XYZ Bank test suite", function(){

    beforeEach(() => {
        cy.visit("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        cy.get("strong[class='mainHeading']").should("have.text", "XYZ Bank");
    });

    it("Login as bank manager and Add customer", function(){
        cy.contains("Bank Manager Login").click();
        cy.contains("Add Customer").click();
        cy.get("input[ng-model='fName']").type(fname);
        cy.get("input[ng-model='lName']").type(lname);
        cy.get("input[ng-model='postCd']").type(postcode);
        cy.get("button[type='submit']").click();
        cy.contains("Customers").click();
        
        cy.get("tr.ng-scope:last-of-type td").each(($el, index, $list) => {
            if(index==0)
            {
                const ftext= $el.text();
                expect(ftext).to.equal(fname);
            }
            else if(index==1)
            {
                const ltext= $el.text();
                expect(ltext).to.equal(lname);
            }
            else if (index==2)
            {
                code=$el.text();
            }
        });
    });

    

    it("Login as bank manager and Add account", function(){
        cy.contains("Bank Manager Login").click();

        cy.contains("Open Account").click();
    });
		

});