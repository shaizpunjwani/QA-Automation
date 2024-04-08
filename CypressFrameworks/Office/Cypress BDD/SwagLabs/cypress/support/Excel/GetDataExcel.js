class GetDataExcel{


    Get_Data() {
        const filename =
          Cypress.config("fileServerFolder") +
          "\\cypress\\support\\Excel\\Form_Data.xlsx";
    
        // Return the promise from cy.task
        return cy.task('ExceltoJsonConverter', filename);
      }


}

export default GetDataExcel;