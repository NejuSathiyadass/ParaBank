package StepDefinition;

import PageObjects.LoginPage;
import Utilities.ConstantsUtils;
import Utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login_StepDefinition {
    private static final Logger LOGGER = LogManager.getLogger(Login_StepDefinition.class);

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

    @Then("user validate's whether the ParaBank homepage is visible")
    public void user_validate_s_whether_the_para_bank_homepage_is_visible() {
        String url = ReusableMethods.getDriver().getCurrentUrl();
        if (url.contains("overview")) {
            LOGGER.info("Home page is visible");
        }
    }


}
