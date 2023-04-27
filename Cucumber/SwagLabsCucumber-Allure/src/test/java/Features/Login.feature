Feature: Login using Username and Password
@Login
Scenario Outline: Try to Login using different Usernames

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page

Examples:
  | username | password |
  | standard_user   | secret_sauce |
  | locked_out_user   | secret_sauce |
  | problem_user   | secret_sauce |
  | performance_glitch_user | secret_sauce |