class AddBook{


    Add_Book(isbn, aisle, name, auth){
        return cy.request({
            method: 'POST',
            url: 'http://216.10.245.166/Library/Addbook.php',
            body: {
                "name": name,
                "isbn": isbn,
                "aisle": aisle,
                "author": auth
            }
        }).then((response)=>{
            return{
            response: response,
            bookid: response.body.ID
            }
        })
    }
}

export default AddBook;