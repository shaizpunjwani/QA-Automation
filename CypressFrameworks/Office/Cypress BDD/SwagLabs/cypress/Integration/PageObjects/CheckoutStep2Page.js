class CheckoutStep2Page {
    prices_each = "div[class='inventory_item_price']";
    tax_price = "div[class='summary_tax_label']";
    total_price = "div[class='summary_info_label summary_total_label']";
    finish_btn = "button[name='finish']";
    confirm_msg = "h2.complete-header";
    sum_prices = 0;
  
    get_each_prices() {
      return cy.get(this.prices_each);
    }
  
    get_tax_price() {
      return cy.get(this.tax_price);
    }
  
    get_total_price() {
      return cy.get(this.total_price);
    }
  
    get_finish_btn() {
      return cy.get(this.finish_btn);
    }
  
    get_confirmation_msg() {
      return cy.get(this.confirm_msg);
    }
  
    Get_Each_Prices() {
      return this.get_each_prices().each(($el, index, $list) => {
        return cy.TextExtractor($el.text(), "$").then((price) => {
          const new_price = Number(price);
          this.sum_prices = this.sum_prices + new_price;
        });
      });
    }
  
    Get_Total_Price() {
      return this.get_total_price().then((element) => {
        return cy.TextExtractor(element.text(), "$").then((new_total) => {
          expect(this.sum_prices).to.equal(Number(new_total));
          this.sum_prices=0;
        });
      });
    }
  
    Get_Tax_Price() {
      return this.get_tax_price().then((element) => {
        return cy.TextExtractor(element.text(), "$").then((new_tax) => {
          this.sum_prices = this.sum_prices + Number(new_tax);
          this.sum_prices = Number(this.sum_prices.toFixed(2));
        });
      });
    }
  
    Get_Final_msg(msg) {
      cy.ClickBtn(this.get_finish_btn());
  
      return this.get_confirmation_msg().then((element) => {
        const text = element.text();
        expect(text).to.includes(msg);
      });
    }
  }
  
  export default CheckoutStep2Page;
  