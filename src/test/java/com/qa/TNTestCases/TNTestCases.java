package com.qa.TNTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TNPages.AccountPage;
import com.qa.TNPages.HomePage;
import com.qa.TNPages.LoginPage;

public class TNTestCases {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		homepage = new HomePage(driver);
	}

	@Test
	public void loginWithValidCredentials() {
		loginpage = new LoginPage(driver);
		homepage.selectAccountDropdown();
		accountpage = homepage.selectLogin();
		loginpage.enterEmail();
		loginpage.enterPassword();
		accountpage = loginpage.loginButton();
		Assert.assertTrue(accountpage.elementVerifaction());

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
