Feature: test cases for bank

  Scenario Outline: I can add user with name '' and pesel '' to bank
    Given I instantiate bank
    And I create user with name '<name>' and pesel '<pesel>'
    When I add user to bank
    Then User is present in bank
    Examples:
      | name              | pesel       |
      | Sławomir Mirosław | 12345678901 |
      | Baruch Maruch     | 09876543212 |
      | Степан Романов    | 98765434562 |
      | 김 치 삼 숭           | 92343434562 |

  Scenario: I cannot duplicate users
    Given I instantiate bank
    And I create user with name 'Noob Saibot' and pesel '087467893'
    When I add user to bank
    And I add user to bank
    Then Cannot add the same user to bank

  Scenario: I can create account for existing user
    Given I instantiate bank
    And I create user with name '<name>' and pesel '<pesel>'
    And I create account with name 'konto oszczędnościowe'
    When I add user to bank
    And I insert account to bank
    Then Account is present in bank

  Scenario: I cannot create account for non-existing user
    Given I instantiate bank
    And I create user with name '<name>' and pesel '<pesel>'
    And I create account with name 'konto oszczędnościowe'
    When I insert account to bank
    Then Account is not present in bank

  Scenario: I cannot duplicate account with the same name for the same user
    Given I instantiate bank
    And I create user with name '<name>' and pesel '<pesel>'
    And I create account with name 'konto oszczędnościowe'
    And I add user to bank
    When I insert account to bank
    And I insert account to bank
    Then User has only '1' account in bank

    Scenario: I can deposit some money to existong account
      Given I mock bank database for this case
      And I instantiate bank
      And I create user with name 'Eryk Rudy' and pesel '12345678764'
      And I create account with name 'Testowe Konto'
      When I add user to bank
      And I insert account to bank
      And I deposit '1000' to account with name "Testowe konto"
      Then Account with name "Testowe konto" has amount of '1000'
