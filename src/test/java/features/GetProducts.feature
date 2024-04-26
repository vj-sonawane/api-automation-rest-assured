Feature: Get all products from FakeStoreAPI

  Scenario: Verify the get API for the products
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then Then I receive the response code as OK

    Scenario Outline: Verify the rate of first product
      Given I hit the url of get products api endpoint
      When I pass the url of products in the request
      Then I verify that the rate of first product is "<rate>"

      Examples:
        | rate |
        | 3.9  |
