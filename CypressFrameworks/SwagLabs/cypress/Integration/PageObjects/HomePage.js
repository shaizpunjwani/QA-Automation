class HomePage{

    homepg_logo="div.app_logo";
    ProdName="div[class='inventory_item_name ']";
    add_cart="div.pricebar button";
    shopping_cart='.shopping_cart_link';
    item_name="div.inventory_item_name ";
    item_price="div.inventory_item_price";


    verifyOrder(flag, valueType) {
        var array = [];
        var elementsSelector;
    
        if (valueType === "string") {
            elementsSelector = this.item_name;
        } 
        else{
            elementsSelector = this.item_price;
        }
    
        cy.get(elementsSelector).each(($el, index, $list) => {
            if (valueType === "string") {
                array.push($el.text());
            } 
            else{
                array.push(Number($el.text()));
            }
        });
    
        if (flag === "0") {
            for (let i = 0; i < array.length - 1; i++) {
                expect(array[i] <= array[i + 1]).to.be.true;
            }
        } else {
            for (let i = 0; i < array.length - 1; i++) {
                expect(array[i] >= array[i + 1]).to.be.true;
            }
        }
    }


    Validate_Landed_Page(text)
    {
        cy.TextComparator(this.get_Homepg_Logo_Selector(),text);

    }

    Select_Filters(filter)
    {
        cy.get("select").select(filter);
    }

    set_counter_val(val)
    {
        this.counter=val;
    }

    get_counter_val()
    {
        return this.counter;
    }
    

    get_Homepg_Logo_Selector()
    {
        return cy.get(this.homepg_logo);
    }

    get_prodname_Selector()
    {
        return cy.get(this.ProdName);
    }

    get_add_cart_Selector()
    {
        return cy.get(this.add_cart);
    }

    get_shopping_cart()
    {
        return cy.get(this.shopping_cart);
    }

    Click_Shopping_Cart()
    {
        cy.ClickBtn(this.get_shopping_cart());

    }

    Add_Products(prodname)
    {

        if(prodname=="None")
        {
            cy.AddProductsCart(this.ProdName,"None", this.add_cart);

        }
        else{
            cy.AddProductsCart(this.ProdName,prodname, this.add_cart);
        }
        
        
        cy.GetCounterVar().then((counterVal)=>{
            // this.set_counter_val(0);
            // this.set_counter_val(counterVal);
            cy.SetCounterVal(0);
            cy.SetCounterVal(counterVal);
        })
    }

}

export default HomePage;