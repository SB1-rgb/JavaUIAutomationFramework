Feature: Registration flow

  Scenario: Successful registration of the user

    Given the Home Page is accessed
    And the Sign up button is clicked
    And the registration form is populated valid data
    When the Submit button is clicked
    Then user is successful registrated
    And user is redirected to Account Page


  Scenario: User is not registered when mandatory fields are not populated

    Given the Home Page is accessed
    And the Sign up button is clicked
    When the Submit button is clicked
    Then user remains on the Register page

