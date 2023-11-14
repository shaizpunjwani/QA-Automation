const neatCSV=require("neat-csv");
let original_productname
describe("JWT Session Test Suite", function(){

    it("Extracting token from LoginAPI Command & CSV Integration", function(){

        cy.LoginAPI().then(function(){

            cy.visit("https://rahulshettyacademy.com/client/", {
                onBeforeLoad : function(window)
                {
                    window.localStorage.setItem("token", Cypress.env("token"))
                }
            })
        })

        cy.get(".card-body b").eq(1).then(function(data){
            original_productname=data.text();
        })

        cy.get(".card-body button[class='btn w-10 rounded']").eq(1).click();
        cy.get("button[routerlink='/dashboard/cart']").click();
        cy.contains("Checkout").click();
        cy.get("input[placeholder='Select Country']").type("pak");

        cy.get(".ta-results button").each(($el, index, $list) => {

            if($el.text().includes("Pakistan")){
                cy.wrap($el).click();
            }
        });

        cy.get(".action__submit").click();
        cy.wait(2000);
        cy.get(".order-summary button").eq(0).click();

        cy.readFile(Cypress.config("fileServerFolder")+"\\cypress\\downloads\\order-invoice_shaiz.akber.csv").then(async function(text){
            const csv=await neatCSV(text);
            const product_name_csv= csv[0]["Product Name"];
            
            expect(product_name_csv).to.equal(original_productname);
        })
        
    });
});