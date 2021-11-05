Feature: Only authorized users should be able to login to the application.

  @wip
  Scenario: Login as a user
    Given the user is on the login page
    When the user enters "username" as username and "password" as password
    Then the user should be able to login