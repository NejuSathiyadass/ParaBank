package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOverviewPage {
    private static AccountOverviewPage accountOverviewInstance;

    private AccountOverviewPage() {
    }

    public static AccountOverviewPage getInstance() {
        if (accountOverviewInstance == null) {
            accountOverviewInstance = new AccountOverviewPage();
        }
        return accountOverviewInstance;
    }


    @FindBy(xpath = "//a[text()=\"Accounts Overview\"]")
    private WebElement accountOverviewLink;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement title;


    public void clickAccountOverviewLink() {
        accountOverviewLink.click();
    }

    public String titleMessage() {
        String value;
        value = title.getText();
        return value;
    }


}
