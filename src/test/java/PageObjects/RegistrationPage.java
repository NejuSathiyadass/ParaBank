package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    private static RegistrationPage registrationInstance;

    private RegistrationPage() {
    }

    public static RegistrationPage getInstance() {
        if (registrationInstance == null) {
            registrationInstance = new RegistrationPage();
        }
        return registrationInstance;
    }

    @FindBy(xpath = "//a[text()=\"Register\"]")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement ssnNumber;

    @FindBy(id = "customer.username")
    private WebElement userName;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@value=\"Register\"]")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@class=\"title\"]//following-sibling::p")
    private WebElement registrationSuccessMessage;

    public void clickRegistrationLink() {
        registerLink.click();
    }

    public void enterFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void enterAddress(String customerAddress) {
        address.sendKeys(customerAddress);
    }

    public void enterCity(String customerCity) {
        city.sendKeys(customerCity);
    }

    public void enterState(String customerState) {
        state.sendKeys(customerState);
    }

    public void enterZipCode(String customerZipCode) {
        zipCode.sendKeys(customerZipCode);
    }

    public void enterPhoneNumber(String customerPhoneNumber) {
        phoneNumber.sendKeys(customerPhoneNumber);
    }

    public void enterSsnNumber(String customerSsnNumber) {
        ssnNumber.sendKeys(customerSsnNumber);
    }

    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterConfirmPassword(String confirm_password) {
        confirmPassword.sendKeys(confirm_password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String successMessage() {
        String value;
        value = registrationSuccessMessage.getText();
        return value;
    }


}
