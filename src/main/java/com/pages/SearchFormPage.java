package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.factory.CRMApp;

public class SearchFormPage {

	/*
	 * public WebDriver driver; public ElementUtil eleUtil;
	 * 
	 * public SearchFormPage(WebDriver DRIVER) {
	 * 
	 * this.driver = DRIVER; eleUtil = new ElementUtil(this.driver);
	 * System.out.println("---------Page Layer Search called ---------");
	 * 
	 * }
	 */

	private CRMApp CRM;

	public SearchFormPage(CRMApp crmapp) {
		this.CRM = crmapp;
	}

	private By frameLocator = By.cssSelector("frame[name*=mainpanel]");
	private By contactsLocator = By.cssSelector("a[title *=Contacts]");
	private By searchFormLocator = By.xpath("//a[text()='Contacts']/..//a[text()='Full Search Form']");
	private By firstNameLocator = By.cssSelector("input[name *= cs_first_name]");
	private By lastNameLocator = By.cssSelector("input[name *= cs_surname]");
	private By searchContactButton = By.xpath("(//input[@value='Search Contacts'])[1]");
	private By checkBoxLocator = By.xpath("//a[text()='Eder Militao']/../../td/input[@type='checkbox']");
	private By phoneLocator = By.xpath("//a[text()='Eder Militao']/../../td/span[@context='phone']");
	private By homeMenuLocator = By.cssSelector("a[title *=Home]");

	public void selectFullSearchForm() {
		
		CRM.getUtil().actions_MouseHover(contactsLocator);
		CRM.getUtil().doClickButton(searchFormLocator);

	}

	public void searchUsingFirstlastName(String firstName, String lastName) {
		CRM.getUtil().doSendKeys(firstNameLocator, firstName);
		CRM.getUtil().doSendKeys(lastNameLocator, lastName);
		CRM.getUtil().doClickButton(searchContactButton);
	}

	public List<Object> clickCheckBoxAndCaptureMobile() {
		List<Object> valueCaptured = new ArrayList<>();
		boolean flag = CRM.getUtil().doClickCheckBox(checkBoxLocator);
		String mobileNumber = CRM.getUtil().doGetText(phoneLocator);

		valueCaptured.add(flag);
		valueCaptured.add(mobileNumber);
		return valueCaptured;

	}

	public void clickContactsMenu() {
		CRM.getUtil().frameSwitch(frameLocator);
		CRM.getUtil().doClickButton(contactsLocator);
	}

	private By contactsOnTable = By.cssSelector("tbody tr > td > a[context *='contact']");
	private By pagination = By.xpath("(//div[@class='pagination'])[1]//strong/../a");

	public void dosearchinContactTable(String nameExpected) {
		By checkBoxNameExpecetd = By.xpath("//a[text()='" + nameExpected + "']/../../td/input[@type='checkbox']");
		CRM.getUtil().pauseScript(10000);

		// page 1

		List<WebElement> contacts = CRM.getUtil().doGetElements(contactsOnTable);
		boolean flag = true;
		while (flag) {

			for (WebElement e : contacts) {
				String nameActual = e.getText();
				if (nameActual.equalsIgnoreCase(nameExpected)) {
					CRM.getUtil().doClickCheckBox(checkBoxNameExpecetd);
					flag = false;
					break;
				}

			}

			// click on page 2,3,4,,5,onwards
			if (flag) {
				List<WebElement> pages = CRM.getUtil().doGetElements(pagination);
				int totalpage = pages.size();
				for (int i = 0; i < totalpage; i++) {
					pages.get(i).click();
					contacts = CRM.getUtil().doGetElements(contactsOnTable);
					pages = CRM.getUtil().doGetElements(pagination);

					for (WebElement e : contacts) {
						String nameActual = e.getText();
						if (nameActual.equalsIgnoreCase(nameExpected)) {
							CRM.getUtil().doClickCheckBox(checkBoxNameExpecetd);
							flag = false;

							/*
							 * To prevent once name found to stop and not traverese the whole pagination
							 */
							i = totalpage + 1;

							/*
							 * break acts on the innermost loop it encounters within the scope
							 */
							break;

						}

					}
				}

			}

			/*
			 * for the while loop, else it would be an infinite
			 */
			flag = false;

		}

	}

	public String dogetCompanyName(String name) {
		By checkBoxSelectionStateLocator = By.xpath("//a[text()='" + name + "']/../../td/input[@type='checkbox']");
		boolean flag = CRM.getUtil().docheckStatusOfCheckBox(checkBoxSelectionStateLocator);
		if (flag) {
			By companyNameLocator = By.xpath("//a[text()='" + name + "']/../../td/a[@context='company']");
			return CRM.getUtil().doGetText(companyNameLocator);
		}
		return null;

	}

	public void clickHomeAndContactsMenu() {
		CRM.getUtil().frameSwitch(frameLocator);
		CRM.getUtil().doClickButton(homeMenuLocator);
		CRM.getUtil().doClickButton(contactsLocator);
	}

	public String clickOnDeleteContacts(String Name) {
		By deleteContactsLocator = By.xpath("//a[text()='" + Name + "']/../../td/a[contains(@href,'delete')]/i");
		CRM.getUtil().doClickButton(deleteContactsLocator);
		String alertText = CRM.getUtil().alertPopUpGetText();
		CRM.getUtil().pauseScript(5000);
		CRM.getUtil().alertPopUpDismiss();
		return alertText;
	}

}
