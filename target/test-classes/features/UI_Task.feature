@verify_ebay_tests
Feature: Verify eBay tests

  @SearchAndVerify_ItemResults
  Scenario: Search and verify results
    Given I am a non-registered customer
    And I navigate to www.ebay.co.uk
    When I search for item - bmw
    Then I get a list of matching results
    And the results displayed show the item prices
    When I sort the results by Lowest Price
#    Then the results are listed in the page in the correct order
#    When I sort the results by Highest Price
#    Then the results are listed in the page in the correct order

#    Given I am a non-registered customer
#    And I navigate to www.ebay.co.uk
#    When I search for an item
#    Then I get a list of matching results
#    And the resulting items cards show: postage price, No of bids, price or show
#  BuyItNow tag
#    When I sort the results by Lowest Price
#    Then the results are listed in the page in the correct order
#    When I sort the results by Highest Price
#    Then the results are listed in the page in the correct order

  @SearchAndNavigate_ResultsPages
  Scenario: Search and navigate through results page
