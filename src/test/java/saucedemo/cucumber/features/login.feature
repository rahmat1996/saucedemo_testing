Feature: login to application

  Scenario: login success
    Given user on login page
    When user input username
    And user input password
    And user click login button
    Then user redirect to product page

  Scenario: login failed
    Given user on login page
    When user input username
    And user input invalid password
    And user click login button
    Then user get error message