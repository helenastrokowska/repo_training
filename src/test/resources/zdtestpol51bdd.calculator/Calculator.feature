Feature: basic calculator function

  Scenario: adding two numbers
    Given I have a calculator
    When I add 2 and 3
    Then I should get 5

  Scenario: multiply two numbers
    Given I have a calculator
    When I multiply 2 by 3
    Then I should get 6

  Scenario: subtract first from second
    Given I have a calculator
    When I subtract 2 from 3
    Then I should get 1

  Scenario: divide first by second
    Given I have a calculator
    When  I divide 6 by 2
    Then I should get 3

  Scenario: rest from dividing
    Given I have a calculator
    When  I calculate rest from 5 by 2
    Then I should get 1




