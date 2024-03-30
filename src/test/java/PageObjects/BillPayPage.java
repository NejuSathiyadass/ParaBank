package PageObjects;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillPayPage {
    private static BillPayPage billPayInstance;

    private BillPayPage() {
    }

    public static BillPayPage getInstance() {
        if (billPayInstance == null) {
            billPayInstance = new BillPayPage();
        }
        return billPayInstance;
    }

    @FindBy(xpath = "//a[text()=\"Bill Pay\"]")
    private WebElement billPayLink;

    @FindBy(name = "payee.name")
    private WebElement payeeName;

    @FindBy(name = "payee.address.street")
    private WebElement payeeAddress;

    @FindBy(name = "payee.address.city")
    private WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    private WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    private WebElement payeeZipCode;

    @FindBy(name = "payee.phoneNumber")
    private WebElement payeePhoneNumber;

    @FindBy(name = "payee.accountNumber")
    private WebElement payeeAccountNumber;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccountNumber;

    @FindBy(name = "amount")
    private WebElement amount;

    @FindBy(name = "fromAccountId")
    private WebElement selectAccount;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement sendPaymentButton;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement message;

    public void clickBillPayLink() {
        billPayLink.click();
    }

    public void enterPayeeName(String name) {
        payeeName.sendKeys(name);
    }

    public void enterPayeeAddress(String address) {
        payeeAddress.sendKeys(address);
    }

    public void enterPayeeCity(String city) {
        payeeCity.sendKeys(city);
    }

    public void enterPayeeState(String state) {
        payeeState.sendKeys(state);
    }

    public void enterPayeeZipCode(String zipCode) {
        payeeZipCode.sendKeys(zipCode);
    }

    public void enterPayeePhoneNumber(String phoneNumber) {
        payeePhoneNumber.sendKeys(phoneNumber);
    }

    public void enterPayeeAccountNumber(String accountNumber) {
        payeeAccountNumber.sendKeys(accountNumber);
    }

    public void enterPayeeVerifyAccountNumber(String accountNumber) {
        verifyAccountNumber.sendKeys(accountNumber);
    }

    public void enterAmount(String amt) {
        amount.sendKeys(amt);
    }

    public void selectAccountNumber() {
        ReusableMethods.selectDropDown(selectAccount, "text", "13344");
    }

    public void clickSendPaymentButton() {
        sendPaymentButton.click();
    }

    public String successMessage() {
        String value;
        value = message.getText();
        return value;
    }


}
