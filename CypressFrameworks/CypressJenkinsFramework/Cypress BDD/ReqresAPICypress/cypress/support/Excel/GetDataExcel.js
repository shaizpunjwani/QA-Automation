class GetDataExcel{


    Get_Data() {
        const filename =
          Cypress.config("fileServerFolder") +
          "\\cypress\\fixtures\\APIData.xlsx";
    
        return cy.task('ExceltoJsonConverter', filename);
      }


}

export default GetDataExcel;