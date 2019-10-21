package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import models.BasicElement;
import utils.ActionsFactory;

/**
* The class representing the My account profile page. It contains all functionalities the scripts need which are contained in this page.
* @version 1.0
* @author Hussein ElSherif
*/
public class ProfilePage {
	private static BasicElement myAccountButton = new BasicElement("My Account button",
			By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/aside/nav/ul/li[2]/a"));

    /**
     * This method verifies the existence of the "My Account" Button on the login dashboard
     * @param WebDriver which is used to steer the application
     * @return True if the My Account button is found, false if not.
     */
	public static boolean verifyMyAccountButtonExists(WebDriver driver) throws IOException {
		return ActionsFactory.VerifyWebElementExists(driver, myAccountButton);
	}
}
