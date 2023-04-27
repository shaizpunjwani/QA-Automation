$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/Account.feature");
formatter.feature({
  "name": "Application Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.user_is_on_netbanking_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login into application with username \"shaiz\" and password \"123\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.user_login_into_application_with_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.home_page_is_populated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cards are displayed are \"true\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.cards_are_displayed_are(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.user_is_on_netbanking_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login into application with username \"john\" and password \"321\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.user_login_into_application_with_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.home_page_is_populated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cards are displayed are \"false\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.cards_are_displayed_are(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.user_is_on_netbanking_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sign up with following details",
  "rows": [
    {
      "cells": [
        "shaiz",
        "123",
        "shaiz@gmail.com",
        "pakistan",
        "0345225678"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.user_sign_up_with_following_details(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.home_page_is_populated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cards are displayed are \"false\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.cards_are_displayed_are(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.step({
  "name": "User login into application with incorect username \u003cuname\u003e and password \u003cpwd\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.step({
  "name": "Cards are displayed are \"true\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "uname",
        "pwd"
      ]
    },
    {
      "cells": [
        "\"shaiz\"",
        "123"
      ]
    },
    {
      "cells": [
        "\"sp\"",
        "456"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.user_is_on_netbanking_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login into application with incorect username \"shaiz\" and password 123",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.user_login_into_application_with_incorect_username_and_password(String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.home_page_is_populated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cards are displayed are \"true\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.cards_are_displayed_are(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Home page default Login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PortalTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on NetBanking landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.user_is_on_netbanking_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login into application with incorect username \"sp\" and password 456",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.user_login_into_application_with_incorect_username_and_password(String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is populated",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.home_page_is_populated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cards are displayed are \"true\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.cards_are_displayed_are(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});