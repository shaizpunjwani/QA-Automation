$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/OrderProduct.feature");
formatter.feature({
  "name": "Place the order for Products",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Placing the Order of the desired Products",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Ordering"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart landing page",
  "keyword": "Given "
});
formatter.step({
  "name": "User searches with short name called \"\u003cVeges\u003e\" and extracted actual name of product",
  "keyword": "When "
});
formatter.step({
  "name": "Add the Quantity \"3\" of the Selected Product to the Cart",
  "keyword": "And "
});
formatter.step({
  "name": "user proceeds to checkout",
  "keyword": "Then "
});
formatter.step({
  "name": "validated the selected product",
  "keyword": "And "
});
formatter.step({
  "name": "verify the user has ability of enter promo code and place the order",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Veges"
      ]
    },
    {
      "cells": [
        "Tom"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Placing the Order of the desired Products",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Ordering"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_is_on_GreenCart_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches with short name called \"Tom\" and extracted actual name of product",
  "keyword": "When "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_searches_with_short_name_called_and_extracted_actual_name_of_product(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add the Quantity \"3\" of the Selected Product to the Cart",
  "keyword": "And "
});
formatter.match({
  "location": "LandingPageStepDefinition.add_the_Quantity_of_the_Selected_Product_to_the_Cart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user proceeds to checkout",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_proceeds_to_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validated the selected product",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageStepDefinition.validated_the_selected_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the user has ability of enter promo code and place the order",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageStepDefinition.verify_the_user_has_ability_of_enter_promo_code_and_place_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/Features/SearchProduct.feature");
formatter.feature({
  "name": "Search and Place the order for Products",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search Experience must be same for Home and offers page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Searching"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart landing page",
  "keyword": "Given "
});
formatter.step({
  "name": "User searches with short name called \"\u003cVeges\u003e\" and extracted actual name of product",
  "keyword": "When "
});
formatter.step({
  "name": "User searches for \"\u003cVeges\u003e\" shortname in Offers page to check if product exist",
  "keyword": "Then "
});
formatter.step({
  "name": "compare the result from offers page and landing page",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Veges"
      ]
    },
    {
      "cells": [
        "Tom"
      ]
    },
    {
      "cells": [
        "Beet"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search Experience must be same for Home and offers page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Searching"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_is_on_GreenCart_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches with short name called \"Tom\" and extracted actual name of product",
  "keyword": "When "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_searches_with_short_name_called_and_extracted_actual_name_of_product(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for \"Tom\" shortname in Offers page to check if product exist",
  "keyword": "Then "
});
formatter.match({
  "location": "OffersPageStepDefinition.user_searches_for_shortname_in_Offers_page_to_check_if_product_exist(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "compare the result from offers page and landing page",
  "keyword": "And "
});
formatter.match({
  "location": "OffersPageStepDefinition.compare_the_result_from_offers_page_and_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Search Experience must be same for Home and offers page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Searching"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_is_on_GreenCart_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches with short name called \"Beet\" and extracted actual name of product",
  "keyword": "When "
});
formatter.match({
  "location": "LandingPageStepDefinition.user_searches_with_short_name_called_and_extracted_actual_name_of_product(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for \"Beet\" shortname in Offers page to check if product exist",
  "keyword": "Then "
});
formatter.match({
  "location": "OffersPageStepDefinition.user_searches_for_shortname_in_Offers_page_to_check_if_product_exist(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "compare the result from offers page and landing page",
  "keyword": "And "
});
formatter.match({
  "location": "OffersPageStepDefinition.compare_the_result_from_offers_page_and_landing_page()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Not Consistent\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat StepDefinitions.OffersPageStepDefinition.compare_the_result_from_offers_page_and_landing_page(OffersPageStepDefinition.java:51)\r\n\tat ✽.compare the result from offers page and landing page(file:src/test/java/Features/SearchProduct.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});