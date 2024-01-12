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

var counter=0;

Cypress.Commands.add("TextComparator", (selector,actual_string)=>{
    selector.then(function(element){
        const logo=element.text();
        expect(logo).to.equal(actual_string);
    })
})

Cypress.Commands.add("AddProductsCart", (homePageInventory, prodname, homePageCart) => {
    counter=0;
    if (prodname === "None") {
        cy.get(homePageInventory).each(($el, index) => {
            cy.get(homePageCart).eq(index).click();
            counter = counter + 1;
        });
    } else {
        // counter = 0;
        // cy.get(homePageInventory).each(($el, index) => {
        //     const text = $el.text();
        //     if (text.includes(prodname)) {
        //         cy.get(homePageCart).eq(index).should('be.visible').click(); // Adjust the wait time as needed
        //         counter = counter + 1;

        cy.get(homePageInventory).each(($el, index, $list) => {

        const text=$el.text();
        if(text.includes(prodname)){
            cy.get(homePageCart).eq(index).click();
            counter=counter+1;
            }
        });
    }
});



Cypress.Commands.add("GetCounterVar",()=>{
    return counter;
})

Cypress.Commands.add("SetCounterVal",(val)=>{
    counter=val;
})

Cypress.Commands.add("ChangeCounterVal", (val)=>{
    counter=counter+val;
})

Cypress.Commands.add("ClickBtn",(locator)=>{
    locator.click();
})

Cypress.Commands.add("EnterValues", (locator, value)=>{
    locator.type(value);
})

Cypress.Commands.add("TextExtractor", (text, spliter)=>{
    const new_price=text.split(spliter)[1].trim();
    return new_price;
})