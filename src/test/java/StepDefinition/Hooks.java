package StepDefinition;

import Utilities.CommonUtils;
import Utilities.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static String scenarioName = null;

    public static String getScenarioName() {
        return scenarioName;
    }

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("Execution Started!");
        try {
            scenarioName = scenario.getName();
            CommonUtils.getInstance().loadProperties();
            if (ReusableMethods.getDriver() == null) {
                ReusableMethods.launchBrowser();
                ReusableMethods.screenMaximize();
                ReusableMethods.implicitlyWait();
                CommonUtils.getInstance().initWebElements();
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @After
    public void afterScenario() {
        try {
            ReusableMethods.takeScreenShot();
            ReusableMethods.tearDown();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        LOGGER.info("Execution Completed!");
    }

}
