package com.pages;

import org.openqa.selenium.By;

import com.factory.CRMApp;

public class CampaignsPage {

	private CRMApp CRM;
	
	public CampaignsPage(CRMApp crmapp) {
		this.CRM = crmapp;
	}
	
	private By campaignsLocator = By.cssSelector("a[href*=campaign]");
	private By newSMSCampaignLocator = By.cssSelector("input[value *= SMS]");
	private By logoutLocator = By.cssSelector("a[href *=logout]");
	private By frameLocator = By.cssSelector("frame[name=mainpanel]");
	
	public void doClickOnCampaignsMenu() {
		CRM.getUtil().frameSwitch(frameLocator);
		CRM.getUtil().doClickButton(campaignsLocator);
		
	}
	
	public boolean doCheckNewSMSCampaign() {
		return CRM.getUtil().elementIsDisplayed(newSMSCampaignLocator);
		
	}
	
	public void doLogoutFromApplication() {
		CRM.getUtil().doClickButton(logoutLocator);
	}
	
	
}
