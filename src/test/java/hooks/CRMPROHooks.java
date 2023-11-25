package hooks;

import java.time.LocalDate;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CRMPROHooks {

	private DriverFactory driverFactory;
	private Properties property;
	private WebDriver driver;
	private static LoginPage loginPage;

	@Before(order = 0)
	public void launchBrowser() {
		System.out.println("--Execution is Starting--DriverFactory");
		driverFactory = new DriverFactory();
		property = driverFactory.init_Properties();
		driver = driverFactory.init_Driver(property);

		// URL is launched
		driver.get(property.getProperty("url"));

		// making the driver to pass on to Login Page
		loginPage = new LoginPage(driver);
	}

	/*
	 *  Getter method
	 */
	public static LoginPage getLoginPageDriver() {
		return loginPage;
	}

	/*
	 * Screenshot for failed Scenario
	 */
	@After(order = 1)
	public void takeScreenShotForFailedScenario(Scenario scenario) {

		/*
		 * For Failed Scenarios Only
		 */
		if (scenario.isFailed()) {
			String attachmentName = scenario.getName();
			byte[] whatToAttach = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(whatToAttach, "image/png", attachmentName);

		}
		/*
		 * For the passed Scenario
		 */
		else {
			String attachmentName = scenario.getName() + "_" + LocalDate.now() + "_" + ".png";
			byte[] whatToAttach = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(whatToAttach, "image/png", attachmentName);
		}
	}


	  @After(order = 0) public void closeBrowser() {
	  System.out.println("--Browser is getting Close--"+driver.toString());
	  driver.quit(); }
	 

}
