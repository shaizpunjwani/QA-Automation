/// <reference types="Cypress" />
import { authenticateAndGetToken, getAuthToken } from "../Authorize/GenerateAuth";
const {Get_Booking} = require("../../../support/APIUtilis/APIUtils");

describe("Get Booking", ()=>{

    before(()=>{
        if (!getAuthToken())
        {
            return authenticateAndGetToken();
        }
    });



    it("Get Previously Added booking", ()=>{
        
        cy.task('getMyUniqueId').then((myUniqueIds) => {
            
            cy.task("getStoredJsonObject").then((jsonObjects)=>{

                for(var i=0; i<myUniqueIds.length; i++)
                {
                    const myUniqueId = myUniqueIds[i];
                    const jsonobject = jsonObjects[i];
                    Get_Booking((myUniqueId).toString()).then((data)=>{




                    const responsePayloadget = data.response.body;
                    expect(responsePayloadget.firstname).to.equal(jsonobject.firstname);
                    expect(responsePayloadget.lastname).to.equal(jsonobject.lastname);
                    expect(responsePayloadget.totalprice).to.equal(jsonobject.totalprice);
                    expect(responsePayloadget.depositpaid).to.equal(jsonobject.depositpaid);
                    expect(new Date(responsePayloadget.bookingdates.checkin)).contains(new Date(jsonobject.bookingdates.checkin));
                    expect(new Date(responsePayloadget.bookingdates.checkout)).contains(new Date(jsonobject.bookingdates.checkout));
                    expect(responsePayloadget.additionalneeds).to.equal(jsonobject.additionalneeds);
                 })
                }
            })
        })
    })

})