@FLTAPS-1163
Feature: Vehicle Information

  @FLTAPS-1165
  Scenario: Verify user can see General Information page
    Given the "sales manager" is on home page
    When navigate to "Fleet" "Vehicles" page
    And user should select a car
    Then user should be on General Information page


  @FLTAPS-1167
  Scenario: Verify user can navigate to General Information page by clicking Eye icon
    Given the "sales manager" is on home page
    When navigate to "Fleet" "Vehicles" page
    And user clicks Eye icon to navigate to General Information page
    Then user should be on General Information page

  @FLTAPS-1174
  Scenario Outline: Verify Sales manager and store manager can see the Edit, Delete and Add Event buttons
    Given the "<user>" is on home page
    When navigate to "Fleet" "Vehicles" page
    And user should select a car
    And user should be on General Information page
    Then user should see Edit, Delete and Add Event buttons

    Examples:
      | user          |
      | sales manager |
      | store manager |


