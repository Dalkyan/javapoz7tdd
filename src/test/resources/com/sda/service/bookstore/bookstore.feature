Feature: test cases for bookstore
  Scenario: I can add a book to bookstore
    Given I instantiate bookstore
    And I create a book
    When I add book to bookstore
    Then Book is present in bookstore

  Scenario: I can update book's title in a bookstore
    Given I instantiate bookstore
    And I create a book
    When I add book to bookstore
    And I update book's title
    Then Book's title in bookstore is updated