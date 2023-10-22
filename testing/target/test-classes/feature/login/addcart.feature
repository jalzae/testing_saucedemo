Feature: Add to Cart Product On Application

  @Regression @Positive
  Scenario: Login to saucedemo.com as valid users
    Given access saucedemo then get login to inventorys
    When scrap all inventory item names
    Then add to product on carts 
    Then check the number on cart detail
    Then access cart page and get item counts