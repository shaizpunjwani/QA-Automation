Feature: Application Login

@PortalTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User login into application with username "shaiz" and password "123"
Then Home page is populated
And Cards are displayed are "true"

@PortalTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User login into application with username "john" and password "321"
Then Home page is populated
And Cards are displayed are "false"

@PortalTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User sign up with following details
  | shaiz | 123 | shaiz@gmail.com | pakistan | 0345225678 |
Then Home page is populated
And Cards are displayed are "false"

@PortalTest
Scenario Outline: Home page default Login
Given User is on NetBanking landing page
When User login into application with incorect username <uname> and password <pwd>
Then Home page is populated
And Cards are displayed are "true"

Examples:
  |uname  |pwd|
  |"shaiz"  |123|
  |"sp"     |456|