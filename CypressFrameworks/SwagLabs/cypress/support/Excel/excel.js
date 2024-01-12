const excelToJson = require('convert-excel-to-json');
const fs = require('fs');
import GetDataExcel from './GetDataExcel';

const exceldata=new GetDataExcel();
var data;

describe("Excel Test Suite", function () {
    it("Extracting data", function () {
      // Use cy.then to properly handle the asynchronous operation
      exceldata.Get_Data().then((result) => {
        data = result;
        cy.log("received obj");
        cy.log(data);
        console.log(data);
      });
    });
  });