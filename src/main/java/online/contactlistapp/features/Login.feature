Feature: Log in scenarios

  @TestRun
  Scenario Outline: Error message is displayed when invalid <attribute> is used

    Given The "https://thinking-tester-contact-list.herokuapp.com/login" link is accessed
    And the Login page is populated with following values:
      | <email>    |
      | <password> |
    When the login button is clicked
    When "submitButton" from "LoginPage" is clicked
    Then the following error message is displayed
      | Incorrect username or password |
    Examples:
      | attribute | email                  | password |
      | email     | invalidemail@gmail.com | any      |
      | password  | validemail@gmail.com   | invalid  |
      | email     | onlydots..             | valid    |