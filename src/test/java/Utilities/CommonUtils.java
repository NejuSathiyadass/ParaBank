package Utilities;

import PageObjects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class CommonUtils {

    private static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);

    private static CommonUtils utiles = null;

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        if (utiles == null) {
            utiles = new CommonUtils();
        }
        return utiles;
    }

    public void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            LOGGER.error(e);
        }

        ConstantsUtils.BROWSER = properties.getProperty("Browser");
        ConstantsUtils.APP_URL = properties.getProperty("Application_URL");
        ConstantsUtils.USERNAME = properties.getProperty("UserName");
        ConstantsUtils.PASSWORD = properties.getProperty("Password");
        ConstantsUtils.CHROME_DRIVER_PATH = properties.getProperty("Chrome_Driver_Path");
        ConstantsUtils.IE_DRIVER_PATH = properties.getProperty("Ie_Driver_Path");
        ConstantsUtils.EDGE_DRIVER_PATH = properties.getProperty("Edge_Driver_Path");
        ConstantsUtils.FIREFOX_DRIVER_PATH = properties.getProperty("Firefox_Driver_Path");
        ConstantsUtils.EXCEL_DATA_PATH = properties.getProperty("Excel_Data_Path");
        ConstantsUtils.REGISTRATION_DATA = properties.getProperty("Registration_Data");
        ConstantsUtils.PAYEE_DETAILS_DATA = properties.getProperty("Payee_Details_Data");
    }

    public void initWebElements() {
        PageFactory.initElements(ReusableMethods.getDriver(), LoginPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), RegistrationPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), OpenAccountPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), AccountOverviewPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), BillPayPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), FindTransactionsPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), RequestLoanPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), TransferFundsPage.getInstance());
        PageFactory.initElements(ReusableMethods.getDriver(), UpdateContactInfoPage.getInstance());
    }

}
