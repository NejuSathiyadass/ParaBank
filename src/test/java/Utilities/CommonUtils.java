package Utilities;

import PageObjects.LoginPage;
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

    }

    public void initWebElements() {
        PageFactory.initElements(ReusableMethods.getDriver(), LoginPage.getInstance());
    }

}
