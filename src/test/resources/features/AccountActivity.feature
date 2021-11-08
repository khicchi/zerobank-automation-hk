Feature: Account activity page layout check

  Background:
    Given the user is logged in
    When user navigates to the "Account Activity" page

  Scenario: Verify title
    Then page should have the title "Zero - Account activity"

  Scenario: Verify account dropdown control default option
    Then Account dropdown's default option should be "Savings"

  Scenario: Verify account dropdown control options
    Then Account dropdown should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Verify Transaction table column names
    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |