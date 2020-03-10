Feature: Verify search result page

  @Regression
  Scenario: TC002_Verify that search result page display list of mathing product list
    Given User is on search result page
    When Scroll down the page
    Then List of product item shows on the page
    And Count of matching product displayed on the page
