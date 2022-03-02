
Feature: Grid

  Background:
    Given the "sales manager" is on home page
    And the user navigates to "Fleet" "Vehicles"

  Scenario: Verify that the title Grid Settings is displayed
    When the user click the Grid button
    Then verify that the user should see Grid Settings title



  Scenario: verify that Grid Settings contain certain property options
    When the user click the Grid button
    Then verify that the user should see the following Grid Settings options
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |




  Scenario: verify that column names can be found by Quick Search box
    When the user click the Grid button
    And the user type "location" in Quick Search box
    Then verify that the search result gives "location" option



  Scenario: verify that column names can be found by Quick Search box
    When the user click the Grid button
    And the user click "Color" checkbox
    Then verify that the status of "Color" checkbox changed



  Scenario: verify that order of columns can be arranged by drag and drop
    When the user click the Grid button
    And the user drag "Model Year" box to "License Plate" box
    Then verify that "Model Year" columns order changed



  Scenario: verify that changes in grid settings are displayed in table structur
    When the user click the Grid button
    And the user click "Chassis Number" and "Doors Number"
    * the user drag "Color" box to "Tags" box
    Then verify that the labels order in Grid Settings is the same as the columns order in table