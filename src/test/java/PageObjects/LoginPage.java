package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private static LoginPage loginInstance;

    private LoginPage() {
    }

    public static LoginPage getInstance() {
        if (loginInstance == null) {
            loginInstance = new LoginPage();
        }
        return loginInstance;
    }

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()=\"Log Out\"]")
    private WebElement logoutButton;


    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }


}
