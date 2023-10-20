Feature: add product to cart

  Scenario: add product to cart success
    Given user already login and on product page
    When user click add to cart button on product
    And user click cart button
    Then product showing on cart