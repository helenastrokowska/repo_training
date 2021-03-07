package zdtestpol51bdd.devto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

public class DevToStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    String firstBlogTitle;
    String firstCastTitle;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.out.println("Before");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Given("I go to devto main page")
    public void i_go_to_devto_main_page() {
        System.out.println("Given");
        driver.get("https://dev.to");
    }
    @When("I click on first blog displayed")
    public void i_click_on_first_blog_displayed() {
        System.out.println("When");
        WebElement firstBlog = driver.findElement(By.cssSelector("h2.crayons-story__title > a"));
        firstBlogTitle = firstBlog.getText();
        firstBlog.click();
    }

    @When("I click text podcast in main page")
    public void i_click_text_podcast_in_main_page() {
        WebElement podcast = driver.findElement(By.linkText("Podcasts"));

        podcast.click();
    }
    @When("I click on first cast displayed")
    public void i_click_on_first_cast_displayed() {
        wait.until(ExpectedConditions.titleContains("Podcasts"));
        WebElement firstCast = driver.findElement(By.tagName("h3"));
        firstCastTitle = firstCast.getText();
        firstCastTitle = firstCastTitle.replace("podcast","");
        firstCast.click();
    }
    @Then("I should be redirected to cast site")
    public void i_should_be_redirected_to_cast_site(){
        wait.until(ExpectedConditions.titleContains(firstCastTitle));
        WebElement castTitle = driver.findElement(By.tagName("h1"));
        String castTitleText = castTitle.getText();
        Assert.assertEquals(firstCastTitle, castTitleText);
    }


    @Then("I should be redirected to blog page")
    public void iShouldBeRedirectedToBlogPage() {
        System.out.println("Then");
        wait.until(ExpectedConditions.titleContains(firstBlogTitle));
        WebElement blogTitle = driver.findElement(By.tagName("h1"));
        String blogTitleText = blogTitle.getText();
        System.out.println("to jest tytuł mojego bloga: " + blogTitleText);
        Assert.assertEquals(firstBlogTitle, blogTitleText);
    }
}


