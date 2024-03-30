package PageObjects;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferFundsPage {
    private static TransferFundsPage transferFundsInstance;

    private TransferFundsPage() {
    }

    public static TransferFundsPage getInstance() {
        if (transferFundsInstance == null) {
            transferFundsInstance = new TransferFundsPage();
        }
        return transferFundsInstance;
    }

    @FindBy(xpath = "//a[text()=\"Transfer Funds\"]")
    private WebElement transferFundsLink;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccount;

    @FindBy(id = "toAccountId")
    private WebElement toAccount;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement transferButton;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement message;

    public void clickTransferFundsLink() {
        transferFundsLink.click();
    }

    public void amountTextBox(String amt) {
        amount.sendKeys(amt);
    }

    public void selectFromAccount() {
        ReusableMethods.selectDropDown(fromAccount, "text", "13344");
    }

    public void selectToAccount() {
        ReusableMethods.selectDropDown(toAccount, "text", "14565");
    }

    public void clickTransferButton() {
        transferButton.click();
    }

    public String successMessage() {
        String value;
        value = message.getText();
        return value;
    }


}
