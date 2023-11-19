package com.pages;

import org.openqa.selenium.By;

import com.factory.CRMApp;

public class AddingContactsPage {

	private CRMApp CRM;

	public AddingContactsPage(CRMApp crmapp) {
		this.CRM = crmapp;
	}

	private By frameLocator = By.cssSelector("frame[name*=mainpanel]");
	private By contactsLocator = By.cssSelector("a[title *=Contacts]");
	private By newContactsLocators = By.cssSelector("a[title*='New Contact']");
	private By firstNameInNewLocator = By.cssSelector("input[name *= 'first_name']");
	private By lastNameInNewContactsLocator = By.cssSelector("input[name *= 'surname']");
	private By saveButtonLocator = By.xpath("//td[@colspan='2']/input[@value='Save']");
	String verifyUserAdded = "//tbody/tr/td[contains(text(),'#') and @class='datacardtitle']";

	public void clickOnNewContacts() {
		CRM.getUtil().frameSwitch(frameLocator);
		CRM.getUtil().actions_MouseHover(contactsLocator);
		CRM.getUtil().doClickButton(newContactsLocators);
	}

	public void enteringFirstNames(String FirstName) {
		CRM.getUtil().doSendKeys(firstNameInNewLocator, FirstName);
		saveOnNewContacts();
	}

	public void saveOnNewContacts() {
		CRM.getUtil().doClickButton(saveButtonLocator);
	}

	public String popUpinNewContactsPage() {
		String alertTextActual = CRM.getUtil().alertPopUpGetText();
		CRM.getUtil().alertPopUpAccept();
		return alertTextActual;

	}

	private By mobileNumberField = By.cssSelector("#mobile");

	public void enterIngMobileNumber(String mobile) {
		CRM.getUtil().findAndEnterValue(mobileNumberField, mobile);

	}

	private By emailField = By.cssSelector("#email:nth-of-type(1)");

	public void enteringEmail(String email) {
		CRM.getUtil().findAndEnterValue(emailField, email);
	}

	private By messengerDropDown = By.xpath("//select[@name='im_netowrk']");

	public void messengerNetwork(String messengerNetwork) {
		CRM.getUtil().selectClassDropwDownHandleGetAllOptions(messengerDropDown, messengerNetwork);
	}

	private String emailSmsCallPreferncesSet = "//*[text()='#']/../following-sibling::td/input[@value='N']";

	public void setPreferncesToNo(String... prefernces) {
		CRM.getUtil().doClickButton(CRM.getUtil().replaceStringInXpath(emailSmsCallPreferncesSet, prefernces[0]));
		CRM.getUtil().doClickButton(CRM.getUtil().replaceStringInXpath(emailSmsCallPreferncesSet, prefernces[1]));
		CRM.getUtil().doClickButton(CRM.getUtil().replaceStringInXpath(emailSmsCallPreferncesSet, prefernces[2]));
	}

	public boolean enteringLastNames(String LastName) {
		CRM.getUtil().doSendKeys(lastNameInNewContactsLocator, LastName);
		saveOnNewContacts();
		return CRM.getUtil().isElementDisplayed(CRM.getUtil().replaceStringInXpath(verifyUserAdded, LastName));
	}
}
