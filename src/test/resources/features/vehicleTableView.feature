

Feature: As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page


  Scenario Outline: All user types can see all vehicle information under 'Fleet-Vehicles' module

    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then verify that user should see Table Headers and information

      | LICENSE PLATE        |
      | TAGS                 |
      | DRIVER               |
      | LOCATION             |
      | CHASSIS NUMBER       |
      | MODEL YEAR           |
      | LAST ODOMETER        |
      | IMMATRICULATION DATE |
      | FIRST CONTRACT DATE  |
      | CVVI                 |
      | SEATS NUMBER         |
      | DOORS NUMBER         |
      | COLOR                |
      | TRANSMISSION         |
      | FUEL TYPE            |
      | CO2 EMISSIONS        |


    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |


  @wip
    Scenario Outline:  User can see the total page number
      Given the user is on the login page
      When the user logged with "<username>" "<password>"
      And the user navigates to "Fleet" "Vehicles"
      Then the user should see the total page number
      Examples:
        | username        | password    |
        | user10          | UserUser123 |
        | salesmanager127 | UserUser123 |
        | storemanager100 | UserUser123 |