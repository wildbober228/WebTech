Feature: : Parse string type to Date type

  @Success
  Scenario: Successful parse String to Date
    Given variables with type String 2020-12-22
    When parse this variable to type Date
    Then variable with type Float 2020-12-22

  @Error
  Scenario: Error parse String to Date
    Given variable with type String 202djd
    When parse this variable to type Date
    Then variable with type Date null