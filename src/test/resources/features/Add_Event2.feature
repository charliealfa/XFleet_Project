Feature: Add_Event2


  @FLTAPS-1136 @first
  Scenario Outline: As a store manager and sales manager can be able to access the "Add Event" page
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select a car
    Then user should display add event button

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |

  @FLTAPS-1201 @first
Scenario Outline: Add Event should open as a pop up
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select a car
    Then user can click add event button
    Then user should display add event pop up

  Examples:
    | username        | password    |
    | salesmanager120 | UserUser123 |
    | storemanager85  | UserUser123 |

  @FLTAPS-1202 @first
  Scenario Outline: User can mark the event with any colour
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select a car
    Then user can click add event button
    Then user can select event color

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |


