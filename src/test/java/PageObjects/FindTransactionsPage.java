package PageObjects;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindTransactionsPage {
    private static FindTransactionsPage findTransactionInstance;

    private FindTransactionsPage() {
    }

    public static FindTransactionsPage getInstance() {
        if (findTransactionInstance == null) {
            findTransactionInstance = new FindTransactionsPage();
        }
        return findTransactionInstance;
    }

    @FindBy(xpath = "//a[text()=\"Find Transactions\"]")
    private WebElement findTransactionLink;

    @FindBy(id = "accountId")
    private WebElement selectAccount;

    @FindBy(id = "criteria.fromDate")
    private WebElement fromDate;

    @FindBy(id = "criteria.toDate")
    private WebElement toDate;

    @FindBy(xpath = "(//button[@type=\"submit\"])[3]")
    private WebElement findTransactionsButton;


    public void clickFindTransactionLink() {
        findTransactionLink.click();
    }

    public void sltAccount() {
        ReusableMethods.selectDropDown(selectAccount, "text", "13344");
    }

    public void enterFromDate(String date) {
        fromDate.sendKeys(date);
    }

    public void enterToDate(String date) {
        toDate.sendKeys(date);
    }

    public void clickFindTransactionsButton() {
        findTransactionsButton.click();
    }


}
