class Homepage{

    Get_name_edit_box()
    {
        return cy.get("div.form-group input[name='name']");
    }

    Get_two_way_binding()
    {
        return cy.get(':nth-child(4) > .ng-untouched');
    }

    Get_Gender()
    {
        return cy.get("select");
    }

    Get_Enterpreneur_radio()
    {
        return cy.get('#inlineRadio3');
    }

    Get_Shop_Tab()
    {
        return cy.get(':nth-child(2) > .nav-link');
    }

}

export default Homepage;