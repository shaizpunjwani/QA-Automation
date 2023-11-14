class Purchase{

    get_country()
    {
        return cy.get('#country');
    }

    get_option()
    {
        return cy.get('.suggestions > ul > li > a');
    }

    get_checkbox_terms()
    {
        return cy.get("#checkbox2");
    }

    get_purchase_btn()
    {
        return cy.get("input[type='submit']");
    }

    get_validation()
    {
        return cy.get('.alert');
    }
}

export default Purchase;