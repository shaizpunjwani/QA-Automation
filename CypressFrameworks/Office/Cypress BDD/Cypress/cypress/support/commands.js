// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//

Cypress.Commands.add("SelectProduct", (prodname)=>{
    cy.get("h4[class='card-title']").each(($el, index, $list) => {
            
        const phone_text=$el.find("a[href='#']").text();
        if(phone_text.includes(prodname))
        {
            cy.get("button.btn-info").eq(index).click();             
        }
     })
})

Cypress.Commands.add("LoginAPI", ()=>{

    cy.request("POST", "https://rahulshettyacademy.com/api/ecom/auth/login", {"userEmail": "shaiz.akber@gmail.com", "userPassword": "Vivov11pro"}).
    then(function(response){
        expect(response.status).to.equal(200);
        Cypress.env("token", response.body.token);
    })
})
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })