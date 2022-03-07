@FLTAPS-1133
@US-011DriverFilter
Feature: user should be able to use the "Driver" filter under the Fleet-Vehicles page


  Background: login as driver
    Given user is on the login page
    When user logged with "user1" "UserUser123"
    Then user navigates to "Fleet" "Vehicles"
    And user clicks "Filters" icon button
    And user clicks "Manage filters" drop down menu
    And user clicks "Driver" check box

  #@FLTAPS-1188
  #Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
    #Then user navigates to "Fleet" "Vehicles"
    #And user clicks "Filters" icon button
    #And user clicks "Manage filters" drop down menu
    #And user clicks "Driver" check box


  @o @FLTAPS-1190
  Scenario: "Driver" filter should provide the methods
    And user clicks "Driver All" drop down
    And user clicks "Contains" drop down menu button
    Then list of methods should be displayed


