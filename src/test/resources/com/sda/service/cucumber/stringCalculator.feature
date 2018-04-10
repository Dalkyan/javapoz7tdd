Feature:
  Scenario: I can calculate single number
    Given I initialize stringCalculator
    And I pass single number value
    When I trigger calculate function
    Then I get 5 as a result

  Scenario: I can calculate null number
    Given I initialize stringCalculator
    And I pass null value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate empty string
    Given I initialize stringCalculator
    And I pass empty string
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate empty string
    Given I initialize stringCalculator
    And I pass empty string
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate two numbers
    Given I initialize stringCalculator
    And I pass two numbers
    When I trigger calculate function
    Then I get 10 as a result

  Scenario: I can calculate multiple numbers
    Given I initialize stringCalculator
    And I pass multiple numbers
    When I trigger calculate function
    Then I get 10 as a result

  Scenario: I can calculate multiple numbers with whitespaces
    Given I initialize stringCalculator
    And I pass multiple numbers with whitespaces
    When I trigger calculate function
    Then I get 10 as a result