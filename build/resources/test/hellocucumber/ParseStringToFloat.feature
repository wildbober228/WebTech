Feature: : Parse string type to Float type

  @Success
  Scenario: Successful parse String to Float
    Given variables with type String 10.0
    When parse this variable to type Float
    Then variable with type Float 10.0

  @Error
  Scenario: Error parse String to Float
    Given variable with type String abccsd
    When parse this variable to type Float
    Then variable with type Float -1