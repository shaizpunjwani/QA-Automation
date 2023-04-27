Feature: Place the order for Products
@Ordering
Scenario Outline: Placing the Order of the desired Products

Given User is on GreenCart landing page
When User searches with short name called "<Veges>" and extracted actual name of product
And Add the Quantity "3" of the Selected Product to the Cart
Then user proceeds to checkout
And validated the selected product
And verify the user has ability of enter promo code and place the order

Examples:
  | Veges |
  | Tom   |