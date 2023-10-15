package crisp.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "crisp/step_definitions",
        dryRun = false,
        tags = "@queryEndpoint"
)

public class Runner extends AbstractTestNGCucumberTests {
}



