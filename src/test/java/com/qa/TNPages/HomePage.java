package com.qa.TNPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement selectLoginOption;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectAccountDropdown() {
		myAccountDropdown.click();
	}

	public AccountPage selectLogin() {
		selectLoginOption.click();
		return new AccountPage(driver);
	}

}