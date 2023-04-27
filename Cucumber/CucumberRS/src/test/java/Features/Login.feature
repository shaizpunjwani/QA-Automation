Feature: Application Login


#  har scenario ko run krne se pehle ye background ko ja kr run karega just as pre-requisute
#Background:
#Given validate browser
#When browser is triggered
#Then check if browser is started


@WebTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User login into application with username "shaiz" and password "123"
Then Home page is populated
And Cards are displayed are "true"

@MobileTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User login into application with username "john" and password "321"
Then Home page is populated
And Cards are displayed are "false"

@MobileTest
Scenario: Home page default Login
Given User is on NetBanking landing page
When User sign up with following details
| shaiz | 123 | shaiz@gmail.com | pakistan | 0345225678 |
Then Home page is populated
And Cards are displayed are "false"

@regTest
Scenario Outline: Home page default Login
Given User is on NetBanking landing page
When User login into application with incorect username <uname> and password <pwd>
Then Home page is populated
And Cards are displayed are "true"

Examples:
  |uname  |pwd|
  |"shaiz"  |123|
  |"sp"     |456|