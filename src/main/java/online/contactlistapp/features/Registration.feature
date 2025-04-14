Feature: Registration flow


  Background:
    Given the Home Page is accessed
    And the Sign up button is clicked

  Scenario: Successful registration of the user

    And the registration form is populated valid data
    When the Submit button is clicked
    Then user is successful registrated
    And user is redirected to Account Page


  Scenario: User is not registered when mandatory fields are not populated

    When the Submit button is clicked
    Then user remains on the Register page

  @ErrorMesssage
  Scenario Outline:Error message is displayed when firstName is too long

    And the register form is populated with following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | invalid     |
      | password  | random      |
    When the Submit button is clicked
    Then the following error message is displayed
      | User validation failed: <affectedField>: Path `<affectedField>` (`fffffffffffffffffffffffffffff`) is longer than the maximum allowed length (20). |
    Examples:
      | affectedField | firstName                     | lastName                      |
      | firstName     | fffffffffffffffffffffffffffff | random                        |
      | lastName      | random                        | fffffffffffffffffffffffffffff |






