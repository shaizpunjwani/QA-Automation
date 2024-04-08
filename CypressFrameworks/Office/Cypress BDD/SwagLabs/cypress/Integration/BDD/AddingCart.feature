Feature: Adding products to the cart

Scenario: Add products to the cart based on the given name

Given Navigate to SwagLabs website
When Fill the Login credentials "standard_user" and "secret_sauce"
Then Validate the landed page
When Add the products which contains "Sauce Labs" in their name
Then Validate the added products
When Proceed to checkout
When Enter the form data
Then Validate the added products along with their prices and end message "Thank you"


Scenario: Add all products to the cart

Given Navigate to SwagLabs website
When Fill the Login credentials "standard_user" and "secret_sauce"
Then Validate the landed page
When Add all the products
Then Validate the added products
When Proceed to checkout
When Enter the form data
Then Validate the added products along with their prices and end message "Thank you"

Scenario: Add all products to the cart but remove some items from cart

Given Navigate to SwagLabs website
When Fill the Login credentials "standard_user" and "secret_sauce"
Then Validate the landed page
When Add all the products
Then Validate the added products
When Remove item from cart
When Proceed to checkout
When Enter the form data
Then Validate the added products along with their prices and end message "Thank you"