$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/amazon.feature");
formatter.feature({
  "name": "Orders management",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Amazon"
    }
  ]
});
formatter.scenario({
  "name": "Amazon order placement and validation test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Amazon"
    }
  ]
});
formatter.step({
  "name": "launch the Amazon URL",
  "keyword": "Given "
});
formatter.match({
  "location": "Testcases.Amazon.launch_the_Amazon_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters product name by choosing category and hit search",
  "keyword": "When "
});
formatter.match({
  "location": "Testcases.Amazon.user_enters_product_name_by_choosing_category_and_hit_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "list of products should be displayed with product name and price",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.list_of_products_should_be_displayed_with_product_name_and_price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on first displayed mobile result",
  "keyword": "When "
});
formatter.match({
  "location": "Testcases.Amazon.user_clicks_on_first_displayed_mobile_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "chosen mobile should open in new window with its details and the user reads the item and price",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.chosen_mobile_should_open_in_new_window_with_its_details_and_the_user_reads_the_item_and_price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hit on add to cart",
  "keyword": "And "
});
formatter.match({
  "location": "Testcases.Amazon.hit_on_add_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on cart to view cart details",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.user_clicks_on_cart_to_view_cart_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "mobile name and price should be displayed and validated by user",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.mobile_name_and_price_should_be_displayed_and_validated_by_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user places the order by clicking proceed to checkout",
  "keyword": "When "
});
formatter.match({
  "location": "Testcases.Amazon.the_user_places_the_order_by_clicking_proceed_to_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters the login details",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.user_enters_the_login_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user chooses delivery address and continue to payment",
  "keyword": "And "
});
formatter.match({
  "location": "Testcases.Amazon.user_chooses_delivery_address_and_continue_to_payment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user removes product from cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Testcases.Amazon.user_removes_product_from_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the browser",
  "keyword": "And "
});
formatter.match({
  "location": "Testcases.Amazon.user_closes_the_browser()"
});
formatter.result({
  "status": "passed"
});
});