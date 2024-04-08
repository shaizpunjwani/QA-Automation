class CartPage{

    selected_products="div[class='cart_item']";
    remove_products="button[id='remove-sauce-labs-bike-light']";
    checkout="button#checkout";

    get_all_selected_products()
    {
        return cy.get(this.selected_products);
    }

    get_remove_products()
    {
        return cy.get(this.remove_products);
    }

    get_proceed_checkout()
    {
        return cy.get(this.checkout);
    }

    Proceed_Checkout()
    {
        cy.ClickBtn(this.get_proceed_checkout());
    }

    Remove_Products_Cart()
    {
        cy.ClickBtn(this.get_remove_products());
        cy.ChangeCounterVal(-1);
    }

    Validate_Added_Products()
    {
        
        cy.GetCounterVar().then((counterVal)=>{
            this.get_all_selected_products().should("have.length", counterVal);
            cy.SetCounterVal(0);
        })
    }

}

export default CartPage;