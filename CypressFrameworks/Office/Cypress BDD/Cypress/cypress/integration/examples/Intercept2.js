describe("Intercepting Test Suite", function(){

    it("Intercept Request API Response", function(){


        cy.intercept("GET", "https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=shetty",
        (req)=>{
            req.url="https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=malhotra"

            req.continue((res)=>{
                //expect(res.statusCode).to.equal(403);
            })
        }).as("dummyurl");
       
        cy.visit("https://rahulshettyacademy.com/angularAppdemo/");
        cy.get("button[routerlink='/library']").click();
        cy.wait("@dummyurl");
        
    });
});