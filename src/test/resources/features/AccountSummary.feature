Feature: Account summary page layout check

  Background:
    Given the user is logged in
    When the user is on the "Account Summary" page

  Scenario: Verify title
    Then page should have the title "Zero – Account summary"


  Scenario: Verify account types
    Then page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Verify Credit Accounts table headers
    Then Credit Accounts table must have these columns
      | Account     |
      | Credit Card |
      | Balance     |