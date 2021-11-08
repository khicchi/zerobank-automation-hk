Feature: Pay Bills page layout check

  Background:
    Given the user is logged in
    When user navigates to the "Pay Bills" page
    And the user on the page

  Scenario: Verify title
    Then page should have the title "Zero - Pay Bills"


  Scenario: Successful Pay operation without description
      And the user enters amount
      And the user enters date
      And the user leaves description blank
      And the user clicks Pay button
      Then "The payment was successfully submitted." message should be displayed.

  Scenario: Successful Pay operation with description
    And the user enters amount
    And the user enters date
    And the user enters description
    And the user clicks Pay button
    Then "The payment was successfully submitted." message should be displayed.

  Scenario: Unsuccessful Pay operation without amount
    And the user enters date
    And the user clicks Pay button
    Then "Please fill out this field." warning message should be displayed for "amount".

  Scenario: Unsuccessful Pay operation without date
    And the user enters amount
    And the user clicks Pay button
    Then "Please fill out this field." warning message should be displayed for "date".

  Scenario Outline: Verify Amount field does not accept alphabetical characters
    And the user enters "<non-numeric characters>" as amount
    And the user enters date
    And the user clicks Pay button
    Then Amount field should not accept non-numeric characters

    Examples:
    |non-numeric characters|
    |d20                   |
    |*,.                   |


  Scenario Outline: Verify Date field does not accept alphabetical characters
    And the user enters "<alphabetical characters>" as date
    #And the user enters amount
    #And the user clicks Pay button
    Then Date field should not accept alphabetical characters

    Examples:
      |alphabetical characters|
      |d20                   |
      |*,.                   |