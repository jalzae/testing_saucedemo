Feature: Sorting Product On Application

  @Regression @Positive
  Scenario: Login to saucedemo.com as valid users
    Given access saucedemo then get login to inventory
    When scrap all inventory item name
    Then change sorting z to a and get desc item by alphabet correctly