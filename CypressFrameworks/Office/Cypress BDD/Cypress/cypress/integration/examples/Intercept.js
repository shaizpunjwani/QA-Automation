describe("Intercepting Test Suite", function(){

    it("Intercept API Response", function(){

        cy.intercept({
            method: 'GET',
            url: 'https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=shetty'
        },
        {
            statusCode: 200,
            body: [{"book_name":"RestAssured with Java","isbn":"BSG","aisle":"2302"}]
        }).as("bookresponse");

        cy.visit("https://rahulshettyacademy.com/angularAppdemo/");
        cy.get("button[routerlink='/library']").click();
        
        //integration test
        cy.wait('@bookresponse').then(({request, response})=>{
            cy.get("tbody tr").should("have.length", response.body.length);
        })
        cy.get('p').should("contain.text", "1 Book available");

        
    });
});