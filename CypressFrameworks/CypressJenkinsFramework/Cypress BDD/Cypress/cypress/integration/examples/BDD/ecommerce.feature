Feature: End to End Ecommerce validation

    Application regression

@Regression
Scenario: Ecommerce product delivery

Given Navigate to Ecommerce page
When Add the items to the cart
And Validate the total prices of the products added
Then Select the country submit and verify "hllo"

@Smoke
Scenario: Enter the form details

Given Navigate to Ecommerce page
When Fill the form details
| name | gender |
| Bob | Female |
Then Validate the added details