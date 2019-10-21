package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
* The class which creates and manages the singleton instance of the selenium webdriver.
* @version 1.0
* @author Hussein ElSherif
*/
public class WebdriverFactory {
	
	private WebdriverFactory() {}

    private static WebDriver instance ;

    /**
     * This method initializes a lazy singleton instance of the webdriver incase it isnt already created, then returns it to the caller.
     * @return instance of WebDriver
     */
    public static synchronized WebDriver getChromeInstance() throws IOException{
    	if(instance == null) {
    		System.setProperty("webdriver.chrome.driver", Reader.getProperty("pathToDriver"));
            ChromeOptions options = new ChromeOptions();
    		instance = new ChromeDriver(options);
  		  	instance.manage().window().maximize();
			instance.manage().timeouts().implicitlyWait(Long.parseLong(Reader.getProperty("minTimeout")), TimeUnit.SECONDS);
        }
        return instance;
    }
    
}
