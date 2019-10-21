package tests;

import pageObjects.ProfilePage;
import pageObjects.RegistrationPage;
import utils.ActionsFactory;
import utils.Reader;
import utils.ReportFactory;
import utils.WebdriverFactory;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

@RunWith(Parameterized.class)
public class RegistrationTest {

	private static WebDriver driver;
	private static ExtentTest test;
	private RegistrationPage regPage;

	@Parameter(0)
	public String testCaseId;
	@Parameter(1)
	public String testCaseName;
	@Parameter(2)
	public String firstName;
	@Parameter(3)
	public String lastName;
	@Parameter(4)
	public String phoneNumber;
	@Parameter(5)
	public String email;
	@Parameter(6)
	public String password;
	@Parameter(7)
	public String confirmPassword;
	@Parameter(8)
	public String expectedResult;

	@Parameters(name = "{1}")
	public static String[][] data() throws IOException {
		return Reader.readDataFromExcel();
	}

	@Before
	public void setUp() throws IOException {
		driver = WebdriverFactory.getChromeInstance();
		test = ReportFactory.getReportInstance().createTest(testCaseId + ". " + testCaseName);
		regPage = new RegistrationPage();
	}

	@Test
	public void test() throws IOException {
		driver.get(Reader.getProperty("registrationUrl"));

		regPage.fillFirstName(driver, test, firstName).fillLastName(driver, test, lastName)
				.fillMobileNumber(driver, test, phoneNumber).fillEmail(driver, test, email)
				.fillPassword(driver, test, password).fillConfirmPassword(driver, test, confirmPassword)
				.clickSignUp(driver, test);

		try {
			if (expectedResult.equals("pass")) {
				Assert.assertTrue(ProfilePage.verifyMyAccountButtonExists(driver));
				test.pass("Testcase assertion successful",
						MediaEntityBuilder.createScreenCaptureFromPath(ActionsFactory.takeScreenshot(driver)).build());
			}
			else if(expectedResult.equals("fail")) {
				Assert.assertFalse(ProfilePage.verifyMyAccountButtonExists(driver));
				test.pass("Testcase assertion successful",
						MediaEntityBuilder.createScreenCaptureFromPath(ActionsFactory.takeScreenshot(driver)).build());
			}
		} catch (AssertionError e) {
			test.fail("Testcase assertion failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ActionsFactory.takeScreenshot(driver)).build());
			throw e;
		}

	}

	@After
	public void afterTest() throws IOException {
		ReportFactory.getReportInstance().flush();
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void afterSuite() throws IOException {
		driver.close();
	}

}
