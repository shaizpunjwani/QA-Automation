import GetDataExcel from "../../support/Excel/GetDataExcel";

class PartsPage{

    upload='.text-right > a.btn';
    file="input[type=\"file\"]";
    savebtn="button[type='submit']";
    search="input[id='Search']";
    filter='.col-lg-3 > .btn-primary';
    Uploader='.dz-success-mark';
    delete_btn=':nth-child(1) > :nth-child(10) > .btn';
    confirmation='.modal-footer > .btn-primary';
    array=[];
    
    
    Get_OEM(loc)
    {
       const oem=':nth-child('+loc+') > .oem';
        return cy.get(oem);
    }

    Get_PartNumber(loc)
    {
        const partnumber='tbody > :nth-child('+loc+') > :nth-child(3)';
        return cy.get(partnumber);
    }

    Get_Description(loc)
    {
        const descrip=':nth-child('+loc+') > .partDescription';
        return cy.get(descrip);
    }

    Get_Price(loc)
    {
        const price='tbody > :nth-child('+loc+') > :nth-child(6)';
        return cy.get(price);
    }

    Get_Search()
    {
        return cy.get(this.search);
    }

    Get_Filter()
    {
        return cy.get(this.filter);
    }

    Get_Delete_btn(){
        return cy.get(this.delete_btn);
    }

    Get_Confirmation()
    {
        return cy.get(this.confirmation);
    }

    Delete_Part() {
        cy.log("running");
        this.Get_Search().clear();
    
        // Use cy.wrap() to create a chain of commands
        cy.wrap(this.array).each((localStorageKey) => {
            cy.window().then((win) => {
                const storedObject = JSON.parse(win.localStorage.getItem(localStorageKey));
                cy.EnterValues(this.Get_Search(), storedObject.A);
                this.Get_Filter().click();
                this.Get_Delete_btn().click();
                this.Get_Confirmation().click();
            });
        });
    
        // Now the length of the array will be logged after the asynchronous operations complete
        cy.log(this.array.length);
    }

    Verify_Added_Data(num, localStorageKey) {
        cy.window().then((win) => {
            const storedObject = JSON.parse(win.localStorage.getItem(localStorageKey));
            cy.Comparator(this.Get_OEM(1), storedObject.A);
            cy.Comparator(this.Get_PartNumber(1), storedObject.B);
            cy.Comparator(this.Get_Description(1), storedObject.D);
            //cy.Comparator(this.Get_Price(num), storedObject.E);
        });
    }

    Search_Part() {
        cy.clearLocalStorage();
        const exceldata = new GetDataExcel();
    
        exceldata.Get_Data().then((data) => {
            var jsonString = JSON.stringify(data);
            const jsonData = JSON.parse(jsonString);
    
            const partExportResult = jsonData['Part Export Result'];
    
            for(let i = 1; i < partExportResult.length; i++) {
                const desiredObject = partExportResult[i];
                const localStorageKey = 'desiredObject' + i;
                this.array.push(localStorageKey);
    
                this.Get_Search().clear();
                cy.EnterValues(this.Get_Search(), desiredObject.A);
    
                cy.window().then((win) => {
                    win.localStorage.setItem(localStorageKey, JSON.stringify(desiredObject));
                    this.Get_Filter().click();
                    this.Verify_Added_Data(i, localStorageKey);
                });
            }
        });
    }

    Get_Upload_Option()
    {
        return cy.get(this.upload);
    }

    Navigate_Upload()
    {
        this.Get_Upload_Option().click();
    }

    Get_File_Selector()
    {
        return cy.get(this.file);
    }

    Get_Save_btn()
    {
        return cy.get(this.savebtn);
    }

    Click_Save()
    {
        cy.get(this.Uploader, { timeout: 10000 }).should('be.visible');

        this.Get_Save_btn().click();
    }


    Upload_File(filename)
    {
        this.Get_File_Selector().attachFile('Upload Part Template.xlsx');
    }

}

export default PartsPage;