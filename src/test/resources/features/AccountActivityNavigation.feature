Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in
    When the user is on the page

  Scenario: Savings account redirect
    And the user clicks on "Savings" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown's default option should be "Savings"

  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown's default option should be "Brokerage"

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown's default option should be "Checking"

    Scenario: Credit Card account redirect
      When the user clicks on "Credit Card" link on the Account Summary page
      Then "Account Activity" page should be displayed
      And Account dropdown's default option should be "Credit Card"

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account dropdown's default option should be "Loan"
