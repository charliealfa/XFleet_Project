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
    And user clicks "Driver All" drop down
    And user clicks "Contains" drop down menu button
    Then list of methods should be displayed

  #@FLTAPS-1188
  #Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
    #Then user navigates to "Fleet" "Vehicles"
    #And user clicks "Filters" icon button
    #And user clicks "Manage filters" drop down menu
    #And user clicks "Driver" check box


  #@FLTAPS-1190
  #Scenario: "Driver" filter should provide the methods
    #And user clicks "Driver All" drop down
    #And user clicks "Contains" drop down menu button
    #Then list of methods should be displayed


  #@FLTAPS-1191
  #Scenario: "Contains" method testing
    #Given user inputs "Miss" into text box
    #When user clicks "Update" button
    #Then results with "Miss" are displayed only

  @Methods
  Scenario: Methods click test
    Given user clicks methodsList drop down menu list

  @nonAlphabeticCharactersTesting
  Scenario: none of methods should not accept non alphabetic characters
    Given user clicks checks non alphabetic characters







