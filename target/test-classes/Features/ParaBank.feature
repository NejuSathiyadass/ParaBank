Feature: Validating the functionalities in "Para Bank" application

  @ParaBank_TC_01 @Registration @ParaBank
  Scenario: Validate whether the user can successfully register in para bank application
    Given user is on the login page of ParaBank application
    When user clicks on register button
    And enters all the user details
    Then clicks on register
    And I verify whether registration is successfully completed


  @ParaBank_TC_02 @Login @ParaBank
  Scenario: Validate whether the user can able to login successfully
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible


  @ParaBank_TC_03 @OpenAccount @ParaBank
  Scenario: Validate whether the user can able to Open the Account successfully
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    Then user navigates to open new account page
    And validates the type of accounts
    And user selects the account type
    And user clicks on open new account button
    Then user validates whether new account is created successfully


  @ParaBank_TC_04 @AccountOverview @ParaBank
  Scenario: Validate whether the user can view the account overview page
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to account overview page
    Then user validates whether the account overview page is displayed


  @ParaBank_TC_05 @TransferFunds @ParaBank
  Scenario: Validate whether the user can able to transfer funds successfully
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to transfer funds page
    And enters the amount which needs to be transferred
    And user selects transfer fund from account and transfer to account
    Then clicks on transfer button
    And user validates whether the fund is transferred successfully


  @ParaBank_TC_06 @BillPay @ParaBank
  Scenario: Validate whether the user can able to pay bill successfully
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to bill pay page
    And user enters the payee details
    And enters the amount
    And user selects the account
    And clicks on send payment button
    Then user validates whether the bill is paid successfully


  @ParaBank_TC_07 @FindTransactions @ParaBank
  Scenario: Validate whether the user can able to find the transactions done within a date range
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to find transactions page
    And user selects the account for which transactions should be shown
    And user enters the from date and to date
    And clicks on find transactions button
    Then user validated whether the transactions between the date range is displayed


  @ParaBank_TC_08 @UpdateContactInfo @ParaBank
  Scenario: Validate whether the user can able to update the contact information
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to update contact information page
    And user enters the contact details which needs to be updated
    And clicks on update profile button
    Then user validates whether the contact information is updated successfully


  @ParaBank_TC_09 @RequestLoan @ParaBank
  Scenario: Validate whether the user can able to request a loan
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user navigates to request loan page
    And user enters the loan amount
    And user enters the down payment amount
    And user selects the account from which loan needs to be requested
    And clicks on apply now button
    Then validates whether the user can request a loan successfully


  @ParaBank_TC_10 @Logout @ParaBank
  Scenario: Validate whether the user can able to logout from the application
    Given user is on the login page of ParaBank application
    When user enters the username and password
    And clicks on login button
    Then user validates whether the ParaBank homepage is visible
    And user clicks on logout button
    And user validates whether the application is logout