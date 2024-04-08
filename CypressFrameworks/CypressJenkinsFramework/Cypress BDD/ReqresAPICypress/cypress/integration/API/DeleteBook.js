class DeleteBook{


    Delete_Book(bookid){
        return cy.request({
            method: 'DELETE',
            url: 'http://216.10.245.166/Library/DeleteBook.php',
            body:
            {
                "ID": bookid
            }
        }).then((response)=>{
            return{
            response: response,
            }
        })
    }
}

export default DeleteBook;