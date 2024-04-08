Feature: Login functionality

Scenario Outline: Enter the credentials in swaglabs

Given Navigate to SwagLabs website
When Fill the Login credentials "<username>" and "<password>"
Then Validate the landed page

Examples:

    | username           | password      |
    | standard_user      | secret_sauce  |
    | locked_out_user    | secret_sauce  |
    | problem_user       | secret_sauce  |
    | performance_glitch_user | secret_sauce |
    | error_user         | secret_sauce  |
    | visual_user        | secret_sauce  |