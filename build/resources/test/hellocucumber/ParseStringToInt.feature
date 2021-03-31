Feature: : Parse string type to int type

  @Success
  Scenario: Successful parse
    Given variable with type String 10
    When parse this variable to type Int
    Then variable with type Int 10

    @Error
    Scenario: Error parse
      Given variable with type String abc
      When parse this variable to type Int
      Then variable with type Int -1


