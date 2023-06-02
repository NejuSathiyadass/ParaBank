Feature: Validating the functionalities in "Para Bank" application

  @Login
  Scenario: Validating Login functionality in Para Bank application
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validate's whether the ParaBank homepage is visible