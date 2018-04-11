Feature:

  Scenario: I can calculate null number
    Given I initialize stringCalculator
    And I pass null value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario Outline: I can calculate multiple numbers
    Given I initialize stringCalculator
    And I pass '<value>' value
    When I trigger calculate function
    Then I get <result> as a result
    Examples:
      | value        | result |
      | 3;4;7        | 14     |
      | 5            | 5      |
      | 5;5          | 10     |
      |              | 0      |
      | 23; 45; 7  ; | 75     |
