Feature: Search and Place the order for Products
@Searching
Scenario Outline: Search Experience must be same for Home and offers page

Given User is on GreenCart landing page
When User searches with short name called "<Veges>" and extracted actual name of product
Then User searches for "<Veges>" shortname in Offers page to check if product exist
And compare the result from offers page and landing page

Examples:
  | Veges |
  | Tom   |
  | Beet  |