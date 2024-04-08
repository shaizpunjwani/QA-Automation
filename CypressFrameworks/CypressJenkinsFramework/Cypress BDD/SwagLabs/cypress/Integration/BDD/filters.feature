Feature: Checking the filters functionality

Scenario Outline: Verify alphabetic order filters on products

Given Navigate to SwagLabs website
When Fill the Login credentials "standard_user" and "secret_sauce"
Then Validate the landed page
When Selecting the alphabetic filters "<Alphabetic>"
Then verify whether the products displayed are according to alphabetic order "<Flag>"

Examples:

    | Alphabetic | Flag |
    | az       | 0 |
    | za       | 1 |


Scenario Outline: Verify pricing order filters on products

Given Navigate to SwagLabs website
When Fill the Login credentials "standard_user" and "secret_sauce"
Then Validate the landed page
When Selecting the numeric filters "<Numeric>"
Then verify whether the products displayed are according numeric order "<Flag>"

Examples:

    | Numeric | Flag |
    | lohi   | 0 |
    | hilo   | 1 |