/// <reference types="Cypress" />

import AddBook from "../API/AddBook";
import DeleteBook from "../API/DeleteBook";
import GetBook from "../API/GetBook";
const {Get_Excel_Data} = require("../../support/Excel/LoadData");

describe("API Test Suite", () => {
    var isbn;
    var aisle;
    var bookid;
    const add_book=new AddBook();
    const get_book=new GetBook();
    const delete_book=new DeleteBook();
    var datajson;
    var exceldata

    before(() => {
        cy.fixture("example.json").then((data) => {
            datajson=data;
            Get_Excel_Data().then((data)=>{
                exceldata=data;
            })
        });
    });

    it("Add Book", () => {
        for (var i = 0; i < exceldata.length; i++) {
        cy.TextGenerate().then(function (element) {
            isbn = element;
    
            cy.NumberGenerate().then(function (element) {
                aisle = element;
                
                
                console.log(exceldata[i]);
    
                    add_book.Add_Book(isbn, aisle, exceldata[i]["A"], exceldata[i]["B"]).then((result) => {
                        expect(result.response.status).to.equal(200);
                        expect(result.response.body).to.have.property("Msg", datajson.success_msg_add);
                        bookid = result.bookid;
                    });
            });
        });
    }
    });

    it("Get Book", () => {


       get_book.Get_Book(bookid).then((result)=>{
        expect(result.response.status).to.equal(200);
        expect(result.response.body[0].isbn).to.equal(isbn);
        expect(result.response.body[0].book_name).to.equal(exceldata.A);
        expect(result.response.body[0].author).to.equal(exceldata.B);
        expect(result.response.body[0].aisle).to.equal(aisle);
       })

    });

    it("Delete Book", () => {
        delete_book.Delete_Book(bookid).then((result)=>{
            expect(result.response.status).to.equal(200);
            expect(result.response.body).have.property("msg", datajson.success_msg_delete);
        })
    })
})
