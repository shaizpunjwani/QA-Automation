import GetDataExcel from '../../support/Excel/GetDataExcel'
class CheckoutStep1Page{

  
    continue_btn="input#continue";
    fname="input[name='firstName']";
    lname="input[name='lastName']";
    postcode="input[name='postalCode']";

    get_continue_btn()
    {
        return cy.get(this.continue_btn);
    }

    get_firstname()
    {
        return cy.get(this.fname);
    }

    get_lastname()
    {
        return cy.get(this.lname);   
    }

    get_postalcode()
    {
        return cy.get(this.postcode);
    }

    Enter_Values_Form()
    {
        const exceldata = new GetDataExcel();

        exceldata.Get_Data().then((data) => {

        var jsonString = JSON.stringify(data);
        const rows = data.Sheet1.slice(1);

        const numRows = rows.length;

        const randomRowNumber = Math.floor(Math.random() * numRows);

        const randomRow = rows[randomRowNumber];
        console.log(randomRow);

          const fname = randomRow.A;
          const lname = randomRow.B;
          const zip = randomRow.C;


          cy.EnterValues(this.get_firstname(), fname);
          cy.EnterValues(this.get_lastname(), lname);
          cy.EnterValues(this.get_postalcode(), zip);

    
        cy.ClickBtn(this.get_continue_btn());
         })
    }

}

export default CheckoutStep1Page;