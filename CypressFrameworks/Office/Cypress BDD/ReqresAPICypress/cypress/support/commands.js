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

Cypress.Commands.add("TextGenerate", () => {
    const length = 3;
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let randomString = '';
    for (let i = 0; i < length; i++) {
      const randomIndex = Math.floor(Math.random() * characters.length);
      randomString += characters.charAt(randomIndex);
    }
    return randomString;
  });

  Cypress.Commands.add("NumberGenerate", () => {
    const min = Math.pow(10, 3 - 1);
    const max = Math.pow(10, 3) - 1;
    const generatedNumber = Math.floor(Math.random() * (max - min + 1)) + min;
    
    const generatedString = generatedNumber.toString();

    return generatedString;
});

let bookid;

Cypress.Commands.add("SetValue", (value)=>{
  bookid=value;
})

Cypress.Commands.add("GetValue", ()=>{
  console.log(bookid);
  return bookid;
})