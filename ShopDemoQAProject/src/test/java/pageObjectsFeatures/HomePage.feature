Feature: Verify search Feature

	@Smoke	
  Scenario: TC001_Verify that user is able to search product
    Given user is on Home Page
    And click on search icon
    When he enter product in search field
    And hits ENTER key
    Then result page is displayed
    
