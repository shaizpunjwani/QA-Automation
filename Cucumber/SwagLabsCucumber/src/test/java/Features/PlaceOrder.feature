Feature: Place Order
@OrderI
Scenario Outline: Try to place order with items

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User selects items to the cart
Then User proceeds to checkout
When User enters its details firstname "john" lastname "cena" and zip "12345"
Then Page is populated with the details of items
And user verifies the items and prices
And finishes order

Examples:
  | username | password |
  | standard_user   | secret_sauce |

@OrderNI
Scenario Outline: Try to place order without items

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
Then User proceeds to checkout
When User enters its details firstname "john" lastname "cena" and zip "12345"
Then Page is populated with the details of items
And user verifies the items and prices
And finishes order

Examples:
  | username | password |
  | standard_user   | secret_sauce |
