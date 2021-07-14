package zdtestpol51bdd.devto;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zdtestpol51.browserUtills.BaseDriver;
import zdtestpol51bdd.devto.pages.MainPage;
import zdtestpol51bdd.devto.pages.PodcastListPage;
import zdtestpol51bdd.devto.pages.SingleBlogPage;
import zdtestpol51bdd.devto.pages.SinglePodcastPage;


import java.util.List;

public class DevToStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    String firstCastTitle;
    String searchingPhrase;
    MainPage mainPage;
SingleBlogPage singleBlogPage;
PodcastListPage podcastListPage;
SinglePodcastPage singlePodcastPage;


    @Before
    public void setup() {
     driver= BaseDriver.setlocalDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Given("I go to devto main page")
    public void i_go_to_devto_main_page() {

                mainPage=new MainPage(driver);
    }

    @When("I click on first blog displayed")
    public void i_click_on_first_blog_displayed() {
        mainPage.selectFirstBlog();
        mainPage.firstBlogTitle = mainPage.firstBlog.getText();
    }

    @When("I click text podcast in main page")
    public void i_click_text_podcast_in_main_page() {

        mainPage.gotoPodcastSection();
    }

    @When("I click on first podcast on the list")
    public void i_click_on_first_podcast_on_the_list() {
        wait.until(ExpectedConditions.titleContains("Podcasts"));
        podcastListPage = new PodcastListPage(driver);
        firstCastTitle = podcastListPage.firstCast.getText();
        firstCastTitle = firstCastTitle.replace("podcast","");
        podcastListPage.selectFirstPodcast();
    }
    @And("I play the podcast")
    public void iPlayThePodcast() {
        wait.until(ExpectedConditions.titleContains(firstCastTitle));
        singlePodcastPage=new SinglePodcastPage(driver);
        singlePodcastPage.playThePodcast();
    }
    @Then("Podcast Should be played")
    public void podcast_should_be_played() {
        wait.until(ExpectedConditions.titleContains(firstCastTitle));
        WebElement castTitle = driver.findElement(By.tagName("h1"));
        String castTitleText = castTitle.getText();
        Assert.assertEquals(firstCastTitle, castTitleText);
    }
    @When("I go to podcast section")
    public void i_go_to_podcast_section() {

        WebElement podcast = driver.findElement(By.linkText("Podcasts"));
        podcast.click();
    }

    @Then("I should be redirected to cast site")
    public void i_should_be_redirected_to_cast_site() {
        wait.until(ExpectedConditions.titleContains(firstCastTitle));
        WebElement castTitle = driver.findElement(By.tagName("h1"));
        String castTitleText = castTitle.getText();
        Assert.assertEquals(firstCastTitle, castTitleText);
    }


    @Then("I should be redirected to blog page")
    public void iShouldBeRedirectedToBlogPage() {

        wait.until(ExpectedConditions.titleContains(mainPage.firstBlogTitle));//tu byłopuste
        singleBlogPage=new SingleBlogPage(driver);
        WebElement blogTitle = driver.findElement(By.cssSelector("h1"));
        String blogTitleText = blogTitle.getText();
        Assert.assertEquals(mainPage.firstBlogTitle, blogTitleText);
    }

    @When("I search for {string} phrase")
    public void i_search_for_testing_phrase(String phrase) {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys(phrase);
        searchingPhrase = phrase;
        searchBar.sendKeys(Keys.ENTER);

    }


    @Then("Top {int} blogs found should have corretc phrase in title or in text below")
    public void top_blogs_found_should_have_corretc_phrase_in_title_or_in_text_below(Integer int1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.crayons-story__title"))); //h3
        wait.until(ExpectedConditions.attributeContains(By.id("substories"), "class", "search-results-loaded"));
        List<WebElement> allPosts = driver.findElements(By.className("crayons-story__body"));
        if (allPosts.size() >= int1) {
            for (int i = 0; i < int1; i++) {
                WebElement singlePost = allPosts.get(i);
                WebElement singlePostTitle = singlePost.findElement(By.cssSelector(".crayons-story__title > a")); //tytul kafelka
                String singlePostTitleText = singlePostTitle.getText().toLowerCase(); // wyciagnij tekst z tytulu
                boolean isPhraseInTitle = singlePostTitleText.contains(searchingPhrase);
                if (isPhraseInTitle) { // isPhraseInTitle == true
                    Assert.assertTrue(isPhraseInTitle);
                } else {
                    String part1="/html/body/div[9]/div/main/div[2]/div[2]/div[2]/article[";
                    String part2="]/div/div/div[2]/div[1]";
                    WebElement tags=singlePost.findElement(By.xpath(part1+(i+1)+part2));
                    String tagsbody=tags.getText().toLowerCase();
                    System.out.println(tagsbody);
                    boolean istPhraseInTags=tagsbody.contains(searchingPhrase);
                    if(istPhraseInTags) {
                        Assert.assertTrue(istPhraseInTags);
                    }else{
                        WebElement WebElementBody=singlePost.findElement(By.className("crayons-article__main"));
                        String textBody=WebElementBody.getText().toLowerCase();
                        Assert.assertTrue(textBody.contains(searchingPhrase));
                    }
                }
            }
        }

    }

@After
    public void tearDown(){
      //  System.out.println("koniec");
      driver.quit();
}
}

