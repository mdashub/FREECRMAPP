package com.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		// System.out.println("-----Element Utility called--------");

	}

	public WebElement doGetElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(150));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public By replaceStringInXpath(String xpath , String valueToReplaced) {
		return By.xpath(xpath.replaceAll("#", valueToReplaced));
	}
	
	public By replaceStringICSS(String xpath , String valueToReplaced) {
		return By.cssSelector(xpath.replaceAll("#", valueToReplaced));
	}

	public boolean doClickCheckBox(By locator) {

		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		doGetElement(locator).click();
		return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public void doSendKeys(By locator, String text) {
		doGetElement(locator).clear();
		doGetElement(locator).sendKeys(text);
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();

	}

	public void doClickButton(By locator) {
		doGetElement(locator).click();
	}

	public String doGetTitle(String title) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public List<WebElement> waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> doGetElements(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		// return driver.findElements(locator);
	}

	public boolean elementIsDisplayed(By locator) {
		return (!waitForElement(locator).isEmpty()) ? true : false;
	}

	public boolean docheckStatusOfCheckBox(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, true));

	}

	public void findAndEnterValue(By locator, String text) {
		doGetElement(locator).clear();
		doGetElement(locator).sendKeys(text);
	}

	/*
	 * Select Class Drop Down
	 */
	public void selectClassDropwDownHandleGetAllOptions(By lcoator, String valueToSelected) {
		doClickButton(lcoator);
		Select select = new Select(doGetElement(lcoator));
		List<WebElement> allOptions = select.getOptions();
		for (WebElement e : allOptions) {
			if (e.getText().equalsIgnoreCase(valueToSelected)) {
				e.click();
				break;
			}

		}
	}

	public void selectClassDropwDownHandleByvalue(By lcoator, String valueToSelected) {
		doClickButton(lcoator);
		Select select = new Select(doGetElement(lcoator));
		select.selectByValue(valueToSelected);
	}

	/*
	 * Actions Util
	 */
	public void actions_MouseHover(By locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(doGetElement(locator)).perform();

	}

	public void actions_EnterKey() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();

	}

	/*
	 * Alert Utils
	 */

	private Alert checkAlertIsPresent() {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String alertPopUpGetText() {
		return checkAlertIsPresent().getText();
	}

	public void alertPopUpDismiss() {
		checkAlertIsPresent().dismiss();
	}

	public void alertPopUpAccept() {
		checkAlertIsPresent().accept();
	}

	/*
	 * Frame Utils
	 */

	public void frameSwitch(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMinutes(4));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public boolean isElementDisplayed(By locator) {
		return doGetElement(locator).isDisplayed();

	}

	public void pauseScript(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
