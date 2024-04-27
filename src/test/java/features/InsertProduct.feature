Feature: Insert products to FakeStoreAPI using POST api

  Scenario Outline: Verify the POST API for the products
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And I pass the request body of product title "<ProductTitle>"
    Then Then I receive the response code as OK

    Examples:
      | ProductTitle  |
      | Dotted Condom |
