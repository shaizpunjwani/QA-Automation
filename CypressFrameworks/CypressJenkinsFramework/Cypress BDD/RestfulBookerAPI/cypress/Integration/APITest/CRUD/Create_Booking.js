/// <reference types="Cypress" />
import { authenticateAndGetToken, getAuthToken } from "../Authorize/GenerateAuth";
const {Create_Booking} = require("../../../support/APIUtilis/APIUtils");
const {Get_Create_Booking_Payload, removeKeyFromPayload} = require("../../../fixtures/GetTestData");
const jsondata=require("../../../support/GetDataJson/GetData");

var booking_payload;

describe("Create Booking", ()=>{

    before(()=>{
        if (!getAuthToken())
        {
            return authenticateAndGetToken();
        }
    });



    it("Add booking", ()=>{
        var bookid_lst=[];
        var book_payload_lst=[]

        for(var i=0; i<20; i++)
        {

            booking_payload=Get_Create_Booking_Payload();

            Create_Booking(booking_payload).then((data)=>{

                const responsePayload = data.response.body.booking;

                expect(responsePayload.firstname).to.equal(booking_payload.firstname);
                expect(responsePayload.lastname).to.equal(booking_payload.lastname);
                expect(responsePayload.totalprice).to.equal(booking_payload.totalprice);
                expect(responsePayload.depositpaid).to.equal(booking_payload.depositpaid);
                
                expect(new Date(responsePayload.bookingdates.checkin)).contains(new Date(booking_payload.bookingdates.checkin));
                expect(new Date(responsePayload.bookingdates.checkout)).contains(new Date(booking_payload.bookingdates.checkout));
        
                expect(responsePayload.additionalneeds).to.equal(booking_payload.additionalneeds);

                bookid_lst.push(data.response.body.bookingid);
                book_payload_lst.push(booking_payload);
            });
        }

        console.log(bookid_lst);
        console.log(book_payload_lst);

        cy.task("setMyUniqueId", bookid_lst);
        cy.task("storeJsonObject", book_payload_lst);

        
    })

    it("Add booking by removing firstname", ()=>{

        booking_payload=removeKeyFromPayload("firstname");
        Create_Booking(booking_payload);
    });

    it("Add booking by removing price", ()=>{

        booking_payload=removeKeyFromPayload("totalprice");
        Create_Booking(booking_payload);
    })

    it("Add booking by removing bookingdates", ()=>{

        booking_payload=removeKeyFromPayload("bookingdates");
        Create_Booking(booking_payload);
    })

    it("Add booking by removing additionalneeds", ()=>{

        booking_payload=removeKeyFromPayload("additionalneeds");
        Create_Booking(booking_payload);

    })

})

