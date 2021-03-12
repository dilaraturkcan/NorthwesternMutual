Feature: User purchasing item
  @demo
  Scenario: Login positive test
    Given User on the "https://www.saucedemo.com/" page
    When User logs in with username "standard_user" and the password "secret_sauce"
    And User adds two or more items to the shopping cart
    And User Assert that the items that you added are in the cart
    Then User remove an items and then continue shopping
    And User add another items
    And User goes to Checkout
    Then User Validates correct items and the total price
    |Sauce Labs Bolt T-Shirt|
    |Total: $25.90|
    And User Finishes Checkout


