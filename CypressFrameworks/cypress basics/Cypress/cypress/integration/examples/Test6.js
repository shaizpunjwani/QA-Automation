/// <reference types="Cypress" />

describe("Handling Web Tables test suite", function(){
    it("Hanlding web tables test case", function(){
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/");

        cy.get(".table-display tr td:nth-child(2)").as("webtable");

        cy.get("@webtable").each(($el, index, $list) => {
            const course=$el.text();

            if(course.includes("Master Selenium Automation"))
            {
                cy.get("@webtable").eq(index).next().then(function(price)
                {
                    const course_price=price.text();
                    expect(course_price).to.equal("25");
                })
            }
         })
 

    })
})