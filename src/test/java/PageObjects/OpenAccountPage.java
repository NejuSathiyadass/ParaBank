package PageObjects;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage {
    private static OpenAccountPage openAccountInstance;

    private OpenAccountPage() {
    }

    public static OpenAccountPage getInstance() {
        if (openAccountInstance == null) {
            openAccountInstance = new OpenAccountPage();
        }
        return openAccountInstance;
    }

    @FindBy(xpath = "//a[text()=\"Open New Account\"]")
    private WebElement openNewAccount;

    @FindBy(id = "type")
    public WebElement accountType;

    @FindBy(id = "fromAccountId")
    private WebElement selectAccount;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement openNewAccountButton;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement accountStatus;

    public void clickOpenNewAccountLink() {
        openNewAccount.click();
    }

    public void selectAccountType() {
        ReusableMethods.selectDropDown(accountType, "text", "SAVINGS");
    }

    public void sltAccount() {
        ReusableMethods.selectDropDown(selectAccount, "text", "13344");
    }

    public void clickOpenNewAccountButton() {
        openNewAccountButton.click();
    }

    public String verifyAccountStatus() {
        String actualValue;
        actualValue = accountStatus.getText();
        return actualValue;
    }


}
