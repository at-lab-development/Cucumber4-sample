package example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_EXE_PATH = "src/main/resources/chromedriver.exe";

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            System.setProperty(WEBDRIVER, WEBDRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void waitVisibilityOf(WebElement element) {
        FluentWait wait = new FluentWait<>(driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(100, MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}