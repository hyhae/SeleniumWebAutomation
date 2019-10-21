package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import models.BasicElement;
import utils.ActionsFactory;

/**
* The class representing the Registration page. It contains all the functions necessary to steer the registration form.
* @version 1.0
* @author Hussein ElSherif
*/
public class RegistrationPage {
	private BasicElement firstNameField = new BasicElement("First Name",
			By.xpath("//*[@id=\"headersignupform\"]/div[3]/input"));
	private BasicElement lastNameField = new BasicElement("Last Name",
			By.xpath("//*[@id=\"headersignupform\"]/div[4]/input"));
	private BasicElement mobileNumberField = new BasicElement("Mobile number",
			By.xpath("//*[@id=\"headersignupform\"]/div[5]/input"));
	private BasicElement emailField = new BasicElement("Email", By.xpath("//*[@id=\"headersignupform\"]/div[6]/input"));
	private BasicElement passwordField = new BasicElement("Password",
			By.xpath("//*[@id=\"headersignupform\"]/div[7]/input"));
	private BasicElement confirmPasswordField = new BasicElement("Confirm password",
			By.xpath("//*[@id=\"headersignupform\"]/div[8]/input"));
	private BasicElement signUpButton = new BasicElement("Sign up",
			By.xpath("//*[@id=\"headersignupform\"]/div[9]/button"));

    /**
     * This method fills first name field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillFirstName(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, firstNameField, text);
		return this;
	}

    /**
     * This method fills Last Name field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillLastName(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, lastNameField, text);
		return this;
	}

    /**
     * This method fills Mobile Number field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillMobileNumber(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, mobileNumberField, text);
		return this;
	}

    /**
     * This method fills Email field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillEmail(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, emailField, text);
		return this;
	}

    /**
     * This method fills password field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillPassword(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, passwordField, text);
		return this;
	}

    /**
     * This method fills Confirm password field in the registration form
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @param String Text to be entered the field.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage fillConfirmPassword(WebDriver driver, ExtentTest test, String text) throws IOException {
		ActionsFactory.EnterTextIntoWebElement(driver, test, confirmPasswordField, text);
		return this;
	}

    /**
     * This method clicks the sign up button on the Registration page.
     * @param WebDriver which is used to steer the application
     * @param ExtentTest which is used to create the html report.
     * @return Returns the instance of the Registration page class to chain function calls.
     */
	public RegistrationPage clickSignUp(WebDriver driver, ExtentTest test) throws IOException {
		ActionsFactory.clickWebElement(driver, test, signUpButton);
		return this;
	}
}
