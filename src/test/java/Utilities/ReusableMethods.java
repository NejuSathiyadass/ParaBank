package Utilities;


import StepDefinition.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ReusableMethods {

    private static final Logger LOGGER = LogManager.getLogger(ReusableMethods.class);

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void launchBrowser() {
        try {
            switch (ConstantsUtils.BROWSER) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "IE":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }

    }

    public static void screenMaximize() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void takeScreenShot() {

        File screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(Hooks.getScenarioName()+".png"));
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public void highLightElement(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].setAttribute('style','border: 3px solid red')", element);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public void selectDropDown(WebElement element, String howTo, String value) {
        Select select = new Select(element);
        try {
            switch (howTo) {
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                case "text":
                    select.deselectByVisibleText(value);
                    break;
                default:
                    LOGGER.info("Please provide a valid selection. Selection are: Index, value, Text");
                    break;
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void closeBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void implicitlyWait() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

}
