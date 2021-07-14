package zdtestpol51bdd.devto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SinglePodcastPage {
    WebDriver driver;
    @FindBy(id = "record")
    WebElement recordBtn;

    public SinglePodcastPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void playThePodcast() {
        recordBtn.click();
    }
}
