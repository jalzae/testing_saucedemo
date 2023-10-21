Feature: Log in in the application

  @Regression @Positive
  Scenario: Login to saucedemo.com as valid users
    Given access saucedemo
    When user enter right username and password
    Then click login button
    Then home page will be displayed

  @Regression @Negative
  Scenario: Login to saucedemo.com as invalid users
    Given access saucedemo
    When User have no right validation and enter the form
    Then click login button
    Then Will be error message validation

  @Regression @Negative
  Scenario: Login without fill the form
    Given access saucedemo
    Then click login button
    Then will be show error message to require the form