Feature: Default


  @FLTAPS-1136
  Scenario Outline: Store Manager can be able to access the "Add Event" page
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select a car

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |


