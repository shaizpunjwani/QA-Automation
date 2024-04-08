import { authenticateAndGetToken, getAuthToken } from "../Authorize/GenerateAuth";
const {Edit_Booking} = require("../../../support/APIUtilis/APIUtils");
const {Get_Create_Booking_Payload} = require("../../../fixtures/GetTestData");

var booking_payload;
var token;

var new_book_payload_lst=[];

describe("Edit Booking", ()=>{

    before(()=>{
        if (!getAuthToken())
        {
            authenticateAndGetToken().then((data)=>{
                token=data;
            })
        }
    });



    it("Edit booking", ()=>{

        cy.task('getMyUniqueId').then((myUniqueIds) => {

            for(var i=0; i<myUniqueIds.length; i++)
            {


            booking_payload=Get_Create_Booking_Payload();
            const myUniqueId=myUniqueIds[i];

            Edit_Booking(token, myUniqueId, booking_payload).then((data)=>{

                const responsePayload = data.response.body;

                expect(responsePayload.firstname).to.equal(booking_payload.firstname);
                expect(responsePayload.lastname).to.equal(booking_payload.lastname);
                expect(responsePayload.totalprice).to.equal(booking_payload.totalprice);
                expect(responsePayload.depositpaid).to.equal(booking_payload.depositpaid);
                
                expect(new Date(responsePayload.bookingdates.checkin)).contains(new Date(booking_payload.bookingdates.checkin));
                expect(new Date(responsePayload.bookingdates.checkout)).contains(new Date(booking_payload.bookingdates.checkout));
        
                expect(responsePayload.additionalneeds).to.equal(booking_payload.additionalneeds);

                new_book_payload_lst.push(booking_payload);

            })
        }

        cy.task("storeJsonObject", new_book_payload_lst);
    
        });
    })

});