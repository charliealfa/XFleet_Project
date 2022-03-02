@wip
Feature: As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page

  # 1- User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
  Scenario Outline: View Per Page button options feature
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    And view per page dropdown should have the following options:
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
#      | storemanager85  | UserUser123 | Dashboard |

  # 2- The value of 'View Per Page' should be '25' by default
  Scenario Outline: View Per Page Dropdown Default Value feature
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    # 2- The value of 'View Per Page' should be '25' by default
    And view per page default value should be "25"
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
#      | storemanager85  | UserUser123 | Dashboard |

  # 3- 'View Per Page' includes the values shown as below and the user can select each of them:
#  Scenario Outline: View Per Page DropDown Options
#    Given the user is on the login page
#    When the user logged with "<username>" "<password>"
#    Then the pageTitle should be "<title>"
#    And user navigate to the "Fleet" "Vehicles" page
#    Then user should see the "All Cars" page
#    # 3- 'View Per Page' includes the values shown as below and the user can select each of them:
#    And view per page dropdown should have the following options:
#      | 10  |
#      | 25  |
#      | 50  |
#      | 100 |
#    Then user select each following options one by one and verify the records displayed
#      | 10  |
#      | 25  |
#      | 50  |
#      | 100 |
#    Examples:
#      | username        | password    | title     |
#      | salesmanager120 | UserUser123 | Dashboard |
#      | storemanager85  | UserUser123 | Dashboard |


  # 4- User can sort a column in ascending or descending order by clicking the column name
#  Scenario Outline: All Cars Page Table Sorting Feature
#    Given the user is on the login page
#    When the user logged with "<username>" "<password>"
#    Then the pageTitle should be "<title>"
#    And user navigate to the "Fleet" "Vehicles" page
#    Then user should see the "All Cars" page
#    Examples:
#      | username        | password    | title     |
#      | salesmanager120 | UserUser123 | Dashboard |
#      | storemanager85  | UserUser123 | Dashboard |



# 5- User can remove all sorting and filtering on the page by using the reset button
#  Scenario Outline: All Cars Page Table Sorting Feature
#    Given the user is on the login page
#    When the user logged with "<username>" "<password>"
#    Then the pageTitle should be "<title>"
#    And user navigate to the "Fleet" "Vehicles" page
#    Then user should see the "All Cars" page
#    And user click on the reset button
#    Then user should see table as like before
#    Examples:
#      | username        | password    | title     |
#      | salesmanager120 | UserUser123 | Dashboard |
#      | storemanager85  | UserUser123 | Dashboard |