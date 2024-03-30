package Utilities;


import StepDefinition.Hooks;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
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
                    System.setProperty("webdriver.chrome.driver", ConstantsUtils.CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                case "IE":
                    System.setProperty("webdriver.ie.driver", ConstantsUtils.IE_DRIVER_PATH);
                    driver = new InternetExplorerDriver();
                    break;
                case "Edge":
                    System.setProperty("webdriver.edge.driver", ConstantsUtils.EDGE_DRIVER_PATH);
                    driver = new EdgeDriver();
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", ConstantsUtils.FIREFOX_DRIVER_PATH);
                    driver = new FirefoxDriver();
                    break;
                default:
                    LOGGER.info("Please provide a valid browser info to start the execution");
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
        String folderPath = "Screenshots";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String filePath = folderPath + File.separator + Hooks.getScenarioName() + ".png";
        try {
            FileUtils.copyFile(screenShot, new File(filePath));
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }


    public static void highLightElement(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].setAttribute('style','border: 3px solid red')", element);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }


    public static void selectDropDown(WebElement element, String howTo, String value) {
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


    public static void dropDownContains(WebElement element, String value) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        boolean isValuePresent = false;
        try {
            for (WebElement option : options) {
                if (option.getText().equals(value)) {
                    isValuePresent = true;
                    break;
                }
            }
            if (isValuePresent) {
                System.out.println("The value '" + value + "' is present in the dropdown.");
            } else {
                System.out.println("The value '" + value + "' is not present in the dropdown.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void tearDown() {
        try {
            driver.quit();
            driver = null;
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


    public static void implicitlyWait(int secondsTime) {
        try {
            driver.manage().timeouts().implicitlyWait(secondsTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void deleteCookies() {
        try {
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }


    public static String readDataFromExcel(String sheetName, String variableName) {
        try {
            FileInputStream file = new FileInputStream(new File(ConstantsUtils.EXCEL_DATA_PATH));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int columnIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null && cell.getStringCellValue().equals(variableName)) {
                    columnIndex = i;
                    break;
                }
            }
            if (columnIndex != -1) {
                Row dataRow = sheet.getRow(1);
                Cell cell = dataRow.getCell(columnIndex);

                if (cell != null) {
                    return cell.toString();
                } else {
                    return "Cell with variable name not found!";
                }
            } else {
                return "Variable name not found in the sheet!";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String generateRandomUserName(int length) {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder usernameBuilder = new StringBuilder();
        try {
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(allowedChars.length());
                usernameBuilder.append(allowedChars.charAt(randomIndex));
            }
            return usernameBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void wait(String time){
        try{
            Thread.sleep(Long.parseLong(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
