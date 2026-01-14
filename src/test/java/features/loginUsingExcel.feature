Feature: Login using Excel
  As a user I should be able to login to the app

#  @Smoke
#  Scenario Outline:  Login with invalid credentials
#  As a user I shouldn't be able to login using invalid username and/or password
#
#    Given I load test data from "TestData" "SauceDemoData" "<row>"
#    Given I am on the sauce demo login page
#    When I enter username
#    And I enter password
#    And I click on the login button
#    Then I should se the error message "<errorMessage>"
#
#    Examples:
#      | row | errorMessage                                                              |
#      | 1   | Epic sadface: Username and password do not match any user in this service |
#      | 2   | Epic sadface: Username and password do not match any user in this service |
#      | 3   | Epic sadface: Username and password do not match any user in this service |

  @Smoke
  Scenario Outline:  Login with invalid credentials
  As a user I shouldn't be able to login using invalid username and/or password

    Given I load test data from "TestData" "SauceDemoData" for "<tc_id>"
    Given I am on the sauce demo login page
    When I enter username
    And I enter password
    And I click on the login button
    Then I should se the error message "<errorMessage>"

    Examples:
      | tc_id   | errorMessage                                                              |
      | TC_0001 | Epic sadface: Username and password do not match any user in this service |
      | TC_0002 | Epic sadface: Username and password do not match any user in this service |
      | TC_0003 | Epic sadface: Username and password do not match any user in this service |