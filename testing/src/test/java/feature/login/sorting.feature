Feature: Sorting Product On Application

  @Regression @Positive
  Scenario: Sorting item on Inventory Page
    Given access saucedemo then get login in inventory
    When scrap inventory items name
    Then change sorting z to a and get desc item by alphabet correctly