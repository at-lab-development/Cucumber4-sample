package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import example.driver.DriverSingleton;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"example/steps"},
        plugin = {"com.epam.jira.QASpaceReporter"}
)
public class TestRunner {

    @AfterClass()
    public static void stopDriver() {
        DriverSingleton.closeDriver();
    }
}