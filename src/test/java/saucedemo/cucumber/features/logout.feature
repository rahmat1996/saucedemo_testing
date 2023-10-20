Feature: logout from application

  Scenario: logout success
    Given user on login page logout scenario
    When user input username logout scenario
    And user input password logout scenario
    And user click login button logout scenario
    And user redirect to product page logout scenario
    And user click sidebar menu logout scenario
    And user click logout button logout scenario
    Then user redirect after logout to login page logout scenario
