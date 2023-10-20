Feature: checkout product

  Scenario: checkout product success
    Given user already login and add product to cart and on cart page
    When user click checkout button
    And user input first name
    And user input last name
    And user input postal code
    And user click continue button
    And user click finish button
    Then user redirect to checkout complete page