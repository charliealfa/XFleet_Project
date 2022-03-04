@FLTAPS-1163
  Feature: Vehicle Information

    @wip
    Scenario: Verify user can see General Information page
      Given the "sales manager" is on home page
      When navigate to "Fleet" "Vehicles" page
      And user should select a car
      Then user should be on General Information page

