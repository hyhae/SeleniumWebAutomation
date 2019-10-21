package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import models.BasicElement;

/**
* The class which contains all actions for the framework.
* @version 1.0
* @author Hussein ElSherif
*/
public class ActionsFactory {

    /**
     * This method clicks the given element using the given driver and reports in the given Extent Test instance.
     * @param WebDriver that is being used to steer the application.
     * @param ExtentTest instance that the test case is using to create the test.
     * @param BasicElement the element containing the element name and identifier used in steering and reporting
     */
	public static void clickWebElement(WebDriver driver, ExtentTest testInstance, BasicElement elemData)
			throws IOException {
		WebElement elem = null;
		try {
			elem = driver.findElement(elemData.getIdentifier());
			elem.click();
			testInstance.pass("Click " + elemData.getElementName(),
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
		} catch (NoSuchElementException e) {
			testInstance.fail("Element " + elemData.getElementName() + " not found. No such element exists on page.",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
			throw e;
		} catch (TimeoutException e) {
			testInstance.fail("Element " + elemData.getElementName() + " not found. Application timeout.",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
			throw e;
		}
	}

/**
 * This method enters text into the given element using the given driver and reports in the given Extent Test instance.
 * @param WebDriver that is being used to steer the application.
 * @param ExtentTest instance that the test case is using to create the test.
 * @param BasicElement the element containing the element name and identifier used in steering and reporting
 */
	public static void EnterTextIntoWebElement(WebDriver driver, ExtentTest testInstance, BasicElement elemData,
			String text) throws IOException {
		WebElement elem = null;
		try {
			elem = driver.findElement(elemData.getIdentifier());
			elem.sendKeys(text);
			testInstance.pass("Enter " + text + " into " + elemData.getElementName(),
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
		} catch (NoSuchElementException e) {
			testInstance.fail("Element " + elemData.getElementName() + " not found. No such element exists on page.",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
			throw e;
		} catch (TimeoutException e) {
			testInstance.fail("Element " + elemData.getElementName() + " not found. Application timeout.",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build());
			throw e;
		}
	}

	/**
	 * This method verifies the existence of the given WebElement.
	 * @param WebDriver that is being used to steer the application.
	 * @param BasicElement the element containing the element name and identifier
	 * @return Returns boolean value. True if element exists, false if element does not exist.
	 */
	public static boolean VerifyWebElementExists(WebDriver driver, BasicElement elemData) {
		WebElement elem = null;
		try {
			elem = driver.findElement(elemData.getIdentifier());
		} catch (Exception e) {
			return false;
		}
		if (elem != null) {
			return true;
		}
		return false;
	}

	/**
	 * This method saves a screenshot of the steered window on the disk and returns it as a string to be linked in the report.
	 * Uses Apache Commons-io
	 * @param WebDriver that is being used to steer the application.
	 * @return Returns String path of the screenshot on the disk
	 */
	public static String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + Reader.getProperty("screenshotPath")
				+ System.currentTimeMillis() + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

}
