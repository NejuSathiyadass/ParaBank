package StepDefinition;

import PageObjects.*;
import Utilities.ConstantsUtils;
import Utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class ParaBank_StepDefinition {

    private static final Logger LOGGER = LogManager.getLogger(ParaBank_StepDefinition.class);

    @Given("user is on the login page of ParaBank application")
    public void user_is_on_the_login_page_of_para_bank_application() {
        ReusableMethods.getDriver().get(ConstantsUtils.APP_URL);
    }

    @When("user enters the username and password")
    public void user_enters_the_username_and_password() {
        LoginPage.getInstance().enterUserName(ConstantsUtils.USERNAME);
        LoginPage.getInstance().enterPassword(ConstantsUtils.PASSWORD);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        LoginPage.getInstance().clickLoginButton();
    }

    @Then("user validates whether the ParaBank homepage is visible")
    public void user_validate_s_whether_the_para_bank_homepage_is_visible() {
        String url = ReusableMethods.getDriver().getCurrentUrl();
        if (url.contains("overview")) {
            LOGGER.info("Home page is visible!!");
        }
    }

    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        RegistrationPage.getInstance().clickRegistrationLink();
    }

    @When("enters all the user details")
    public void enters_all_the_user_details() {
        String firstname = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "first_name");
        String lastname = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "last_name");
        String address = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "home_address");
        String city = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "home_city");
        String state = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "home_state");
        String zipcode = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "home_zipcode");
        String phonenumber = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "phone_number");
        String ssnnumber = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "ssn_number");
        String username = ReusableMethods.generateRandomUserName(9);
        String pass = ReusableMethods.readDataFromExcel(ConstantsUtils.REGISTRATION_DATA, "password");
        RegistrationPage.getInstance().enterFirstName(firstname);
        RegistrationPage.getInstance().enterLastName(lastname);
        RegistrationPage.getInstance().enterAddress(address);
        RegistrationPage.getInstance().enterCity(city);
        RegistrationPage.getInstance().enterState(state);
        RegistrationPage.getInstance().enterZipCode(zipcode);
        RegistrationPage.getInstance().enterPhoneNumber(phonenumber);
        RegistrationPage.getInstance().enterSsnNumber(ssnnumber);
        RegistrationPage.getInstance().enterUserName(username);
        RegistrationPage.getInstance().enterPassword(pass);
        RegistrationPage.getInstance().enterConfirmPassword(pass);
    }

    @Then("clicks on register")
    public void clicks_on_register() {
        RegistrationPage.getInstance().clickRegisterButton();
    }

    @Then("I verify whether registration is successfully completed")
    public void i_verify_whether_registration_is_successfully_completed() {
        String message = RegistrationPage.getInstance().successMessage();
        Assert.assertEquals("Your account was created successfully. You are now logged in.", message);
        LOGGER.info("Para Bank account registered successfully!!");
    }

    @Then("user navigates to open new account page")
    public void user_navigates_to_account_page() {
        OpenAccountPage.getInstance().clickOpenNewAccountLink();
    }

    @Then("validates the type of accounts")
    public void validates_the_type_of_accounts() {
        ReusableMethods.dropDownContains(OpenAccountPage.getInstance().accountType, "CHECKING");
        ReusableMethods.dropDownContains(OpenAccountPage.getInstance().accountType, "SAVINGS");
    }

    @Then("user selects the account type")
    public void user_selects_the_account_type() {
        ReusableMethods.wait("5000");
        OpenAccountPage.getInstance().selectAccountType();
        OpenAccountPage.getInstance().sltAccount();
    }

    @Then("user clicks on open new account button")
    public void user_clicks_on_open_new_account_button() {
        OpenAccountPage.getInstance().clickOpenNewAccountButton();
    }

    @Then("user validates whether new account is created successfully")
    public void user_validates_whether_new_account_is_created_successfully() {
        ReusableMethods.wait("5000");
        String message = OpenAccountPage.getInstance().verifyAccountStatus();
        Assert.assertEquals("Account Opened!", message);
        LOGGER.info("New account is created successfully!!");
    }

    @Then("user navigates to account overview page")
    public void user_navigates_to_account_overview_page() {
        AccountOverviewPage.getInstance().clickAccountOverviewLink();
    }

    @Then("user validates whether the account overview page is displayed")
    public void user_validates_whether_the_account_overview_page_is_displayed() {
        String pageName = AccountOverviewPage.getInstance().titleMessage();
        Assert.assertEquals("Accounts Overview", pageName);
    }

    @Then("user navigates to transfer funds page")
    public void user_navigates_to_transfer_funds_page() {
        TransferFundsPage.getInstance().clickTransferFundsLink();
    }

    @Then("enters the amount which needs to be transferred")
    public void enters_the_amount_which_needs_to_be_transferred() {
        ReusableMethods.wait("5000");
        TransferFundsPage.getInstance().amountTextBox("5");
    }

    @Then("user selects transfer fund from account and transfer to account")
    public void user_selects_transfer_fund_from_account_and_transfer_to_account() {
        ReusableMethods.wait("5000");
        TransferFundsPage.getInstance().selectFromAccount();
        TransferFundsPage.getInstance().selectToAccount();
    }

    @Then("clicks on transfer button")
    public void clicks_on_transfer_button() {
        TransferFundsPage.getInstance().clickTransferButton();
    }

    @Then("user validates whether the fund is transferred successfully")
    public void user_validates_whether_the_fund_is_transferred_successfully() {
        ReusableMethods.wait("5000");
        String message = TransferFundsPage.getInstance().successMessage();
        Assert.assertEquals("Transfer Complete!", message);
        LOGGER.info("Fund transferred successfully!!");
    }

    @Then("user navigates to bill pay page")
    public void user_navigates_to_bill_pay_page() {
        BillPayPage.getInstance().clickBillPayLink();
    }

    @Then("user enters the payee details")
    public void user_enters_the_payee_details() {
        BillPayPage.getInstance().enterPayeeName(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_name"));
        BillPayPage.getInstance().enterPayeeAddress(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_address"));
        BillPayPage.getInstance().enterPayeeCity(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_city"));
        BillPayPage.getInstance().enterPayeeState(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_state"));
        BillPayPage.getInstance().enterPayeeZipCode(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_zipcode"));
        BillPayPage.getInstance().enterPayeePhoneNumber(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_phone_number"));
        BillPayPage.getInstance().enterPayeeAccountNumber(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_account_number"));
        BillPayPage.getInstance().enterPayeeVerifyAccountNumber(ReusableMethods.readDataFromExcel(ConstantsUtils.PAYEE_DETAILS_DATA, "payee_account_number"));
    }

    @Then("enters the amount")
    public void enters_the_amount() {
        BillPayPage.getInstance().enterAmount("10");
    }

    @Then("user selects the account")
    public void user_selects_the_account() {
        ReusableMethods.wait("5000");
        BillPayPage.getInstance().selectAccountNumber();
    }

    @Then("clicks on send payment button")
    public void clicks_on_send_payment_button() {
        BillPayPage.getInstance().clickSendPaymentButton();
    }

    @Then("user validates whether the bill is paid successfully")
    public void user_validates_whether_the_bill_is_paid_successfully() {
        ReusableMethods.wait("5000");
        String message = BillPayPage.getInstance().successMessage();
        Assert.assertEquals("Bill Payment Complete", message);
    }

    @Then("user navigates to find transactions page")
    public void user_navigates_to_find_transactions_page() {
        FindTransactionsPage.getInstance().clickFindTransactionLink();
    }

    @Then("user selects the account for which transactions should be shown")
    public void user_selects_the_account_for_which_transactions_should_be_shown() {
        ReusableMethods.wait("5000");
        FindTransactionsPage.getInstance().sltAccount();
    }

    @Then("user enters the from date and to date")
    public void user_enters_the_from_date_and_to_date() {
        FindTransactionsPage.getInstance().enterFromDate("01/01/2024");
        FindTransactionsPage.getInstance().enterToDate("31/03/2024");
    }

    @Then("clicks on find transactions button")
    public void clicks_on_find_transactions_button() {
        FindTransactionsPage.getInstance().clickFindTransactionsButton();
    }

    @Then("user validated whether the transactions between the date range is displayed")
    public void user_validated_whether_the_transactions_between_the_date_range_is_displayed() {
        ReusableMethods.wait("5000");
        String url = ReusableMethods.getDriver().getCurrentUrl();
        if (url.contains("findtrans")) {
            LOGGER.info("Transactions is displayed!!");
        }
    }

    @Then("user navigates to update contact information page")
    public void user_navigates_to_update_contact_information_page() {
        UpdateContactInfoPage.getInstance().clickUpdateContactInfoLink();
    }

    @Then("user enters the contact details which needs to be updated")
    public void user_enters_the_contact_details_which_needs_to_be_updated() {
        ReusableMethods.wait("5000");
        UpdateContactInfoPage.customerPhoneNumber.clear();
        UpdateContactInfoPage.getInstance().enterPhoneNumber("310-447-4121");
    }

    @Then("clicks on update profile button")
    public void clicks_on_update_profile_button() {
        UpdateContactInfoPage.getInstance().clickUpdateProfileButton();
    }

    @Then("user validates whether the contact information is updated successfully")
    public void user_validates_whether_the_contact_information_is_updated_successfully() {
        ReusableMethods.wait("5000");
        String message = UpdateContactInfoPage.getInstance().successMessage();
        Assert.assertEquals("Profile Updated", message);
        LOGGER.info("Contact is updated successfully!!");
    }

    @Then("user navigates to request loan page")
    public void user_navigates_to_request_loan_page() {
        RequestLoanPage.getInstance().clickRequestLoanLink();
    }

    @Then("user enters the loan amount")
    public void user_enters_the_loan_amount() {
        RequestLoanPage.getInstance().enterLoanAmount("100");
    }

    @Then("user enters the down payment amount")
    public void user_enters_the_down_payment_amount() {
        RequestLoanPage.getInstance().enterDownPayment("5");
    }

    @Then("user selects the account from which loan needs to be requested")
    public void user_selects_the_account_from_which_loan_needs_to_be_requested() {
        ReusableMethods.wait("5000");
        RequestLoanPage.getInstance().sltAccount();
    }

    @Then("clicks on apply now button")
    public void clicks_on_apply_now_button() {
        RequestLoanPage.getInstance().clickApplyNowButton();
    }

    @Then("validates whether the user can request a loan successfully")
    public void validates_whether_the_user_can_request_a_loan_successfully() {
        ReusableMethods.wait("5000");
        String message = RequestLoanPage.getInstance().successMessage();
        Assert.assertEquals("Loan Request Processed", message);
        LOGGER.info("Loan requested successfully!!");
    }

    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        LoginPage.getInstance().clickLogoutButton();
    }

    @Then("user validates whether the application is logout")
    public void user_validates_whether_the_application_is_logout() {
        String url = ReusableMethods.getDriver().getCurrentUrl();
        if (url.contains("index")) {
            LOGGER.info("Logout from parabank application!!");
        }
    }

}
