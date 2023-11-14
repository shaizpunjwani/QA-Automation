/// <reference types="Cypress" />


describe("my second test suite", function(){
    it("My second test case", function(){
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/");

        //checkboxes
        cy.get("#checkBoxOption1").check().should("be.checked").and("have.value", "option1");
        cy.get("#checkBoxOption1").uncheck().should("not.be.checked");
        cy.get("input[type='checkbox']").check(["option2", "option3"]);

        //handling static dropdowns
        cy.get("select").select("option2").should("have.value", "option2");

        //handling dynamic dropdowns
        //.ui-menu-item div
        cy.get("#autocomplete").type("ind");
        cy.wait(1000);
        cy.get(".ui-menu-item div").each(($el, index, $list) => {
            if($el.text()=="India")
            {
                cy.wrap($el).click().should("have.text","India");
            }
        })

        //checking for visibility and invisibility of text box
        cy.get("#displayed-text").should("be.visible");
        cy.get("#hide-textbox").click();
        cy.get("#displayed-text").should("not.be.visible");
        cy.get("#show-textbox").click();
        cy.get("#displayed-text").should("be.visible");

        //radion buttons
        cy.get(".radioButton").check(["radio1"]).should("be.checked");
        
    })
})