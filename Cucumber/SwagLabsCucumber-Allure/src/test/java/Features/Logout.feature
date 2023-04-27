Feature: Logout Successfully
@Logout
Scenario Outline: Try to Logout after successful Login attempt

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User tries to Logout from Landing page
Then User is on Login Page

Examples:
  | username | password |
  | standard_user   | secret_sauce |