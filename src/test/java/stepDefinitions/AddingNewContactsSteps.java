package stepDefinitions;

import org.testng.asserts.SoftAssert;

import com.pages.AddingContactsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingNewContactsSteps {
	AddingContactsPage addContactsPage = new AddingContactsPage(LoginPageSteps.getCrmapp());
	
	@Given("user clicks on New Contacts")
	public void clickNewContacts() {
		addContactsPage.clickOnNewContacts();
	}
	
	@When("{string} is entered and try Saving")
	public void enterNamesFirstName(String names) {
		addContactsPage.enteringFirstNames(names);
	}
	
	@Then("Pop up appaers with message {string}")
	public void validatePopUpMessage(String messageExpected) {
		String messageActual =addContactsPage.popUpinNewContactsPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(messageActual, messageExpected);
				
	}
	
	@Then("{string} {string} {string} is to be filled and prefernces set to No")
	public void addingMobileEmailAndSetPrefernces(String mobile, String email, String messengerNetwork) {
		String[] preferences = {"Receive Email","Receive SMS", "Allow Calls"};
		addContactsPage.enteringEmail(email);
		addContactsPage.messengerNetwork(messengerNetwork);
		addContactsPage.enterIngMobileNumber(mobile);
		addContactsPage.setPreferncesToNo(preferences);
		
	}
	@And("{string} is entered and Saved")
	public void enterNamesLastName(String names) {
		boolean flag = addContactsPage.enteringLastNames(names);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(flag, true);
		softAssert.assertAll();
	}
}
