Feature: Account summary page layout check

  Background:
    Given the user is logged in
    When the user is on the "Account Summary" page

  @wip
  Scenario: Check account types
    Then page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @wip
  Scenario: Check Credit Accounts table
    Then Credit Accounts table must have these columns
      | Account     |
      | Credit Card |
      | Balance     |