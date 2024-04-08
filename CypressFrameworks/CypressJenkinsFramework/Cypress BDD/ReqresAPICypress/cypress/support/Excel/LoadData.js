import Get_Data from "../Excel/GetDataExcel"

function Get_Excel_Data() {
    const exceldata = new Get_Data();
    // Return the promise directly, no need for an additional `cy.wrap()`
    return exceldata.Get_Data().then((data) => {
        const rows = data.Sheet1.slice(1);
        // const numRows = rows.length;
        // const randomRowNumber = Math.floor(Math.random() * numRows);
        // const randomRow = rows[randomRowNumber];
        // return randomRow;
        return rows;
    });
}

module.exports = {
    Get_Excel_Data
};