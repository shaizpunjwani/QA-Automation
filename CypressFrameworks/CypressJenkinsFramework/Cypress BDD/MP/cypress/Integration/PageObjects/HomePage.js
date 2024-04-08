class HomePage{

    search='#CleanPartNumber';
    part='.nav > :nth-child(3) > a';
    parts_suggest="div[class='tt-suggestion tt-selectable']:nth-child(1)";
    qty='#item_Quantity';

    Get_Qty()
    {
        return cy.get(this.qty);
    }

    Get_Suggested_parts()
    {
        return cy.get(this.parts_suggest);
    }

    Enter_PartNo(value)
    {
        cy.EnterValues(this.Get_Search(), value);
    }

    Enter_Qty(value)
    {
        cy.EnterValues(this.Get_Qty(), value);
    }

    Get_Search()
    {
        return cy.get(this.search);
    }

    Get_Part()
    {
        return cy.get(this.part);
    }

    Click_Suggested_part()
    {
        this.Get_Suggested_parts().click();
    }


    Navigate_Parts()
    {
        this.Get_Part().click();
    }

    Validate_Homepage()
    {
        this.Get_Search().should("be.visible");
    }
}

export default HomePage;