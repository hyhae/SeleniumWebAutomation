package tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Reader;
import utils.WebdriverFactory;


public class GoogleTest {

    private WebDriver driver;
    private By searchBar = By.xpath("//input[@class='gLFyf gsfi']");
    private By searchButton = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']");
    private By searchResultLocator = By.xpath("//div[@class='yuRUbf']");

    @Before
    public void setUp() throws IOException {
        driver = WebdriverFactory.getChromeInstance();
        driver.get("https://google.com");
    }

    @Test
    public void test() throws IOException {
        driver.findElement(searchBar).sendKeys("cegedim");
        driver.findElement(searchButton).click();
        List<WebElement> searchResult = driver.findElements(searchResultLocator);

        Assert.assertTrue("Less than 11 results found.", searchResult.size() > 10);

        try {
            Thread.sleep(5000);
        }
        catch(Exception e){

        }
    }

    @After
    public void afterTest() throws IOException {
        driver.quit();
    }

}
