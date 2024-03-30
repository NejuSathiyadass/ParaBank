package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@ParaBank_TC_01",
        features = "src/test/resources/Features",
        glue = "StepDefinition",
        plugin = {"html:target/Cucumber-reports/report.html", "rerun:target/failed_scenarios.txt"})
public class ParaBank_Runner {

}
