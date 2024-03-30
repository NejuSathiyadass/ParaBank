package PageObjects;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestLoanPage {
    private static RequestLoanPage requestLoanInstance;

    private RequestLoanPage() {
    }

    public static RequestLoanPage getInstance() {
        if (requestLoanInstance == null) {
            requestLoanInstance = new RequestLoanPage();
        }
        return requestLoanInstance;
    }


    @FindBy(xpath = "//a[text()=\"Request Loan\"]")
    private WebElement requestLoanLink;

    @FindBy(id = "amount")
    private WebElement loanAmount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(id = "fromAccountId")
    private WebElement selectAccount;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement applyNowButton;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement message;


    public void clickRequestLoanLink() {
        requestLoanLink.click();
    }

    public void enterLoanAmount(String amount) {
        loanAmount.sendKeys(amount);
    }

    public void enterDownPayment(String amount) {
        downPayment.sendKeys(amount);
    }

    public void sltAccount() {
        ReusableMethods.selectDropDown(selectAccount, "text", "13344");
    }

    public void clickApplyNowButton() {
        applyNowButton.click();
    }

    public String successMessage() {
        String value;
        value = message.getText();
        return value;
    }


}
