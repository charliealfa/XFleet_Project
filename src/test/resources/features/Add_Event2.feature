Feature: Add_Event2


  @FLTAPS-1136 @first
  Scenario Outline: As a store manager and sales manager can be able to access the "Add Event" page
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    Then user should display add event button

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |

  @FLTAPS-1201 @first
  Scenario Outline: Add Event should open as a pop up
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    And user can click add event button
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
    Then user should select any car or row
    And user can click add event button
    Then user can select event color

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |

  @FLTAPS-1204 @first
  Scenario Outline: Time boxes will disappear after clicking "All-day-event" check box
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    And user can click add event button
    Then user select All-day-event checkbox
    Then time boxes will disappear

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |

  @FLTAPS-1206 @first
  Scenario Outline: Repeat options should select the options below (repeats dropdown menu)
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    And user can click add event button
    Then Repeats should include the options

      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |

    @FLTAPS-1207 @first
  Scenario Outline: Ending options should be as below -> "Never"-> "After"-> "By" and clickable
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    And user can click add event button
    Then Ending options should be clickable

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |

  @FLTAPS-1208 @first
  Scenario Outline: All Users can see all events on the General information page
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then user should select any car or row
    And user can click add event button
    Then user create An Event after clicking Save then All created events should be appear

    Examples:
      | username        | password    |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |



