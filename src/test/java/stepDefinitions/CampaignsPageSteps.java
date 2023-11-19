package stepDefinitions;

import org.testng.asserts.SoftAssert;

import com.pages.CampaignsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignsPageSteps {

	LoginPageSteps lps = new LoginPageSteps();
	CampaignsPage campaignsPage = new CampaignsPage(lps.getCrmapp());

	@Given("User click on Campaigns")
	public void clickOnCampaignsMenu() {
		campaignsPage.doClickOnCampaignsMenu();

	}

	@When("User sees table with NewSMSCampaign")
	public void checkNewSMSCampaign() {
		boolean flag = campaignsPage.doCheckNewSMSCampaign();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(false);
		softAssert.assertAll();

	}

	@Then("user logs out")
	public void logoutApplication() {
		campaignsPage.doLogoutFromApplication();
		
	}

}
