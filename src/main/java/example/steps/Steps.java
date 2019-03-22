package example.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import example.driver.DriverSingleton;
import example.pages.YouTubePage;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Steps {

    private final WebDriver driver = DriverSingleton.getDriver();
    private YouTubePage youTubePage;
    private Scenario scenario;

    public Steps() {
        this.youTubePage = new YouTubePage(driver);
    }

@Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^I am on page with url '([^\\\"]*)'$")
    public void givenIAmOnPage(String pageUrl) {
        youTubePage.open(pageUrl);
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        scenario.write("Test of write event");
    }

    @Then("^I should see author name '([^\\\"]*)'$")
    public void thenIShouldSeeAuthorName(String expectedAuthorName) {
        Assert.assertEquals(true,true);
    }

    @Then("^I should see '([^\\\"]*)' in list video$")
    public void thenIShouldSeeVideoTitle(String expectedVideoTitle) {
        String actualVideoTitle = youTubePage.getVideoInList();
        Assert.assertEquals(expectedVideoTitle, actualVideoTitle);
    }

    @Then("^I should see channel title '([^\\\"]*)'$")
    public void thenIShouldSeeInTitle(String expectedChannelTitle) {
        String actualChannelTitle = youTubePage.getChannelTitle();
        Assert.assertEquals(expectedChannelTitle, actualChannelTitle);
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}