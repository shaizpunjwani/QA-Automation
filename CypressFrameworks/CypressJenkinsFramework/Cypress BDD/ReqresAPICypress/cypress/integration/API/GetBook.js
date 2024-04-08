class GetBook{


    Get_Book(bookid){
        return cy.request({
            method: 'GET',
            url: 'http://216.10.245.166/Library/GetBook.php',
            qs: {
                ID: bookid
            }
        }).then((response)=>{
            return{
            response: response,
            }
        })
    }
}

export default GetBook;