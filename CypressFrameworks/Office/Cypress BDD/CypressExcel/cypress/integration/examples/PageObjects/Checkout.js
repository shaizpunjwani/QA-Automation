class Checkout{

    get_checkout_btn()
    {
        return cy.get(':nth-child(4) > :nth-child(5) > .btn');
    }

    get_price_each()
    {
        return cy.get("tr td:nth-child(4) strong");
    }

    get_total_price()
    {
        return cy.get("h3 strong");
    }
}

export default Checkout;