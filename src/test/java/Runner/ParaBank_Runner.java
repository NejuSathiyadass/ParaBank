package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinition", dryRun = false, monochrome = true,
        plugin = {"html:target/Cucumber-reports/report.html", "rerun:target/failed_scenarios.txt"})
public class ParaBank_Runner {
}
