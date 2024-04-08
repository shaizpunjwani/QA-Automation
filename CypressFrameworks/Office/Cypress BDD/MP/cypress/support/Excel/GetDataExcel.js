class GetDataExcel{


    Get_Data() {
        const filename =
          Cypress.config("fileServerFolder") +
          "\\cypress\\fixtures\\Upload Part Template.xlsx";
    
        // Return the promise from cy.task
        return cy.task('ExceltoJsonConverter', filename);
      }


}

export default GetDataExcel;