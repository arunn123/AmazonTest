@Amazon
Feature: Orders management

  Scenario: Amazon order placement and validation test
    Given launch the Amazon URL
    When user enters product name by choosing category and hit search
    Then list of products should be displayed with product name and price
    When user clicks on first displayed mobile result
    Then chosen mobile should open in new window with its details and the user reads the item and price
    And hit on add to cart
    Then user clicks on cart to view cart details
    Then mobile name and price should be displayed and validated by user
    When the user places the order by clicking proceed to checkout
    Then user enters the login details
    And user chooses delivery address and continue to payment
    Then user removes product from cart
    And user closes the browser
