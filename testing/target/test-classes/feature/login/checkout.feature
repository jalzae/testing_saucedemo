Feature: Checkout Product On Application

  @Regression @Positive
  Scenario: Login to saucedemo.com as valid users
    Given access saucedemo then get login to inventory
    When scrap all inventory item name
    Then add to product on cart
    Then check the number on cart detail
    Then access cart page and get item count
    Then click checkout button
    Then fill the form correctly
    Then go to checkout step two pages
    Then go to checkout complete

  @Regression @Negative
  Scenario: Login to saucedemo.com as valid users
    Given access saucedemo then get login to inventory
    When scrap all inventory item name
    Then add to product on cart
    Then check the number on cart detail
    Then access cart page and get item count
    Then click checkout button
    Then fill the form uncorrectly
    Then show error require 
