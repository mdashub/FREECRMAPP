package com.factory;

import org.openqa.selenium.WebDriver;

import com.util.ElementUtil;

public class CRMApp {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public CRMApp (WebDriver DRIVER) {
		this.driver = DRIVER;
		this.eleUtil = new ElementUtil(this.driver);
	}
	
	public ElementUtil getUtil() {
		return eleUtil;
	}

}
