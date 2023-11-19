package stepDefinitions;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pages.SearchFormPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFormPageSteps {

	private SearchFormPage searchFormPage = new SearchFormPage(LoginPageSteps.getCrmapp());

	@Given("user clicks on Full Search Form in Contacts")
	public void full_Search_form_Contacts() {

		searchFormPage.selectFullSearchForm();

	}

	@Then("user enter the {string} and {string} to search")
	public void searchingNameinForm(String firstName, String lastName) {
		searchFormPage.searchUsingFirstlastName(firstName, lastName);
	}

	@And("user checks the checkbox and capture the mobileNumber{string}")
	public void checkCheboxAndGetMobile(String mobileNumberExpected) {
		List<Object> captured = searchFormPage.clickCheckBoxAndCaptureMobile();

		// Assert the List<Object> as it has stored flag and number

		boolean flagState = (Boolean) captured.get(0);
		String mobileNumberActual = captured.get(1).toString();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(flagState);
		softAssert.assertEquals(mobileNumberActual, mobileNumberExpected);
		softAssert.assertAll();
	}

	@Given("user clicks in Contacts")
	public void clickContacts() {

		searchFormPage.clickContactsMenu();

	}

	@Then("user search for {string} in the table and checks the checkBox")
	public void searchInContactTable(String Name) {
		searchFormPage.dosearchinContactTable(Name);
	}

	@And("confirm that Company is {string} and {string} is checked")
	public void checkCompanyname(String companyNameExpeceted, String Name) {
		String CompanyNameActual = searchFormPage.dogetCompanyName(Name);
		Assert.assertEquals(CompanyNameActual, companyNameExpeceted);
	}

	String Name;

	@When("Search for {string} {string} in the table and checks the checkBox")
	public void searchForNewlyAddedContactsInTable(String FirstName, String LastName) {
		
		searchFormPage.clickHomeAndContactsMenu();

		Name = FirstName + " " + LastName;
		searchFormPage.dosearchinContactTable(Name);
	}

	@Then("Deleting pop up appears with message {string}")
	public void deleteContacts(String deletePopUpMessageExpected) {
		String deletePopUpMessageActual = searchFormPage.clickOnDeleteContacts(Name);
		String expectedMessage = deletePopUpMessageExpected + Name + "?";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(expectedMessage, deletePopUpMessageActual);
		softAssert.assertAll();

	}
}
