package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateContactInfoPage {
    private static UpdateContactInfoPage updateContactInfoInstance;

    private UpdateContactInfoPage() {
    }

    public static UpdateContactInfoPage getInstance() {
        if (updateContactInfoInstance == null) {
            updateContactInfoInstance = new UpdateContactInfoPage();
        }
        return updateContactInfoInstance;
    }


    @FindBy(xpath = "//a[text()=\"Update Contact Info\"]")
    private WebElement updateContactInfoLink;

    @FindBy(id = "customer.phoneNumber")
    public static WebElement customerPhoneNumber;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement updateProfileButton;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement message;

    public void clickUpdateContactInfoLink() {
        updateContactInfoLink.click();
    }

    public void enterPhoneNumber(String number) {
        customerPhoneNumber.sendKeys(number);
    }

    public void clickUpdateProfileButton() {
        updateProfileButton.click();
    }

    public String successMessage() {
        String value;
        value = message.getText();
        return value;
    }


}
