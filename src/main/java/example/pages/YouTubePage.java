package example.pages;

import example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubePage {

    private WebDriver driver;

    @FindBy(xpath = "(//*[@id='owner-name'])[2]")
    private WebElement authorName;

    @FindBy(id = "channel-title")
    private WebElement channelTitle;

    @FindBy(id = "video-title")
    private WebElement videoInList;

    public YouTubePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void open(String URL) {
        driver.get(URL);
    }

    public String getAuthorName() {
        DriverSingleton.waitVisibilityOf(authorName);
        return authorName.getText();
    }

    public String getChannelTitle() {
        DriverSingleton.waitVisibilityOf(channelTitle);
        return channelTitle.getText();
    }

    public String getVideoInList() {
        DriverSingleton.waitVisibilityOf(videoInList);
        return videoInList.getText();
    }
}