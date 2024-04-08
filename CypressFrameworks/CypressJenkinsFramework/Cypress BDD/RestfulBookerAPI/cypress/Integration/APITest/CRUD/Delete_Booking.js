import { authenticateAndGetToken, getAuthToken } from "../Authorize/GenerateAuth";
const {Delete_Booking} = require("../../../support/APIUtilis/APIUtils");

var token;

describe("Delete Booking", ()=>{

    before(()=>{
        if (!getAuthToken())
        {
            authenticateAndGetToken().then((data)=>{
                token=data;
            })
        }
    });



    it("Delete booking", ()=>{

        cy.task('getMyUniqueId').then((myUniqueIds) => {

            for(var i=0; i<myUniqueIds.length; i++)
            {
                const myUniqueId=myUniqueIds[i];
                Delete_Booking(token, myUniqueId).then((data)=>{

                    const responsePayload = data.response.body;
                    expect(responsePayload).to.equal("Created");
                })
            }
    
        });
    })

});