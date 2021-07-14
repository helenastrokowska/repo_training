package zdtestpol51bdd.devto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PodcastListPage {
    WebDriver driver;
    @FindBy(tagName = "h3")
    public WebElement firstCast;
    public PodcastListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void selectFirstPodcast(){
        firstCast.click();
    }
}

