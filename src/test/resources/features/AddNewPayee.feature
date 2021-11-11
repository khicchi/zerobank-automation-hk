Feature: Add new payee under pay bills

  Background:
    Given the user is logged in
    When user navigates to the "Pay Bills" page
    And the user on the page

  Scenario: Add a new payee
    Given User navigates to "Add New Payee" tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." message should be displayed
